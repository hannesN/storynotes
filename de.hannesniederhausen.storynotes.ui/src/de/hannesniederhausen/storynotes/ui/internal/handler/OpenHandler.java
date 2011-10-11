/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class OpenHandler {
	@Inject
	private IModelProviderService modelProviderService;
	
	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL)
	private Shell shell;
	
	@Execute
	public void execute() {
		FileDialog dlg = new FileDialog(shell, SWT.OPEN);
		dlg.setFilterExtensions(new String[] { "*.stn" });
		dlg.setText("Open File...");

		String filename = dlg.open();
		if (filename != null) {
			modelProviderService.loadFile(filename);	
		}

		
	}

}
