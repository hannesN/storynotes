/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.PlotCategory;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;

/**
 * @author Hannes Niederhausen
 * 
 */
public class CreatePlotCategoryAction extends AbstractCreationAction {

	public static final String PLOT_NAME = "Plot";

	public CreatePlotCategoryAction(IEclipseContext context, EObject parent) {
		super(context, parent);
		setText("Create Plot Category");
		checkEnabled();
	}

	private void checkEnabled() {
		Project project = (Project) getParentElement();
		for (Category c : project.getCategories()) {
			if (c instanceof PlotCategory) {
				setEnabled(false);
				return;
			}
		}
		setEnabled(true);
	}

	@Override
	public void run() {
		final Project project = (Project) getParentElement();

		Category c = getModelProviderService().getModelFactory().createPlotCategory();
		c.setName(PLOT_NAME);
		project.getCategories().add(c);

		getSelectionService().setSelection(c);

	}
}
