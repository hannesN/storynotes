/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import org.eclipse.emf.common.command.CommandStack;

/**
 * @author niederhausen
 *
 */
public class CommandStackHandler {

	private CommandStack commandStack;

	/**
	 * 
	 */
	public CommandStackHandler() {
		super();
	}

	/**
	 * @param commandStack the commandStack to set
	 */
	public void setCommandStack(CommandStack commandStack) {
		this.commandStack = commandStack;
	}
	
	/**
	 * @return the commandStack
	 */
	protected CommandStack getCommandStack() {
		return commandStack;
	}

}