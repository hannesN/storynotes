/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import java.util.Arrays;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.PlotCategory;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import de.hannesniederhausen.storynotes.model.StorynotesPackage.Literals;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

/**
 * {@link InputMask} for the {@link PlotCategory}
 * 
 * @author Hannes Niederhausen
 * 
 */
public class PlotCategoryInputMask extends InputMask implements IDoubleClickListener {
	private DataBindingContext m_bindingContext;

	private PlotCategory model;
	private Table table;
	private CheckboxTableViewer checkboxTableViewer;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);

		setControl(comp);
		comp.setLayout(new GridLayout(1, false));

		Label lblPlotNotes = new Label(comp, SWT.NONE);
		lblPlotNotes.setText("Plot Notes:");

		checkboxTableViewer = CheckboxTableViewer.newCheckList(comp, SWT.BORDER | SWT.FULL_SELECTION);
		checkboxTableViewer.setColumnProperties(new String[] { "Title",
				"Version", "insideOutline" });
		checkboxTableViewer.addDoubleClickListener(this);
		table = checkboxTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableColumn tblclmnTitle = new TableColumn(table, SWT.NONE);
		tblclmnTitle.setWidth(100);
		tblclmnTitle.setText("Title");
		
		TableColumn tblclmnNumber = new TableColumn(table, SWT.NONE);
		tblclmnNumber.setWidth(100);
		tblclmnNumber.setText("Number");
		
		TableColumn tblclmnInsideoutline = new TableColumn(table, SWT.NONE);
		tblclmnInsideoutline.setWidth(100);
		tblclmnInsideoutline.setText("insideOutline");

		Button removeButton = new Button(comp, SWT.NONE);
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object[] checkedElements = checkboxTableViewer.getCheckedElements();
				if (checkedElements.length==0)
					return;
				
				EditingDomain editingDomain = getEclipseContext().get(EditingDomain.class);
				
				RemoveCommand cmd = new RemoveCommand(editingDomain, model.getNotes(), Arrays.asList(checkedElements));
				editingDomain.getCommandStack().execute(cmd);
				
			}
		});
		removeButton.setText("Remove Selection");

		if (model != null)
			m_bindingContext = initDataBindings();
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext != null)
			m_bindingContext.dispose();

		this.model = (PlotCategory) model;

		m_bindingContext = initDataBindings();
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { Literals.PLOT_NOTE__TITLE,
						Literals.PLOT_NOTE__NUMBER,
						Literals.PLOT_NOTE__INSIDE_OUTLINE });
		checkboxTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMaps));
		//
		checkboxTableViewer.setContentProvider(listContentProvider);
		//
		IObservableList modelNotesObserveList = EMFObservables.observeList(
				Realm.getDefault(), model, Literals.CATEGORY__NOTES);
		checkboxTableViewer.setInput(modelNotesObserveList);
		//
		return bindingContext;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		Object sel = ((IStructuredSelection) event.getSelection()).getFirstElement();
		getEclipseContext().get(ESelectionService.class).setSelection(sel);
	}
}
