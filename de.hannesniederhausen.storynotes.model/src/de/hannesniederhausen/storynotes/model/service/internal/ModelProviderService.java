package de.hannesniederhausen.storynotes.model.service.internal;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.StorynotesFactory;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

public class ModelProviderService implements IModelProviderService {

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
		// TODO load file
		newFile();
		file.setFilename(filename);
	}

	@Override
	public void closeFile() {
		file = null;
	}

	@Override
	public void saveFile() {
		// TODO save file
		
	}

	@Override
	public void newFile() {
		// TODO Auto-generated method stub
		file = getModelFactory().createFile();
	}
}
