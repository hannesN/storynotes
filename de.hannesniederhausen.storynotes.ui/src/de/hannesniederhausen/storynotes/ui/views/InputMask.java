/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * The {@link IInputMask} class specifies the properties of an input mask
 * for a model element used by the main view.
 * 
 * @author Hannes Niederhausen
 *
 */
public abstract class InputMask extends Composite {

	public InputMask(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Sets the new model for the input mask
	 */
	public abstract void setModel(EObject model);
	
}
