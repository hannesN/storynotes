/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.PlotCategory;
import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePlotCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePlotNote;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PlotCategoryInputMask;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PlotNoteInputMask;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class PlotCategoryProvider implements ICategoryProviderService {

	@Override
	public Class<? extends InputMask> getCategoryInputMaskClass() {
		return PlotCategoryInputMask.class;
	}

	@Override
	public Class<? extends InputMask> getNoteInputMaskClass(Class<? extends Note> noteClass) {
		if (PlotNote.class.isAssignableFrom(noteClass))
			return PlotNoteInputMask.class;
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
