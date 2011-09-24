/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.views;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * The {@link IInputMask} class specifies the properties of an input mask
 * for a model element used by the main view.
 * 
 * @author Hannes Niederhausen
 *
 */
public abstract class InputMask {

	@Inject
	private IEclipseContext eclipseContext;
	
	private Composite control;
	
	public InputMask() {

	}

	/**
	 * Returns the control which of the input mask
	 * 
	 * @return the control
	 */
	public Composite getControl() {
		return control;
	}
	
	/**
	 * Sets the container which contains the input mask elements
	 * 
	 * @param control the control to set
	 */
	protected void setControl(Composite control) {
		this.control = control;
	}
	
	/**
	 * Creates the widgets using the given parent widget
	 * 
	 * @param parent the parent for the input mask
	 */
	public abstract void createControl(Composite parent);
	
	/**
	 * Sets the new model for the input mask
	 */
	public abstract void setModel(EObject model);

	
	/**
	 * Returns the eclipse context
	 * 
	 * @return the eclipseContext
	 */
	protected IEclipseContext getEclipseContext() {
		return eclipseContext;
	}
}
