/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

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

	private EObject currentModel;
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		currentModel = (EObject) newInput;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof File) {
			return new Object[]{inputElement};
		}
		
		if (inputElement instanceof Project) {
			return new Object[]{((EObject)inputElement).eContainer(), inputElement};
		}
		
		return new Object[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof File) {
			File file = (File) parentElement;
			return file.getProjects().toArray();
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

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		if ((element instanceof File) || (element==null))
			return false;
		return true;
	}

}
