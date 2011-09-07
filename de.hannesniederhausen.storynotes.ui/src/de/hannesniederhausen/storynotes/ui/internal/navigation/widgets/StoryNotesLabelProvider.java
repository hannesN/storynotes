package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

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

public class StoryNotesLabelProvider implements ILabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof File) {
			String filename = ((File) element).getFilename();
			if (filename==null)
				filename = "Unnamed file";
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