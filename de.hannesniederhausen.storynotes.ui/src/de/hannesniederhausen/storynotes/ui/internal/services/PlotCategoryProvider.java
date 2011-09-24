/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.PlotCategory;
import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePlotCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePlotNote;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PlotNoteInputmask;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class PlotCategoryProvider implements ICategoryProviderService {

	@Override
	public Class<? extends InputMask> getCategoryInputClassClass() {
		return CategoryInputMask.class;
	}

	@Override
	public InputMask createNoteInputMask(Composite parent,
			Class<? extends Note> noteClass) {
//		if (PlotNote.class.isAssignableFrom(noteClass))
//			return new PlotNoteInputmask(parent, SWT.NONE);
		return null;
	}

	@Override
	public IAction[] getNoteActions(IEclipseContext context, EObject parent) {
		return new IAction[]{new CreatePlotNote(context, parent)};
	}

	@Override
	public IAction getCategoryActions(IEclipseContext context, EObject parent) {
		return new CreatePlotCategoryAction(context, parent);
	}

	@Override
	public Class<? extends Category> getCategoryClass() {
		return PlotCategory.class;
	}
}
