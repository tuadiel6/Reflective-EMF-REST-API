/**
 */
package PublicationSystem.impl;

import PublicationSystem.Publication;
import PublicationSystem.PublicationModel;
import PublicationSystem.PublicationSystemPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Publication Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link PublicationSystem.impl.PublicationModelImpl#getPublications <em>Publications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PublicationModelImpl extends MinimalEObjectImpl.Container implements PublicationModel {
	/**
	 * The cached value of the '{@link #getPublications() <em>Publications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublications()
	 * @generated
	 * @ordered
	 */
	protected EList<Publication> publications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PublicationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PublicationSystemPackage.Literals.PUBLICATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Publication> getPublications() {
		if (publications == null) {
			publications = new EObjectContainmentEList<Publication>(Publication.class, this, PublicationSystemPackage.PUBLICATION_MODEL__PUBLICATIONS);
		}
		return publications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PublicationSystemPackage.PUBLICATION_MODEL__PUBLICATIONS:
				return ((InternalEList<?>)getPublications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PublicationSystemPackage.PUBLICATION_MODEL__PUBLICATIONS:
				return getPublications();
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
			case PublicationSystemPackage.PUBLICATION_MODEL__PUBLICATIONS:
				getPublications().clear();
				getPublications().addAll((Collection<? extends Publication>)newValue);
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
			case PublicationSystemPackage.PUBLICATION_MODEL__PUBLICATIONS:
				getPublications().clear();
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
			case PublicationSystemPackage.PUBLICATION_MODEL__PUBLICATIONS:
				return publications != null && !publications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PublicationModelImpl
