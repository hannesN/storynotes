/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;

/**
 * A {@link IContentProvider} used by the navigation bar, which
 * creates the content based on an Storynotes model element.
 * 
 * It iterates through the eContainer attirbutes to create the 
 * list for the navigation. 
 *  
 * @author Hannes Niederhausen
 *
 */
public class StoryNotesModelContentProvider implements ITreeContentProvider{

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		ArrayList<EObject> parents = new ArrayList<EObject>(5);
		
		EObject currObject = (EObject) inputElement;
		
		do {
			parents.add(currObject);
			currObject = currObject.eContainer();
		} while (currObject!=null);
			
		Collections.reverse(parents);
		return parents.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof File) {
			File file = (File) parentElement;
			return file.getProjects().toArray();
		}
		
		if (parentElement instanceof Category) {
			Category c = (Category) parentElement;
			return c.getNotes().toArray();
		}
		
		if (parentElement instanceof Project) {
			Project p = (Project) parentElement;
			return p.getCategories().toArray();
		}
		
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if ((element instanceof File) || (element==null))
			return null;
		else
			return ((EObject)element).eContainer();
	}

	@Override
	public boolean hasChildren(Object element) {
		if ((element instanceof File) || (element==null))
			return false;
		return true;
	}

}
