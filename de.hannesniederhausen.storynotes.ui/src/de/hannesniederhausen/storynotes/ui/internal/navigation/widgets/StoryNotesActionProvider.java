/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.ui.internal.actions.AbstractCreationAction;
import de.hannesniederhausen.storynotes.ui.internal.actions.CreateProjectAction;
import de.hannesniederhausen.storynotes.ui.internal.services.ICategoryProviderManager;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateGenericNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreatePersonNote;
import de.hannesniederhausen.storynotes.ui.internal.services.actions.CreateSettingNote;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class StoryNotesActionProvider implements IActionProvider {

	private IEclipseContext context;
	private ICategoryProviderManager categoryProviderManager;
	
	@Override
	public IAction[] getActions(Object element) {
		
		if (element instanceof File) {
			return new IAction[]{getAction((EObject)element, CreateProjectAction.class)};
		} 
		
		if (element instanceof Project) {
			List<IAction> actionList = new ArrayList<IAction>();
			for (ICategoryProviderService cps : categoryProviderManager.getServices()) {
				IAction a = cps.getCategoryActions(context, (EObject) element);
				if (a.isEnabled())
					actionList.add(a);
			}
			return actionList.toArray(new IAction[actionList.size()]);
		}
		
		if (element instanceof Category) {
			ICategoryProviderService s = categoryProviderManager.getServiceFor(((Category)element).getClass());
			return s.getNoteActions(context, (EObject) element);
		}
		
		return new IAction[0];
	}
	

	public void setContext(IEclipseContext context) {
		this.context = context;
		this.categoryProviderManager = context.get(ICategoryProviderManager.class);
	}

	private IAction getAction(EObject element, Class<? extends AbstractCreationAction> clazz) {
		try {
			AbstractCreationAction a = (AbstractCreationAction) clazz.newInstance();
			a.setParentElement(element);
			a.setContext(context);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
