 
package de.hannesniederhausen.storynotes.ui.internal.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

public class UndoHandler extends CommandStackHandler {
	
	@CanExecute
	public boolean canExecute() {
		return (getCommandStack()!=null && getCommandStack().canUndo());
	}
	
	
	@Execute
	public void execute() {
		if (getCommandStack()!=null && getCommandStack().canUndo()) {
			getCommandStack().undo();
		}
	}	
}