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
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.CategoryImpl
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = FILE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NOTES = FILE_ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl <em>Person Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPersonNote()
	 * @generated
	 */
	int PERSON_NOTE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__ID = NOTE__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__REF_ID = NOTE__REF_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__NAME = NOTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__CV = NOTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__AGE = NOTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hair Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__HAIR_COLOR = NOTE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Eye Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__EYE_COLOR = NOTE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__SIZE = NOTE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__WEIGHT = NOTE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Skin Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__SKIN_COLOR = NOTE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Social Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__SOCIAL_BACKGROUND = NOTE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Hobbies</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__HOBBIES = NOTE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Psychological Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND = NOTE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Person Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_NOTE_FEATURE_COUNT = NOTE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.SettingNoteImpl <em>Setting Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.SettingNoteImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getSettingNote()
	 * @generated
	 */
	int SETTING_NOTE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_NOTE__ID = NOTE__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_NOTE__REF_ID = NOTE__REF_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_NOTE__NAME = NOTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_NOTE__KIND = NOTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_NOTE__DESCRIPTION = NOTE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Setting Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_NOTE_FEATURE_COUNT = NOTE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl <em>Plot Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl
	 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPlotNote()
	 * @generated
	 */
	int PLOT_NOTE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE__ID = NOTE__ID;

	/**
	 * The feature id for the '<em><b>Ref Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE__REF_ID = NOTE__REF_ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE__KIND = NOTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE__TITLE = NOTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE__NOTES = NOTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE__DESCRIPTION = NOTE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Plot Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_NOTE_FEATURE_COUNT = NOTE_FEATURE_COUNT + 4;

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
	 * Returns the meta object for the containment reference list '{@link de.hannesniederhausen.storynotes.model.Category#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notes</em>'.
	 * @see de.hannesniederhausen.storynotes.model.Category#getNotes()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Notes();

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
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.PersonNote <em>Person Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person Note</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote
	 * @generated
	 */
	EClass getPersonNote();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getName()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getCv <em>Cv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cv</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getCv()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_Cv();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getAge()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_Age();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getHairColor <em>Hair Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hair Color</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getHairColor()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_HairColor();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getEyeColor <em>Eye Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eye Color</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getEyeColor()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_EyeColor();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getSize()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_Size();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getWeight()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_Weight();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getSkinColor <em>Skin Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skin Color</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getSkinColor()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_SkinColor();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getSocialBackground <em>Social Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Social Background</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getSocialBackground()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_SocialBackground();

	/**
	 * Returns the meta object for the attribute list '{@link de.hannesniederhausen.storynotes.model.PersonNote#getHobbies <em>Hobbies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Hobbies</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getHobbies()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_Hobbies();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PersonNote#getPsychologicalBackground <em>Psychological Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Psychological Background</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote#getPsychologicalBackground()
	 * @see #getPersonNote()
	 * @generated
	 */
	EAttribute getPersonNote_PsychologicalBackground();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.SettingNote <em>Setting Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setting Note</em>'.
	 * @see de.hannesniederhausen.storynotes.model.SettingNote
	 * @generated
	 */
	EClass getSettingNote();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.SettingNote#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hannesniederhausen.storynotes.model.SettingNote#getName()
	 * @see #getSettingNote()
	 * @generated
	 */
	EAttribute getSettingNote_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.SettingNote#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.hannesniederhausen.storynotes.model.SettingNote#getKind()
	 * @see #getSettingNote()
	 * @generated
	 */
	EAttribute getSettingNote_Kind();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.SettingNote#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hannesniederhausen.storynotes.model.SettingNote#getDescription()
	 * @see #getSettingNote()
	 * @generated
	 */
	EAttribute getSettingNote_Description();

	/**
	 * Returns the meta object for class '{@link de.hannesniederhausen.storynotes.model.PlotNote <em>Plot Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plot Note</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PlotNote
	 * @generated
	 */
	EClass getPlotNote();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PlotNote#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PlotNote#getKind()
	 * @see #getPlotNote()
	 * @generated
	 */
	EAttribute getPlotNote_Kind();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PlotNote#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PlotNote#getTitle()
	 * @see #getPlotNote()
	 * @generated
	 */
	EAttribute getPlotNote_Title();

	/**
	 * Returns the meta object for the reference '{@link de.hannesniederhausen.storynotes.model.PlotNote#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Notes</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PlotNote#getNotes()
	 * @see #getPlotNote()
	 * @generated
	 */
	EReference getPlotNote_Notes();

	/**
	 * Returns the meta object for the attribute '{@link de.hannesniederhausen.storynotes.model.PlotNote#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hannesniederhausen.storynotes.model.PlotNote#getDescription()
	 * @see #getPlotNote()
	 * @generated
	 */
	EAttribute getPlotNote_Description();

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
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.CategoryImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__NOTES = eINSTANCE.getCategory_Notes();

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
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl <em>Person Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPersonNote()
		 * @generated
		 */
		EClass PERSON_NOTE = eINSTANCE.getPersonNote();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__NAME = eINSTANCE.getPersonNote_Name();

		/**
		 * The meta object literal for the '<em><b>Cv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__CV = eINSTANCE.getPersonNote_Cv();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__AGE = eINSTANCE.getPersonNote_Age();

		/**
		 * The meta object literal for the '<em><b>Hair Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__HAIR_COLOR = eINSTANCE
				.getPersonNote_HairColor();

		/**
		 * The meta object literal for the '<em><b>Eye Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__EYE_COLOR = eINSTANCE.getPersonNote_EyeColor();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__SIZE = eINSTANCE.getPersonNote_Size();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__WEIGHT = eINSTANCE.getPersonNote_Weight();

		/**
		 * The meta object literal for the '<em><b>Skin Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__SKIN_COLOR = eINSTANCE
				.getPersonNote_SkinColor();

		/**
		 * The meta object literal for the '<em><b>Social Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__SOCIAL_BACKGROUND = eINSTANCE
				.getPersonNote_SocialBackground();

		/**
		 * The meta object literal for the '<em><b>Hobbies</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__HOBBIES = eINSTANCE.getPersonNote_Hobbies();

		/**
		 * The meta object literal for the '<em><b>Psychological Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND = eINSTANCE
				.getPersonNote_PsychologicalBackground();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.SettingNoteImpl <em>Setting Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.SettingNoteImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getSettingNote()
		 * @generated
		 */
		EClass SETTING_NOTE = eINSTANCE.getSettingNote();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING_NOTE__NAME = eINSTANCE.getSettingNote_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING_NOTE__KIND = eINSTANCE.getSettingNote_Kind();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING_NOTE__DESCRIPTION = eINSTANCE
				.getSettingNote_Description();

		/**
		 * The meta object literal for the '{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl <em>Plot Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl
		 * @see de.hannesniederhausen.storynotes.model.impl.StorynotesPackageImpl#getPlotNote()
		 * @generated
		 */
		EClass PLOT_NOTE = eINSTANCE.getPlotNote();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLOT_NOTE__KIND = eINSTANCE.getPlotNote_Kind();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLOT_NOTE__TITLE = eINSTANCE.getPlotNote_Title();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLOT_NOTE__NOTES = eINSTANCE.getPlotNote_Notes();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLOT_NOTE__DESCRIPTION = eINSTANCE.getPlotNote_Description();

	}

} //StorynotesPackage
