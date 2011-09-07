/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.SettingNote;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 *
 */
public class CreateSettingNote extends AbstractCreationAction {

	public CreateSettingNote(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Setting...");
	}
	
	@Override
	public void run() {
		InputDialog dlg = new InputDialog(getShell(), 
				"Setting Name", 
				"Please enter a name for the setting.", 
				"", 
				null);
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			Category cat = (Category) getParentElement();
			
			SettingNote note = getModelProviderService().getModelFactory().createSettingNote();
			note.setName(name);
			cat.getNotes().add(note);
			
			getSelectionService().setSelection(note);
		}
	}
}
