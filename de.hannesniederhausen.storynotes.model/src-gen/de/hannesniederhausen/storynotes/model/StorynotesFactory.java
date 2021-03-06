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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage
 * @generated
 */
public interface StorynotesFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StorynotesFactory eINSTANCE = de.hannesniederhausen.storynotes.model.impl.StorynotesFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File</em>'.
	 * @generated
	 */
	File createFile();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>Person Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person Note</em>'.
	 * @generated
	 */
	PersonNote createPersonNote();

	/**
	 * Returns a new object of class '<em>Setting Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Setting Note</em>'.
	 * @generated
	 */
	SettingNote createSettingNote();

	/**
	 * Returns a new object of class '<em>Plot Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plot Note</em>'.
	 * @generated
	 */
	PlotNote createPlotNote();

	/**
	 * Returns a new object of class '<em>Generic Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Note</em>'.
	 * @generated
	 */
	GenericNote createGenericNote();

	/**
	 * Returns a new object of class '<em>Generic Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Category</em>'.
	 * @generated
	 */
	GenericCategory createGenericCategory();

	/**
	 * Returns a new object of class '<em>Person Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person Category</em>'.
	 * @generated
	 */
	PersonCategory createPersonCategory();

	/**
	 * Returns a new object of class '<em>Setting Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Setting Category</em>'.
	 * @generated
	 */
	SettingCategory createSettingCategory();

	/**
	 * Returns a new object of class '<em>Plot Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plot Category</em>'.
	 * @generated
	 */
	PlotCategory createPlotCategory();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StorynotesPackage getStorynotesPackage();

} //StorynotesFactory

