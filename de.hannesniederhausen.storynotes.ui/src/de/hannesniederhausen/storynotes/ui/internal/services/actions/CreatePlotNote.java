/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 *
 */
public class CreatePlotNote extends AbstractCreationAction {

	public CreatePlotNote(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Plot...");
	}
	
	@Override
	public void run() {
		InputDialog dlg = new InputDialog(getShell(), 
				"Plot Title", 
				"Please enter a title for the plot element.", 
				"", 
				null);
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			Category cat = (Category) getParentElement();
			
			PlotNote note = getModelProviderService().getModelFactory().createPlotNote();
			note.setTitle(name);
			cat.getNotes().add(note);
			
			getSelectionService().setSelection(note);
		}
	}
}
