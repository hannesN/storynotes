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

import de.hannesniederhausen.storynotes.model.PlotNote;
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
 * This is the item provider adapter for a {@link de.hannesniederhausen.storynotes.model.PlotNote} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PlotNoteItemProvider extends FileElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlotNoteItemProvider(AdapterFactory adapterFactory) {
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
			addNumberPropertyDescriptor(object);
			addTitlePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addInsideOutlinePropertyDescriptor(object);
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
	 * This adds a property descriptor for the Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PlotNote_number_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PlotNote_number_feature", "_UI_PlotNote_type"),
				StorynotesPackage.Literals.PLOT_NOTE__NUMBER, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PlotNote_title_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PlotNote_title_feature", "_UI_PlotNote_type"),
				StorynotesPackage.Literals.PLOT_NOTE__TITLE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_PlotNote_description_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_PlotNote_description_feature",
								"_UI_PlotNote_type"),
						StorynotesPackage.Literals.PLOT_NOTE__DESCRIPTION,
						true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Inside Outline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInsideOutlinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PlotNote_insideOutline_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_PlotNote_insideOutline_feature",
						"_UI_PlotNote_type"),
				StorynotesPackage.Literals.PLOT_NOTE__INSIDE_OUTLINE, true,
				false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This returns PlotNote.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/PlotNote"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		PlotNote plotNote = (PlotNote) object;
		return getString("_UI_PlotNote_type") + " " + plotNote.getId();
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

		switch (notification.getFeatureID(PlotNote.class)) {
		case StorynotesPackage.PLOT_NOTE__REF_ID:
		case StorynotesPackage.PLOT_NOTE__NUMBER:
		case StorynotesPackage.PLOT_NOTE__TITLE:
		case StorynotesPackage.PLOT_NOTE__DESCRIPTION:
		case StorynotesPackage.PLOT_NOTE__INSIDE_OUTLINE:
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
