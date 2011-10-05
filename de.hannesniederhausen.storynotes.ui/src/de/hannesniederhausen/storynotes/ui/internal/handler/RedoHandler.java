 
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.CommandStack;

public class RedoHandler {
	@Inject
	IEclipseContext context;
	
	CommandStack commandStack;
	
	@CanExecute
	public boolean canExecute() {
		return (commandStack!=null && commandStack.canRedo());
	}
	
	@Execute
	public void execute() {

		if (commandStack!=null && commandStack.canRedo()) {
			commandStack.redo();
		}
	}
	
	/**
	 * @param commandStack the commandStack to set
	 */
	public void setCommandStack(CommandStack commandStack) {
		this.commandStack = commandStack;
	}
}