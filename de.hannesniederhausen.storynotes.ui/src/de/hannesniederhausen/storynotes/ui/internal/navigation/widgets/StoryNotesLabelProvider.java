package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.GenericNote;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.SettingNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;

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
		
		if (element instanceof Project)
			return ((Project) element).getName();
		
		if (element instanceof Category)
			return ((Category) element).getName();
		
		if (element instanceof PersonNote) {
			return ((PersonNote) element).getName();
		}
		
		if (element instanceof GenericNote) {
			return ((GenericNote) element).getTitle();
		}
		
		if (element instanceof PlotNote) {
			return ((PlotNote) element).getTitle();
		}
		
		if (element instanceof PersonNote) {
			return ((PersonNote) element).getName();
		}
		
		if (element instanceof SettingNote) {
			return ((SettingNote) element).getName();
		}
		
		return element.toString();
	}
	
	public EStructuralFeature getLabelFeature(Object element) {
		if (element instanceof File) {
			return StorynotesPackage.Literals.FILE__FILENAME;
		}
		
		if (element instanceof Project)
			return StorynotesPackage.Literals.PROJECT__NAME;
		
		if (element instanceof Category)
			return StorynotesPackage.Literals.CATEGORY__NAME;
		
		if (element instanceof PersonNote) {
			return StorynotesPackage.Literals.PERSON_NOTE__NAME;
		}
		
		if (element instanceof GenericNote) {
			return StorynotesPackage.Literals.GENERIC_NOTE__TITLE;
		}
		
		if (element instanceof PlotNote) {
			return StorynotesPackage.Literals.PLOT_NOTE__TITLE;
		}
		
		if (element instanceof SettingNote) {
			return StorynotesPackage.Literals.SETTING_NOTE__NAME;
		}
		return null;
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