/**
 * 
 */
package de.hannesniederhausen.storynotes.export.internal.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * Handler for the export command
 * 
 * @author Hannes Niederhausen
 *
 */
public class ExportHandler {

	@Inject
	private IModelProviderService modelProvider;
	
	@CanExecute
	public boolean canExecute() {
		return modelProvider.getFile()!=null;
	}
	
	@Execute
	public void execute() {
		// TODO implement me
		System.out.println("Exporting");
	}
	
}
