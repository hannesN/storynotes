/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.actions;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.PersonNote;

/**
 * @author Hannes Niederhausen
 *
 */
public class CreatePersonNote extends AbstractCreationAction {

	public CreatePersonNote() {
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
			cat.getNotes().add(note);
			
			getSelectionService().setSelection(note);
		}
	}
}
