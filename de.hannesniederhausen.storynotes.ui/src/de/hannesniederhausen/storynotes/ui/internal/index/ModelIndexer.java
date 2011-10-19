/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.StaleReaderException;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.FileElement;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * The {@link ModelIndexer} creates a lucene index from the current model. It listenes to the command stack and adds model changes to the index.
 * 
 * @author Hannes Niederhausen
 *
 */
public class ModelIndexer {

	private static final String NOTE = "note";

	private static final String CATEGORY = "category";

	private static final String NAME = "name";

	private static final String TYPE = "type";

	private static final String ID = "id";

	private static final String DESCRIPTION = "description";

	private static final String PROJECT = "project";
	
	private static final String PARENT = "parent";
	
	private Set<String> fieldNames;

	@Inject
	private IModelProviderService modelProviderService;

	private Directory index; 
	
	private IndexAdapter indexAdapter;

	private IndexWriter writer;

	private StandardAnalyzer analyzer;
	
	@PostConstruct
	public void init() {
		
		try {
			java.io.File fsFile = new java.io.File("/tmp/index");
			if (fsFile.exists()) {
				deleteDir(fsFile);
			}
			
			fieldNames = new HashSet<String>();
			fieldNames.add(DESCRIPTION);
			
			
			indexAdapter = new IndexAdapter();
			index = new RAMDirectory();		
			analyzer = new StandardAnalyzer(Version.LUCENE_29);
			writer = new IndexWriter(index, analyzer, true, IndexWriter.MaxFieldLength.UNLIMITED);
			
			File file = modelProviderService.getFile();
			
			for (Project p : file.getProjects()) {
				addProject(p, writer, true);
			}

			IndexReader reader = writer.getReader();
			int nDocs = reader.numDocs();
			for (int i=0; i<nDocs; i++) {
				System.out.println("d="+reader.document(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	public void dispose() {
		try {
			fieldNames.clear();
			index.close();
			writer.close();
			indexAdapter.dispose();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Document> query(String queryString) {
		IndexSearcher searcher = null;
		try {
			searcher = new IndexSearcher(writer.getReader());
			
			if (queryString.charAt(queryString.length()-1)!=' ') {
				queryString+="*";
			}
			
			int size = fieldNames.size();
			String[] fields = fieldNames.toArray(new String[size]);
			BooleanClause.Occur[] flags = new BooleanClause.Occur[size];
			for (int i=0; i<size; i++) {
				flags[i]=BooleanClause.Occur.MUST;
			}
			
			Query query = MultiFieldQueryParser.parse(Version.LUCENE_29, queryString, fields, flags, analyzer);
			
			List<Document> resultList = new ArrayList<Document>(10);
			
			TopDocs td = searcher.search(query, null, 10);
			
			for (ScoreDoc sd : td.scoreDocs) {
				resultList.add(searcher.doc(sd.doc));
			}
			
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (searcher!=null)
					searcher.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * @param writer 
	 * @param file
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 */
	private void addProject(Project p, IndexWriter writer, boolean handleChildren) throws CorruptIndexException, IOException {
		Document doc = createDocument(PROJECT, p.getName(), p);

		indexAdapter.addTo(p);
		String description = p.getDescription();
		if (description!=null) {
			doc.add(new Field(DESCRIPTION, description, Field.Store.YES, Field.Index.ANALYZED));
		}
		
		writer.addDocument(doc);
		
		if (handleChildren) {
			for (Category cat : p.getCategories()) {
				addCategory(cat, writer, handleChildren);
			}
		}
	}

	/**
	 * @param p
	 * @param doc
	 * @param typeName 
	 * @param name 
	 * @param fe 
	 */
	private Document createDocument(String typeName, String name, FileElement fe) {
		Document doc = new Document();
		
		doc.add(new Field(ID, Long.toString(fe.getId()), Field.Store.YES, Field.Index.NO));
		doc.add(new Field(TYPE, typeName, Field.Store.YES, Field.Index.NO));
		if (name!=null)
			doc.add(new Field(NAME, name, Field.Store.YES, Field.Index.ANALYZED));
		
		EObject parent = fe.eContainer();
		while (parent instanceof FileElement) {
			doc.add(new Field(PARENT, Long.toString(((FileElement) parent).getId()), 
					Field.Store.YES, Field.Index.NO));
			parent = parent.eContainer();
		}
		
		
		return doc;
	}


	/**
	 * @param cat
	 * @param writer
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 */
	private void addCategory(Category cat, IndexWriter writer, boolean handleChildren) throws CorruptIndexException, IOException {
		Document doc = createDocument(CATEGORY, cat.getName(), cat);
		indexAdapter.addTo(cat);
		if (handleChildren) {
			for (Note n : cat.getNotes()) {
				addNote(n, writer);
			}
		}
		writer.addDocument(doc);
	}


	/**
	 * @param n
	 * @param writer
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 */
	private void addNote(Note n, IndexWriter writer) throws CorruptIndexException, IOException {
		Document doc = createDocument(NOTE, null, n);
		EList<EStructuralFeature> features = n.eClass().getEStructuralFeatures();
		indexAdapter.addTo(n);
		for (EStructuralFeature f : features) {
			Object value = n.eGet(f);
			if (value != null) {
				doc.add(new Field(f.getName(), value.toString(), Field.Store.YES, Field.Index.ANALYZED));
				fieldNames.add(f.getName());
			}
		}
		writer.addDocument(doc);
	}
	
	/**
	 * Deletes
	 * @param dir
	 */
	private void deleteDir(java.io.File dir) {
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException("dir is not a directory");
		}
		
		for (java.io.File f : dir.listFiles()) {
			if (f.isDirectory()) {
				deleteDir(f);
			} else if (f.isFile()) {
				f.delete();
			}
		}
		
		dir.delete();
	}


	private void removeElement(FileElement element, boolean removeChildren) throws CorruptIndexException, IOException {
		removeElements(removeChildren, element);
	}
	

	private void removeElements(boolean removeChildren, FileElement... elements) throws StaleReaderException, CorruptIndexException, LockObtainFailedException, IOException {
		for (FileElement e : elements) {
			Term term = new Term(ID, Long.toString(e.getId()));
			writer.deleteDocuments(term);
			if (removeChildren) {
				Term childTerm = new Term(PARENT, Long.toString(e.getId()));
				writer.deleteDocuments(childTerm);
			}
		}
	}
	
	private class IndexAdapter extends AdapterImpl {
		
		private Set<EObject> listenedObjects = new HashSet<EObject>();
		
		@Override
		public void notifyChanged(Notification msg) {
			Object notifier = msg.getNotifier();
			if (notifier instanceof File) {
				handleFileChanges(msg);
				return;
			} 
			if (notifier instanceof Project) {
				handleProjectChanges(msg);
				return;
			}
			if (notifier instanceof Category) {
				handleCategoryChanges(msg);
				return;
			}
			if (notifier instanceof Note) {
				handleNoteChanges(msg);
				return;
			}
		}
		
		public void dispose() {
			for (EObject o : listenedObjects) {
				o.eAdapters().remove(this);
			}
			listenedObjects.clear();
		}

		/**
		 * @param msg
		 */
		private void handleNoteChanges(Notification msg) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * @param msg
		 */
		private void handleCategoryChanges(Notification msg) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * @param msg
		 */
		private void handleProjectChanges(Notification msg) {
			try {
				switch (msg.getEventType()) {
				case Notification.ADD:
				{
					Category cat = (Category) msg.getNewValue();
					addCategory(cat, writer, true);
				}
				case Notification.ADD_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Project> projects = (List<Project>) msg.getNewValue();
					for (Project p : projects) {
						addProject(p, writer, true);
					}
				}	
				case Notification.REMOVE:
				{
					Category cat = (Category) msg.getNewValue();
					removeElement(cat, true);
				}
				case Notification.REMOVE_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Category> projects = (List<Category>) msg.getNewValue();
					removeElements(true, projects.toArray(new FileElement[projects.size()]));
				}
				
				} // end of switch
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}

		/**
		 * @param msg
		 */
		private void handleFileChanges(Notification msg) {
			
			if (msg.getFeatureID(File.class)!=StorynotesPackage.FILE__PROJECTS)
				return;
			
			try {
				switch (msg.getEventType()) {
				case Notification.ADD:
				{
					Project p = (Project) msg.getNewValue();
					addProject(p, writer, true);
				}
				case Notification.ADD_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Project> projects = (List<Project>) msg.getNewValue();
					for (Project p : projects) {
						addProject(p, writer, true);
					}
				}	
				case Notification.REMOVE:
				{
					Project p = (Project) msg.getNewValue();
					removeElement(p, true);
				}
				case Notification.REMOVE_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Project> projects = (List<Project>) msg.getNewValue();
					removeElements(true, projects.toArray(new FileElement[projects.size()]));
				}
				
				} // end of switch
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}
		
		private void addTo(EObject element) {
			if (listenedObjects.contains(element))
				return;
			element.eAdapters().add(this);
			listenedObjects.add(element);
		}
	}
}
