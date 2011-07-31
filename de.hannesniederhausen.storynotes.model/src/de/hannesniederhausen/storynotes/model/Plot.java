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
package de.hannesniederhausen.storynotes.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Plot#getKind <em>Kind</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Plot#getTitle <em>Title</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Plot#getNotes <em>Notes</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Plot#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlot()
 * @model
 * @generated
 */
public interface Plot extends Note {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlot_Kind()
	 * @model required="true"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Plot#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlot_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Plot#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' reference.
	 * @see #setNotes(Note)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlot_Notes()
	 * @model
	 * @generated
	 */
	Note getNotes();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Plot#getNotes <em>Notes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' reference.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(Note value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlot_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Plot#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Plot
