/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class SaveHandler {

	@Inject
	private IModelProviderService modelProviderService;
	
	@Execute
	public void execute() {
		modelProviderService.saveFile();
	}

	@CanExecute
	public boolean canExecute() {
		File file = modelProviderService.getFile();
		return file!=null && file.getFilename()!=null;
	}
}
