/**
 * 
 */
package de.hannesniederhausen.storynotes.model.service;

import org.eclipse.emf.ecore.EObject;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.StorynotesFactory;

/**
 * Interface for the model provider service.
 * 
 * @author Hannes Niederhausen
 *
 */
public interface IModelProviderService {

	/**
	 * 
	 * @return the factory for new model elements
	 */
	public StorynotesFactory getModelFactory();
	
	/**
	 * Returns the currently loaded model
	 * 
	 * @return the file object containing the model
	 */
	public File getFile();
	
	/**
	 * Loads a file with the given filename and sets the currently loaded file
	 * to the new file.
	 * @param filename the name of the file to load
	 */
	public void loadFile(String filename);
	
	/**
	 * Saves the file using its filename
	 */
	public void saveFile();
	
	/**
	 * Creates a new empty file
	 */
	public void newFile();
	
	/**
	 * Closes the currently loaded file.
	 */
	public void closeFile();
	
	/**
	 * Adds a file listener
	 * @param l
	 */
	public void addFileListener(IFileListener l);
	
	/**
	 * Removes a file listener
	 * @param l
	 */
	public void removeFileListener(IFileListener l);
	
	/**
	 * Returns the element with the given id.
	 * 
	 * @param id the id of the element
	 * @return the element with the given id or <code>null</code>
	 */
	public EObject getElementById(long id);
}
