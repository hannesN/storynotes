/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.views.category;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.StorynotesPackage.Literals;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * @author Hannes Niederhausen
 *
 */
public class CategoryInputMask extends InputMask {
	private DataBindingContext m_bindingContext;

	private Category category;
	private Table table;
	private TableViewer tableViewer;
	private Label titleLabel;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CategoryInputMask(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		titleLabel = new Label(this, SWT.NONE);
		titleLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		titleLabel.setFont(SWTResourceManager.getFont("Ubuntu", 25, SWT.ITALIC));
		titleLabel.setText("name");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setText("Notes in this category:");
		
		tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnId = tableViewerColumn.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("id");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn_1.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");

	}

	@Override
	protected void checkSubclass() {
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null) {
			m_bindingContext.dispose();
		}
		this.category = (Category) model;
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.FILE_ELEMENT__ID, Literals.NOTE__REF_ID});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		//
		IObservableList categoryNotesObserveList = EMFObservables.observeList(Realm.getDefault(), category, Literals.CATEGORY__NOTES);
		tableViewer.setInput(categoryNotesObserveList);
		//
		IObservableValue titleLabelObserveTextObserveWidget = SWTObservables.observeText(titleLabel);
		IObservableValue categoryNameObserveValue = PojoObservables.observeValue(category, "name");
		bindingContext.bindValue(titleLabelObserveTextObserveWidget, categoryNameObserveValue, null, null);
		//
		return bindingContext;
	}
}
