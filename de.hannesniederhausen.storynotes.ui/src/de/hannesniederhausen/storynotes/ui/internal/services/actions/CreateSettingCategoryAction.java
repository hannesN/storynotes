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
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.PersonCategory;
import de.hannesniederhausen.storynotes.model.PlotCategory;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.SettingCategory;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 * 
 */
public class CreateSettingCategoryAction extends AbstractCreationAction {

	public static final String SETTING_NAME = "Setting";

	public CreateSettingCategoryAction(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Setting Category");
		checkEnabled();
	}

	private void checkEnabled() {
		Project project = (Project) getParentElement();
		for (Category c : project.getCategories()) {
			if (c instanceof SettingCategory) {
				setEnabled(false);
				return;
			}
		}
		setEnabled(true);
	}

	@Override
	public void run() {
		final Project project = (Project) getParentElement();

		Category c = getModelProviderService().getModelFactory().createSettingCategory();
		c.setName(SETTING_NAME);
		project.getCategories().add(c);

		getSelectionService().setSelection(c);

	}
}
