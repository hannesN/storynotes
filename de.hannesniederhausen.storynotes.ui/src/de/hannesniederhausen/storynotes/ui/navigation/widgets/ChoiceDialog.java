/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Hannes Niederhausen
 * 
 */
public class ChoiceDialog extends Dialog implements FocusListener, IDoubleClickListener, KeyListener {

	private IActionProvider actionProvider;
	private ILabelProvider labelProvider;
	private TableViewer viewer;
	private Shell shell;
	private final Object model;
	private ESelectionService selectionService;

	public ChoiceDialog(Shell parent, int style, 
						ESelectionService selectionService, ILabelProvider labelProvider, 
						IActionProvider actionProvider, Object model) {
		super(parent, style);
		this.selectionService = selectionService;
		this.model = model;
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
		viewer.addDoubleClickListener(this);

		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.getControl().addFocusListener(this);
		viewer.getControl().addKeyListener(this);
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

	@Override
	public void doubleClick(DoubleClickEvent event) {
		processSelection();
	}
	
	private void processSelection() {
		IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
		if (sel.isEmpty())
			return;
		Object o = sel.getFirstElement();
		if (o instanceof IAction) {
			((IAction) o).run();
		} else {
			selectionService.setSelection(o);
		}
		getShell().close();
	}
	
	private class ContentProvider extends ArrayContentProvider {
		@Override
		public Object[] getElements(Object arg0) {

			IAction[] actions = actionProvider.getActions(model);
			Object[] elements = super.getElements(arg0);
			if (actions.length==0) {
				return elements;
			}
			
			Object[] results = new Object[actions.length+elements.length];
			System.arraycopy(actions, 0, results, 0, actions.length);
			System.arraycopy(elements, 0, results, actions.length, elements.length);
			return results;
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.keyCode==SWT.CR) {
			processSelection();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
