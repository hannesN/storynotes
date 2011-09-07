/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;

/**
 * @author Hannes Niederhausen
 *
 */
public class CategoryProviderManager implements ICategoryProviderManager {

	
	public Map<Class<? extends Category>, ICategoryProviderService> services;
	
	/**
	 * 
	 */
	public CategoryProviderManager() {
		services = new HashMap<Class<? extends Category>, ICategoryProviderService>();
	}
	
	@Override
	public Collection<ICategoryProviderService> getServices() {
		return services.values();
	}
	
	/**
	 * @param services the services to set
	 */
	public void addService(ICategoryProviderService service) {
		this.services.put(service.getCategoryClass(), service);
	}
	
	public void removeService(ICategoryProviderService service) {
		this.services.remove(service.getCategoryClass());
	}

	@Override
	public ICategoryProviderService getServiceFor(
			Class<? extends Category> clazz) {
		ICategoryProviderService result = this.services.get(clazz);
		
		if (result == null) {
			for (Entry<Class<? extends Category>, ICategoryProviderService> e : services.entrySet()) {
				if (e.getKey().isAssignableFrom(clazz)) {
					return e.getValue();
				}
			}
		}
		
		return result;
	}
	
}
