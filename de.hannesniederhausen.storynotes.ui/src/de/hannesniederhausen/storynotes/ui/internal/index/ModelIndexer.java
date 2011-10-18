/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.index;

import java.io.IOException;
import java.util.EventObject;
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
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

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

	@Inject
	private IModelProviderService modelProviderService;

	private Directory index; 
	
	private IndexAdapter indexAdapter;
	
	@PostConstruct
	public void init() {
		
		try {
			java.io.File fsFile = new java.io.File("/tmp/index");
			if (fsFile.exists()) {
				deleteDir(fsFile);
			}
			
			indexAdapter = new IndexAdapter();
			
			index = new SimpleFSDirectory(fsFile);		
			IndexWriter writer = getIndexWriter();
			
			File file = modelProviderService.getFile();
			
			for (Project p : file.getProjects()) {
				addProject(p, writer, true);
			}
			
			writer.close();

			IndexReader reader = IndexReader.open(index, true);
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
			index.close();
			indexAdapter.dispose();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	private IndexWriter getIndexWriter() throws CorruptIndexException,
			LockObtainFailedException, IOException {
		IndexWriter writer = new IndexWriter(index, new StandardAnalyzer(Version.LUCENE_29), true, IndexWriter.MaxFieldLength.UNLIMITED);
		return writer;
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
		if (description!=null)
			doc.add(new Field(DESCRIPTION, description, Field.Store.YES, Field.Index.ANALYZED));
		
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
			doc.add(new Field(f.getName(), n.eGet(f).toString(), Field.Store.YES, Field.Index.ANALYZED));
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
		IndexReader reader = IndexReader.open(index, false);
		
		removeElements(reader, removeChildren, element);
		
		reader.close();
	}
	

	private void removeElements(IndexReader reader, boolean removeChildren, FileElement... elements) throws StaleReaderException, CorruptIndexException, LockObtainFailedException, IOException {
		for (FileElement e : elements) {
			Term term = new Term(ID, Long.toString(e.getId()));
			reader.deleteDocuments(term);
			if (removeChildren) {
				Term childTerm = new Term(PARENT, Long.toString(e.getId()));
				reader.deleteDocuments(childTerm);
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
					IndexWriter writer = getIndexWriter();
					addCategory(cat, writer, true);
					writer.close();
				}
				case Notification.ADD_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Project> projects = (List<Project>) msg.getNewValue();
					IndexWriter writer = getIndexWriter();
					for (Project p : projects) {
						addProject(p, writer, true);
					}
					writer.close();
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
					IndexReader reader = IndexReader.open(index, false);
					removeElements(reader, true, projects.toArray(new FileElement[projects.size()]));
					reader.close();
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
					IndexWriter writer = getIndexWriter();
					addProject(p, writer, true);
					writer.close();
				}
				case Notification.ADD_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Project> projects = (List<Project>) msg.getNewValue();
					IndexWriter writer = getIndexWriter();
					for (Project p : projects) {
						addProject(p, writer, true);
					}
					writer.close();
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
					IndexReader reader = IndexReader.open(index, false);
					removeElements(reader, true, projects.toArray(new FileElement[projects.size()]));
					reader.close();
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
