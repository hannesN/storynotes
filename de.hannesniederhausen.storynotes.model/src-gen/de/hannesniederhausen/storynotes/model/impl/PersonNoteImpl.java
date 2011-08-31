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

import de.hannesniederhausen.storynotes.model.PersonNote;
import de.hannesniederhausen.storynotes.model.StorynotesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person Note</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getRefId <em>Ref Id</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getCv <em>Cv</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getAge <em>Age</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getHairColor <em>Hair Color</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getEyeColor <em>Eye Color</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getSize <em>Size</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getSkinColor <em>Skin Color</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getSocialBackground <em>Social Background</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getHobbies <em>Hobbies</em>}</li>
 *   <li>{@link de.hannesniederhausen.storynotes.model.impl.PersonNoteImpl#getPsychologicalBackground <em>Psychological Background</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonNoteImpl extends FileElementImpl implements PersonNote {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCv() <em>Cv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCv()
	 * @generated
	 * @ordered
	 */
	protected static final String CV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCv() <em>Cv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCv()
	 * @generated
	 * @ordered
	 */
	protected String cv = CV_EDEFAULT;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHairColor() <em>Hair Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHairColor()
	 * @generated
	 * @ordered
	 */
	protected static final String HAIR_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHairColor() <em>Hair Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHairColor()
	 * @generated
	 * @ordered
	 */
	protected String hairColor = HAIR_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getEyeColor() <em>Eye Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEyeColor()
	 * @generated
	 * @ordered
	 */
	protected static final String EYE_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEyeColor() <em>Eye Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEyeColor()
	 * @generated
	 * @ordered
	 */
	protected String eyeColor = EYE_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final float WEIGHT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected float weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSkinColor() <em>Skin Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkinColor()
	 * @generated
	 * @ordered
	 */
	protected static final String SKIN_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSkinColor() <em>Skin Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkinColor()
	 * @generated
	 * @ordered
	 */
	protected String skinColor = SKIN_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSocialBackground() <em>Social Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocialBackground()
	 * @generated
	 * @ordered
	 */
	protected static final String SOCIAL_BACKGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSocialBackground() <em>Social Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocialBackground()
	 * @generated
	 * @ordered
	 */
	protected String socialBackground = SOCIAL_BACKGROUND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHobbies() <em>Hobbies</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHobbies()
	 * @generated
	 * @ordered
	 */
	protected EList<String> hobbies;

	/**
	 * The default value of the '{@link #getPsychologicalBackground() <em>Psychological Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPsychologicalBackground()
	 * @generated
	 * @ordered
	 */
	protected static final String PSYCHOLOGICAL_BACKGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPsychologicalBackground() <em>Psychological Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPsychologicalBackground()
	 * @generated
	 * @ordered
	 */
	protected String psychologicalBackground = PSYCHOLOGICAL_BACKGROUND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonNoteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorynotesPackage.Literals.PERSON_NOTE;
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
					StorynotesPackage.PERSON_NOTE__REF_ID, oldRefId, refId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCv() {
		return cv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCv(String newCv) {
		String oldCv = cv;
		cv = newCv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__CV, oldCv, cv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHairColor() {
		return hairColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHairColor(String newHairColor) {
		String oldHairColor = hairColor;
		hairColor = newHairColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__HAIR_COLOR, oldHairColor,
					hairColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEyeColor() {
		return eyeColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEyeColor(String newEyeColor) {
		String oldEyeColor = eyeColor;
		eyeColor = newEyeColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__EYE_COLOR, oldEyeColor,
					eyeColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(float newWeight) {
		float oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSkinColor() {
		return skinColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkinColor(String newSkinColor) {
		String oldSkinColor = skinColor;
		skinColor = newSkinColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__SKIN_COLOR, oldSkinColor,
					skinColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSocialBackground() {
		return socialBackground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSocialBackground(String newSocialBackground) {
		String oldSocialBackground = socialBackground;
		socialBackground = newSocialBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__SOCIAL_BACKGROUND,
					oldSocialBackground, socialBackground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getHobbies() {
		if (hobbies == null) {
			hobbies = new EDataTypeUniqueEList<String>(String.class, this,
					StorynotesPackage.PERSON_NOTE__HOBBIES);
		}
		return hobbies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPsychologicalBackground() {
		return psychologicalBackground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPsychologicalBackground(String newPsychologicalBackground) {
		String oldPsychologicalBackground = psychologicalBackground;
		psychologicalBackground = newPsychologicalBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StorynotesPackage.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND,
					oldPsychologicalBackground, psychologicalBackground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case StorynotesPackage.PERSON_NOTE__REF_ID:
			return getRefId();
		case StorynotesPackage.PERSON_NOTE__NAME:
			return getName();
		case StorynotesPackage.PERSON_NOTE__CV:
			return getCv();
		case StorynotesPackage.PERSON_NOTE__AGE:
			return getAge();
		case StorynotesPackage.PERSON_NOTE__HAIR_COLOR:
			return getHairColor();
		case StorynotesPackage.PERSON_NOTE__EYE_COLOR:
			return getEyeColor();
		case StorynotesPackage.PERSON_NOTE__SIZE:
			return getSize();
		case StorynotesPackage.PERSON_NOTE__WEIGHT:
			return getWeight();
		case StorynotesPackage.PERSON_NOTE__SKIN_COLOR:
			return getSkinColor();
		case StorynotesPackage.PERSON_NOTE__SOCIAL_BACKGROUND:
			return getSocialBackground();
		case StorynotesPackage.PERSON_NOTE__HOBBIES:
			return getHobbies();
		case StorynotesPackage.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND:
			return getPsychologicalBackground();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case StorynotesPackage.PERSON_NOTE__REF_ID:
			setRefId((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__NAME:
			setName((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__CV:
			setCv((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__AGE:
			setAge((Integer) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__HAIR_COLOR:
			setHairColor((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__EYE_COLOR:
			setEyeColor((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__SIZE:
			setSize((Integer) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__WEIGHT:
			setWeight((Float) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__SKIN_COLOR:
			setSkinColor((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__SOCIAL_BACKGROUND:
			setSocialBackground((String) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__HOBBIES:
			getHobbies().clear();
			getHobbies().addAll((Collection<? extends String>) newValue);
			return;
		case StorynotesPackage.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND:
			setPsychologicalBackground((String) newValue);
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
		case StorynotesPackage.PERSON_NOTE__REF_ID:
			setRefId(REF_ID_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__CV:
			setCv(CV_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__AGE:
			setAge(AGE_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__HAIR_COLOR:
			setHairColor(HAIR_COLOR_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__EYE_COLOR:
			setEyeColor(EYE_COLOR_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__WEIGHT:
			setWeight(WEIGHT_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__SKIN_COLOR:
			setSkinColor(SKIN_COLOR_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__SOCIAL_BACKGROUND:
			setSocialBackground(SOCIAL_BACKGROUND_EDEFAULT);
			return;
		case StorynotesPackage.PERSON_NOTE__HOBBIES:
			getHobbies().clear();
			return;
		case StorynotesPackage.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND:
			setPsychologicalBackground(PSYCHOLOGICAL_BACKGROUND_EDEFAULT);
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
		case StorynotesPackage.PERSON_NOTE__REF_ID:
			return REF_ID_EDEFAULT == null ? refId != null : !REF_ID_EDEFAULT
					.equals(refId);
		case StorynotesPackage.PERSON_NOTE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case StorynotesPackage.PERSON_NOTE__CV:
			return CV_EDEFAULT == null ? cv != null : !CV_EDEFAULT.equals(cv);
		case StorynotesPackage.PERSON_NOTE__AGE:
			return age != AGE_EDEFAULT;
		case StorynotesPackage.PERSON_NOTE__HAIR_COLOR:
			return HAIR_COLOR_EDEFAULT == null ? hairColor != null
					: !HAIR_COLOR_EDEFAULT.equals(hairColor);
		case StorynotesPackage.PERSON_NOTE__EYE_COLOR:
			return EYE_COLOR_EDEFAULT == null ? eyeColor != null
					: !EYE_COLOR_EDEFAULT.equals(eyeColor);
		case StorynotesPackage.PERSON_NOTE__SIZE:
			return size != SIZE_EDEFAULT;
		case StorynotesPackage.PERSON_NOTE__WEIGHT:
			return weight != WEIGHT_EDEFAULT;
		case StorynotesPackage.PERSON_NOTE__SKIN_COLOR:
			return SKIN_COLOR_EDEFAULT == null ? skinColor != null
					: !SKIN_COLOR_EDEFAULT.equals(skinColor);
		case StorynotesPackage.PERSON_NOTE__SOCIAL_BACKGROUND:
			return SOCIAL_BACKGROUND_EDEFAULT == null ? socialBackground != null
					: !SOCIAL_BACKGROUND_EDEFAULT.equals(socialBackground);
		case StorynotesPackage.PERSON_NOTE__HOBBIES:
			return hobbies != null && !hobbies.isEmpty();
		case StorynotesPackage.PERSON_NOTE__PSYCHOLOGICAL_BACKGROUND:
			return PSYCHOLOGICAL_BACKGROUND_EDEFAULT == null ? psychologicalBackground != null
					: !PSYCHOLOGICAL_BACKGROUND_EDEFAULT
							.equals(psychologicalBackground);
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
		result.append(", name: ");
		result.append(name);
		result.append(", cv: ");
		result.append(cv);
		result.append(", age: ");
		result.append(age);
		result.append(", hairColor: ");
		result.append(hairColor);
		result.append(", eyeColor: ");
		result.append(eyeColor);
		result.append(", size: ");
		result.append(size);
		result.append(", weight: ");
		result.append(weight);
		result.append(", skinColor: ");
		result.append(skinColor);
		result.append(", socialBackground: ");
		result.append(socialBackground);
		result.append(", hobbies: ");
		result.append(hobbies);
		result.append(", psychologicalBackground: ");
		result.append(psychologicalBackground);
		result.append(')');
		return result.toString();
	}

} //PersonNoteImpl
