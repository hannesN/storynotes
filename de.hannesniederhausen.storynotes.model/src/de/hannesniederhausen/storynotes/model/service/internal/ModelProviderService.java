package de.hannesniederhausen.storynotes.model.service.internal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

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
		try {
			java.io.File file = new java.io.File(filename);
			ZipFile zf = new ZipFile(file);
			ZipEntry entry = zf.getEntry("content.xmi");
			InputStream is = zf.getInputStream(entry);

			XMIResourceImpl res = (XMIResourceImpl) getResourceSet().createResource(URI.createFileURI(filename));
			res.setEncoding("UTF-8");
			res.load(is, Collections.emptyMap());
			File oldFile = this.file;
			this.file = (File) res.getContents().get(0);
			this.file.setFilename(filename);
			notifyChange(oldFile, this.file);
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
		XMIResourceImpl res = (XMIResourceImpl) resSet.createResource(URI.createFileURI(file.getFilename()));
		
		res.getContents().add(file);
		try {
			
			java.io.File realFile = new java.io.File(file.getFilename());
			if (realFile.exists())
				realFile.delete();
			
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(realFile));
			ZipEntry entry = new ZipEntry("content.xmi");

			
			zos.putNextEntry(entry);
			
			
			res.setEncoding("UTF-8");
			res.save(zos, Collections.emptyMap());
			zos.closeEntry();
			
			
			zos.close();
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
