/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 *
 */
public class CreatePersonNote extends AbstractCreationAction {

	public CreatePersonNote(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Person...");
	}
	
	@Override
	public void run() {
		InputDialog dlg = new InputDialog(getShell(), 
				"Person Name", 
				"Please enter a name for the person.", 
				"", 
				null);
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			Category cat = (Category) getParentElement();
			
			PersonNote note = getModelProviderService().getModelFactory().createPersonNote();
			note.setName(name);

			AddCommand cmd = new AddCommand(getEditingDomain(), cat, StorynotesPackage.Literals.CATEGORY__NOTES, note);
			getEditingDomain().getCommandStack().execute(cmd);
			
			getSelectionService().setSelection(note);
		}
	}
}
