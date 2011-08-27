/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.actions;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;


/**
 * @author Hannes Niederhausen
 *
 */
public class CreateProjectAction extends AbstractCreationAction {
	
	public CreateProjectAction() {
		super();
		setText("Create Project...");
	}
	
	@Override
	public void run() {
		InputDialog dlg = new InputDialog(null, 
				"Project Name", 
				"Please enter a project name", 
				"", 
				null);
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			File file = (File) getParentElement();
			
			Project p = getModelProviderService().getModelFactory().createProject();
			p.setName(name);
			file.getProjects().add(p);
			
			getSelectionService().setSelection(p);
			
			
		}
	}
}
