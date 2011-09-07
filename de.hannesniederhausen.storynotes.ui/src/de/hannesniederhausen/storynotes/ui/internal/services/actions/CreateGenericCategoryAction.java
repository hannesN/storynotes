/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.GenericCategory;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;



/**
 * @author Hannes Niederhausen
 *
 */
public class CreateGenericCategoryAction extends AbstractCreationAction {
	
	public CreateGenericCategoryAction(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Category...");
	}
	
	@Override
	public void run() {
		final Project project = (Project) getParentElement();
		
		InputDialog dlg = new InputDialog(getShell(), 
				"Category Name", 
				"Please enter a category name", 
				"", 
				new IInputValidator() {
					
					@Override
					public String isValid(String newText) {
						if (newText.isEmpty()) {
							return "No name given!";
						}
						for (Category c : project.getCategories()) {
							if (newText.equals(c.getName())) {
								return "Category with that name already exists!";
							}
						}
						return null;
					}
				});
		if (dlg.open()==Dialog.OK) {
			String name = dlg.getValue();
			
			GenericCategory c = getModelProviderService().getModelFactory().createGenericCategory();
			c.setName(name);
			project.getCategories().add(c);
			
			getSelectionService().setSelection(c);
		}
	}
}
