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
package de.hannesniederhausen.storynotes.model.impl;

import de.hannesniederhausen.storynotes.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StorynotesFactoryImpl extends EFactoryImpl implements
		StorynotesFactory {

	/**
	 * Counter to know which was the last given id
	 *
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static long lastId = -1;

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StorynotesFactory init() {
		try {
			StorynotesFactory theStorynotesFactory = (StorynotesFactory) EPackage.Registry.INSTANCE
					.getEFactory("https://github.com/hannesN/storynotes");
			if (theStorynotesFactory != null) {
				return theStorynotesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StorynotesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorynotesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case StorynotesPackage.FILE:
			return createFile();
		case StorynotesPackage.PROJECT:
			return createProject();
		case StorynotesPackage.PERSON_NOTE:
			return createPersonNote();
		case StorynotesPackage.SETTING_NOTE:
			return createSettingNote();
		case StorynotesPackage.PLOT_NOTE:
			return createPlotNote();
		case StorynotesPackage.GENERIC_NOTE:
			return createGenericNote();
		case StorynotesPackage.GENERIC_CATEGORY:
			return createGenericCategory();
		case StorynotesPackage.PERSON_CATEGORY:
			return createPersonCategory();
		case StorynotesPackage.SETTING_CATEGORY:
			return createSettingCategory();
		case StorynotesPackage.PLOT_CATEGORY:
			return createPlotCategory();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		setId(project);
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonNote createPersonNote() {
		PersonNoteImpl personNote = new PersonNoteImpl();
		setId(personNote);
		return personNote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingNote createSettingNote() {
		SettingNoteImpl settingNote = new SettingNoteImpl();
		setId(settingNote);
		return settingNote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlotNote createPlotNote() {
		PlotNoteImpl plotNote = new PlotNoteImpl();
		setId(plotNote);
		return plotNote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericNote createGenericNote() {
		GenericNoteImpl genericNote = new GenericNoteImpl();
		setId(genericNote);
		return genericNote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericCategory createGenericCategory() {
		GenericCategoryImpl genericCategory = new GenericCategoryImpl();
		setId(genericCategory);
		return genericCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonCategory createPersonCategory() {
		PersonCategoryImpl personCategory = new PersonCategoryImpl();
		setId(personCategory);
		return personCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingCategory createSettingCategory() {
		SettingCategoryImpl settingCategory = new SettingCategoryImpl();
		setId(settingCategory);
		return settingCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlotCategory createPlotCategory() {
		PlotCategoryImpl plotCategory = new PlotCategoryImpl();
		setId(plotCategory);
		return plotCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorynotesPackage getStorynotesPackage() {
		return (StorynotesPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private void setId(FileElement element) {
		lastId++;
		element.setId(lastId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StorynotesPackage getPackage() {
		return StorynotesPackage.eINSTANCE;
	}

} //StorynotesFactoryImpl

