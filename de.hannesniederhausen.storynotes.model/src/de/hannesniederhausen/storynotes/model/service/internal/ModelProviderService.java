package de.hannesniederhausen.storynotes.model.service.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.StorynotesFactory;
import de.hannesniederhausen.storynotes.model.service.IFileListener;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

public class ModelProviderService implements IModelProviderService {

	private List<IFileListener> listeners;
	private File file;

	@Override
	public StorynotesFactory getModelFactory() {
		return StorynotesFactory.eINSTANCE;
	}

	@Override
	public File getFile() {
		return this.file;
	}

	@Override
	public void loadFile(String filename) {

		ResourceSet resSet = getResourceSet();
		Resource res = resSet.getResource(URI.createFileURI(filename), true);
		
		try {
			res.load(Collections.emptyMap());
			File oldFile = file;
			file = (File) res.getContents().get(0);
			file.setFilename(filename);
			notifyChange(oldFile, file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void closeFile() {
		File oldFile = file;
		file = null;
		notifyChange(oldFile, file);
	}

	@Override
	public void saveFile() {
		if (file==null || file.getFilename()==null)
			throw new IllegalStateException("invalid file or filename");
		
		ResourceSet resSet = getResourceSet();
		
		Resource res = resSet.createResource(URI.createFileURI(file.getFilename()));
		
		res.getContents().add(file);
		
		try {
			res.save(Collections.emptyMap());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void newFile() {
		File oldFile = file;
		file = getModelFactory().createFile();
		notifyChange(oldFile, file);
	}
	
	@Override
	public void addFileListener(IFileListener l) {
		if (listeners==null) {
			listeners = new ArrayList<IFileListener>();
		}
		listeners.add(l);
	}
	
	@Override
	public void removeFileListener(IFileListener l) {
		if (listeners==null)
			return;
		listeners.remove(l);
	}

	private ResourceSet getResourceSet() {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> map = reg.getExtensionToFactoryMap();
		map.put("stn", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		return resSet;
	}
	
	private void notifyChange(File oldFile, File newFile) {
		if (listeners==null || listeners.isEmpty())
			return;
		
		IFileListener[] lArray = listeners.toArray(new IFileListener[listeners.size()]);
		for (IFileListener l : lArray) {
			l.fileChanged(oldFile, newFile);
		}
	}
}
