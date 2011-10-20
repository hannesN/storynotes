/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.LabelProvider;

import de.hannesniederhausen.storynotes.model.annotations.IAnnotationConstants;

/**
 * Label provider which parses the features of the EMF generated model for the label annotation and uses this feature as text.
 * 
 * 
 * 
 * @author Hannes Niederhausen
 *
 */
public class StorynotesModelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (!(element instanceof EObject)) {
			throw new IllegalArgumentException("Model must be instances of EOBject!");
		}
		
		EObject e = (EObject) element;
		
		EStructuralFeature labelFeature = null;
		
		for (EStructuralFeature f : e.eClass().getEAllStructuralFeatures()) {
			if (f.getEAnnotation(IAnnotationConstants.MODEL_LABEL)!=null) {
				labelFeature=f;
				break;
			}
		}
		
		if (labelFeature==null)
			throw new IllegalArgumentException("Missing annotation in element: "+element);
		
		Object val = e.eGet(labelFeature);
		
		if (val==null)
			throw new IllegalArgumentException("Label Feature is null in element: "+element);
		
		return val.toString();
	}
	
}
