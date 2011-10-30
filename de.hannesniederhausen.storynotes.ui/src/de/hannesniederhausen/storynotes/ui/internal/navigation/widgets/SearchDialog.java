/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import org.apache.lucene.document.Document;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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

import de.hannesniederhausen.storynotes.model.service.IModelProviderService;

/**
 * @author Hannes Niederhausen
 * 
 */
public class SearchDialog extends Dialog implements FocusListener,
		IDoubleClickListener, KeyListener {

	private TableViewer viewer;
	private Shell shell;
	private IEclipseContext context;

	public SearchDialog(Shell parent, int style, IEclipseContext context) {
		super(parent, style);
		this.context = context;
		init(parent);
	}

	private void init(Shell parent) {
		shell = new Shell(parent, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setSize(300, 300);

		shell.setLayout(new GridLayout());

		viewer = new TableViewer(shell);
		viewer.setLabelProvider(new DocumentLabelProvider());
		viewer.setContentProvider(ArrayContentProvider.getInstance());
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
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent arg0) {
//		getShell().close();
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
		
		Document d = (Document) o;
		
		IModelProviderService mps = context.get(IModelProviderService.class);
		
		context.get(ESelectionService.class).setSelection(mps.getElementById(Long.parseLong(d.get("id"))));
		

		if (!getShell().isDisposed()) {
			getShell().close();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.CR) {
			processSelection();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private class DocumentLabelProvider implements ILabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
		}

		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public String getText(Object element) {
			return ((Document) element).get("field_label");
		}

	}
}
