/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import java.util.Arrays;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import de.hannesniederhausen.storynotes.model.PersonCategory;
import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
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

	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(1, false));
		
		Label lblPlotNotes = new Label(comp, SWT.NONE);
		lblPlotNotes.setText("Person Notes:");

		checkboxTableViewer = CheckboxTableViewer.newCheckList(comp, SWT.BORDER
				| SWT.FULL_SELECTION);
		checkboxTableViewer.setColumnProperties(new String[] { "Name" });
		checkboxTableViewer.setAllGrayed(false);
		checkboxTableViewer.setAllChecked(false);
		checkboxTableViewer.addDoubleClickListener(this);
		table = checkboxTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Button deleteButton = new Button(comp, SWT.PUSH);
		deleteButton.setText("Delete Selected Persons");
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object[] checkedElements = checkboxTableViewer.getCheckedElements();
				if (checkedElements.length==0)
					return;
				
				EditingDomain ed = getEclipseContext().get(EditingDomain.class);
				
				Command cmd = RemoveCommand.create(ed, category, StorynotesPackage.Literals.CATEGORY__NOTES, Arrays.asList(checkedElements));
				
				if (cmd.canExecute()) {
					ed.getCommandStack().execute(cmd);
				}
			}
		});
		
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
		IObservableList categoryNotesObserveList = EMFProperties.list(StorynotesPackage.Literals.CATEGORY__NOTES).observe(category); 
		checkboxTableViewer.setInput(categoryNotesObserveList);
		//
		return bindingContext;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		IStructuredSelection sel = (IStructuredSelection) checkboxTableViewer.getSelection();
		
		ESelectionService eSelectionService = getEclipseContext().get(ESelectionService.class);
		eSelectionService.setSelection(sel.getFirstElement());
	}
}
