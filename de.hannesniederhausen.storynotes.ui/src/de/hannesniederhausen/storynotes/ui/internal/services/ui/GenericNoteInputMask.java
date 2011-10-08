/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.GenericNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
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

	
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		
		Label lblTitle = new Label(comp, SWT.NONE);
		lblTitle.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTitle.setText("Title:");
		
		titleText = new Text(comp, SWT.BORDER);
		titleText.setMessage("Title");
		titleText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblContent = new Label(comp, SWT.NONE);
		lblContent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblContent.setText("Content:");
		
		descriptionText = new Text(comp, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		setControl(comp);
		
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null)
			m_bindingContext.dispose();
		this.note = (GenericNote) model;
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		EditingDomain ed = getEclipseContext().get(EditingDomain.class);
		
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(titleText, SWT.Modify));
		IObservableValue noteTitleObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.GENERIC_NOTE__TITLE).observe(note);
		bindingContext.bindValue(textObserveTextObserveWidget, noteTitleObserveValue, null, null);
		//
		IObservableValue text_1ObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(descriptionText, SWT.Modify));
		IObservableValue noteDescriptionObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.GENERIC_NOTE__DESCRIPTION).observe(note);
		bindingContext.bindValue(text_1ObserveTextObserveWidget, noteDescriptionObserveValue, null, null);
		//
		return bindingContext;
	}
}
