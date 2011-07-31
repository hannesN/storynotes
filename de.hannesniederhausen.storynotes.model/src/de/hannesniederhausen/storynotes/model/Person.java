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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getName <em>Name</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getCv <em>Cv</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getAge <em>Age</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getHairColor <em>Hair Color</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getEyeColor <em>Eye Color</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getSize <em>Size</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getWeight <em>Weight</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getSkinColor <em>Skin Color</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getSocialBackground <em>Social Background</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getHobbies <em>Hobbies</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.Person#getPsychologicalBackground <em>Psychological Background</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends Note {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Cv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cv</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cv</em>' attribute.
	 * @see #setCv(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_Cv()
	 * @model
	 * @generated
	 */
	String getCv();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getCv <em>Cv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cv</em>' attribute.
	 * @see #getCv()
	 * @generated
	 */
	void setCv(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Hair Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hair Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hair Color</em>' attribute.
	 * @see #setHairColor(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_HairColor()
	 * @model required="true"
	 * @generated
	 */
	String getHairColor();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getHairColor <em>Hair Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hair Color</em>' attribute.
	 * @see #getHairColor()
	 * @generated
	 */
	void setHairColor(String value);

	/**
	 * Returns the value of the '<em><b>Eye Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eye Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eye Color</em>' attribute.
	 * @see #setEyeColor(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_EyeColor()
	 * @model required="true"
	 * @generated
	 */
	String getEyeColor();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getEyeColor <em>Eye Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eye Color</em>' attribute.
	 * @see #getEyeColor()
	 * @generated
	 */
	void setEyeColor(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_Size()
	 * @model required="true"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(float)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_Weight()
	 * @model required="true"
	 * @generated
	 */
	float getWeight();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(float value);

	/**
	 * Returns the value of the '<em><b>Skin Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skin Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skin Color</em>' attribute.
	 * @see #setSkinColor(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_SkinColor()
	 * @model required="true"
	 * @generated
	 */
	String getSkinColor();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getSkinColor <em>Skin Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skin Color</em>' attribute.
	 * @see #getSkinColor()
	 * @generated
	 */
	void setSkinColor(String value);

	/**
	 * Returns the value of the '<em><b>Social Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Social Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Social Background</em>' attribute.
	 * @see #setSocialBackground(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_SocialBackground()
	 * @model required="true"
	 * @generated
	 */
	String getSocialBackground();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getSocialBackground <em>Social Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Social Background</em>' attribute.
	 * @see #getSocialBackground()
	 * @generated
	 */
	void setSocialBackground(String value);

	/**
	 * Returns the value of the '<em><b>Hobbies</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hobbies</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hobbies</em>' attribute list.
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_Hobbies()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getHobbies();

	/**
	 * Returns the value of the '<em><b>Psychological Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Psychological Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Psychological Background</em>' attribute.
	 * @see #setPsychologicalBackground(String)
	 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage#getPerson_PsychologicalBackground()
	 * @model required="true"
	 * @generated
	 */
	String getPsychologicalBackground();

	/**
	 * Sets the value of the '{@link de.hannesniederhausen.storynotes.model.Person#getPsychologicalBackground <em>Psychological Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Psychological Background</em>' attribute.
	 * @see #getPsychologicalBackground()
	 * @generated
	 */
	void setPsychologicalBackground(String value);

} // Person
