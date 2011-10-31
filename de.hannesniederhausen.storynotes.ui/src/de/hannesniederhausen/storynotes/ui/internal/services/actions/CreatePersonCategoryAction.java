/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.PersonCategory;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 * 
 */
public class CreatePersonCategoryAction extends AbstractCreationAction {

	public static final String PERSON_NAME = "Persons";

	public CreatePersonCategoryAction(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Person Category");
		checkEnabled();
	}

	private void checkEnabled() {
		Project project = (Project) getParentElement();
		for (Category c : project.getCategories()) {
			if (c instanceof PersonCategory) {
				setEnabled(false);
				return;
			}
		}
		setEnabled(true);
	}

	@Override
	public void run() {
		final Project project = (Project) getParentElement();

		Category c = getModelProviderService().getModelFactory()
				.createPersonCategory();
		c.setName(PERSON_NAME);
		
		AddCommand cmd = new AddCommand(getEditingDomain(), project, StorynotesPackage.Literals.PROJECT__CATEGORIES, c);
		getEditingDomain().getCommandStack().execute(cmd);

		getSelectionService().setSelection(c);

	}
}
