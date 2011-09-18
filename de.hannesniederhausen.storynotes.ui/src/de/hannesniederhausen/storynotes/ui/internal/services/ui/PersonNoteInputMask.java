package de.hannesniederhausen.storynotes.ui.internal.services.ui;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * Input mask for Person Notes
 * 
 * @author Hannes Niederhausen
 */
public class PersonNoteInputMask extends InputMask {

	private PersonNote person;
	
	/**
	 * @param parent
	 * @param style
	 */
	public PersonNoteInputMask(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void setModel(EObject model) {

		this.person = (PersonNote) model;
		
	}

}
