/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.SettingCategory;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateSettingCategoryAction;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateSettingNote;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class SettingCategoryProvider implements ICategoryProviderService {

	@Override
	public Class<? extends InputMask> getCategoryInputClassClass() {
		return CategoryInputMask.class;
	}

	@Override
	public InputMask createNoteInputMask(Composite parent,
			Class<? extends Note> noteClass) {
//		if (SettingNote.class.isAssignableFrom(noteClass))
//			return new SettingNoteInputmask(parent, SWT.NONE);
		return null;
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
}
