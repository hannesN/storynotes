/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.services.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage.Literals;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

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
	private Text text;
	private Button inOutlineCheckButton;

	
	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null)
			m_bindingContext.dispose();
		this.model = (PlotNote) model;
		m_bindingContext = initDataBindings();
	}

	/**
	 * @wbp.parser.entryPoint
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
		
		Label lblPartOfOutline = new Label(comp, SWT.NONE);
		lblPartOfOutline.setText("Part of Outline:");
		
		Composite composite = new Composite(comp, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.marginWidth = 0;
		composite.setLayout(gl_composite);
		
		inOutlineCheckButton = new Button(composite, SWT.CHECK);
		inOutlineCheckButton.setBounds(0, 0, 115, 24);
		
		Label lblOulineNumber = new Label(composite, SWT.NONE);
		lblOulineNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOulineNumber.setText("Ouline Number:");
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
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
		
		EditingDomain editingDomain = getEclipseContext().get(EditingDomain.class);
		
		//
		IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(500, SWTObservables.observeText(nameText, SWT.Modify));
		IObservableValue modelTitleObserveValue = EMFEditObservables.observeValue(editingDomain, model, Literals.PLOT_NOTE__TITLE);
		bindingContext.bindValue(nameTextObserveTextObserveWidget, modelTitleObserveValue, null, null);
		//
		IObservableValue btnCheckButtonObserveSelectionObserveWidget = SWTObservables.observeSelection(inOutlineCheckButton);
		IObservableValue modelInsideOutlineObserveValue = EMFEditObservables.observeValue(editingDomain, model, Literals.PLOT_NOTE__INSIDE_OUTLINE);
		bindingContext.bindValue(btnCheckButtonObserveSelectionObserveWidget, modelInsideOutlineObserveValue, null, null);
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables.observeText(text, SWT.Modify);
		IObservableValue modelNumberObserveValue = EMFEditObservables.observeValue(editingDomain, model, Literals.PLOT_NOTE__NUMBER);
		bindingContext.bindValue(textObserveTextObserveWidget, modelNumberObserveValue, null, null);
		//
		IObservableValue contentTextObserveTextObserveWidget = SWTObservables.observeText(contentText, SWT.Modify);
		IObservableValue modelDescriptionObserveValue = EMFEditObservables.observeValue(editingDomain, model, Literals.PLOT_NOTE__DESCRIPTION);
		bindingContext.bindValue(contentTextObserveTextObserveWidget, modelDescriptionObserveValue, null, null);
		//
		return bindingContext;
	}
}

