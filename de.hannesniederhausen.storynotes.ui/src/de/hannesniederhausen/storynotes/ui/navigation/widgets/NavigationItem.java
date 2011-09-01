/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Widget;

import de.hannesniederhausen.storynotes.model.Note;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationItem extends Item  {

	private IEclipseContext context;
	private ITreeContentProvider contentProvider;
	private IActionProvider actionProvider;
	private ILabelProvider labelProvider;
	private Composite container;
	
	private Object model;
	private Button siblingButton;
	private Button childrenButton;
	
	public NavigationItem(Widget parent, int style, ILabelProvider labelProvider, 
						  ITreeContentProvider contentProvider, 
						  IEclipseContext context,
						  IActionProvider actionProvider, Object model) {
		super(parent, style);
		this.context = context;
		this.actionProvider = actionProvider;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		this.model = model;
		createControl(parent, style, labelProvider, model);
		
	}

	@Override
	public void setText(String string) {
		super.setText(string);
		siblingButton.setText(string);
		container.layout();
	}

	private void createControl(Widget parent, int style, ILabelProvider labelProvider, Object model) {
		container = new Composite((Composite) parent, style);
		container.setLayout(new GridLayout(2, false));
		
		
		siblingButton = new Button(container, SWT.PUSH);
		siblingButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showSiblingSelectionOptions();
			}
		});
		
		setText(labelProvider.getText(model));
		
		if (model instanceof Note) 
			return;
		
		childrenButton = new Button(container, SWT.PUSH);
		childrenButton.setText(">");
		
		childrenButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showChildSelectionOptions();
			}
		});
		
		
	}


	private void showChildSelectionOptions() {
		Object[] children = contentProvider.getChildren(model);
		
		ChoiceDialog dlg = new ChoiceDialog(container.getShell(), 0,
											context,
											labelProvider, 
											actionProvider, model);
		
		
		dlg.setInput(children);
		
		Point p = childrenButton.toDisplay(0,0);
		p.y += childrenButton.getBounds().height;
		dlg.getShell().setLocation(p);
		
		dlg.open();
		
	}

	private void fillMenu(Object[] children, Menu childMenu) {
		for (Object o : children)  {
			MenuItem item = new MenuItem(childMenu, SWT.PUSH);
			item.setText(labelProvider.getText(o));
		}
	}

	
	private void showSiblingSelectionOptions() {
		Object parent = contentProvider.getParent(model);
		if (parent==null) {
			return;
		}
		
		Object[] children = contentProvider.getChildren(parent);
		
		ChoiceDialog dlg = new ChoiceDialog(container.getShell(), 0,
											context,
											labelProvider, 
											null, model);
		
		
		dlg.setInput(children);
		
		Point p = siblingButton.toDisplay(0,0);
		p.y += siblingButton.getBounds().height;
		dlg.getShell().setLocation(p);
		
		dlg.open();
	}
}
