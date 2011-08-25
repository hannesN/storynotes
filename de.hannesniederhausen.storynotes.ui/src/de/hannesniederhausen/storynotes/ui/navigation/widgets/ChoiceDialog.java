/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.navigation.widgets;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Hannes Niederhausen
 * 
 */
public class ChoiceDialog extends Dialog implements FocusListener {

	private TableViewer viewer;
	private Shell shell;

	public ChoiceDialog(Shell parent, int style, ILabelProvider labelProvider) {
		super(parent, style);
		init(parent);
		viewer.setLabelProvider(labelProvider);
	}

	private void init(Shell parent) {
		shell = new Shell(parent, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setSize(400, 300);

		shell.setLayout(new GridLayout());

		viewer = new TableViewer(shell);
		viewer.setContentProvider(ArrayContentProvider.getInstance());

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

}
