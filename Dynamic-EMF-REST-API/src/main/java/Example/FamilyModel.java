/**
 */
package Example;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Family Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Example.FamilyModel#getFamilys <em>Familys</em>}</li>
 * </ul>
 *
 * @see Example.ExamplePackage#getFamilyModel()
 * @model
 * @generated
 */
public interface FamilyModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Familys</b></em>' containment reference list.
	 * The list contents are of type {@link Example.Family}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Familys</em>' containment reference list.
	 * @see Example.ExamplePackage#getFamilyModel_Familys()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Family> getFamilys();

} // FamilyModel
