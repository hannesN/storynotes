/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class OpenHandler {
	@Inject
	private IModelProviderService modelProviderService;
	
	@Inject
	IEclipseContext context;
	
	@Execute
	public void execute() {
		
		String filename = null;
		// TODO get Filename
		
		modelProviderService.loadFile(filename);
	}
}
