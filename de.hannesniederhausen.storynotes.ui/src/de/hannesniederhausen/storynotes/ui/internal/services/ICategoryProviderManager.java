/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import java.util.Collection;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;

/**
 * Interface for the provider manager.
 * 
 * @author Hannes Niederhausen
 *
 */
public interface ICategoryProviderManager {

	public Collection<ICategoryProviderService> getServices();
	
	/**
	 * Returns a category service if it exists. If the class object represents a class
	 * all implemented interfaces are checked too.
	 * 
	 * @param clazz
	 * @return <code>null</code> or the first found category service
	 */
	public ICategoryProviderService getServiceFor(Class<? extends Category> clazz);
	
}
