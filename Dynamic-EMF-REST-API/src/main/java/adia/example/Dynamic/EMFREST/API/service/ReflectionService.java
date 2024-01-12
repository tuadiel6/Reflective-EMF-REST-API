package adia.example.Dynamic.EMFREST.API.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import adia.example.Dynamic.EMFREST.API.repository.ReflectionRepository;



@Service
public class ReflectionService {
	@JsonIgnoreProperties
	@Autowired
    private ReflectionRepository reflectionRepository;
	/*
	 * This code defines a method named findAllClasses that uses the Reflections library 
	 * to discover all classes within a specified package. 
	 * The method returns a Set<Class> containing all the classes found in the specified package.
	 */
	
	// ==================GET All CLASSES INSIDE A PACKAGE===================
	public List<Class<?>> findAllClasses(String packageName) throws ReflectiveOperationException {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        
        Set<Class<? extends Object>> classesSet = reflections.getSubTypesOf(Object.class);

        // Convert Set<Class<?>> to List<Class<?>>
        List<Class<?>> classesList = new ArrayList<>(classesSet);

        return classesList;
        //return reflections.getSubTypesOf(Object.class);
    }
	
	// ==================GET All METHOD INSIDE A CLASS ===================
	public static List<Method> findAllMethods(String packageName, String className) throws ClassNotFoundException {
		
		Class<?> clazz = Class.forName(packageName + "." + className);
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
        	method.setAccessible(true);
        	methods.add(method);
            System.out.println("Class Methods:"+method);
        }
        return methods;
    }
    
    
    // ==================GET All OPERATION===================
    /*
     * Performs a "GET" operation on a model using reflection.
     */
	public <T> List<T> fetchItemList(String packageName, String className)
            throws ReflectiveOperationException, IllegalArgumentException,
            InvocationTargetException, FileNotFoundException {

        /*
         * To store the dynamically loaded class.
         */
        Class<?> target = null;
        
        // Get all classes in the specified package and iterates over them.
        // If a class name matches the specified combination of packageName and className, set the target variable to that class.
        List<Class<?>> classes = findAllClasses(packageName);
        for (Class<?> clazz : classes) {
            if (clazz.getName().equalsIgnoreCase(packageName + "." + className)) {
                target = clazz;
                break;
            }
        }

        if (target == null) {
            throw new IllegalArgumentException("Class not found: " + packageName + "." + className);
        }
           
     // Retrieve the available models and their corresponding file paths
        Map<String, List<String>> availableModels = reflectionRepository.loadAvailableModels();

        List<T> combinedElements = new ArrayList<>();
        
     // Iterate over the list of file paths for the specified package
        for (String modelPath : availableModels.get(packageName.toLowerCase())) {
            // Load XMI for the current model path
            List<T> modelElements = (List<T>) reflectionRepository.loadXMI(packageName,className);

            // Add the elements to the combined list
            //combinedElements.addAll(modelElements);
            //combinedElements.add((T) modelElements);
            
            combinedElements.add(0, (T) modelElements);
            
        }

        return combinedElements.subList(0, 1);
        
    }
	
	
	// ==================GET EACH ELEMENT OPERATION===================
    /*
     * Performs a "GET" operation on a model using reflection.
     */
	public <T> List<T> fetchEachItem(String packageName, String className, String methodName)
            throws ReflectiveOperationException, IllegalArgumentException,
            InvocationTargetException, FileNotFoundException {

        /*
         * To store the dynamically loaded class.
         */
        Class<?> target = null;
        
        ReflectionRepository repos = new ReflectionRepository();

        // Get all classes in the specified package and iterates over them.
        // If a class name matches the specified combination of packageName and className, set the target variable to that class.
        List<Class<?>> classes = findAllClasses(packageName);
        for (Class<?> clazz : classes) {
            if (clazz.getName().equalsIgnoreCase(packageName + "." + className)) {
        	//if (clazz.getName().equalsIgnoreCase(packageName + "."+packageName +"package")) {
                target = clazz;
                break;
            }
        }

        if (target == null) {
            throw new IllegalArgumentException("Class not found: " + packageName + "." + className);
        }
          
        
        List<EObject> obj = repos.loadXMI(packageName, className); 
		
		/*
		 * Calls the loadXMI method on the repos object, which loads an XMI model  
		 */	
		 
        Method meth = Class.forName(target.getCanonicalName()).getMethod("get" + methodName+"s");
		  List<T> listModelElement = new ArrayList<T>();
		  
		  for(EObject element: obj) {
			  listModelElement.addAll((Collection<? extends T>) meth.invoke(element, null));
		  }
		
		  /*
		 * Catches and prints an IOException if there is an issue saving the XMI file.
		 */
			/*
			 * try { ((EObject) obj).eResource().save(Collections.EMPTY_MAP);
			 * System.out.println("XMI file saved successfully."); } catch (IOException e) {
			 * e.printStackTrace(); System.err.println("Failed to save XMI file."); }
			 */
		    
		  return listModelElement; 
        
    }
	

	//==================POST OPERATION================
	public List<EObject> addElementToList(String packageName, String className, String modelName, Map<String, Object> requestBody)
	        throws ReflectiveOperationException, IOException {
	    
		// find all classes in the specified package and checks if a class with the provided name exists.
	    Class<?> target = null;
	    ReflectionRepository repos = new ReflectionRepository();
	    List<Class<?>> classes = findAllClasses(packageName);
	    for (Class<?> clazz : classes) {
	        if (clazz.getName().equals(packageName + "." + className)) {
	            target = clazz;
	            break;
	        }
	    }

	    if (target == null) {
	        throw new IllegalArgumentException("Class not found: " + packageName + "." + className);
	    }

	    ResourceSet resourceSet = new ResourceSetImpl();
	    String factoryClassName = packageName + "Factory";
	    //create a new instance of the specified class with the provided attributes.
	    EObject newInstance = createInstance(packageName, className, factoryClassName, requestBody, resourceSet);

	    // Load the existing model elements and add the newly created instance.
	    List<EObject> existingElements = repos.addLoadXMI2(packageName, className, modelName, newInstance);

	    // Identify the parent element where you want to add the new child
	    EObject parentElement = findParentElement(existingElements, packageName, className);

	    // Add the new instance to the containment reference of the parent element
	    if (parentElement != null) {
	        EReference containmentReference = findContainmentReference(parentElement, className);
	        if (containmentReference != null && containmentReference.isMany()) {
	            ((EList<EObject>) parentElement.eGet(containmentReference)).add(newInstance);
	        } 
	    } else {
	        System.err.println("Parent element not found.");
	    }

	    // Save the modified model to the XMI file.
	    try {
	        for (EObject element : existingElements) {
	            if (element.eResource() != null) {
	                element.eResource().save(Collections.EMPTY_MAP);
	                System.out.println(element);
	            } else {
	                System.err.println("Element not associated with a resource: " + element);
	            }
	        }
	        System.out.println("XMI file saved successfully.");
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.err.println("Failed to save XMI file.");
	    }

	    return existingElements;
	}

	// Find the parent element based on the structure of your model. It iterates through the elements and returns the first one that is an instance of the specified class.
	private EObject findParentElement(List<EObject> existingElements, String packageName, String className) throws ClassNotFoundException {
	    for (EObject element : existingElements) {
	        //if (element instanceof ProductModel) {
	        if (Class.forName(packageName+"."+className).isInstance(element)) {
	            return element;
	        }
	    }
	    return null;
	}

	// Find the containment reference based on the class name. Returns the first containment reference whose type matches the provided class name.
	private EReference findContainmentReference(EObject container, String className) {
	    for (EReference reference : container.eClass().getEAllContainments()) {
	        if (reference.getEReferenceType().getName().equals(className)) {
	            return reference;
	        }
	    }
	    return null;
	}

	
	//=========Create an Instance==========
	/*
	 * Creates an instance of a specified class using reflection.
	 * It sets attribute values on the created instance based on the provided attributes.
	 */
	public EObject createInstance(String packageName, String className, 
			String factoryClassName, Map<String, Object> attributes, ResourceSet resourceSet)
	        throws ReflectiveOperationException {
		//Use the generated factory to create instances of your model elements. 
	    Class<?> factoryClass = Class.forName(packageName + "." + factoryClassName);
	    Method createMethod = factoryClass.getMethod("create" + className);

	    // Get the factory instance using the generated eINSTANCE field
	    Field eInstanceField = factoryClass.getField("eINSTANCE");
	    Object factoryInstance = eInstanceField.get(null);
	    
	    // Invoke the create method on the factory instance
	    Object createdObject = createMethod.invoke(factoryInstance);

	    // Set attribute values using reflection
	    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
	        String attributeName = entry.getKey();
	        Object attributeValue = entry.getValue();
	        
	        System.out.println("Key:"+entry.getKey()+"Value:"+entry.getValue());
	        // Use reflection to set the attribute value on the created instance
	        Field field = createdObject.getClass().getDeclaredField(attributeName);
	        field.setAccessible(true);
	        field.set(createdObject, attributeValue);
	    }

		  // This works only on the root level. We need to Create instances of child classes.--->To be done	 
	    return (EObject) createdObject;
	}

	
	// ==================SEARCH OPERATION===================
	
	public <T> List<T> fetchItemListWithSearch(String packageName, String className, String methodName, String attributeName, String searchValue)
	        throws ReflectiveOperationException, IllegalArgumentException, InvocationTargetException, FileNotFoundException {
	
		  // Retrieve the available models and their corresponding file paths
	    Map<String, List<String>> availableModels = reflectionRepository.loadAvailableModels();

	    List<T> searchedElement = new ArrayList<>();

	    // Get the target class
	    Class<?> target = findClassByName(packageName, className);
	    if (target == null) {
	        throw new IllegalArgumentException("Class not found: " + packageName + "." + className);
	    }

	    // Load XMI for the target class
	    List<T> modelElements = (List<T>) reflectionRepository.loadXMI(packageName, className);

	    // Filter elements based on search conditions
	    List<T> filteredElements = filterModelElements(modelElements, attributeName, searchValue);

	    // Add the filtered elements to the combined list
	    searchedElement.addAll(filteredElements);

	    return searchedElement;
	}

	private <T> List<T> filterModelElements(List<T> modelElements, String attributeName, String searchValue) {
	    return modelElements.stream()
	            .filter(element -> {
	                try {
	                    return matchesSearchCondition(element, attributeName, searchValue);
	                } catch (ReflectiveOperationException e) {
	                    e.printStackTrace();
	                    return false;
	                }
	            })
	            .collect(Collectors.toList());
	}

	// Helper method to check if an element matches the search criteria
	private <T> boolean matchesSearchCondition(T element, String attributeName, String searchValue)
	        throws ReflectiveOperationException {
		
		try {
            // Use reflection to get the value of the specified attribute
            Method getterMethod = element.getClass().getMethod("get" + attributeName);
            Object attributeValue = getterMethod.invoke(element);

            // Perform case-insensitive string matching
            if (attributeValue instanceof String) {
                return ((String) attributeValue).toLowerCase().contains(searchValue.toLowerCase());
            } else {
                // Modify this part based on the type of the attribute
                // For example, for numeric types, you might want to perform exact matching
                return attributeValue.equals(searchValue);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace(); 
            return false;
        }
    }
	
	
	private Class<?> findClassByName(String packageName, String className) throws ReflectiveOperationException {
		// Retrieve a list of all classes in the specified package
		List<Class<?>> classes = findAllClasses(packageName);
        for (Class<?> clazz : classes) {
        	// Check if the fully qualified name of the current class matches the expected class name
            if (clazz.getName().equalsIgnoreCase(packageName + "." + className)) {
                return clazz;
            }
        }
        return null;
    }
	
	
	// ==================DELETE OPERATION===================
		  /*
		   * This code defines a method that deletes an item from a model by its ID using reflection. 
		   * The method dynamically loads classes, retrieves a list of model elements, 
		   * removes an item with a specified ID, updates the model, and then saves the modified resource back to an XMI file 
		   */
	    
	 	  public <T> void deleteItemById(String packageName, String className, 
	 			  String methodName, Integer Id) throws ReflectiveOperationException, 
	 	  IllegalArgumentException, InvocationTargetException, FileNotFoundException {
	 		 
	 		 ReflectionRepository repos = new ReflectionRepository();
	 		
	 		//store the loaded class.
	 		//Class target = null;
	 		Class<?> target = null;
	 		
	 		/*
	 		 * Get all classes in the specified package and iterates over them. 
	 		 * If a class name matches the specified combination of packageName and className, sets target to that class
	 		 */
	 		
	        List<Class<?>> classes = findAllClasses(packageName);
	        for (Class<?> clazz : classes) {
	            if (clazz.getName().equalsIgnoreCase(packageName + "." + className)) {
	                target = clazz;
	                break;
	            }
	        }

	        if (target == null) {
	            throw new IllegalArgumentException("Class not found: " + packageName + "." + className);
	        }
	        
	     // Retrieve the available models and their corresponding file paths
	        List<T> combinedElements = new ArrayList<>();
	        Map<String, List<String>> availableModels = repos.loadAvailableModels();

	        //List<T> combinedElements = new ArrayList<>();
	        
	     // Iterate over the list of file paths for the specified package
	        for (String modelPath : availableModels.get(packageName.toLowerCase())) {
	            // Load XMI for the current model path
	            List<T> modelElements = (List<T>) repos.loadXMI(packageName, className);
	            
	            combinedElements.add(0, (T) modelElements);
	        
			  System.out.println("List before removal: " + combinedElements);
			  
			// Assuming you have a method named "getId" in your model class
			  int idToDelete = Id;
			  System.out.println("ID to delete: " + idToDelete);
			  	
			  /*
			   * Removes an item from listModelElement if its ID matches the specified idToDelete. 
			   * The ID is obtained using reflection to invoke the getId method on each item.
			   */
			  combinedElements.removeIf(item -> {
		            try {
		                Method getIdMethod = item.getClass().getMethod("getId");
		                Integer itemId = (Integer) getIdMethod.invoke(item);
		                System.out.println("Item ID: " + itemId);
		                return itemId.equals(idToDelete);
		            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
		                e.printStackTrace(); // Handle the exception according to your needs
		                return false;
		            }
		        });
			  
			  System.out.println("List after removal: " + combinedElements);
		        //System.out.println("List after removal: " + combinedElements);

		        // Save the modified resource back to the XMI file
		        // Note: You may want to check if saving is required based on your specific use case
		    /*
		        try {
		        	T eObject =  combinedElements.get(0); // Assuming there is one root element
	                if (((EObject) eObject).eResource() != null) {
	                    ((EObject) eObject).eResource().save(Collections.emptyMap());
	                    System.out.println("XMI file saved successfully.");
	                } else {
	                    System.err.println("Resource is null, unable to save XMI file.");
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	                System.err.println("Failed to save XMI file.");
	            }
	            */
	        }
	 	  }  
	 	  
	 	  
	 	  //=====================
	 	 /*
	 	  public void deleteElementss(String packageName, String className, String attributeName, Object attributeValue)
	 	        throws ReflectiveOperationException, FileNotFoundException {

	 	    List<EObject> modelElements = reflectionRepository.loadXMI(packageName, className);

	 	    for (EObject element : modelElements) {
	 	        Class<?> clazz = element.getClass();
	 	        Field field;

	 	        try {
	 	            field = clazz.getDeclaredField(attributeName);
	 	            field.setAccessible(true); // Ensure private fields are accessible

	 	            // Print the value for debugging
	 	            System.out.println("Field Name: " + attributeName + ", Value: " + field.get(element));

	 	            Object value = field.get(element);

	 	            if (Objects.equals(value, attributeValue)) {
	 	                Resource resource = element.eResource();
	 	                if (resource != null) {
	 	                	System.out.println("Deleting Element:");
	 	                    System.out.println("Element: " + element);
	 	                    System.out.println("Resource: " + resource);
	 	                    // Remove the element from the model
	 	                    resource.getContents().remove(element);
	 	                    
	 	                    // Save the resource
	 	                    resource.save(Collections.EMPTY_MAP);
	 	                    System.out.println("Element deleted successfully.");
	 	                } else {
	 	                    System.err.println("Element not associated with a resource: " + element);
	 	                }
	 	            }
	 	        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
	 	            e.printStackTrace();
	 	           System.err.println("Failed to save XMI file.");
	 	        }
	 	    }
	 	}
*/
	 	 
	 	  //===================DELETE ELEMENTS BASED ON ATTRIBUTE AND VALUE ====================
	 	 
	 	 public void deleteElementbyAttribute(String packageName, String className, String attributeName, Object attributeValue)
	 	        throws ReflectiveOperationException, FileNotFoundException {

	 	    // Retrieve the available models and their corresponding file paths
	 	    Map<String, List<String>> availableModels = reflectionRepository.loadAvailableModels();

	 	    // Load XMI for the specified package and class
	 	    List<EObject> modelElements = reflectionRepository.loadXMI(packageName, className);

	 	    // Iterate over the loaded model elements
	 	    for (EObject element : modelElements) {
	 	        // Use reflection to get the attribute value
	 	        try {
	 	            Field field = element.getClass().getDeclaredField(attributeName);
	 	            field.setAccessible(true);
	 	            // Print the value for debugging
	 	            System.out.println("Field Name: " + attributeName + ", Value: " + field.get(element));

	 	            Object value = field.get(element);

	 	            // Check if the attribute value matches the specified value
	 	            if (Objects.equals(value, attributeValue)) {
	 	                // Check if the element is associated with a resource
	 	                Resource resource = element.eResource();
	 	                if (resource != null) {
	 	                	
	 	                	System.out.println("------Deleting Element:-------");
	 	                    System.out.println("Element: " + element);
	 	                    System.out.println("Resource: " + resource);
	 	                    // Delete the element
	 	                    EcoreUtil.delete(element, true);

	 	                    // Save the resource
	 	                    resource.save(Collections.EMPTY_MAP);
	 	                    System.out.println("Element deleted successfully.");
	 	                } else {
	 	                    System.err.println("Element not associated with a resource: " + element);
	 	                }
	 	            }
	 	        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
	 	            e.printStackTrace();
	 	        }
	 	    }
	 	}

	 	 
//===================DELETE ELEMENTS BASED ON ATTRIBUTE AND VALUE ON A SPECIFIC XMI FILE ====================
	 	 
	 	 public void deleteElementbyAttributeXMI(String packageName, String className, String attributeName, Object attributeValue, String xmiFileName)
	 	        throws ReflectiveOperationException, FileNotFoundException {

	 	    // Retrieve the available models and their corresponding file paths
	 	    Map<String, List<String>> availableModels = reflectionRepository.loadAvailableModels();

	 	    // Load XMI for the specified package and class
	 	    List<EObject> modelElements = reflectionRepository.loadXMIPath(packageName, className, xmiFileName);

	 	    // Iterate over the loaded model elements
	 	    for (EObject element : modelElements) {
	 	        // Use reflection to get the attribute value
	 	        try {
	 	            Field field = element.getClass().getDeclaredField(attributeName);
	 	            field.setAccessible(true);
	 	            // Print the value for debugging
	 	            System.out.println("Field Name: " + attributeName + ", Value: " + field.get(element));

	 	            Object value = field.get(element);

	 	            // Check if the attribute value matches the specified value
	 	            if (Objects.equals(value, attributeValue)) {
	 	                // Check if the element is associated with a resource
	 	                Resource resource = element.eResource();
	 	                if (resource != null) {
	 	                	
	 	                	System.out.println("------Deleting Element:-------");
	 	                    System.out.println("Element: " + element);
	 	                    System.out.println("Resource: " + resource);
	 	                    // Delete the element
	 	                    EcoreUtil.delete(element, true);

	 	                    // Save the resource
	 	                    resource.save(Collections.EMPTY_MAP);
	 	                    System.out.println("Element deleted successfully.");
	 	                } else {
	 	                    System.err.println("Element not associated with a resource: " + element);
	 	                }
	 	            }
	 	        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
	 	            e.printStackTrace();
	 	        }
	 	    }
	 	}

	 	 	  
	 	  //======================DELETE ELEMENT BY CLASS NAME================
	 	public void deleteElementsByClassName(String packageName, String className)
	 	        throws ReflectiveOperationException, IOException {

	 	    // Retrieve the available models and their corresponding file paths
	 	    Map<String, List<String>> availableModels = reflectionRepository.loadAvailableModels();

	 	    // Load XMI for the specified package and class
	 	    List<EObject> modelElements = reflectionRepository.loadXMI(packageName, className);

	 	    // Iterate over the loaded model elements
	 	    Iterator<EObject> iterator = modelElements.iterator();
	 	    while (iterator.hasNext()) {
	 	        EObject element = iterator.next();

	 	        // Check if the element's class name matches the specified class name
	 	        if (element.eClass().getName().equals(className)) {
	 	            // Check if the element is associated with a resource
	 	            Resource resource = element.eResource();
	 	            if (resource != null) {
	 	            	System.out.println("------Deleting Element:-------");
 	                    System.out.println("Element: " + element);
 	                    System.out.println("Resource: " + resource);
	 	                // Delete the element
	 	                EcoreUtil.delete(element, true);

	 	                // Save the resource
	 	                resource.save(Collections.EMPTY_MAP);
	 	                System.out.println("Element deleted successfully.");
	 	            } else {
	 	                System.err.println("Element not associated with a resource: " + element);
	 	            }

	 	            // Remove the element from the iterator to avoid concurrent modification issues
	 	            iterator.remove();
	 	        }
	 	    }
	 	}
	 	
	 	
	 	
	 	//==============DELETE ELEMENTS BY CLASS NAME ON A SPECIFIC XMI FILE=================
	 	
	 	public void deleteClassNameBasedXMI(String packageName, String className, String xmiFileName)
	 	        throws ReflectiveOperationException, IOException {

	 	    // Retrieve the available models and their corresponding file paths
	 	    Map<String, List<String>> availableModels = reflectionRepository.loadAvailableModels();

	 	    // Look up the list of file paths for the specified package
	 	    List<String> modelPaths = availableModels.get(packageName.toLowerCase());
	 	    if (modelPaths == null || modelPaths.isEmpty()) {
	 	        throw new IllegalArgumentException("Model not found: " + packageName);
	 	    }

	 	            // Load XMI for the current model path
	 	            List<EObject> modelElements = reflectionRepository.loadXMIPath(packageName, className, xmiFileName);

	 	            // Iterate over the loaded model elements
	 	            Iterator<EObject> iterator = modelElements.iterator();
	 	            while (iterator.hasNext()) {
	 	                EObject element = iterator.next();

	 	                // Check if the element's class name matches the specified class name
	 	                if (element.eClass().getName().equals(className)) {
	 	                    // Check if the element is associated with a resource
	 	                    Resource resource = element.eResource();
	 	                    if (resource != null) {
	 	                    	System.out.println("------Deleting Element:-------");
	 	 	                    System.out.println("Element: " + element);
	 	 	                    System.out.println("Resource: " + resource);
	 	                        // Delete the element
	 	                        EcoreUtil.delete(element, true);

	 	                        // Save the resource
	 	                        resource.save(Collections.EMPTY_MAP);
	 	                        System.out.println("Element deleted successfully.");
	 	                    } else {
	 	                        System.err.println("Element not associated with a resource: " + element);
	 	                    }

	 	                    // Remove the element from the iterator to avoid concurrent modification issues
	 	                    iterator.remove();
	 	                }
	 	            }
	 	            return; // Exit after processing the specified XMI file
	 	}


	 	//==============UPDATE ELEMENT BY CLASS NAME BASED ON ATTRIBUTE AND VALUE ON A SPECIFIC XMI FILE=================
	 	public void updateElement(String packageName, String className, String xmiFileName, String attributeName,
	 	        String attributeValue, Object updatedValue)
	 	        throws ReflectiveOperationException, FileNotFoundException {
	 	    
	 	    // Load XMI for the specified package and class
	 	    List<EObject> modelElements = reflectionRepository.loadXMIPath(packageName, className, xmiFileName);

	 	    // Iterate over the loaded model elements
	 	    for (EObject element : modelElements) {
	 	        // Use reflection to get the attribute value
	 	        try {
	 	            Field field = element.getClass().getDeclaredField(attributeName);
	 	            field.setAccessible(true);
	 	            System.out.println("Field Name: " + attributeName + ", Value: " + field.get(element));
	 	            Object value = field.get(element);
	 	            
	 	            // Check if the attribute value matches the specified value
	 	            if (Objects.equals(value, attributeValue)) {
	 	                // Update the attribute value with the new value
	 	                field.set(element, updatedValue);

	 	                // Save the modified resource
	 	                Resource resource = element.eResource();
	 	                if (resource != null) {
	 	                    resource.save(Collections.EMPTY_MAP);
	 	                    System.out.println("Element updated successfully.");
	 	                } else {
	 	                    System.err.println("Element not associated with a resource: " + element);
	 	                }
	 	            }
	 	        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
	 	            e.printStackTrace();
	 	        }
	 	    }
	 	}

	 	
	 	//===========POST NEW ELEMENT TO THE EXISTING ELEMENTS ============================
	 	
	 	public <T> void addElement(String packageName, String parentClassName, Map<String, Object> attributes,
                String parentContainmentName, String attributeNameToMatch, Object attributeValueToMatch,String childClassName,
                String childContainmentName, String xmiFileName)
			throws ReflectiveOperationException, IOException {
			
			// Load XMI for the specified package and class
			List<EObject> modelElements = reflectionRepository.loadXMIPath(packageName, parentClassName, xmiFileName);
			
			// Find the parent element with the specified attribute name and value
			Optional<EObject> matchingParentElement = modelElements.stream()
			.filter(element -> doesElementMatch(element, parentContainmentName, attributeNameToMatch, attributeValueToMatch))
			.findFirst();
			
			// If a matching parent element is found, add a new child element to it
			matchingParentElement.ifPresent(parentElement -> {
			try {
				EClass parentEClass = parentElement.eClass();
				System.out.println("Features of parentElement: " + parentEClass.getEAllStructuralFeatures());
				//String childClassName = "Son";
			EObject newChild = createInstance1(packageName, childClassName, attributes);
			EStructuralFeature childFeature = parentElement.eClass().getEStructuralFeature(childContainmentName);
			System.out.println("parentElement: " + parentElement);
			System.out.println("childElementName: " + childContainmentName);
			System.out.println("childFeature: " + childFeature);
			// Check if the parent element has a containment feature for the child element
			if (childFeature.isMany()) {
			    @SuppressWarnings("unchecked")
			    List<EObject> children = (List<EObject>) parentElement.eGet(childFeature);
			    children.add(newChild);
			} else {
			    parentElement.eSet(childFeature, newChild);
			}
			
			// Save the modified resource
			for (EObject element : modelElements) {
			    Resource resource = element.eResource();
			    if (resource != null) {
			        resource.save(Collections.EMPTY_MAP);
			        System.out.println("Element added successfully.");
			    } else {
			        System.err.println("Element not associated with a resource: " + element);
			    }
			}
			} catch (IOException | ReflectiveOperationException e) {
			e.printStackTrace();
			}
			});
			}

	 	
	 	
	 	
	 	// Helper method to check if an element matches the specified attribute name and value
	 	private boolean doesElementMatch(EObject element, String elementName, String attributeName, Object attributeValueToMatch) {
	 	    try {
	 	        EStructuralFeature feature = element.eClass().getEStructuralFeature(attributeName);
	 	        if (feature != null) {
	 	            Object value = element.eGet(feature);

	 	            return Objects.equals(value, attributeValueToMatch);
	 	        }
	 	    } catch (Exception e) {
	 	        e.printStackTrace();
	 	    }
	 	    return false;
	 	}

	 	
	 	
	 	private EObject createInstance1(String packageName, String className, Map<String, Object> attributes)
	 	        throws ReflectiveOperationException {
	 	    
	 		String factoryClassName = packageName + "Factory";
	 		Class<?> modelClass = Class.forName(packageName + "." + factoryClassName);
	 	    
	 	    Method createMethod = modelClass.getMethod("create" + className);
	 	// Get the factory instance using the generated eINSTANCE field
		    Field eInstanceField = modelClass.getField("eINSTANCE");
		    Object factoryInstance = eInstanceField.get(null);
	 	    //Object newInstance = modelClass.getDeclaredConstructor().newInstance();
		    
		    // Invoke the create method on the factory instance
		    Object createdObject = createMethod.invoke(factoryInstance);

	 	    // Set attribute values using reflection
	 	    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
	 	        String attributeName = entry.getKey();
	 	        Object attributeValue = entry.getValue();
	 	        
	 	       System.out.println("Key:"+entry.getKey()+" "+"Value:"+entry.getValue());

	 	   // Use reflection to set the attribute value on the created instance
		        Field field = createdObject.getClass().getDeclaredField(attributeName);
		        field.setAccessible(true);
		        field.set(createdObject, attributeValue);
	 	    }

	 	    return (EObject) createdObject;
	 	}
	 	
	 	
	 	
	 	//=========================
	 	
	 	/*
	 	public void addFamily(String packageName, String xmiFileName, String familyName, List<Map<String, Object>> familyMembers, Map<String, Object> attributes)
	 	        throws ReflectiveOperationException, IOException {

	 	    // Load XMI for the specified package and class
	 	    List<EObject> modelElements = reflectionRepository.loadXMIPath(packageName, "FamigliaModel", xmiFileName);
	 	    
	 	    // Create a new family instance
	 	    FamigliaFactory factory = FamigliaFactory.eINSTANCE;
	 	    Family newFamily = factory.createFamily();

	 	    // Set attributes for the new family
	 	    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
	 	        String attributeName = entry.getKey();
	 	        Object attributeValue = entry.getValue();
	 	        
	 	        // Use reflection to set the attribute value on the created instance
	 	        EStructuralFeature feature = newFamily.eClass().getEStructuralFeature(attributeName);
	 	        if (feature != null) {
	 	            newFamily.eSet(feature, attributeValue);
	 	        } else {
	 	            System.err.println("Attribute not found for family: " + attributeName);
	 	        }
	 	    }

	 	    // Create family members dynamically
	 	    for (Map<String, Object> familyMember : familyMembers) {
	 	        EObject newFamilyMember = createFamilyMemberInstance(packageName, familyMember);
	 	        
	 	        // Get the type of family member (sons, daughters, parents, etc.)
	 	        String familyMemberType = familyMember.get("type").toString();
	 	        EStructuralFeature familyMemberFeature = newFamily.eClass().getEStructuralFeature(familyMemberType);

	 	        if (familyMemberFeature != null && familyMemberFeature.isMany()) {
	 	            ((List<EObject>) newFamily.eGet(familyMemberFeature)).add(newFamilyMember);
	 	        } else {
	 	            System.err.println("Feature not found or not a multi-valued feature for family member type: " + familyMemberType);
	 	        }
	 	    }

	 	    // Add the new family to the loaded model elements
	 	    EStructuralFeature familiesFeature = modelElements.get(0).eClass().getEStructuralFeature("familys");
	 	    if (familiesFeature != null && familiesFeature.isMany()) {
	 	        ((List<EObject>) modelElements.get(0).eGet(familiesFeature)).add(newFamily);
	 	    } else {
	 	        System.err.println("Feature not found or not a multi-valued feature for families.");
	 	    }

	 	    // Save the modified resource
	 	    for (EObject element : modelElements) {
	 	        Resource resource = element.eResource();
	 	        if (resource != null) {
	 	            resource.save(Collections.EMPTY_MAP);
	 	            System.out.println("Family added successfully.");
	 	        } else {
	 	            System.err.println("Element not associated with a resource: " + element);
	 	        }
	 	    }
	 	}

	 	private EObject createFamilyMemberInstance(String packageName, Map<String, Object> familyMemberAttributes)
	 	        throws ReflectiveOperationException {
	 	    String familyMemberType = familyMemberAttributes.get("type").toString();

	 	    // Use the FamigliaPackage to retrieve the EClass dynamically
	 	    FamigliaPackage famigliaPackage = FamigliaPackage.eINSTANCE;
	 	    EClass familyMemberEClass = (EClass) famigliaPackage.getEClassifier(familyMemberType);

	 	    if (familyMemberEClass == null) {
	 	        System.err.println("EClass not found for family member type: " + familyMemberType);
	 	        return null;
	 	    }

	 	    // Use the FamigliaFactory to create instances dynamically
	 	    FamigliaFactory factory = FamigliaFactory.eINSTANCE;
	 	    EObject newFamilyMember = factory.create(familyMemberEClass);

	 	    // Set attributes for the new family member
	 	    for (Map.Entry<String, Object> entry : familyMemberAttributes.entrySet()) {
	 	        String attributeName = entry.getKey();
	 	        Object attributeValue = entry.getValue();

	 	        // Use reflection to set the attribute value on the created instance
	 	        EStructuralFeature feature = newFamilyMember.eClass().getEStructuralFeature(attributeName);
	 	        if (feature != null) {
	 	            newFamilyMember.eSet(feature, attributeValue);
	 	        } else {
	 	            System.err.println("Attribute not found for family member: " + attributeName);
	 	        }
	 	    }

	 	    return newFamilyMember;
	 	}

	 	*/
	 	
	 	
	 	
	 	//==========CREATE A NEW FAMILY===============
	 	
	 	public List<EObject> addFamily(String packageName, String className, String parentClassName, String xmiFileName, Map<String, Object> requestBody)
	            throws ReflectiveOperationException, IOException {

	        Class<?> target = findClass(packageName, className);

	        if (target == null) {
	            throw new IllegalArgumentException("Class not found: " + packageName + "." + className);
	        }

	        // Load the existing model elements
	        List<EObject> existingElements = reflectionRepository.loadXMIPath(packageName, parentClassName, xmiFileName);

	        // Create a new instance of the specified class with the provided attributes.
	        EObject newInstance = createInstance1(packageName, className, requestBody);

	        // Find the parent element where you want to add the new child
	        EObject parentElement = findParentElement1(existingElements, packageName, parentClassName);

	        // Find the containment reference in the parent element based on the type of the new instance
	        EReference containmentReference = findContainmentReference1(parentElement, newInstance.eClass().getName());

	        // Add the new instance to the containment reference of the parent element
	        if (parentElement != null && containmentReference != null) {
	            if (containmentReference.isMany()) {
	                ((List<EObject>) parentElement.eGet(containmentReference)).add(newInstance);
	            } else {
	                parentElement.eSet(containmentReference, newInstance);
	            }
	        } else {
	            System.err.println("Parent element or containment reference not found.");
	        }

	        // Save the modified model to the XMI file.
	        try {
	            for (EObject element : existingElements) {
	                Resource resource = element.eResource();
	                if (resource != null) {
	                    resource.save(Collections.EMPTY_MAP);
	                    System.out.println("XMI file saved successfully.");
	                } else {
	                    System.err.println("Element not associated with a resource: " + element);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.err.println("Failed to save XMI file.");
	        }

	        return existingElements;
	    }

	    private Class<?> findClass(String packageName, String className) throws ReflectiveOperationException {
	        for (Class<?> clazz : findAllClasses(packageName)) {
	            if (clazz.getName().equals(packageName + "." + className)) {
	                return clazz;
	            }
	        }
	        return null;
	    }

	    private EObject findParentElement1(List<EObject> existingElements, String packageName, String className) throws ClassNotFoundException {
	        for (EObject element : existingElements) {
	            if (Class.forName(packageName + "." + className).isInstance(element)) {
	                return element;
	            }
	        }
	        return null;
	    }

	    private EReference findContainmentReference1(EObject container, String typeName) {
	        for (EReference reference : container.eClass().getEAllContainments()) {
	            if (reference.getEReferenceType().getName().equals(typeName)) {
	                return reference;
	            }
	        }
	        return null;
	    }
		






	
	
}
