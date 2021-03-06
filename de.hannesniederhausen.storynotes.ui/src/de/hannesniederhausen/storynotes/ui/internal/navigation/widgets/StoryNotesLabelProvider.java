package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.annotations.IAnnotationConstants;

public class StoryNotesLabelProvider implements ILabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof File) {
			String filename = ((File) element).getFilename();
			if (filename==null)
				filename = "Unnamed file";
			else {
				java.io.File f = new java.io.File(filename);
				filename=f.getName();
			}
			return filename;
		}
		
		EStructuralFeature lf = getLabelFeature(element);
		if (lf!=null) {
			EObject e = (EObject) element;
			return e.eGet(lf).toString();
		}
		
		return "";
	}
	
	public EStructuralFeature getLabelFeature(Object element) {
		
		EObject e = (EObject) element;
		
		EStructuralFeature labelFeature = null;
		
		for (EStructuralFeature f : e.eClass().getEAllStructuralFeatures()) {
			if (f.getEAnnotation(IAnnotationConstants.MODEL_LABEL)!=null) {
				labelFeature=f;
				break;
			}
		}
		
		return labelFeature;
		
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}
}