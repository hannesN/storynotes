/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.ui.actions.AbstractCreationAction;
import de.hannesniederhausen.storynotes.ui.actions.CreateCategoryAction;
import de.hannesniederhausen.storynotes.ui.actions.CreateGenericNote;
import de.hannesniederhausen.storynotes.ui.actions.CreatePersonNote;
import de.hannesniederhausen.storynotes.ui.actions.CreateProjectAction;
import de.hannesniederhausen.storynotes.ui.actions.CreateSettingNote;

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
			return new IAction[]{getAction((EObject)element, CreateProjectAction.class)};
		} 
		
		if (element instanceof Project) {
			return new IAction[]{getAction((EObject)element, CreateCategoryAction.class)};
		}
		
		if (element instanceof Category) {
			return new IAction[]{
					getAction((EObject)element, CreatePersonNote.class),
					getAction((EObject)element, CreateGenericNote.class),
					getAction((EObject)element, CreateSettingNote.class),
					getAction((EObject)element, CreateGenericNote.class)					
			};
		}
		
		return new IAction[0];
	}
	

	public void setModelProviderService(
			IModelProviderService modelProviderService) {
		this.modelProviderService = modelProviderService;
	}

	public void setContext(IEclipseContext context) {
		this.context = context;
	}

	private IAction getAction(EObject element, Class<? extends AbstractCreationAction> clazz) {
		try {
			AbstractCreationAction a = (AbstractCreationAction) clazz.newInstance();
			a.setParentElement(element);
			a.setContext(context);
			a.setModelProviderService(modelProviderService);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
