/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import de.hannesniederhausen.storynotes.model.PersonCategory;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * InputMask for the person category.
 * 
 * @author Hannes Niederhausen
 * 
 */
public class PersonCategoryInputMask extends InputMask implements IDoubleClickListener {
	private DataBindingContext m_bindingContext;

	private PersonCategory category;
	private Table table;
	private CheckboxTableViewer checkboxTableViewer;

	
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(1, false));

		checkboxTableViewer = CheckboxTableViewer.newCheckList(comp, SWT.BORDER
				| SWT.FULL_SELECTION);
		checkboxTableViewer.setColumnProperties(new String[] { "Name" });
		checkboxTableViewer.setAllGrayed(false);
		checkboxTableViewer.setAllChecked(false);
		table = checkboxTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		setControl(comp);
	}
	
	@Override
	public void setModel(EObject model) {
		if (m_bindingContext != null) {
			m_bindingContext.dispose();

		}

		category = (PersonCategory) model;

		m_bindingContext = initDataBindings();
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), PersonNote.class, "name");
		checkboxTableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		checkboxTableViewer.setContentProvider(listContentProvider);

		//
		IObservableList categoryNotesObserveList = PojoObservables.observeList(
				Realm.getDefault(), category, "notes");
		checkboxTableViewer.setInput(categoryNotesObserveList);
		//
		return bindingContext;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		IStructuredSelection sel = (IStructuredSelection) checkboxTableViewer.getSelection();
		
		// TODO set selection
	}
}
