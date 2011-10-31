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
 * A representation of the model object '<em><b>Plot Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hannesniederhausen.storynotes.model.PlotNote#getNumber <em>Number</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.PlotNote#getTitle <em>Title</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.PlotNote#getDescription <em>Description</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.PlotNote#isInsideOutline <em>Inside Outline</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlotNote()
 * @model
 * @generated
 */
public interface PlotNote extends Note {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlotNote_Number()
	 * @model
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.PlotNote#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

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
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlotNote_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.PlotNote#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

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
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlotNote_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.PlotNote#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Inside Outline</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Outline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Outline</em>' attribute.
	 * @see #setInsideOutline(boolean)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPlotNote_InsideOutline()
	 * @model default="false"
	 * @generated
	 */
	boolean isInsideOutline();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.PlotNote#isInsideOutline <em>Inside Outline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Outline</em>' attribute.
	 * @see #isInsideOutline()
	 * @generated
	 */
	void setInsideOutline(boolean value);

} // PlotNote
