/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import org.eclipse.jface.action.IAction;

/**
 * A command provider provides command for specific elements for the drop down
 * lists.
 * 
 * These actions are shown in the drop down lists of the navigation item. Mostly
 * they will be "create new element" commands.
 * 
 * @author Hannes Niederhausen
 * 
 */
public interface IActionProvider {

	/**
	 * Returns an array of {@link IAction} for the specific element
	 * 
	 * @param element
	 *            the element which for the commands
	 * 
	 * @return an array if {@link IAction}; must not be <code>null</code> but
	 *         may be empty
	 */
	public IAction[] getActions(Object element);

	public static class NullActionProvider implements IActionProvider {

		public static NullActionProvider instance;

		public static IActionProvider getInstance() {
			if (instance == null) {
				instance = new NullActionProvider();
			}
			return instance;
		}
		
		private NullActionProvider() {
		}

		@Override
		public IAction[] getActions(Object element) {
			return new IAction[0];
		}

	}
}
