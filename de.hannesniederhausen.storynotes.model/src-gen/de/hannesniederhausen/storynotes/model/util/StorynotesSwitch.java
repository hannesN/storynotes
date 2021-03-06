/**
 * Copyright (c) 2011 Hannes Niederhausen.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Hannes Niederhausen - Initial API and implementation
 * 
 */
package de.hannesniederhausen.storynotes.model.util;

import de.hannesniederhausen.storynotes.model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage
 * @generated
 */
public class StorynotesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StorynotesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorynotesSwitch() {
		if (modelPackage == null) {
			modelPackage = StorynotesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case StorynotesPackage.FILE: {
			File file = (File) theEObject;
			T result = caseFile(file);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.PROJECT: {
			Project project = (Project) theEObject;
			T result = caseProject(project);
			if (result == null)
				result = caseFileElement(project);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.FILE_ELEMENT: {
			FileElement fileElement = (FileElement) theEObject;
			T result = caseFileElement(fileElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.CATEGORY: {
			Category category = (Category) theEObject;
			T result = caseCategory(category);
			if (result == null)
				result = caseFileElement(category);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.NOTE: {
			Note note = (Note) theEObject;
			T result = caseNote(note);
			if (result == null)
				result = caseFileElement(note);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.PERSON_NOTE: {
			PersonNote personNote = (PersonNote) theEObject;
			T result = casePersonNote(personNote);
			if (result == null)
				result = caseNote(personNote);
			if (result == null)
				result = caseFileElement(personNote);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.SETTING_NOTE: {
			SettingNote settingNote = (SettingNote) theEObject;
			T result = caseSettingNote(settingNote);
			if (result == null)
				result = caseNote(settingNote);
			if (result == null)
				result = caseFileElement(settingNote);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.PLOT_NOTE: {
			PlotNote plotNote = (PlotNote) theEObject;
			T result = casePlotNote(plotNote);
			if (result == null)
				result = caseNote(plotNote);
			if (result == null)
				result = caseFileElement(plotNote);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.GENERIC_NOTE: {
			GenericNote genericNote = (GenericNote) theEObject;
			T result = caseGenericNote(genericNote);
			if (result == null)
				result = caseNote(genericNote);
			if (result == null)
				result = caseFileElement(genericNote);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.GENERIC_CATEGORY: {
			GenericCategory genericCategory = (GenericCategory) theEObject;
			T result = caseGenericCategory(genericCategory);
			if (result == null)
				result = caseCategory(genericCategory);
			if (result == null)
				result = caseFileElement(genericCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.PERSON_CATEGORY: {
			PersonCategory personCategory = (PersonCategory) theEObject;
			T result = casePersonCategory(personCategory);
			if (result == null)
				result = caseCategory(personCategory);
			if (result == null)
				result = caseFileElement(personCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.SETTING_CATEGORY: {
			SettingCategory settingCategory = (SettingCategory) theEObject;
			T result = caseSettingCategory(settingCategory);
			if (result == null)
				result = caseCategory(settingCategory);
			if (result == null)
				result = caseFileElement(settingCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorynotesPackage.PLOT_CATEGORY: {
			PlotCategory plotCategory = (PlotCategory) theEObject;
			T result = casePlotCategory(plotCategory);
			if (result == null)
				result = caseCategory(plotCategory);
			if (result == null)
				result = caseFileElement(plotCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFile(File object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProject(Project object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileElement(FileElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategory(Category object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNote(Note object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Person Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Person Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonNote(PersonNote object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Setting Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Setting Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSettingNote(SettingNote object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plot Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plot Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlotNote(PlotNote object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericNote(GenericNote object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericCategory(GenericCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Person Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Person Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonCategory(PersonCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Setting Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Setting Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSettingCategory(SettingCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plot Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plot Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlotCategory(PlotCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StorynotesSwitch
