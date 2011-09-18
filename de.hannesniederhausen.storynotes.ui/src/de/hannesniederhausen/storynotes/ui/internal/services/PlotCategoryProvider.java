/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import java.security.InvalidParameterException;

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
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PlotNoteInputMask;
import de.hannesniederhausen.storynotes.ui.services.AbstractCategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class PlotCategoryProvider extends AbstractCategoryProviderService {

	@Override
	public InputMask createCategoryInputMask(Composite parent) {
		InputMask im = super.createCategoryInputMask(parent);
		if (im==null) {
			im = new CategoryInputMask(parent, SWT.NONE);
			setCategoryInputMask(im);
		}
		
		return im;
	}

	@Override
	public InputMask createNoteInputMask(Composite parent,
			Class<? extends Note> noteClass) {
		InputMask im;
		try {
			im = super.createNoteInputMask(parent, noteClass);
			
			if (im == null) {
				im = new PlotNoteInputMask(parent, SWT.NONE);
				setNoteInputmask(im);
			}

			return im;
		} catch (InvalidParameterException e) {
			return null;
		}
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

	@Override
	protected Class<? extends Note> getNoteClass() {
		return PlotNote.class;
	}
}
