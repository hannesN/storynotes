/**
 * 
 */
package de.hannesniederhausen.storynotes.model.service;

import de.hannesniederhausen.storynotes.model.File;

/**
 * Listener which gets notified when the
 * file in the {@link IModelProviderService} will be closed, created or loaded.
 * 
 * 
 * @author Hannes Niederhausen
 *
 */
public interface IFileListener {

	/**
	 * The method which is called when the file attribute of the service changes.
	 * It will not notify changes inside the model.
	 */
	public void fileChanged(File oldFile, File newFile);
}
