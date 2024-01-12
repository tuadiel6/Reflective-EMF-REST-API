/**
 */
package Example;

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
 * @see Example.ExampleFactory
 * @model kind="package"
 * @generated
 */
public interface ExamplePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Example";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://emf-rest.com/Example";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Example";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExamplePackage eINSTANCE = Example.impl.ExamplePackageImpl.init();

	/**
	 * The meta object id for the '{@link Example.impl.FamilyModelImpl <em>Family Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Example.impl.FamilyModelImpl
	 * @see Example.impl.ExamplePackageImpl#getFamilyModel()
	 * @generated
	 */
	int FAMILY_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Familys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_MODEL__FAMILYS = 0;

	/**
	 * The number of structural features of the '<em>Family Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Family Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Example.impl.FamilyImpl <em>Family</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Example.impl.FamilyImpl
	 * @see Example.impl.ExamplePackageImpl#getFamily()
	 * @generated
	 */
	int FAMILY = 1;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__PARENTS = 0;

	/**
	 * The feature id for the '<em><b>Sons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__SONS = 1;

	/**
	 * The feature id for the '<em><b>Daughters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__DAUGHTERS = 2;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__ADDRESS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__NAME = 4;

	/**
	 * The number of structural features of the '<em>Family</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Family</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Example.impl.ParentImpl <em>Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Example.impl.ParentImpl
	 * @see Example.impl.ExamplePackageImpl#getParent()
	 * @generated
	 */
	int PARENT = 2;

	/**
	 * The feature id for the '<em><b>Family</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT__FAMILY = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT__FIRST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT__LAST_NAME = 2;

	/**
	 * The number of structural features of the '<em>Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Example.impl.SonImpl <em>Son</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Example.impl.SonImpl
	 * @see Example.impl.ExamplePackageImpl#getSon()
	 * @generated
	 */
	int SON = 3;

	/**
	 * The feature id for the '<em><b>Family</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SON__FAMILY = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SON__FIRST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SON__LAST_NAME = 2;

	/**
	 * The number of structural features of the '<em>Son</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SON_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Son</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Example.impl.DaughterImpl <em>Daughter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Example.impl.DaughterImpl
	 * @see Example.impl.ExamplePackageImpl#getDaughter()
	 * @generated
	 */
	int DAUGHTER = 4;

	/**
	 * The feature id for the '<em><b>Family</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAUGHTER__FAMILY = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAUGHTER__FIRST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAUGHTER__LAST_NAME = 2;

	/**
	 * The number of structural features of the '<em>Daughter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAUGHTER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Daughter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAUGHTER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Example.FamilyModel <em>Family Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Family Model</em>'.
	 * @see Example.FamilyModel
	 * @generated
	 */
	EClass getFamilyModel();

	/**
	 * Returns the meta object for the containment reference list '{@link Example.FamilyModel#getFamilys <em>Familys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Familys</em>'.
	 * @see Example.FamilyModel#getFamilys()
	 * @see #getFamilyModel()
	 * @generated
	 */
	EReference getFamilyModel_Familys();

	/**
	 * Returns the meta object for class '{@link Example.Family <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Family</em>'.
	 * @see Example.Family
	 * @generated
	 */
	EClass getFamily();

	/**
	 * Returns the meta object for the containment reference list '{@link Example.Family#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parents</em>'.
	 * @see Example.Family#getParents()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_Parents();

	/**
	 * Returns the meta object for the containment reference list '{@link Example.Family#getSons <em>Sons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sons</em>'.
	 * @see Example.Family#getSons()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_Sons();

	/**
	 * Returns the meta object for the containment reference list '{@link Example.Family#getDaughters <em>Daughters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Daughters</em>'.
	 * @see Example.Family#getDaughters()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_Daughters();

	/**
	 * Returns the meta object for the attribute '{@link Example.Family#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see Example.Family#getAddress()
	 * @see #getFamily()
	 * @generated
	 */
	EAttribute getFamily_Address();

	/**
	 * Returns the meta object for the attribute '{@link Example.Family#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Example.Family#getName()
	 * @see #getFamily()
	 * @generated
	 */
	EAttribute getFamily_Name();

	/**
	 * Returns the meta object for class '{@link Example.Parent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent</em>'.
	 * @see Example.Parent
	 * @generated
	 */
	EClass getParent();

	/**
	 * Returns the meta object for the container reference '{@link Example.Parent#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Family</em>'.
	 * @see Example.Parent#getFamily()
	 * @see #getParent()
	 * @generated
	 */
	EReference getParent_Family();

	/**
	 * Returns the meta object for the attribute '{@link Example.Parent#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see Example.Parent#getFirstName()
	 * @see #getParent()
	 * @generated
	 */
	EAttribute getParent_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link Example.Parent#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see Example.Parent#getLastName()
	 * @see #getParent()
	 * @generated
	 */
	EAttribute getParent_LastName();

	/**
	 * Returns the meta object for class '{@link Example.Son <em>Son</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Son</em>'.
	 * @see Example.Son
	 * @generated
	 */
	EClass getSon();

	/**
	 * Returns the meta object for the container reference '{@link Example.Son#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Family</em>'.
	 * @see Example.Son#getFamily()
	 * @see #getSon()
	 * @generated
	 */
	EReference getSon_Family();

	/**
	 * Returns the meta object for the attribute '{@link Example.Son#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see Example.Son#getFirstName()
	 * @see #getSon()
	 * @generated
	 */
	EAttribute getSon_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link Example.Son#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see Example.Son#getLastName()
	 * @see #getSon()
	 * @generated
	 */
	EAttribute getSon_LastName();

	/**
	 * Returns the meta object for class '{@link Example.Daughter <em>Daughter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Daughter</em>'.
	 * @see Example.Daughter
	 * @generated
	 */
	EClass getDaughter();

	/**
	 * Returns the meta object for the container reference '{@link Example.Daughter#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Family</em>'.
	 * @see Example.Daughter#getFamily()
	 * @see #getDaughter()
	 * @generated
	 */
	EReference getDaughter_Family();

	/**
	 * Returns the meta object for the attribute '{@link Example.Daughter#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see Example.Daughter#getFirstName()
	 * @see #getDaughter()
	 * @generated
	 */
	EAttribute getDaughter_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link Example.Daughter#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see Example.Daughter#getLastName()
	 * @see #getDaughter()
	 * @generated
	 */
	EAttribute getDaughter_LastName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExampleFactory getExampleFactory();

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
		 * The meta object literal for the '{@link Example.impl.FamilyModelImpl <em>Family Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Example.impl.FamilyModelImpl
		 * @see Example.impl.ExamplePackageImpl#getFamilyModel()
		 * @generated
		 */
		EClass FAMILY_MODEL = eINSTANCE.getFamilyModel();

		/**
		 * The meta object literal for the '<em><b>Familys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY_MODEL__FAMILYS = eINSTANCE.getFamilyModel_Familys();

		/**
		 * The meta object literal for the '{@link Example.impl.FamilyImpl <em>Family</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Example.impl.FamilyImpl
		 * @see Example.impl.ExamplePackageImpl#getFamily()
		 * @generated
		 */
		EClass FAMILY = eINSTANCE.getFamily();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__PARENTS = eINSTANCE.getFamily_Parents();

		/**
		 * The meta object literal for the '<em><b>Sons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__SONS = eINSTANCE.getFamily_Sons();

		/**
		 * The meta object literal for the '<em><b>Daughters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__DAUGHTERS = eINSTANCE.getFamily_Daughters();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAMILY__ADDRESS = eINSTANCE.getFamily_Address();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAMILY__NAME = eINSTANCE.getFamily_Name();

		/**
		 * The meta object literal for the '{@link Example.impl.ParentImpl <em>Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Example.impl.ParentImpl
		 * @see Example.impl.ExamplePackageImpl#getParent()
		 * @generated
		 */
		EClass PARENT = eINSTANCE.getParent();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT__FAMILY = eINSTANCE.getParent_Family();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARENT__FIRST_NAME = eINSTANCE.getParent_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARENT__LAST_NAME = eINSTANCE.getParent_LastName();

		/**
		 * The meta object literal for the '{@link Example.impl.SonImpl <em>Son</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Example.impl.SonImpl
		 * @see Example.impl.ExamplePackageImpl#getSon()
		 * @generated
		 */
		EClass SON = eINSTANCE.getSon();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SON__FAMILY = eINSTANCE.getSon_Family();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SON__FIRST_NAME = eINSTANCE.getSon_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SON__LAST_NAME = eINSTANCE.getSon_LastName();

		/**
		 * The meta object literal for the '{@link Example.impl.DaughterImpl <em>Daughter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Example.impl.DaughterImpl
		 * @see Example.impl.ExamplePackageImpl#getDaughter()
		 * @generated
		 */
		EClass DAUGHTER = eINSTANCE.getDaughter();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAUGHTER__FAMILY = eINSTANCE.getDaughter_Family();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAUGHTER__FIRST_NAME = eINSTANCE.getDaughter_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAUGHTER__LAST_NAME = eINSTANCE.getDaughter_LastName();

	}

} //ExamplePackage
