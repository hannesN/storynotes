/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

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

	private Composite container;
	private Label label;
	
	public NavigationItem(Widget parent, int style) {
		super(parent, style);
		container = new Composite((Composite) parent, style);
		container.setLayout(new GridLayout());
		label = new Label(container, SWT.NONE);
	}
	
	@Override
	public void setText(String string) {
		super.setText(string);
		label.setText(string);
		container.layout();
	}
}
