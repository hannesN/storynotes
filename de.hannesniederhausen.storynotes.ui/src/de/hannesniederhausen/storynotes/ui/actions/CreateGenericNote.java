/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.actions;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.GenericNote;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.model.SettingNote;

/**
 * @author Hannes Niederhausen
 *
 */
public class CreateGenericNote extends AbstractCreationAction {

	public CreateGenericNote() {
		setText("Create Generic Note...");
	}
	
	@Override
	public void run() {
		InputDialog dlg = new InputDialog(getShell(), 
				"Note Title", 
				"Please enter a title for the note.", 
				"", 
				null);
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			Category cat = (Category) getParentElement();
			
			GenericNote note = getModelProviderService().getModelFactory().createGenericNote();
			note.setTitle(name);
			cat.getNotes().add(note);
			
			getSelectionService().setSelection(note);
		}
	}
}
