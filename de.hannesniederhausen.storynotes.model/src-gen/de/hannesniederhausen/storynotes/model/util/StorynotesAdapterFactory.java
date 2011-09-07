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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hannesniederhausen.storynotes.model.StorynotesPackage
 * @generated
 */
public class StorynotesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StorynotesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorynotesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StorynotesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorynotesSwitch<Adapter> modelSwitch = new StorynotesSwitch<Adapter>() {
		@Override
		public Adapter caseFile(File object) {
			return createFileAdapter();
		}

		@Override
		public Adapter caseProject(Project object) {
			return createProjectAdapter();
		}

		@Override
		public Adapter caseFileElement(FileElement object) {
			return createFileElementAdapter();
		}

		@Override
		public Adapter caseCategory(Category object) {
			return createCategoryAdapter();
		}

		@Override
		public Adapter caseNote(Note object) {
			return createNoteAdapter();
		}

		@Override
		public Adapter casePersonNote(PersonNote object) {
			return createPersonNoteAdapter();
		}

		@Override
		public Adapter caseSettingNote(SettingNote object) {
			return createSettingNoteAdapter();
		}

		@Override
		public Adapter casePlotNote(PlotNote object) {
			return createPlotNoteAdapter();
		}

		@Override
		public Adapter caseGenericNote(GenericNote object) {
			return createGenericNoteAdapter();
		}

		@Override
		public Adapter caseGenericCategory(GenericCategory object) {
			return createGenericCategoryAdapter();
		}

		@Override
		public Adapter casePersonCategory(PersonCategory object) {
			return createPersonCategoryAdapter();
		}

		@Override
		public Adapter caseSettingCategory(SettingCategory object) {
			return createSettingCategoryAdapter();
		}

		@Override
		public Adapter casePlotCategory(PlotCategory object) {
			return createPlotCategoryAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.File
	 * @generated
	 */
	public Adapter createFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.Project
	 * @generated
	 */
	public Adapter createProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.FileElement <em>File Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.FileElement
	 * @generated
	 */
	public Adapter createFileElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.Category
	 * @generated
	 */
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.Note
	 * @generated
	 */
	public Adapter createNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.PersonNote <em>Person Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.PersonNote
	 * @generated
	 */
	public Adapter createPersonNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.SettingNote <em>Setting Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.SettingNote
	 * @generated
	 */
	public Adapter createSettingNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.PlotNote <em>Plot Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.PlotNote
	 * @generated
	 */
	public Adapter createPlotNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.GenericNote <em>Generic Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.GenericNote
	 * @generated
	 */
	public Adapter createGenericNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.GenericCategory <em>Generic Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.GenericCategory
	 * @generated
	 */
	public Adapter createGenericCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.PersonCategory <em>Person Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.PersonCategory
	 * @generated
	 */
	public Adapter createPersonCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.SettingCategory <em>Setting Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.SettingCategory
	 * @generated
	 */
	public Adapter createSettingCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hannesniederhausen.storynotes.model.PlotCategory <em>Plot Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hannesniederhausen.storynotes.model.PlotCategory
	 * @generated
	 */
	public Adapter createPlotCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StorynotesAdapterFactory
