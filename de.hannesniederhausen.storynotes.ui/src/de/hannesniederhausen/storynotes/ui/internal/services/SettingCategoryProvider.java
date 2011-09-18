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
import de.hannesniederhausen.storynotes.model.SettingCategory;
import de.hannesniederhausen.storynotes.model.SettingNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateSettingCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateSettingNote;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.SettingNoteInputMask;
import de.hannesniederhausen.storynotes.ui.services.AbstractCategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class SettingCategoryProvider extends AbstractCategoryProviderService {

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
				im = new SettingNoteInputMask(parent, SWT.NONE);
				setNoteInputmask(im);
			}

			return im;
		} catch (InvalidParameterException e) {
			return null;
		}
	}

	@Override
	public IAction[] getNoteActions(IEclipseContext context, EObject parent) {
		return new IAction[]{new CreateSettingNote(context, parent)};
	}

	@Override
	public IAction getCategoryActions(IEclipseContext context, EObject parent) {
		return new CreateSettingCategoryAction(context, parent);
	}

	@Override
	public Class<? extends Category> getCategoryClass() {
		return SettingCategory.class;
	}

	@Override
	protected Class<? extends Note> getNoteClass() {
		return SettingNote.class;
	}
}
