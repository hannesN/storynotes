/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.BasicCommandStack;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class SaveHandler extends CommandStackHandler {

	@Inject
	private IModelProviderService modelProviderService;
	
	@Execute
	public void execute() {
		modelProviderService.saveFile();
		
		if (getCommandStack()!=null) {
			((BasicCommandStack) getCommandStack()).saveIsDone();
		}
		
	}

	@CanExecute
	public boolean canExecute() {
		File file = modelProviderService.getFile();
		
		return (file!=null && file.getFilename()!=null && getCommandStack()!=null  
				&& ((BasicCommandStack) getCommandStack()).isSaveNeeded());
	}
}
