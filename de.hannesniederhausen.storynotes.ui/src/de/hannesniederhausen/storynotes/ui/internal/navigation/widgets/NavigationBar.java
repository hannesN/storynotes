/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.navigation.widgets;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import de.hannesniederhausen.storynotes.model.StorynotesPackage;

/**
 * @author Hannes Niederhausen
 *
 */
public class NavigationBar extends StructuredViewer implements ModifyListener {

	private ESelectionService selectionService;
	
	private IActionProvider actionProvider;
	
	private Composite control;

	private IEclipseContext context;
	
	private DataBindingContext bindingContext;
	
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

	public void setSelectionService(ESelectionService selectionService) {
		this.selectionService = selectionService;
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
		control.setLayout(new RowLayout(SWT.HORIZONTAL));
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


	@SuppressWarnings("rawtypes")
	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		if (control.isDisposed()) {
			return;
		}
		
		for (Control c : control.getChildren()) {
			c.dispose();
		}
		
		if (bindingContext!=null)
			bindingContext.dispose();
		
		bindingContext = new DataBindingContext();
		
		IStructuredContentProvider cp = (IStructuredContentProvider) getContentProvider();
		Object[] elements = cp.getElements(getInput());
		
		StoryNotesLabelProvider lp = (StoryNotesLabelProvider) getLabelProvider();
		
//		((GridLayout)control.getLayout()).numColumns=elements.length;
		for (Object obj : elements) {
			NavigationItem item = new NavigationItem(control, SWT.NONE, 
					lp, 
					(ITreeContentProvider) getContentProvider(), 
					context,
					actionProvider, obj);
			
			IObservableValue itemObservableValue = SWTObservables.observeText(item);
			IObservableValue modelObserveValue = EMFProperties.value(lp.getLabelFeature(obj)).observe(obj);
			
			bindingContext.bindValue(itemObservableValue, modelObserveValue, null, null);
			
		}
		control.layout(true);
	}
	
	private void initSearchText() {
		Text searchText = new Text(control, SWT.BORDER|SWT.CANCEL);
		searchText.addModifyListener(this);
	}

	public void setContext(IEclipseContext context) {
		this.context = context;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	@Override
	public void modifyText(ModifyEvent e) {
		// TODO do something: search and show results
	}
	
	private class ModelObservableValue extends AbstractObservableValue {

		
		
		@Override
		public Object getValueType() {
			return String.class;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
		 */
		@Override
		protected Object doGetValue() {
			
			return null;
		}
	}
}
