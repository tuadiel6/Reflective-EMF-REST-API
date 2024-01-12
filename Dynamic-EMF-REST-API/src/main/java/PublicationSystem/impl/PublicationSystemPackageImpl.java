/**
 */
package PublicationSystem.impl;

import PublicationSystem.Publication;
import PublicationSystem.PublicationModel;
import PublicationSystem.PublicationSystemFactory;
import PublicationSystem.PublicationSystemPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PublicationSystemPackageImpl extends EPackageImpl implements PublicationSystemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publicationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publicationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see PublicationSystem.PublicationSystemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PublicationSystemPackageImpl() {
		super(eNS_URI, PublicationSystemFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link PublicationSystemPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PublicationSystemPackage init() {
		if (isInited) return (PublicationSystemPackage)EPackage.Registry.INSTANCE.getEPackage(PublicationSystemPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPublicationSystemPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PublicationSystemPackageImpl thePublicationSystemPackage = registeredPublicationSystemPackage instanceof PublicationSystemPackageImpl ? (PublicationSystemPackageImpl)registeredPublicationSystemPackage : new PublicationSystemPackageImpl();

		isInited = true;

		// Create package meta-data objects
		thePublicationSystemPackage.createPackageContents();

		// Initialize created meta-data
		thePublicationSystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePublicationSystemPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PublicationSystemPackage.eNS_URI, thePublicationSystemPackage);
		return thePublicationSystemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublicationModel() {
		return publicationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublicationModel_Publications() {
		return (EReference)publicationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublication() {
		return publicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublication_Id() {
		return (EAttribute)publicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublication_Author() {
		return (EAttribute)publicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublication_Title() {
		return (EAttribute)publicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicationSystemFactory getPublicationSystemFactory() {
		return (PublicationSystemFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		publicationModelEClass = createEClass(PUBLICATION_MODEL);
		createEReference(publicationModelEClass, PUBLICATION_MODEL__PUBLICATIONS);

		publicationEClass = createEClass(PUBLICATION);
		createEAttribute(publicationEClass, PUBLICATION__ID);
		createEAttribute(publicationEClass, PUBLICATION__AUTHOR);
		createEAttribute(publicationEClass, PUBLICATION__TITLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(publicationModelEClass, PublicationModel.class, "PublicationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPublicationModel_Publications(), this.getPublication(), null, "publications", null, 1, -1, PublicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(publicationEClass, Publication.class, "Publication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPublication_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Publication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPublication_Author(), ecorePackage.getEString(), "author", null, 0, 1, Publication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPublication_Title(), ecorePackage.getEString(), "title", null, 0, 1, Publication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PublicationSystemPackageImpl
