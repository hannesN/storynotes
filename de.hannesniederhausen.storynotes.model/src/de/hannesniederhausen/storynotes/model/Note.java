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
 * A representation of the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Note#getRefId <em>Ref Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getNote()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Note extends FileElement {
	/**
	 * Returns the value of the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Id</em>' attribute.
	 * @see #setRefId(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getNote_RefId()
	 * @model required="true"
	 * @generated
	 */
	String getRefId();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Note#getRefId <em>Ref Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Id</em>' attribute.
	 * @see #getRefId()
	 * @generated
	 */
	void setRefId(String value);

} // Note
