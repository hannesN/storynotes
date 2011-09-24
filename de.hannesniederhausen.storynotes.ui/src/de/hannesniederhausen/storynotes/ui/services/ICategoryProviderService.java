/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.services;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.Category;
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
	 * Creates and returns the input mask class should be instanciated using the {@link ContextInjectionFactory}
	 * 
	 */
	public Class<? extends InputMask> getCategoryInputMaskClass();
	
	/**
	 * Creates and returns the input mask class should be instanciated using the {@link ContextInjectionFactory}
	 * 
	 * @param noteClass
	 * @return
	 */
	public Class<? extends InputMask> getNoteInputMaskClass(Class<? extends Note> noteClass);
	
	/**
	 * An array of actions, which can be executed at the categories
	 * navigation node.
	 * 
	 * @param context the {@link IEclipseContext} of the rcp application
	 * @param parent the parent object
	 * 
	 * @return an array of actions. Must not be <code>null</code>
	 */
	public IAction[] getNoteActions(IEclipseContext context, EObject parent);
	
	/**
	 * An array of actions, which will be added to the projects action list.
	 * 
	 * @param context the {@link IEclipseContext} of the rcp application
	 * @param parent the parent object
	 * 
	 * @return an array of actions. Must not be <code>null</code>
	 */
	public IAction getCategoryActions(IEclipseContext context, EObject parent);
	
	
	/**
	 * Returns the class object of the category which will be crated by this service. This is used to lookup the service
	 * in the UI, e.g. when asking for input masks
	 * 
	 * @return the class object of the category
	 */
	public Class<? extends Category> getCategoryClass();
}
