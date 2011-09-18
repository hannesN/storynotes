/**
 * 
 */
package de.hannesniederhausen.storynotes.ui.internal.views.pages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.ui.views.InputMask;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;

/**
 * {@link InputMask} for the {@link Project}.
 * 
 * @author Hannes Niederhausen
 * 
 */
public class ProjectInputMask extends InputMask {
	private DataBindingContext m_bindingContext;

	private Project project;
	private Text nameText;
	private Text descriptionText;

	/**
	 * @param parent
	 * @param style
	 */
	public ProjectInputMask(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		Label lblProject = new Label(this, SWT.NONE);
		lblProject.setText("Project:");
		new Label(this, SWT.NONE);

		Label lblName = new Label(this, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblName.setText("Name:");

		nameText = new Text(this, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblDescription = new Label(this, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));
		lblDescription.setText("Description:");

		descriptionText = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		
		if (project != null)
			m_bindingContext = initDataBindings();
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext != null)
			m_bindingContext.dispose();
		
		this.project = (Project) model;

		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(nameText, SWT.Modify));
		IObservableValue projectNameObserveValue = PojoObservables.observeValue(project, "name");
		bindingContext.bindValue(nameTextObserveTextObserveWidget, projectNameObserveValue, null, null);
		//
		IObservableValue descriptionTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(descriptionText, SWT.Modify));
		IObservableValue projectDescriptionObserveValue = PojoObservables.observeValue(project, "description");
		bindingContext.bindValue(descriptionTextObserveTextObserveWidget, projectDescriptionObserveValue, null, null);
		//
		return bindingContext;
	}
}
