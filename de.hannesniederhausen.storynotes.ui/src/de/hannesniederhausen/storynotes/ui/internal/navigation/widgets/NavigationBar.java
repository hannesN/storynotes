/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import java.util.Collections;
import java.util.List;

import org.apache.lucene.document.Document;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import de.hannesniederhausen.storynotes.ui.internal.index.ModelIndexer;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationBar extends StructuredViewer implements ModifyListener {

	private IActionProvider actionProvider;
	
	private Composite control;

	private IEclipseContext context;
	
	private DataBindingContext bindingContext;

	private Composite naviComp;

	private SearchDialog searchDialog;
	
	public NavigationBar(Composite parent) {
		init(parent);
	}

	@Override
	public void reveal(Object element) {
	}

	@Override
	public Control getControl() {
		return control;
	}

	/**
	 * Sets the action provider. Setting it to null removes the already set provider.
	 * @param actionProvider the new action provider or <code>null</code>
	 */
	public void setActionProvider(IActionProvider actionProvider) {
		if (actionProvider==null) {
			this.actionProvider = IActionProvider.NullActionProvider.getInstance();
		} else {
			this.actionProvider = actionProvider;
		}
	}

	private void init(Composite parent) {
		setActionProvider(null);
		control = new Composite(parent, SWT.NONE);
		control.setLayout(new GridLayout(2, false));
		naviComp = new Composite(control, SWT.NONE);
		naviComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		naviComp.setLayout(new RowLayout(SWT.HORIZONTAL));
//		control2.setData(CSSSWTConstants.CSS_ID_KEY, "navigationBar");
		
		Text searchText = new Text(control, SWT.BORDER|SWT.CANCEL|SWT.SEARCH);
		GridData gd = new GridData();
		gd.widthHint = 150;
		searchText.setLayoutData(gd);
		searchText.addModifyListener(this);
		
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


	@SuppressWarnings("rawtypes")
	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		if (naviComp.isDisposed()) {
			return;
		}
		
		for (Control c : naviComp.getChildren()) {
			c.dispose();
		}
		
		if (bindingContext!=null)
			bindingContext.dispose();
		
		bindingContext = new DataBindingContext();
		
		IStructuredContentProvider cp = (IStructuredContentProvider) getContentProvider();
		Object[] elements = cp.getElements(getInput());
		
		StoryNotesLabelProvider lp = (StoryNotesLabelProvider) getLabelProvider();
		
//		((GridLayout)control2.getLayout()).numColumns=elements.length;
		for (Object obj : elements) {
			NavigationItem item = new NavigationItem(naviComp, SWT.NONE, 
					lp, 
					(ITreeContentProvider) getContentProvider(), 
					context,
					actionProvider, obj);
			
			IObservableValue itemObservableValue = SWTObservables.observeText(item);
			IObservableValue modelObserveValue = EMFProperties.value(lp.getLabelFeature(obj)).observe(obj);
			
			bindingContext.bindValue(itemObservableValue, modelObserveValue, null, null);
			
		}
		
		naviComp.layout(true);
	}
	

	public void setContext(IEclipseContext context) {
		this.context = context;
	}
	
	@Override
	public void modifyText(ModifyEvent e) {
		Text searchText = (Text) e.widget;
		String text = searchText.getText();
		
		if (text.length()<3)
			return;
		
		ModelIndexer mi = context.get(ModelIndexer.class);
		
		List<Document> result = mi.query(text);
		
		if (searchDialog==null) {
			searchDialog = new SearchDialog(control.getShell(), SWT.NONE, context);
		}
	
		searchDialog.setInput(result);
		searchDialog.open();
		Point p = searchText.toDisplay(0,0);
		Rectangle searchBounds = searchText.getBounds();
		p.y += searchBounds.height;
		p.x -= Math.max(0, (searchDialog.getShell().getBounds().width-searchBounds.width));
		searchDialog.getShell().setLocation(p);
		
		System.out.println(searchDialog.getShell().getBounds());
		
	}
}
