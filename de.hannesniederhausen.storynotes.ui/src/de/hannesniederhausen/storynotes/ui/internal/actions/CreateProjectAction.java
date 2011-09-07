/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;


/**
 * @author Hannes Niederhausen
 *
 */
public class CreateProjectAction extends AbstractCreationAction {
	
	public CreateProjectAction(IEclipseContext context, EObject parent) {
		super(context, parent);
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
			file.getProjects().add(p);
			
			getSelectionService().setSelection(p);
			
			
		}
	}
}
