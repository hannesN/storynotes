/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.GenericCategory;
import de.hannesniederhausen.storynotes.model.GenericNote;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateGenericCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateGenericNote;
import de.hannesniederhausen.storynotes.ui.internal.services.ui.GenericNoteInputMask;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class GenericCategoryProvider implements ICategoryProviderService {


	@Override
	public Class<? extends InputMask> getCategoryInputMaskClass() {
		return CategoryInputMask.class;
	}

	@Override
	public java.lang.Class<? extends InputMask> getNoteInputMaskClass(java.lang.Class<? extends Note> noteClass) {
		if (GenericNote.class.isAssignableFrom(noteClass))
			return GenericNoteInputMask.class;
		
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

	@Override
	public Class<? extends Category> getCategoryClass() {
		return GenericCategory.class;
	}
}
