/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.e4.core.contexts.IEclipseContext;
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
	private IEclipseContext context;
	
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

	public void setContext(IEclipseContext context) {
		this.context = context;
	}

	private IAction[] getAction(EObject element, Class<? extends AbstractCreationAction> clazz) {
		try {
			AbstractCreationAction a = (AbstractCreationAction) clazz.newInstance();
			a.setParentElement(element);
			a.setContext(context);
			a.setModelProviderService(modelProviderService);
			return new IAction[]{a};
		} catch (Exception e) {
			// TODO logging
			e.printStackTrace();
		}
		return new IAction[0];
	}

}
