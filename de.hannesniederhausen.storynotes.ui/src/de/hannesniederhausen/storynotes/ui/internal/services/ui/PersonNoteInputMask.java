package de.hannesniederhausen.storynotes.ui.internal.services.ui;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * Input mask for Person Notes
 * 
 * @author Hannes Niederhausen
 */
public class PersonNoteInputMask extends InputMask {
	private DataBindingContext m_bindingContext;

	private PersonNote person;
	private Text socialBackgroundText;
	private Text psychoBackgroundText;
	private Text nameText;
	private Text skinColorText;
	private Text hairColorText;
	private Text eyeColorText;
	private Text sizeText;
	private Text weightText;
	private Table table;
	private TableViewer hobbyTableViewer;
	private Combo combo;
	private Text cvText;

	
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CTabFolder tabFolder = new CTabFolder(comp, SWT.BORDER);
		tabFolder.setTabPosition(SWT.BOTTOM);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem generalItem = new CTabItem(tabFolder, SWT.NONE);
		generalItem.setText("General");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		generalItem.setControl(composite);
		composite.setLayout(new GridLayout(4, false));
		
		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name:");
		
		nameText = new Text(composite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label lblAge = new Label(composite, SWT.NONE);
		lblAge.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAge.setText("Age:");
		
		combo = new Combo(composite, SWT.NONE);
		combo.setItems(new String[] {"1", "2"});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSize = new Label(composite, SWT.NONE);
		lblSize.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSize.setText("Size:");
		
		sizeText = new Text(composite, SWT.BORDER);
		sizeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblWeight = new Label(composite, SWT.NONE);
		lblWeight.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWeight.setText("Weight:");
		
		weightText = new Text(composite, SWT.BORDER);
		weightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblColorOfSkin = new Label(composite, SWT.NONE);
		lblColorOfSkin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblColorOfSkin.setText("Skin Color:");
		
		skinColorText = new Text(composite, SWT.BORDER);
		skinColorText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblColorOfHair = new Label(composite, SWT.NONE);
		lblColorOfHair.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblColorOfHair.setText("Hair Color:");
		
		hairColorText = new Text(composite, SWT.BORDER);
		hairColorText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEyeColor = new Label(composite, SWT.NONE);
		lblEyeColor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEyeColor.setText("Eye Color:");
		
		eyeColorText = new Text(composite, SWT.BORDER);
		eyeColorText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblHobbies = new Label(composite, SWT.NONE);
		lblHobbies.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblHobbies.setText("Hobbies:");
		
		hobbyTableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = hobbyTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Composite hobbyButtonBar = new Composite(composite, SWT.NONE);
		hobbyButtonBar.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		hobbyButtonBar.setLayout(new GridLayout(1, false));
		
		Button btnAdd = new Button(hobbyButtonBar, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newHobby();
			}
		});
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAdd.setBounds(0, 0, 75, 25);
		btnAdd.setText("Add...");
		
		Button btnRemove = new Button(hobbyButtonBar, SWT.NONE);
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeSelectedHobbies();
			}
		});
		btnRemove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnRemove.setBounds(0, 0, 75, 25);
		btnRemove.setText("Remove...");
		
		Button btnRemoveAll = new Button(hobbyButtonBar, SWT.NONE);
		btnRemoveAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeAllHobbies();
			}
		});
		btnRemoveAll.setBounds(0, 0, 75, 25);
		btnRemoveAll.setText("Remove All");
		new Label(composite, SWT.NONE);
		
		CTabItem cvItem = new CTabItem(tabFolder, SWT.NONE);
		cvItem.setText("CV");
		
		cvText = new Text(tabFolder, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		cvItem.setControl(cvText);
		
		CTabItem tbtmSocialBackground = new CTabItem(tabFolder, SWT.NONE);
		tbtmSocialBackground.setText("Social Background");
		
		socialBackgroundText = new Text(tabFolder, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		tbtmSocialBackground.setControl(socialBackgroundText);
		
		CTabItem tbtmPsychologicalBackground = new CTabItem(tabFolder, SWT.NONE);
		tbtmPsychologicalBackground.setText("Psychological Background");
		
		psychoBackgroundText = new Text(tabFolder, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		tbtmPsychologicalBackground.setControl(psychoBackgroundText);
		
		if (person!=null)
			m_bindingContext = initDataBindings();
		
		setControl(comp);
		
		tabFolder.setSelection(0);
	}

	/**
	 * 
	 */
	protected void removeAllHobbies() {
		EditingDomain ed = getEclipseContext().get(EditingDomain.class);
		Command cmd = RemoveCommand.create(ed, person, StorynotesPackage.Literals.PERSON_NOTE__HOBBIES, new ArrayList<String>(person.getHobbies()));
		if (cmd.canExecute()) {
			ed.getCommandStack().execute(cmd);
		}
	}

	/**
	 * 
	 */
	protected void removeSelectedHobbies() {
		
		IStructuredSelection sel = (IStructuredSelection) hobbyTableViewer.getSelection();
		
		List<String> removeableHobbies = new ArrayList<String>();
		for (@SuppressWarnings("unchecked")
		Iterator<String> it = sel.iterator(); it.hasNext();) {
			removeableHobbies.add(it.next());
		}
		
		EditingDomain ed = getEclipseContext().get(EditingDomain.class);
		Command cmd = RemoveCommand.create(ed, person, StorynotesPackage.Literals.PERSON_NOTE__HOBBIES, removeableHobbies);
		if (cmd.canExecute()) {
			ed.getCommandStack().execute(cmd);
		}
	}

	/**
	 * 
	 */
	protected void newHobby() {
		
		InputDialog dlg = new InputDialog(getControl().getShell(), "Enter a new Hobby", "Please enter a new hobby.", "", new IInputValidator() {
			
			@Override
			public String isValid(String newText) {
				if (newText.isEmpty())
					return "No text entered!";
				if (person.getHobbies().contains(newText)) {
					return "Hobby already in the persons hobby list.";
				}
				return null;
			}
		});
		
		if (dlg.open()==Dialog.OK) {
			EditingDomain ed = getEclipseContext().get(EditingDomain.class);
			Command cmd = AddCommand.create(ed, person, StorynotesPackage.Literals.PERSON_NOTE__HOBBIES, dlg.getValue());
			if (cmd.canExecute()) {
				ed.getCommandStack().execute(cmd);
			}
		}
	}

	@Override
	public void setModel(EObject model) {
		if (m_bindingContext!=null)
			m_bindingContext.dispose();
		
		this.person = (PersonNote) model;
		
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		EditingDomain ed = getEclipseContext().get(EditingDomain.class);
		
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(nameText, SWT.Modify));
		IObservableValue personNameObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__NAME).observe(person);
		bindingContext.bindValue(nameTextObserveTextObserveWidget, personNameObserveValue, null, null);
		//
		IObservableValue comboObserveSelectionObserveWidget = SWTObservables.observeSelection(combo);
		IObservableValue personAgeObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__AGE).observe(person);
		bindingContext.bindValue(comboObserveSelectionObserveWidget, personAgeObserveValue, null, null);
		//
		IObservableValue sizeTextObserveTextObserveWidget = SWTObservables.observeText(sizeText, SWT.Modify);
		IObservableValue personSizeObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__SIZE).observe(person);
		bindingContext.bindValue(sizeTextObserveTextObserveWidget, personSizeObserveValue, null, null);
		//
		IObservableValue weightTextObserveTextObserveWidget = SWTObservables.observeText(weightText, SWT.Modify);
		IObservableValue personWeightObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__WEIGHT).observe(person);
		bindingContext.bindValue(weightTextObserveTextObserveWidget, personWeightObserveValue, null, null);
		//
		IObservableValue skinColorTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(skinColorText, SWT.Modify));
		IObservableValue personSkinColorObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__SKIN_COLOR).observe(person);
		bindingContext.bindValue(skinColorTextObserveTextObserveWidget, personSkinColorObserveValue, null, null);
		//
		IObservableValue hairColorTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(hairColorText, SWT.Modify));
		IObservableValue personHairColorObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__HAIR_COLOR).observe(person);
		bindingContext.bindValue(hairColorTextObserveTextObserveWidget, personHairColorObserveValue, null, null);
		//
		IObservableValue eyeColorTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(eyeColorText, SWT.Modify));
		IObservableValue personEyeColorObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__EYE_COLOR).observe(person);
		bindingContext.bindValue(eyeColorTextObserveTextObserveWidget, personEyeColorObserveValue, null, null);
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		hobbyTableViewer.setContentProvider(listContentProvider);
		//
		hobbyTableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return (String) element;
			}
		});
		//
		IObservableList personHobbiesObserveList = EMFEditProperties.list(ed, StorynotesPackage.Literals.PERSON_NOTE__HOBBIES).observe(person); 
		hobbyTableViewer.setInput(personHobbiesObserveList);
		//
		IObservableValue socialBackgroundTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(socialBackgroundText, SWT.Modify));
		IObservableValue personSocialBackgroundObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__SOCIAL_BACKGROUND).observe(person);
		bindingContext.bindValue(socialBackgroundTextObserveTextObserveWidget, personSocialBackgroundObserveValue, null, null);
		//
		IObservableValue psychoBackgroundTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(psychoBackgroundText, SWT.Modify));
		IObservableValue personPsychologicalBackgroundObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND).observe(person);
		bindingContext.bindValue(psychoBackgroundTextObserveTextObserveWidget, personPsychologicalBackgroundObserveValue, null, null);
		//
		IObservableValue cvTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(cvText, SWT.Modify));
		IObservableValue personCvObserveValue = EMFEditProperties.value(ed, StorynotesPackage.Literals.PERSON_NOTE__CV).observe(person);
		bindingContext.bindValue(cvTextObserveTextObserveWidget, personCvObserveValue, null, null);
		//
		return bindingContext;
	}
}
