/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.services;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * The service used to specify a category type.
 * 
 * 
 * @author Hannes Niederhausen
 *
 */
public interface ICategoryProviderService {

	/**
	 * Creates and returns a composite which contains the
	 * input mask to edit the category attributes.
	 * 
	 */
	public InputMask createCategoryInputMask(Composite parent);
	
	/**
	 * Creates and returns a composite which contains the
	 * input mask to edit a note.
	 * 
	 * @param parent
	 * @param noteClass
	 * @return
	 */
	public InputMask createNoteInputMask(Composite parent, Class<? extends Note> noteClass);
	
	/**
	 * An array of actions, which can be executed at the categories
	 * navigation node.
	 * 
	 * @return an array of actions. Must not be <code>null</code>
	 */
	public IAction[] getNoteActions();
	
	/**
	 * An array of actions, which will be added to the projects action list.
	 * 
	 * @return an array of actions. Must not be <code>null</code>
	 */
	public IAction getCategoryActions();
}
