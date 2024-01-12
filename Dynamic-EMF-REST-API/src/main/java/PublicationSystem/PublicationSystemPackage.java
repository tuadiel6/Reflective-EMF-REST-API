/**
 */
package PublicationSystem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see PublicationSystem.PublicationSystemFactory
 * @model kind="package"
 * @generated
 */
public interface PublicationSystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PublicationSystem";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://example.publicationsystem/v1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "publicationsystem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PublicationSystemPackage eINSTANCE = PublicationSystem.impl.PublicationSystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link PublicationSystem.impl.PublicationModelImpl <em>Publication Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see PublicationSystem.impl.PublicationModelImpl
	 * @see PublicationSystem.impl.PublicationSystemPackageImpl#getPublicationModel()
	 * @generated
	 */
	int PUBLICATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Publications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_MODEL__PUBLICATIONS = 0;

	/**
	 * The number of structural features of the '<em>Publication Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Publication Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link PublicationSystem.impl.PublicationImpl <em>Publication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see PublicationSystem.impl.PublicationImpl
	 * @see PublicationSystem.impl.PublicationSystemPackageImpl#getPublication()
	 * @generated
	 */
	int PUBLICATION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION__TITLE = 2;

	/**
	 * The number of structural features of the '<em>Publication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Publication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link PublicationSystem.PublicationModel <em>Publication Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publication Model</em>'.
	 * @see PublicationSystem.PublicationModel
	 * @generated
	 */
	EClass getPublicationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link PublicationSystem.PublicationModel#getPublications <em>Publications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Publications</em>'.
	 * @see PublicationSystem.PublicationModel#getPublications()
	 * @see #getPublicationModel()
	 * @generated
	 */
	EReference getPublicationModel_Publications();

	/**
	 * Returns the meta object for class '{@link PublicationSystem.Publication <em>Publication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publication</em>'.
	 * @see PublicationSystem.Publication
	 * @generated
	 */
	EClass getPublication();

	/**
	 * Returns the meta object for the attribute '{@link PublicationSystem.Publication#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see PublicationSystem.Publication#getId()
	 * @see #getPublication()
	 * @generated
	 */
	EAttribute getPublication_Id();

	/**
	 * Returns the meta object for the attribute '{@link PublicationSystem.Publication#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see PublicationSystem.Publication#getAuthor()
	 * @see #getPublication()
	 * @generated
	 */
	EAttribute getPublication_Author();

	/**
	 * Returns the meta object for the attribute '{@link PublicationSystem.Publication#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see PublicationSystem.Publication#getTitle()
	 * @see #getPublication()
	 * @generated
	 */
	EAttribute getPublication_Title();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PublicationSystemFactory getPublicationSystemFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link PublicationSystem.impl.PublicationModelImpl <em>Publication Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see PublicationSystem.impl.PublicationModelImpl
		 * @see PublicationSystem.impl.PublicationSystemPackageImpl#getPublicationModel()
		 * @generated
		 */
		EClass PUBLICATION_MODEL = eINSTANCE.getPublicationModel();

		/**
		 * The meta object literal for the '<em><b>Publications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PUBLICATION_MODEL__PUBLICATIONS = eINSTANCE.getPublicationModel_Publications();

		/**
		 * The meta object literal for the '{@link PublicationSystem.impl.PublicationImpl <em>Publication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see PublicationSystem.impl.PublicationImpl
		 * @see PublicationSystem.impl.PublicationSystemPackageImpl#getPublication()
		 * @generated
		 */
		EClass PUBLICATION = eINSTANCE.getPublication();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLICATION__ID = eINSTANCE.getPublication_Id();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLICATION__AUTHOR = eINSTANCE.getPublication_Author();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLICATION__TITLE = eINSTANCE.getPublication_Title();

	}

} //PublicationSystemPackage
