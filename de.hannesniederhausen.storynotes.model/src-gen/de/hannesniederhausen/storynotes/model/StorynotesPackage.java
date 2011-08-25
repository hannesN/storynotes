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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hannesniederhausen.storynotes.model.StorynotesFactory
 * @model kind="package"
 * @generated
 */
public interface StorynotesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://github.com/hannesN/storynotes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sn";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StorynotesPackage eINSTANCE = de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.FileImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__FILENAME = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PROJECTS = 3;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.FileElementImpl <em>File Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.FileElementImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getFileElement()
	 * @generated
	 */
	int FILE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ELEMENT__ID = 0;

	/**
	 * The number of structural features of the '<em>File Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.ProjectImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ID = FILE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = FILE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CATEGORIES = FILE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = FILE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.Category <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.Category
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = FILE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NOTES = FILE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = FILE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = FILE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.Note <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.Note
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__ID = FILE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__REF_ID = FILE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = FILE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.PersonImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ID = NOTE__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__REF_ID = NOTE__REF_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = NOTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CV = NOTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__AGE = NOTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hair Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__HAIR_COLOR = NOTE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Eye Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__EYE_COLOR = NOTE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SIZE = NOTE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__WEIGHT = NOTE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Skin Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SKIN_COLOR = NOTE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Social Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SOCIAL_BACKGROUND = NOTE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Hobbies</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__HOBBIES = NOTE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Psychological Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PSYCHOLOGICAL_BACKGROUND = NOTE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = NOTE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.SettingImpl <em>Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.SettingImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getSetting()
	 * @generated
	 */
	int SETTING = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__ID = NOTE__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__REF_ID = NOTE__REF_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__NAME = NOTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__KIND = NOTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DESCRIPTION = NOTE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_FEATURE_COUNT = NOTE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.PlotImpl <em>Plot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.PlotImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPlot()
	 * @generated
	 */
	int PLOT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT__ID = NOTE__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT__REF_ID = NOTE__REF_ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT__KIND = NOTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT__TITLE = NOTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT__NOTES = NOTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT__DESCRIPTION = NOTE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Plot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_FEATURE_COUNT = NOTE_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see de.hannesniederhausen.storynotes.model.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.File#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see de.hannesniederhausen.storynotes.model.File#getFilename()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Filename();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.File#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see de.hannesniederhausen.storynotes.model.File#getAuthor()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Author();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.File#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.hannesniederhausen.storynotes.model.File#getVersion()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hannesniederhausen.storynotes.model.File#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see de.hannesniederhausen.storynotes.model.File#getProjects()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_Projects();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hannesniederhausen.storynotes.model.Project#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Project#getCategories()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Categories();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.FileElement <em>File Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Element</em>'.
	 * @see de.hannesniederhausen.storynotes.model.FileElement
	 * @generated
	 */
	EClass getFileElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.FileElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hannesniederhausen.storynotes.model.FileElement#getId()
	 * @see #getFileElement()
	 * @generated
	 */
	EAttribute getFileElement_Id();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the reference list '{@link de.hannesniederhausen.storynotes.model.Category#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Notes</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Category#getNotes()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Notes();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Note#getRefId <em>Ref Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Id</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Note#getRefId()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_RefId();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getCv <em>Cv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cv</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getCv()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Cv();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getAge()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Age();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getHairColor <em>Hair Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hair Color</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getHairColor()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_HairColor();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getEyeColor <em>Eye Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eye Color</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getEyeColor()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_EyeColor();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getSize()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Size();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getWeight()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Weight();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getSkinColor <em>Skin Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skin Color</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getSkinColor()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_SkinColor();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getSocialBackground <em>Social Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Social Background</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getSocialBackground()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_SocialBackground();

	/**
	 * Returns the meta object for the attribute list '{@link de.hannesniederhausen.storynotes.model.Person#getHobbies <em>Hobbies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Hobbies</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getHobbies()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Hobbies();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Person#getPsychologicalBackground <em>Psychological Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Psychological Background</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Person#getPsychologicalBackground()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_PsychologicalBackground();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.Setting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setting</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Setting
	 * @generated
	 */
	EClass getSetting();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Setting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Setting#getName()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Setting#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Setting#getKind()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Kind();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Setting#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Setting#getDescription()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Description();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.Plot <em>Plot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plot</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Plot
	 * @generated
	 */
	EClass getPlot();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Plot#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Plot#getKind()
	 * @see #getPlot()
	 * @generated
	 */
	EAttribute getPlot_Kind();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Plot#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Plot#getTitle()
	 * @see #getPlot()
	 * @generated
	 */
	EAttribute getPlot_Title();

	/**
	 * Returns the meta object for the reference '{@link de.hannesniederhausen.storynotes.model.Plot#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Notes</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Plot#getNotes()
	 * @see #getPlot()
	 * @generated
	 */
	EReference getPlot_Notes();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.Plot#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Plot#getDescription()
	 * @see #getPlot()
	 * @generated
	 */
	EAttribute getPlot_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StorynotesFactory getStorynotesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.FileImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__FILENAME = eINSTANCE.getFile_Filename();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__AUTHOR = eINSTANCE.getFile_Author();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__VERSION = eINSTANCE.getFile_Version();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__PROJECTS = eINSTANCE.getFile_Projects();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.ProjectImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CATEGORIES = eINSTANCE.getProject_Categories();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.FileElementImpl <em>File Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.FileElementImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getFileElement()
		 * @generated
		 */
		EClass FILE_ELEMENT = eINSTANCE.getFileElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ELEMENT__ID = eINSTANCE.getFileElement_Id();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.Category <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.Category
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__NOTES = eINSTANCE.getCategory_Notes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.Note <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.Note
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Ref Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__REF_ID = eINSTANCE.getNote_RefId();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.PersonImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Cv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__CV = eINSTANCE.getPerson_Cv();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__AGE = eINSTANCE.getPerson_Age();

		/**
		 * The meta object literal for the '<em><b>Hair Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__HAIR_COLOR = eINSTANCE.getPerson_HairColor();

		/**
		 * The meta object literal for the '<em><b>Eye Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__EYE_COLOR = eINSTANCE.getPerson_EyeColor();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SIZE = eINSTANCE.getPerson_Size();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__WEIGHT = eINSTANCE.getPerson_Weight();

		/**
		 * The meta object literal for the '<em><b>Skin Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SKIN_COLOR = eINSTANCE.getPerson_SkinColor();

		/**
		 * The meta object literal for the '<em><b>Social Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SOCIAL_BACKGROUND = eINSTANCE
				.getPerson_SocialBackground();

		/**
		 * The meta object literal for the '<em><b>Hobbies</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__HOBBIES = eINSTANCE.getPerson_Hobbies();

		/**
		 * The meta object literal for the '<em><b>Psychological Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__PSYCHOLOGICAL_BACKGROUND = eINSTANCE
				.getPerson_PsychologicalBackground();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.SettingImpl <em>Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.SettingImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getSetting()
		 * @generated
		 */
		EClass SETTING = eINSTANCE.getSetting();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__NAME = eINSTANCE.getSetting_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__KIND = eINSTANCE.getSetting_Kind();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__DESCRIPTION = eINSTANCE.getSetting_Description();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.PlotImpl <em>Plot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.PlotImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPlot()
		 * @generated
		 */
		EClass PLOT = eINSTANCE.getPlot();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLOT__KIND = eINSTANCE.getPlot_Kind();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLOT__TITLE = eINSTANCE.getPlot_Title();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLOT__NOTES = eINSTANCE.getPlot_Notes();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLOT__DESCRIPTION = eINSTANCE.getPlot_Description();

	}

} //StorynotesPackage
