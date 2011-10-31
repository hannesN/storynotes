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
import de.hannesniederhausen.storynotes.model.GenericNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 *
 */
public class CreateGenericNote extends AbstractCreationAction {

	public CreateGenericNote(IEclipseContext context, EObject parent, String categoryName) {
		super(context, parent);
		setText("Create "+categoryName+" Note...");
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
			
			AddCommand cmd = new AddCommand(getEditingDomain(), cat, StorynotesPackage.Literals.CATEGORY__NOTES, note);
			getEditingDomain().getCommandStack().execute(cmd);
			
			getSelectionService().setSelection(note);
		}
	}
}
