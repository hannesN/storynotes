 
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.CommandStack;

public class UndoHandler {
	
	@Inject
	IEclipseContext context;
	
	CommandStack commandStack;
	
	@CanExecute
	public boolean canExecute() {
		return (commandStack!=null && commandStack.canUndo());
	}
	
	
	@Execute
	public void execute() {
		
		if (commandStack!=null && commandStack.canUndo()) {
			commandStack.undo();
		}
	}
	
	/**
	 * @param commandStack the commandStack to set
	 */
	public void setCommandStack(CommandStack commandStack) {
		this.commandStack = commandStack;
	}
}