/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import java.util.Collections;
import java.util.List;

import org.eclipse.e4.ui.css.swt.CSSSWTConstants;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationBar extends StructuredViewer {

	private Composite control;
	
	public NavigationBar(Composite parent) {
		init(parent);
	}

	private void init(Composite parent) {
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
					(ITreeContentProvider) getContentProvider(), obj);
		}
		
	}
	
}
