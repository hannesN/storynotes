/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.GenericCategory;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateGenericCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateGenericNote;
import de.hannesniederhausen.storynotes.ui.internal.views.MainView;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class GenericCategoryProvider implements ICategoryProviderService {


	@Override
	public InputMask createCategoryInputMask(Composite parent) {
		return new CategoryInputMask(parent, SWT.NONE);
	}

	@Override
	public InputMask createNoteInputMask(Composite parent, Class<? extends Note> noteClass) {
		return null;
	}

	@Override
	public IAction[] getNoteActions(IEclipseContext context, EObject parent) {
		return new IAction[] {new CreateGenericNote(context, parent)};
	}

	@Override
	public IAction getCategoryActions(IEclipseContext context, EObject parent) {
		return new CreateGenericCategoryAction(context, parent);
	}

	/* (non-Javadoc)
	 * @see de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService#getCategoryClass()
	 */
	@Override
	public Class<? extends Category> getCategoryClass() {
		return GenericCategory.class;
	}
}
