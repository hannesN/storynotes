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
package de.hannesniederhausen.storynotes.model.provider;

import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.hannesniederhausen.storynotes.model.PersonNote} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PersonNoteItemProvider extends FileElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonNoteItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addRefIdPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addCvPropertyDescriptor(object);
			addAgePropertyDescriptor(object);
			addHairColorPropertyDescriptor(object);
			addEyeColorPropertyDescriptor(object);
			addSizePropertyDescriptor(object);
			addWeightPropertyDescriptor(object);
			addSkinColorPropertyDescriptor(object);
			addSocialBackgroundPropertyDescriptor(object);
			addHobbiesPropertyDescriptor(object);
			addPsychologicalBackgroundPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ref Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Note_refId_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Note_refId_feature", "_UI_Note_type"),
				StorynotesPackage.Literals.NOTE__REF_ID, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_name_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_name_feature", "_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Cv feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCvPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_cv_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_cv_feature", "_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__CV, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Age feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_age_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_age_feature", "_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__AGE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hair Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHairColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_hairColor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_hairColor_feature",
						"_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__HAIR_COLOR, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Eye Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEyeColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_eyeColor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_eyeColor_feature",
						"_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__EYE_COLOR, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_PersonNote_size_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_PersonNote_size_feature",
								"_UI_PersonNote_type"),
						StorynotesPackage.Literals.PERSON_NOTE__SIZE, true,
						false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Weight feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_PersonNote_weight_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_PersonNote_weight_feature",
								"_UI_PersonNote_type"),
						StorynotesPackage.Literals.PERSON_NOTE__WEIGHT, true,
						false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE,
						null, null));
	}

	/**
	 * This adds a property descriptor for the Skin Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSkinColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_skinColor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_skinColor_feature",
						"_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__SKIN_COLOR, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Social Background feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSocialBackgroundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PersonNote_socialBackground_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PersonNote_socialBackground_feature",
						"_UI_PersonNote_type"),
				StorynotesPackage.Literals.PERSON_NOTE__SOCIAL_BACKGROUND,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Hobbies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHobbiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_PersonNote_hobbies_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_PersonNote_hobbies_feature",
								"_UI_PersonNote_type"),
						StorynotesPackage.Literals.PERSON_NOTE__HOBBIES, true,
						false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Psychological Background feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPsychologicalBackgroundPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_PersonNote_psychologicalBackground_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_PersonNote_psychologicalBackground_feature",
								"_UI_PersonNote_type"),
						StorynotesPackage.Literals.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND,
						true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns PersonNote.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/PersonNote"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PersonNote) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_PersonNote_type")
				: getString("_UI_PersonNote_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PersonNote.class)) {
		case StorynotesPackage.PERSON_NOTE__REF_ID:
		case StorynotesPackage.PERSON_NOTE__NAME:
		case StorynotesPackage.PERSON_NOTE__CV:
		case StorynotesPackage.PERSON_NOTE__AGE:
		case StorynotesPackage.PERSON_NOTE__HAIR_COLOR:
		case StorynotesPackage.PERSON_NOTE__EYE_COLOR:
		case StorynotesPackage.PERSON_NOTE__SIZE:
		case StorynotesPackage.PERSON_NOTE__WEIGHT:
		case StorynotesPackage.PERSON_NOTE__SKIN_COLOR:
		case StorynotesPackage.PERSON_NOTE__SOCIAL_BACKGROUND:
		case StorynotesPackage.PERSON_NOTE__HOBBIES:
		case StorynotesPackage.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
