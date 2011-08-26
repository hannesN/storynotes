/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.core.resources.ICommand;

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
public interface ICommandProvider {

	/**
	 * Returns an array of commands for the specific element
	 * 
	 * @param element
	 *            the element which for the commands
	 * 
	 * @return an array if {@link ICommand}; must not be <code>null</code> but
	 *         may be empty
	 */
	public ICommand[] getCommand(Object element);

	public static class NullCommandProvider implements ICommandProvider {

		public static NullCommandProvider instance;

		public static ICommandProvider getInstance() {
			if (instance == null) {
				instance = new NullCommandProvider();
			}
			return instance;
		}
		
		private NullCommandProvider() {
		}

		@Override
		public ICommand[] getCommand(Object element) {
			return new ICommand[0];
		}

	}
}
