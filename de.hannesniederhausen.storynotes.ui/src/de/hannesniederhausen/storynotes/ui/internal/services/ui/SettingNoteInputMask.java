/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.model.SettingNote;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * This input mask provides a form for the {@link PlotNote}.
 * 
 * @author Hannes Niederhausen
 *
 */
public class SettingNoteInputMask extends InputMask {
	private DataBindingContext m_bindingContext;

	private SettingNote model;
	private Text nameText;
	private Text contentText;
	private Text typeText;

	/**
	 * @param parent
	 * @param style
	 */
	public SettingNoteInputMask(Composite parent, int style) {
		super(parent, style);
		init(parent, style);
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null)
			m_bindingContext.dispose();
		this.model = (SettingNote) model;
		m_bindingContext = initDataBindings();
	}

	
	private void init(Composite parent, int style) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		setLayout(gridLayout);
		
		Label lblPlotNote = new Label(this, SWT.NONE);
		lblPlotNote.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblPlotNote.setText("Setting Note:");
		
		Label lblTitle = new Label(this, SWT.NONE);
		lblTitle.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTitle.setText("Name:");
		
		nameText = new Text(this, SWT.BORDER);
		nameText.setMessage("Chapter 1");
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblType = new Label(this, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Type:");
		
		typeText = new Text(this, SWT.BORDER);
		typeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblContent = new Label(this, SWT.NONE);
		lblContent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblContent.setText("Content:");
		
		contentText = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		contentText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		contentText.setMessage("The protagonist walk alone at the beach. No one is there...");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		if (model!=null)
			m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(nameText, SWT.Modify));
		IObservableValue modelTitleObserveValue = PojoObservables.observeValue(model, "name");
		bindingContext.bindValue(nameTextObserveTextObserveWidget, modelTitleObserveValue, null, null);
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(contentText, SWT.Modify));
		IObservableValue modelDescriptionObserveValue = PojoObservables.observeValue(model, "description");
		bindingContext.bindValue(textObserveTextObserveWidget, modelDescriptionObserveValue, null, null);
		//
		IObservableValue typeTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(typeText, SWT.Modify));
		IObservableValue modelKindObserveValue = PojoObservables.observeValue(model, "kind");
		bindingContext.bindValue(typeTextObserveTextObserveWidget, modelKindObserveValue, null, null);
		//
		return bindingContext;
	}
}

