/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.actions;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class AbstractCreationAction extends Action {

	private EObject parentElement;
	private IModelProviderService modelProviderService;
	private ESelectionService selectionService;
	
	public AbstractCreationAction() {
	}
	
	
	public AbstractCreationAction(EObject parentElement,
			IModelProviderService modelProviderService) {
		super();
		this.parentElement = parentElement;
		this.modelProviderService = modelProviderService;
	}

	public void setSelectionService(ESelectionService selectionService) {
		this.selectionService = selectionService;
	}
	
	public void setParentElement(EObject parentElement) {
		this.parentElement = parentElement;
	}
	
	public void setModelProviderService(
			IModelProviderService modelProviderService) {
		this.modelProviderService = modelProviderService;
	}
	
	protected ESelectionService getSelectionService() {
		return selectionService;
	}
	
	protected IModelProviderService getModelProviderService() {
		return modelProviderService;
	}
	
	protected EObject getParentElement() {
		return parentElement;
	}
}
