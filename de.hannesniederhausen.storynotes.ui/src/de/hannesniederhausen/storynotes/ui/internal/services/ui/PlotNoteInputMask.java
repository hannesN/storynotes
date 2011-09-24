/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;

/**
 * This input mask provides a form for the {@link PlotNote}.
 * 
 * @author Hannes Niederhausen
 *
 */
public class PlotNoteInputMask extends InputMask {
	private DataBindingContext m_bindingContext;

	private PlotNote model;
	private Text nameText;
	private Text contentText;

	
	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null)
			m_bindingContext.dispose();
		this.model = (PlotNote) model;
		m_bindingContext = initDataBindings();
	}

	/* (non-Javadoc)
	 * @see de.hannesniederhausen.storynotes.ui.views.InputMask#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		comp.setLayout(gridLayout);
		
		Label lblPlotNote = new Label(comp, SWT.NONE);
		lblPlotNote.setText("Plot Note:");
		new Label(comp, SWT.NONE);
		
		Label lblTitle = new Label(comp, SWT.NONE);
		lblTitle.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTitle.setText("Name:");
		
		nameText = new Text(comp, SWT.BORDER);
		nameText.setMessage("Chapter 1");
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblContent = new Label(comp, SWT.NONE);
		lblContent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblContent.setText("Content:");
		
		contentText = new Text(comp, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		contentText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		contentText.setMessage("The protagonist walk alone at the beach. No one is there...");
		
		if (model!=null)
			m_bindingContext = initDataBindings();
		
		setControl(comp);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(nameText, SWT.Modify));
		IObservableValue modelTitleObserveValue = PojoObservables.observeValue(model, "title");
		bindingContext.bindValue(nameTextObserveTextObserveWidget, modelTitleObserveValue, null, null);
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(contentText, SWT.Modify));
		IObservableValue modelDescriptionObserveValue = PojoObservables.observeValue(model, "description");
		bindingContext.bindValue(textObserveTextObserveWidget, modelDescriptionObserveValue, null, null);
		//
		return bindingContext;
	}
}

