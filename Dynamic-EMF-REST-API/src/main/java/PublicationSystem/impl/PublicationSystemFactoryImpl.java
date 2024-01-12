/**
 */
package PublicationSystem.impl;

import PublicationSystem.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PublicationSystemFactoryImpl extends EFactoryImpl implements PublicationSystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PublicationSystemFactory init() {
		try {
			PublicationSystemFactory thePublicationSystemFactory = (PublicationSystemFactory)EPackage.Registry.INSTANCE.getEFactory(PublicationSystemPackage.eNS_URI);
			if (thePublicationSystemFactory != null) {
				return thePublicationSystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PublicationSystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicationSystemFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PublicationSystemPackage.PUBLICATION_MODEL: return createPublicationModel();
			case PublicationSystemPackage.PUBLICATION: return createPublication();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicationModel createPublicationModel() {
		PublicationModelImpl publicationModel = new PublicationModelImpl();
		return publicationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publication createPublication() {
		PublicationImpl publication = new PublicationImpl();
		return publication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicationSystemPackage getPublicationSystemPackage() {
		return (PublicationSystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PublicationSystemPackage getPackage() {
		return PublicationSystemPackage.eINSTANCE;
	}

} //PublicationSystemFactoryImpl
