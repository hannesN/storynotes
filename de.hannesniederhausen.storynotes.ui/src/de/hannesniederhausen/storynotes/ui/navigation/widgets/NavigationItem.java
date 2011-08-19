/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationItem extends Item {

	private ITreeContentProvider contentProvider;
	private ILabelProvider labelProvider;
	private Composite container;
	private Label label;
	
	private Object model;
	
	public NavigationItem(Widget parent, int style, ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object model) {
		super(parent, style);
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		this.model = model;
		container = new Composite((Composite) parent, style);
		container.setLayout(new GridLayout());
		label = new Label(container, SWT.NONE);
		
		setText(labelProvider.getText(model));
		
	}
	
	@Override
	public void setText(String string) {
		super.setText(string);
		label.setText(string);
		container.layout();
	}
}
