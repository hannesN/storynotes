/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 * 
 */
public class SaveAsHandler extends CommandStackHandler {

	@Inject
	private IModelProviderService modelProviderService;

	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL)
	private Shell shell;
	
	@Execute
	public void execute() {
		FileDialog dlg = new FileDialog(shell, SWT.SAVE);
		dlg.setFilterExtensions(new String[] { "*.stn" });
		dlg.setText("Save File...");

		String filename = dlg.open();
		if (filename != null) {
			File file = modelProviderService.getFile();
			file.setFilename(filename);
			modelProviderService.saveFile();
			
			if (getCommandStack()!=null)
				((BasicCommandStack)getCommandStack()).saveIsDone();
		}

		
	}

	public boolean canExecute() {
		File file = modelProviderService.getFile();
		return file != null;
	}
}
