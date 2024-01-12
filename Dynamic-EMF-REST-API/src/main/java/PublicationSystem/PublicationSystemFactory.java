/**
 */
package PublicationSystem;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see PublicationSystem.PublicationSystemPackage
 * @generated
 */
public interface PublicationSystemFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PublicationSystemFactory eINSTANCE = PublicationSystem.impl.PublicationSystemFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Publication Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publication Model</em>'.
	 * @generated
	 */
	PublicationModel createPublicationModel();

	/**
	 * Returns a new object of class '<em>Publication</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publication</em>'.
	 * @generated
	 */
	Publication createPublication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PublicationSystemPackage getPublicationSystemPackage();

} //PublicationSystemFactory
