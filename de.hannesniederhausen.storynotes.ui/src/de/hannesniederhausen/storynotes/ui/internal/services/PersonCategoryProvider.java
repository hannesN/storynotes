/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.PersonCategory;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePersonCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePersonNote;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PersonCategoryInputMask;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.PersonNoteInputMask;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class PersonCategoryProvider implements ICategoryProviderService {

	@Override
	public Class<? extends InputMask> getCategoryInputMaskClass() {
		return PersonCategoryInputMask.class;

	}

	@Override
	public Class<? extends InputMask> getNoteInputMaskClass(
			Class<? extends Note> noteClass) {
		if (PersonNote.class.isAssignableFrom(noteClass))
			return PersonNoteInputMask.class;
		return null;
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
