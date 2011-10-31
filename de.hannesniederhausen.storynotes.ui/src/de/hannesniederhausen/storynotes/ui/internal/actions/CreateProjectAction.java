/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.actions;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;


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
		InputDialog dlg = new InputDialog(getShell(), 
				"Project Name", 
				"Please enter a project name", 
				"", 
				null);
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			File file = (File) getParentElement();
			
			Project p = getModelProviderService().getModelFactory().createProject();
			p.setName(name);
			
			
			AddCommand cmd = new AddCommand(getEditingDomain(), file, StorynotesPackage.Literals.FILE__PROJECTS, p);
			getEditingDomain().getCommandStack().execute(cmd);
			
			getSelectionService().setSelection(p);
			
			
		}
	}
}
