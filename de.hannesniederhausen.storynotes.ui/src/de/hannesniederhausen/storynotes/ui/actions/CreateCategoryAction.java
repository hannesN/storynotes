/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.actions;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;



/**
 * @author Hannes Niederhausen
 *
 */
public class CreateCategoryAction extends AbstractCreationAction {
	
	public CreateCategoryAction() {
		super();
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
			
			Category c = getModelProviderService().getModelFactory().createCategory();
			c.setName(name);
			project.getCategories().add(c);
			
			getSelectionService().setSelection(c);
		}
	}
}
