/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationBar extends StructuredViewer {

	private IActionProvider actionProvider;
	
	private Composite control;
	
	public NavigationBar(Composite parent) {
		init(parent);
	}

	private void init(Composite parent) {
		setCommandProvider(null);
		control = new Composite(parent, SWT.NONE);
		control.setLayout(new GridLayout());
//		control.setData(CSSSWTConstants.CSS_ID_KEY, "navigationBar");
		
	}

	
	
	@Override
	protected Widget doFindInputItem(Object element) {

		if (element==null) {
			return null;
		}
		
		if (element==getInput()||element.equals(getInput())) {
			return doFindItem(element);
		}
		
		return null;
	}


	@Override
	protected Widget doFindItem(Object element) {
		if (element==null)
			return null;
		return null;
	}


	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("rawtypes")
	@Override
	protected List getSelectionFromWidget() {
		return Collections.emptyList();
	}


	@Override
	protected void internalRefresh(Object element) {
		control.layout();
	}


	@Override
	public void reveal(Object element) {
	}


	@SuppressWarnings("rawtypes")
	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
	}


	@Override
	public Control getControl() {
		return control;
	}
	
	/**
	 * Sets the command provider. Setting it to null removes the already set provider.
	 * @param actionProvider the new command provider or <code>null</code>
	 */
	public void setCommandProvider(IActionProvider actionProvider) {
		if (actionProvider==null) {
			this.actionProvider = IActionProvider.NullCommandProvider.getInstance();
		} else {
			this.actionProvider = actionProvider;
		}
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		if (control.isDisposed()) {
			return;
		}
		
		for (Control c : control.getChildren()) {
			c.dispose();
		}
		
		IStructuredContentProvider cp = (IStructuredContentProvider) getContentProvider();
		Object[] elements = cp.getElements(getInput());
		((GridLayout)control.getLayout()).numColumns=elements.length;
		for (Object obj : elements) {
			new NavigationItem(control, SWT.NONE, 
					(ILabelProvider) getLabelProvider(), 
					(ITreeContentProvider) getContentProvider(), 
					actionProvider, obj);
		}
		
	}
	
}
