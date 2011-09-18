/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.services;

import java.security.InvalidParameterException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * Abstract class which implements a caching for the created {@link InputMask}s.
 * 
 * 
 * @author Hannes Niederhausen
 *
 */
public abstract class AbstractCategoryProviderService implements
		ICategoryProviderService {

	private InputMask categoryInputMask;
	private InputMask noteInputmask;
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * This implementations returns <code>null</code> or a cached {@link InputMask}, which was set by {@link #setCategoryInputMask(InputMask)}.
	 */
	@Override
	public InputMask createCategoryInputMask(Composite parent) {
		if (isUseable(parent, categoryInputMask)) {
		
			return categoryInputMask;
		}
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 	 * This implementations returns <code>null</code> or a cached {@link InputMask}, which was set by {@link #setNoteInputmask(InputMask)}.
	 */
	@Override
	public InputMask createNoteInputMask(Composite parent,
			Class<? extends Note> noteClass) {
		if (!getNoteClass().isAssignableFrom(noteClass))
			throw new InvalidParameterException("Note class: "+noteClass.getName()+" is an invalid parameter");
				
		if (isUseable(parent, noteInputmask)) {
			return noteInputmask;
		}	
		return null;
	}
	
	
	@Override
	public IAction[] getNoteActions(IEclipseContext context, EObject parent) {
		return new IAction[0];
	}

	@Override
	public IAction getCategoryActions(IEclipseContext context, EObject parent) {
		return null;
	}

	/**
	 * Caches the given {@link InputMask}.
	 * 
	 * Note: If there already is a cached InputMask, it will be disposed.
	 * 
	 * @param categoryInputMask the categoryInputMask to set
	 */
	protected void setCategoryInputMask(InputMask categoryInputMask) {
		if (this.categoryInputMask!=null) {
			this.categoryInputMask.dispose();
		}
		
		this.categoryInputMask = categoryInputMask;
	}

	/**
	 * Caches the given InputMask.
	 * 
	 * Note: If there already is a cached InputMask, it will be disposed.
	 * 
	 * @param noteInputmask the noteInputmask to set
	 */
	protected void setNoteInputmask(InputMask noteInputmask) {
		if (this.noteInputmask!=null && !this.noteInputmask.isDisposed()) {
			this.noteInputmask.dispose();
		}
		this.noteInputmask = noteInputmask;
	}

	/**
	 * 
	 * @return the class which represents the type of the note which will be edited by the generated {@link InputMask}
	 */
	protected abstract Class<? extends Note> getNoteClass();

	/**
	 * @param parent
	 * @param inputMask 
	 * @return
	 */
	private boolean isUseable(Composite parent, InputMask inputMask) {
		return inputMask != null && !inputMask.isDisposed()
				&& inputMask.getParent().equals(parent);
	}

}
