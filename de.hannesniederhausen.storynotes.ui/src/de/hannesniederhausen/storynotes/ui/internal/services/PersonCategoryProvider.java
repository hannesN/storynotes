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
import de.hannesniederhausen.storynotes.model.PersonCategory;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePersonCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePersonNote;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PersonNoteInputMask;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class PersonCategoryProvider implements ICategoryProviderService {

	@Override
	public Class<? extends InputMask> getCategoryInputClassClass() {
		return CategoryInputMask.class;

	}

	@Override
	public InputMask createNoteInputMask(Composite parent,
			Class<? extends Note> noteClass) {
		return null;
//		InputMask im;
//		try {
//			im = super.createNoteInputMask(parent, noteClass);
//			
//			if (im == null) {
//				im = new PersonNoteInputMask(parent, SWT.NONE);
//				setNoteInputmask(im);
//			}
//
//			return im;
//		} catch (InvalidParameterException e) {
//			return null;
//		}
//		
	}

	@Override
	public IAction[] getNoteActions(IEclipseContext context, EObject parent) {
		return new IAction[]{new CreatePersonNote(context, parent)};
	}

	@Override
	public IAction getCategoryActions(IEclipseContext context, EObject parent) {
		return new CreatePersonCategoryAction(context, parent);
	}
	
	@Override
	public Class<? extends Category> getCategoryClass() {
		return PersonCategory.class;
	}
}
