/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.ui.actions.AbstractCreationAction;
import de.hannesniederhausen.storynotes.ui.actions.CreateCategoryAction;
import de.hannesniederhausen.storynotes.ui.actions.CreateProjectAction;

/**
 * @author Hannes Niederhausen
 *
 */
public class StoryNotesActionProvider implements IActionProvider {

	private IModelProviderService modelProviderService;
	private ESelectionService selectionService;
	
	@Override
	public IAction[] getActions(Object element) {
		if (element instanceof File) {
			return getAction((File)element, CreateProjectAction.class);
		} 
		
		if (element instanceof Project) {
			return getAction((File)element, CreateCategoryAction.class);
		}
		return new IAction[0];
	}
	
	private IAction[] getProjectActions(Project element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModelProviderService(
			IModelProviderService modelProviderService) {
		this.modelProviderService = modelProviderService;
	}
	
	public void setSelectionService(ESelectionService selectionService) {
		this.selectionService = selectionService;
	}

	private IAction[] getAction(EObject element, Class<? extends AbstractCreationAction> clazz) {
		try {
			AbstractCreationAction a = (AbstractCreationAction) clazz.newInstance();
			a.setParentElement(element);
			a.setSelectionService(selectionService);
			a.setModelProviderService(modelProviderService);
			return new IAction[]{a};
		} catch (Exception e) {
			// TODO logging
			e.printStackTrace();
		}
		return new IAction[0];
	}

}
