/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.ui.internal.views.MainView;

/**
 * @author Hannes Niederhausen
 *
 */
public class AbstractCreationAction extends Action {

	private EObject parentElement;
	private IModelProviderService modelProviderService;
	private IEclipseContext context;
	
	public AbstractCreationAction() {
	}
	
	public void setContext(IEclipseContext context) {
		this.context = context;
	}

	
	public void setParentElement(EObject parentElement) {
		this.parentElement = parentElement;
	}
	
	public void setModelProviderService(
			IModelProviderService modelProviderService) {
		this.modelProviderService = modelProviderService;
	}
	
	protected ESelectionService getSelectionService() {
		return context.get(ESelectionService.class);
	}
	
	protected Shell getShell() {
		return context.get(MainView.class).getParent().getShell();
	}
	
	protected IModelProviderService getModelProviderService() {
		return modelProviderService;
	}
	
	protected EObject getParentElement() {
		return parentElement;
	}
}
