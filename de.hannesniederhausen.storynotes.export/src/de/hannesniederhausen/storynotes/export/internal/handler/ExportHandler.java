/**
 * 
 */
package de.hannesniederhausen.storynotes.export.internal.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.export.internal.ui.OutlineExportWizard;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * Handler for the export command.
 * 
 * @author Hannes Niederhausen
 *
 */
public class ExportHandler {

	@Inject
	private IModelProviderService modelProvider;
	
	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL)
	private Shell shell;
	
	@CanExecute
	public boolean canExecute() {
		File file = modelProvider.getFile();
		return (file!=null && file.getProjects().size()>0);
	}
	
	@Execute
	public void execute() {
		WizardDialog dlg = new WizardDialog(shell, new OutlineExportWizard(modelProvider.getFile())); 
		dlg.open();
	}
	
}
