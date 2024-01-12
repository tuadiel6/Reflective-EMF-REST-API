package adia.example.Dynamic.EMFREST.API.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.springframework.stereotype.Repository;

import Example.Family;
import Example.Son;

import org.eclipse.emf.common.util.EList;


@Repository
public class ReflectionRepository {
String modelDirectory = "/Users/adielt./Documents/Dynamic-EMF-REST-API/src/main/resources/model";
	// A map of available models within the specified directory.
	public Map<String, List<String>> loadAvailableModels() 
			throws FileNotFoundException {
		
		//Creates a HashMap to store the mapping of package names to their corresponding file paths.
		Map<String, List<String>> modelPaths = new HashMap<>();
		//object representing the directory specified by the variable modelDirectory.
        File directory = new File(modelDirectory);
        
        //Store the package name extracted from the model files.
        //String packageName="";
        	
        //Checks if the specified directory exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".xmi"));
            if (files != null) {
                for (File file : files) {
                    
                	//Read the contents of the current file
                	Scanner sc = new Scanner(file);
                	//To check if the model file contains the required information.
                    boolean flag = false;
                    String packageName = "";
                    /*
                     * Reads each line of the file and extracts the package name. 
                     * If a line contains a colon (':'), it assumes that the package name is present
                     */
                    while(sc.hasNextLine()) {
                    	packageName = sc.nextLine();
                    	  int index = packageName.indexOf(":");
                    	  if(index!=-1){
                    	  packageName=packageName.substring(1,index);
                    	  flag=true;
                  			break;
                    	  }	
                    }
                    //If the required information was not found in the file, an exception is thrown.
                    if(flag!=true) {
                    	throw new IllegalArgumentException("Model not found:");
                    }
                    /*
                     * Gets the absolute path of the file and adds an entry to the 
                     * modelPaths map with the package name (converted to lowercase) as the 
                     * key and the file path as the value.
                     */
                    String modelPath = file.getAbsolutePath();
                    modelPaths.computeIfAbsent(packageName.toLowerCase(), k -> new ArrayList<>()).add(modelPath);
                }
            }
        }
        /*
         * Returns the map containing the package names
         * and their corresponding file paths.
         */
        return modelPaths;
    }
	
	//======================Loading XMI================================
	/*
	 * This code defines a method named loadXMI 
	 * that loads an XMI model based on the provided package name. 
	 * The code assumes that XMI files representing models are available in a directory
	 */
	public List<EObject> loadXMI(String packageName, String className) 
			throws ReflectiveOperationException, FileNotFoundException {
	    // Method to obtain a map of available models where keys are package names, and values are lists of file paths.
	    Map<String, List<String>> availableModels = loadAvailableModels();

	    // Prints the available models and their corresponding file paths
	    System.out.println("Available Models:");
	    for (Entry<String, List<String>> entry : availableModels.entrySet()) {
	        System.out.println(entry.getKey() + ": " + entry.getValue());
	    }

	    // Looks up the list of file paths for the specified package name.
	    List<String> modelPaths = availableModels.get(packageName.toLowerCase());
	    System.out.println("-----------------Selected model------------------");
	    System.out.println(packageName + ": " + modelPaths);
	    if (modelPaths == null || modelPaths.isEmpty()) {
	        throw new IllegalArgumentException("Model not found: " + packageName);
	    }

	    List<EObject> allModelElements = new ArrayList<>();

	    for (String modelPath : modelPaths) {
	        /*
	         * Dynamically loads the Java class representing the model package.
	         * It assumes that the package class follows the convention of having a static field named "eINSTANCE."
	         * This field is then retrieved using reflection API.
	         */
	    	Class<?> modelPackageClass = Class.forName(packageName + "." + packageName + "Package");
	    	Object modelPackage = modelPackageClass.getField("eINSTANCE").get(modelPackageClass);
	        // Register the XMI resource factory for the .xmi extension
	        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put("xmi", new XMIResourceFactoryImpl());

	        // Creates a new resource set to manage resources.
	        ResourceSet resSet = new ResourceSetImpl();

	        /*
	         * Retrieves the resource from the resource set based on the URI created from the model path.
	         * The true argument indicates that the resource should be created if it does not exist.
	         */
	        Resource resource = resSet.getResource(URI.createURI(modelPath), true);

	        /*
	         * Retrieves all model elements from the resource's contents and adds them to the list.
	         */
	        
	        /*
	         * Using EcoreUtil.getAllContents ensures that you traverse all elements in the model, 
	         * and you can filter out elements based on the expected class name.
	         */
	        
	        Iterator<EObject> allContents = EcoreUtil.getAllContents(resource, true);
	        while (allContents.hasNext()) {
	            EObject element = allContents.next();
	            System.out.println("Element Class Name: " + element.eClass().getName());
	            System.out.println("Expected Class Name: " + className);

	            if (element.eClass().getName().equals(className)) {
	                allModelElements.add(element);
	            }
	        }
	        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
	         
	        //allModelElements.add(resource.getContents().get(0));
	        
	        System.out.println("Model Elements:"+allModelElements);
	        
	    }
		return allModelElements;

    }
	
	
	//============addLoadXMI+++++++++++++++++
	public List<EObject> addLoadXMI(String packageName, String className,String methodName, EObject obj) 
	throws ReflectiveOperationException, FileNotFoundException {
	    // Method to obtain a map of available models where keys are package names, and values are lists of file paths.
	    Map<String, List<String>> availableModels = loadAvailableModels();

	    // Prints the available models and their corresponding file paths
	    System.out.println("Available Models:");
	    for (Entry<String, List<String>> entry : availableModels.entrySet()) {
	        System.out.println(entry.getKey() + ": " + entry.getValue());
	    }

	    // Looks up the list of file paths for the specified package name.
	    List<String> modelPaths = availableModels.get(packageName.toLowerCase());
	    System.out.println("-----------------Selected model------------------");
	    System.out.println(packageName + ": " + modelPaths);
	    if (modelPaths == null || modelPaths.isEmpty()) {
	        throw new IllegalArgumentException("Model not found: " + packageName);
	    }

	    List<EObject> allModelElements = new ArrayList<>();

	    for (String modelPath : modelPaths) {
	        
	    	Class<?> modelPackageClass = Class.forName(packageName + "." + packageName + "Package");
	    	Object modelPackage = modelPackageClass.getField("eINSTANCE").get(modelPackageClass);
	        // Register the XMI resource factory for the .xmi extension
	        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put("xmi", new XMIResourceFactoryImpl());

	        // Creates a new resource set to manage resources.
	        ResourceSet resSet = new ResourceSetImpl();

	        
	         //Retrieves the resource from the resource set based on the URI created from the model path.
	         //The true argument indicates that the resource should be created if it does not exist.
	         
	        Resource resource = resSet.getResource(URI.createURI(modelPath), true);
	        
	        resSet.getResources().get(0).getContents().add(obj);
	        
	        Iterator<EObject> allContents = EcoreUtil.getAllContents(resource, true);
	        while (allContents.hasNext()) {
	            EObject element = allContents.next();
	            System.out.println("Element Class Name: " + element.eClass().getName());
	            System.out.println("Expected Class Name: " + className);

	            if (element.eClass().getName().equals(className)) {
	                allModelElements.add(element);
	            }
	        }
	        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
	                 
	        
	        System.out.println("Test>"+allModelElements);
	        
	    }
		return allModelElements;

    }
	
	
	//===================LoadXMI Method for creating a model instance===================
	/*
	 * Method for dynamically loading XMI models, finding or creating a specified model instance, 
	 * and adding a new object to a containment reference within that model.
	 * packageName: The name of EMF package, className: The name of the class for which an instance should be created.
	 * modelName: name of the model and obj: The object to be added to the model.
	 */
	//
	public List<EObject> addLoadXMI2(String packageName, String className, String modelName, EObject obj)
	        throws ReflectiveOperationException, FileNotFoundException {

	    // Method to obtain a map of available models where keys are package names, and values are lists of file paths.
	    Map<String, List<String>> availableModels = loadAvailableModels();

	    // Prints the available models and their corresponding file paths
	    System.out.println("Available Models:");
	    for (Entry<String, List<String>> entry : availableModels.entrySet()) {
	        System.out.println(entry.getKey() + ": " + entry.getValue());
	    }

	    // Looks up the list of file paths for the specified package name.
	    List<String> modelPaths = availableModels.get(packageName.toLowerCase());
	    System.out.println("-----------------Selected model------------------");
	    System.out.println(packageName + ": " + modelPaths);
	    if (modelPaths == null || modelPaths.isEmpty()) {
	        throw new IllegalArgumentException("Model not found: " + packageName);
	    }

	    List<EObject> allModelElements = new ArrayList<>();

	    for (String modelPath : modelPaths) {
	        // Obtain the EPackage instance directly
	        EPackage ePackage = loadEPackage(packageName);
	        if (ePackage == null) {
	            throw new IllegalArgumentException("EPackage not found: " + packageName);
	        }

	        // Register the XMI resource factory for the .xmi extension
	        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put("xmi", new XMIResourceFactoryImpl());

	        // Creates a new resource set to manage resources.
	        ResourceSet resSet = new ResourceSetImpl();

	        // Retrieves the resource from the resource set based on the URI created from the model path.
	        // The true argument indicates that the resource should be created if it does not exist.
	        Resource resource = resSet.getResource(URI.createURI(modelPath), true);

	        // Find or create the specified model instance
	        //myModel = productModel
	        EObject myModel = findOrCreateNewModel(resSet, ePackage, modelName);
	        // Add the obj to the ProductModel containment reference
	        
	        /*
	         * Adds the provided object (obj) to the containment reference within the model instance. 
	         * The containment reference name is derived from the class name (className) in lowercase, with an "s" appended.
	         */
	        
	        //String feature = "families";
	        String feature = className.toLowerCase()+"s";
	        
	        //if (myModel != null && obj instanceof Product) 
	        if (myModel != null && Class.forName(packageName+"."+className).isInstance(obj)){
	            EFactory factory = ePackage.getEFactoryInstance(); 
	            
	            //EClass productModelEClass = (EClass) ePackage.getEClassifier("ProductModel");
	            EClass myModelEClass = (EClass) ePackage.getEClassifier(modelName);
	          
	            //productsReference == classesReference
	            EReference classesReference = (EReference) myModelEClass.getEStructuralFeature(feature);
	            if (classesReference != null && classesReference.isMany()) {
	                ((EList<EObject>) myModel.eGet(classesReference)).add(obj);
	            } else {
	                System.err.println("Containment reference not found or not a multi-valued reference.");
	            }
	        }
	        
	        /*
	         * Iterates over all contents of the resource and adds elements with a matching class name 
	         * to the allModelElements list.
	         */
	        
	        Iterator<EObject> allContents = EcoreUtil.getAllContents(resource, true);
	        while (allContents.hasNext()) {
	            EObject element = allContents.next();
	            System.out.println("Element Class Name: " + element.eClass().getName());
	            System.out.println("Expected Class Name: " + className);

	            if (element.eClass().getName().equals(className)) {
	                allModelElements.add(element);
	            }
	        }
	        System.out.println("+++++++++++++++++++++++++++++++++++++++++");

	        System.out.println("Model Instances:" + allModelElements);
	    }

	    return allModelElements;
	}
	
	/* Find or create a Model in the resource set.
	 * Iterates through the resources and contents in the given resource set.
	 * Checks if the object's class name or instance class name matches the specified model name.
	 */
	private EObject findOrCreateNewModel(ResourceSet resSet, EPackage ePackage, String modelName) {
	    for (Resource res : resSet.getResources()) {
	        for (EObject obj : res.getContents()) {
	            if (obj.eClass().getName().equals(modelName) || obj.eClass().getInstanceClassName().equals(modelName)) {
	                System.out.println("my obj:"+obj);
	            	return obj;
	            }
	        }
	    }
		return null;
	}
	    
	// Dynamically loads the EPackage instance for the specified package name using reflection.
	private EPackage loadEPackage(String packageName) {
	    try {
	        Class<?> packageClass = Class.forName(packageName + "." + packageName + "Package");
	        Field eInstanceField = packageClass.getField("eINSTANCE");
	        return (EPackage) eInstanceField.get(null);
	    } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
	        e.printStackTrace();
	    }
	    return null;
	    

	}
	
		
	
	//======================Loading XMI based on a specific XMI File===================
	public List<EObject> loadXMIPath(String packageName, String className, String xmiFileName) 
			throws ReflectiveOperationException, FileNotFoundException {
	    // Method to obtain a map of available models where keys are package names, and values are lists of file paths.
	    Map<String, List<String>> availableModels = loadAvailableModels();

	    // Prints the available models and their corresponding file paths
	    System.out.println("Available Models:");
	    for (Entry<String, List<String>> entry : availableModels.entrySet()) {
	        System.out.println(entry.getKey() + ": " + entry.getValue());
	    }

	    // Looks up the list of file paths for the specified package name.
	    List<String> modelPaths = availableModels.get(packageName.toLowerCase());
	    System.out.println("-----------------Selected model------------------");
	    System.out.println(packageName + ": " + modelPaths);
	    if (modelPaths == null || modelPaths.isEmpty()) {
	        throw new IllegalArgumentException("Model not found: " + packageName);
	    }

	    List<EObject> allModelElements = new ArrayList<>();

	    for (String modelPath : modelPaths) {
	        /*
	         * Dynamically loads the Java class representing the model package.
	         * It assumes that the package class follows the convention of having a static field named "eINSTANCE."
	         * This field is then retrieved using reflection API.
	         */
	    	// Check if the current model path matches the specified XMI file name
	    	if (modelPath.contains(xmiFileName + ".xmi")) {
	    		System.out.println("CURRENT MODEL PATH:" +modelPath);
		    	Class<?> modelPackageClass = Class.forName(packageName + "." + packageName + "Package");
		    	Object modelPackage = modelPackageClass.getField("eINSTANCE").get(modelPackageClass);
		        // Register the XMI resource factory for the .xmi extension
		        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		        Map<String, Object> m = reg.getExtensionToFactoryMap();
		        m.put("xmi", new XMIResourceFactoryImpl());
	
		        // Creates a new resource set to manage resources.
		        ResourceSet resSet = new ResourceSetImpl();
	
		        /*
		         * Retrieves the resource from the resource set based on the URI created from the model path.
		         * The true argument indicates that the resource should be created if it does not exist.
		         */
		        Resource resource = resSet.getResource(URI.createURI(modelPath), true);
	
		        /*
		         * Retrieves all model elements from the resource's contents and adds them to the list.
		         */
		        
		        /*
		         * Using EcoreUtil.getAllContents ensures that you traverse all elements in the model, 
		         * and you can filter out elements based on the expected class name.
		         */
		        
		        Iterator<EObject> allContents = EcoreUtil.getAllContents(resource, true);
		        while (allContents.hasNext()) {
		            EObject element = allContents.next();
		            System.out.println("Element Class Name: " + element.eClass().getName());
		            System.out.println("Expected Class Name: " + className);
	
		            if (element.eClass().getName().equals(className)) {
		                allModelElements.add(element);
		            }
		        }
		        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		         
		        //allModelElements.add(resource.getContents().get(0));
		        
		        System.out.println("Model Elements:"+allModelElements);
	        
	    }
	    	
	    }
		return allModelElements;

    }
	

	
}
