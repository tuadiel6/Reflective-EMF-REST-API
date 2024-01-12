/**
 */
package PublicationSystem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Publication Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PublicationSystem.PublicationModel#getPublications <em>Publications</em>}</li>
 * </ul>
 *
 * @see PublicationSystem.PublicationSystemPackage#getPublicationModel()
 * @model
 * @generated
 */
public interface PublicationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Publications</b></em>' containment reference list.
	 * The list contents are of type {@link PublicationSystem.Publication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publications</em>' containment reference list.
	 * @see PublicationSystem.PublicationSystemPackage#getPublicationModel_Publications()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Publication> getPublications();

} // PublicationModel
