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

import de.hannesniederhausen.storynotes.model.util.StorynotesAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StorynotesItemProviderAdapterFactory extends
		StorynotesAdapterFactory implements ComposeableAdapterFactory,
		IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorynotesItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.File} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileItemProvider fileItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileAdapter() {
		if (fileItemProvider == null) {
			fileItemProvider = new FileItemProvider(this);
		}

		return fileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.Project} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectItemProvider projectItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.Project}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProjectAdapter() {
		if (projectItemProvider == null) {
			projectItemProvider = new ProjectItemProvider(this);
		}

		return projectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.PersonNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonNoteItemProvider personNoteItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.PersonNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPersonNoteAdapter() {
		if (personNoteItemProvider == null) {
			personNoteItemProvider = new PersonNoteItemProvider(this);
		}

		return personNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.SettingNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SettingNoteItemProvider settingNoteItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.SettingNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSettingNoteAdapter() {
		if (settingNoteItemProvider == null) {
			settingNoteItemProvider = new SettingNoteItemProvider(this);
		}

		return settingNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.PlotNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlotNoteItemProvider plotNoteItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.PlotNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlotNoteAdapter() {
		if (plotNoteItemProvider == null) {
			plotNoteItemProvider = new PlotNoteItemProvider(this);
		}

		return plotNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.GenericNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericNoteItemProvider genericNoteItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.GenericNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGenericNoteAdapter() {
		if (genericNoteItemProvider == null) {
			genericNoteItemProvider = new GenericNoteItemProvider(this);
		}

		return genericNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.GenericCategory} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericCategoryItemProvider genericCategoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.GenericCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGenericCategoryAdapter() {
		if (genericCategoryItemProvider == null) {
			genericCategoryItemProvider = new GenericCategoryItemProvider(this);
		}

		return genericCategoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.PersonCategory} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonCategoryItemProvider personCategoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.PersonCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPersonCategoryAdapter() {
		if (personCategoryItemProvider == null) {
			personCategoryItemProvider = new PersonCategoryItemProvider(this);
		}

		return personCategoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.SettingCategory} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SettingCategoryItemProvider settingCategoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.SettingCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSettingCategoryAdapter() {
		if (settingCategoryItemProvider == null) {
			settingCategoryItemProvider = new SettingCategoryItemProvider(this);
		}

		return settingCategoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hannesniederhausen.storynotes.model.PlotCategory} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlotCategoryItemProvider plotCategoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.hannesniederhausen.storynotes.model.PlotCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlotCategoryAdapter() {
		if (plotCategoryItemProvider == null) {
			plotCategoryItemProvider = new PlotCategoryItemProvider(this);
		}

		return plotCategoryItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(
			ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>)
					|| (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (fileItemProvider != null)
			fileItemProvider.dispose();
		if (projectItemProvider != null)
			projectItemProvider.dispose();
		if (personNoteItemProvider != null)
			personNoteItemProvider.dispose();
		if (settingNoteItemProvider != null)
			settingNoteItemProvider.dispose();
		if (plotNoteItemProvider != null)
			plotNoteItemProvider.dispose();
		if (genericNoteItemProvider != null)
			genericNoteItemProvider.dispose();
		if (genericCategoryItemProvider != null)
			genericCategoryItemProvider.dispose();
		if (personCategoryItemProvider != null)
			personCategoryItemProvider.dispose();
		if (settingCategoryItemProvider != null)
			settingCategoryItemProvider.dispose();
		if (plotCategoryItemProvider != null)
			plotCategoryItemProvider.dispose();
	}

}
