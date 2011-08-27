/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Hannes Niederhausen
 * 
 */
public class ChoiceDialog extends Dialog implements FocusListener {

	private IActionProvider actionProvider;
	private ILabelProvider labelProvider;
	private TableViewer viewer;
	private Shell shell;
	

	public ChoiceDialog(Shell parent, int style, ILabelProvider labelProvider, IActionProvider actionProvider) {
		super(parent, style);
		init(parent);
		this.actionProvider = actionProvider;
		this.labelProvider = labelProvider;
	}

	private void init(Shell parent) {
		shell = new Shell(parent, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setSize(400, 300);

		shell.setLayout(new GridLayout());

		viewer = new TableViewer(shell);
		viewer.setLabelProvider(new LabelProvider());
		viewer.setContentProvider(new ContentProvider());

		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.getControl().addFocusListener(this);
	}

	public Shell getShell() {
		return shell;
	}

	public void setInput(Object input) {
		viewer.setInput(input);
	}

	public void open() {
		getShell().setVisible(true);
		setFocus();
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		getShell().close();
	}

	private class ContentProvider extends ArrayContentProvider {
		@Override
		public Object[] getElements(Object arg0) {

			IAction[] actions = actionProvider.getActions(arg0);
			Object[] elements = super.getElements(arg0);
			if (actions.length==0) {
				return elements;
			}
			
			Object[] results = new Object[actions.length+elements.length];
			System.arraycopy(actions, 0, results, 0, actions.length);
			System.arraycopy(elements, 0, results, actions.length, elements.length);
			return null;
		}
		
	}
	
	private class LabelProvider implements ILabelProvider {

		@Override
		public void addListener(ILabelProviderListener arg0) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean isLabelProperty(Object arg0, String arg1) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener arg0) {
		}

		@Override
		public Image getImage(Object arg0) {
			return labelProvider.getImage(arg0);
		}

		@Override
		public String getText(Object arg0) {
			if (arg0 instanceof IAction) {
				return ((IAction) arg0).getText();
			}
			return labelProvider.getText(arg0);
		}
		
	}
}
