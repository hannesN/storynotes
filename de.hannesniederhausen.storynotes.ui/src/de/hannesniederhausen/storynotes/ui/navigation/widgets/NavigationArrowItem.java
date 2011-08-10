/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationArrowItem extends Item {

	public NavigationArrowItem(Widget parent, int style) {
		super(parent, style);
		setText("->");
	}

}
