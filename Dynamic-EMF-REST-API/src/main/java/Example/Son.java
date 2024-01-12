/**
 */
package Example;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Son</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Example.Son#getFamily <em>Family</em>}</li>
 *   <li>{@link Example.Son#getFirstName <em>First Name</em>}</li>
 *   <li>{@link Example.Son#getLastName <em>Last Name</em>}</li>
 * </ul>
 *
 * @see Example.ExamplePackage#getSon()
 * @model
 * @generated
 */
public interface Son extends EObject {
	/**
	 * Returns the value of the '<em><b>Family</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Example.Family#getSons <em>Sons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family</em>' container reference.
	 * @see #setFamily(Family)
	 * @see Example.ExamplePackage#getSon_Family()
	 * @see Example.Family#getSons
	 * @model opposite="sons" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamily();

	/**
	 * Sets the value of the '{@link Example.Son#getFamily <em>Family</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' container reference.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(Family value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see Example.ExamplePackage#getSon_FirstName()
	 * @model id="true" ordered="false"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link Example.Son#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see Example.ExamplePackage#getSon_LastName()
	 * @model unique="false"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link Example.Son#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

} // Son
