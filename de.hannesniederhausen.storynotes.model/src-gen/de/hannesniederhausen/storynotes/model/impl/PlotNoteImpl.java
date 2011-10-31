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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plot Note</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl#getRefId <em>Ref Id</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PlotNoteImpl#isInsideOutline <em>Inside Outline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlotNoteImpl extends FileElementImpl implements PlotNote {
	/**
	 * The default value of the '{@link #getRefId() <em>Ref Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefId()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefId() <em>Ref Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefId()
	 * @generated
	 * @ordered
	 */
	protected String refId = REF_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected String number = NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isInsideOutline() <em>Inside Outline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInsideOutline()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSIDE_OUTLINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInsideOutline() <em>Inside Outline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInsideOutline()
	 * @generated
	 * @ordered
	 */
	protected boolean insideOutline = INSIDE_OUTLINE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlotNoteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorynotesPackage.Literals.PLOT_NOTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefId(String newRefId) {
		String oldRefId = refId;
		refId = newRefId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PLOT_NOTE__REF_ID, oldRefId, refId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(String newNumber) {
		String oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PLOT_NOTE__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PLOT_NOTE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PLOT_NOTE__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInsideOutline() {
		return insideOutline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsideOutline(boolean newInsideOutline) {
		boolean oldInsideOutline = insideOutline;
		insideOutline = newInsideOutline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PLOT_NOTE__INSIDE_OUTLINE,
					oldInsideOutline, insideOutline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case StorynotesPackage.PLOT_NOTE__REF_ID:
			return getRefId();
		case StorynotesPackage.PLOT_NOTE__NUMBER:
			return getNumber();
		case StorynotesPackage.PLOT_NOTE__TITLE:
			return getTitle();
		case StorynotesPackage.PLOT_NOTE__DESCRIPTION:
			return getDescription();
		case StorynotesPackage.PLOT_NOTE__INSIDE_OUTLINE:
			return isInsideOutline();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case StorynotesPackage.PLOT_NOTE__REF_ID:
			setRefId((String) newValue);
			return;
		case StorynotesPackage.PLOT_NOTE__NUMBER:
			setNumber((String) newValue);
			return;
		case StorynotesPackage.PLOT_NOTE__TITLE:
			setTitle((String) newValue);
			return;
		case StorynotesPackage.PLOT_NOTE__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case StorynotesPackage.PLOT_NOTE__INSIDE_OUTLINE:
			setInsideOutline((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case StorynotesPackage.PLOT_NOTE__REF_ID:
			setRefId(REF_ID_EDEFAULT);
			return;
		case StorynotesPackage.PLOT_NOTE__NUMBER:
			setNumber(NUMBER_EDEFAULT);
			return;
		case StorynotesPackage.PLOT_NOTE__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case StorynotesPackage.PLOT_NOTE__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case StorynotesPackage.PLOT_NOTE__INSIDE_OUTLINE:
			setInsideOutline(INSIDE_OUTLINE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case StorynotesPackage.PLOT_NOTE__REF_ID:
			return REF_ID_EDEFAULT == null ? refId != null : !REF_ID_EDEFAULT
					.equals(refId);
		case StorynotesPackage.PLOT_NOTE__NUMBER:
			return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT
					.equals(number);
		case StorynotesPackage.PLOT_NOTE__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT
					.equals(title);
		case StorynotesPackage.PLOT_NOTE__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case StorynotesPackage.PLOT_NOTE__INSIDE_OUTLINE:
			return insideOutline != INSIDE_OUTLINE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (refId: ");
		result.append(refId);
		result.append(", number: ");
		result.append(number);
		result.append(", title: ");
		result.append(title);
		result.append(", description: ");
		result.append(description);
		result.append(", insideOutline: ");
		result.append(insideOutline);
		result.append(')');
		return result.toString();
	}

} //PlotNoteImpl
