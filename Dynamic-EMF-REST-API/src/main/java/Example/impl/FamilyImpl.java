/**
 */
package Example.impl;

import Example.Daughter;
import Example.ExamplePackage;
import Example.Family;
import Example.Parent;
import Example.Son;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Family</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Example.impl.FamilyImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link Example.impl.FamilyImpl#getSons <em>Sons</em>}</li>
 *   <li>{@link Example.impl.FamilyImpl#getDaughters <em>Daughters</em>}</li>
 *   <li>{@link Example.impl.FamilyImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link Example.impl.FamilyImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FamilyImpl extends MinimalEObjectImpl.Container implements Family {
	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<Parent> parents;

	/**
	 * The cached value of the '{@link #getSons() <em>Sons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSons()
	 * @generated
	 * @ordered
	 */
	protected EList<Son> sons;

	/**
	 * The cached value of the '{@link #getDaughters() <em>Daughters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaughters()
	 * @generated
	 * @ordered
	 */
	protected EList<Daughter> daughters;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FamilyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.FAMILY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parent> getParents() {
		if (parents == null) {
			parents = new EObjectContainmentWithInverseEList<Parent>(Parent.class, this, ExamplePackage.FAMILY__PARENTS, ExamplePackage.PARENT__FAMILY);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Son> getSons() {
		if (sons == null) {
			sons = new EObjectContainmentWithInverseEList<Son>(Son.class, this, ExamplePackage.FAMILY__SONS, ExamplePackage.SON__FAMILY);
		}
		return sons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Daughter> getDaughters() {
		if (daughters == null) {
			daughters = new EObjectContainmentWithInverseEList<Daughter>(Daughter.class, this, ExamplePackage.FAMILY__DAUGHTERS, ExamplePackage.DAUGHTER__FAMILY);
		}
		return daughters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.FAMILY__ADDRESS, oldAddress, address));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.FAMILY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExamplePackage.FAMILY__PARENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParents()).basicAdd(otherEnd, msgs);
			case ExamplePackage.FAMILY__SONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSons()).basicAdd(otherEnd, msgs);
			case ExamplePackage.FAMILY__DAUGHTERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDaughters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExamplePackage.FAMILY__PARENTS:
				return ((InternalEList<?>)getParents()).basicRemove(otherEnd, msgs);
			case ExamplePackage.FAMILY__SONS:
				return ((InternalEList<?>)getSons()).basicRemove(otherEnd, msgs);
			case ExamplePackage.FAMILY__DAUGHTERS:
				return ((InternalEList<?>)getDaughters()).basicRemove(otherEnd, msgs);
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
			case ExamplePackage.FAMILY__PARENTS:
				return getParents();
			case ExamplePackage.FAMILY__SONS:
				return getSons();
			case ExamplePackage.FAMILY__DAUGHTERS:
				return getDaughters();
			case ExamplePackage.FAMILY__ADDRESS:
				return getAddress();
			case ExamplePackage.FAMILY__NAME:
				return getName();
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
			case ExamplePackage.FAMILY__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends Parent>)newValue);
				return;
			case ExamplePackage.FAMILY__SONS:
				getSons().clear();
				getSons().addAll((Collection<? extends Son>)newValue);
				return;
			case ExamplePackage.FAMILY__DAUGHTERS:
				getDaughters().clear();
				getDaughters().addAll((Collection<? extends Daughter>)newValue);
				return;
			case ExamplePackage.FAMILY__ADDRESS:
				setAddress((String)newValue);
				return;
			case ExamplePackage.FAMILY__NAME:
				setName((String)newValue);
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
			case ExamplePackage.FAMILY__PARENTS:
				getParents().clear();
				return;
			case ExamplePackage.FAMILY__SONS:
				getSons().clear();
				return;
			case ExamplePackage.FAMILY__DAUGHTERS:
				getDaughters().clear();
				return;
			case ExamplePackage.FAMILY__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case ExamplePackage.FAMILY__NAME:
				setName(NAME_EDEFAULT);
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
			case ExamplePackage.FAMILY__PARENTS:
				return parents != null && !parents.isEmpty();
			case ExamplePackage.FAMILY__SONS:
				return sons != null && !sons.isEmpty();
			case ExamplePackage.FAMILY__DAUGHTERS:
				return daughters != null && !daughters.isEmpty();
			case ExamplePackage.FAMILY__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case ExamplePackage.FAMILY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (address: ");
		result.append(address);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FamilyImpl
