/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.Preferences;

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
	
	@Inject
	IPreferencesService preferencesService;
	
	@Execute
	public void execute() {
		FileDialog dlg = new FileDialog(shell, SWT.SAVE);
		dlg.setFilterExtensions(new String[] { "*.stn" });
		dlg.setText("Save File...");

		IEclipsePreferences root = preferencesService.getRootNode();
		Preferences storynotesprefs = root.node("/storynotes");
		
		String lastPath = storynotesprefs.get("lastpath", "./.");
		dlg.setFilterPath(lastPath);

		String filename = dlg.open();
		if (filename != null) {
			File file = modelProviderService.getFile();
			file.setFilename(filename);
			modelProviderService.saveFile();
			
			if (getCommandStack()!=null)
				((BasicCommandStack)getCommandStack()).saveIsDone();
			
			
			storynotesprefs.put("lastpath", filename.substring(0, filename.lastIndexOf(java.io.File.separator))+"/.");
			
			
			
		}

		
	}

	public boolean canExecute() {
		File file = modelProviderService.getFile();
		return file != null;
	}
}
