/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.GenericNote;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;

/**
 * @author Hannes Niederhausen
 *
 */
public class GenericNoteInputMask extends InputMask {
	private DataBindingContext m_bindingContext;

	private GenericNote note;
	private Text titleText;
	private Text descriptionText;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GenericNoteInputMask(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Label lblTitle = new Label(this, SWT.NONE);
		lblTitle.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTitle.setText("Title:");
		
		titleText = new Text(this, SWT.BORDER);
		titleText.setMessage("Title");
		titleText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblContent = new Label(this, SWT.NONE);
		lblContent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblContent.setText("Content:");
		
		descriptionText = new Text(this, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		

	}

	@Override
	protected void checkSubclass() {
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null)
			m_bindingContext.dispose();
		this.note = (GenericNote) model;
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables.observeDelayedValue(50, SWTObservables.observeText(titleText, SWT.Modify));
		IObservableValue noteTitleObserveValue = PojoObservables.observeValue(note, "title");
		bindingContext.bindValue(textObserveTextObserveWidget, noteTitleObserveValue, null, null);
		//
		IObservableValue text_1ObserveTextObserveWidget = SWTObservables.observeDelayedValue(500, SWTObservables.observeText(descriptionText, SWT.Modify));
		IObservableValue noteDescriptionObserveValue = PojoObservables.observeValue(note, "description");
		bindingContext.bindValue(text_1ObserveTextObserveWidget, noteDescriptionObserveValue, null, null);
		//
		return bindingContext;
	}
}
