package adia.example.Dynamic.EMFREST.API.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import adia.example.Dynamic.EMFREST.API.service.ReflectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "AN APPROACH TO EXPOSE EMF MODELS FOR REMOTE ACCESS ", description = "An approach that leverages on reflection API to expose EMF models for remote access")
@RestController
public class ReflectionController {
	
private final ReflectionService reflectionService;
	@Autowired
    public ReflectionController(ReflectionService reflectionService) {
        this.reflectionService = reflectionService;
    }
	
	
		// ================Get All the Classes inside a Package ===========
		@Operation(summary = "Get all classes inside a package",
				description = "Get all classes by specifying its Package name")
		@GetMapping("/{packageName}")
		public List<Class<?>> getAllClasses( 
				@Parameter(description = "Insert a package name. e.g.: Example")
	            @PathVariable("packageName") String packageName
	       ) throws ReflectiveOperationException 
		{
			return reflectionService.findAllClasses(packageName);		
			
		}
		
		//==========Get all methods inside a class======
		@Operation(summary = "Get all methods inside a class",
				description = "Get all class methods by speciffying its Package name and Class Name")
		@GetMapping("/{packageName}/{className}/methods")
		public List<Method> getAllMethods(
				@Parameter(description = "Insert a package name. e.g.: Example")
	            @PathVariable("packageName") String packageName,
	            @Parameter(description = "Insert a ClassName name. e.g.: Family")
				@PathVariable("className") String className
	       ) throws ReflectiveOperationException 
		{
			return ReflectionService.findAllMethods(packageName, className);
			
		}
		
		
		// ================GET ALL===========
		@Operation(summary = "Get all model elements",
			      description = "Get all model elements by specifying its Package name, Class name and Method name. The response is a list of model elements within the package.")
		@GetMapping("{packageName}/{className}/all")
		public <T> List<T> fetchPubList(
				@Parameter(description = "Insert a package name. e.g.: Example") 
				@PathVariable String packageName,
				@Parameter(description = "Insert a class name. e.g.: Family")
				@PathVariable String className
				) throws IllegalArgumentException, InvocationTargetException, ReflectiveOperationException, IOException {
			return reflectionService.fetchItemList(packageName,className);
		}
		
		 //================GET EACH ITEM===========
		@Operation(summary = "Get each item from the model",
				description = "Get each item by specifying its Package name, Class name and Method name (i.e, reference name)")
		@GetMapping("{packageName}/{className}/{methodName}")
		public <T> List<T> fetchEachList(@Parameter(description = "Insert a package name. e.g.: Example") 
					@PathVariable String packageName,
					@Parameter(description = "Insert a class name. e.g.: Family")
					@PathVariable String className,
					@Parameter(description = "Insert a method name. e.g.: Son (This will be translated into getSons)")
					@PathVariable String methodName) throws IllegalArgumentException, InvocationTargetException, ReflectiveOperationException, IOException {
			return reflectionService.fetchEachItem(packageName,className,methodName);
		}
		
		
		 //================ADD NEW ITEM===========
		@Operation(summary = "Add a new element to the model",
				description = "Add new element to the model by specifying its Package name, Class name and the Model name")
		@PostMapping("{packageName}/{className}/{modelName}/add")
	    public ResponseEntity<String> addElementToList(
	    		@Parameter(description = "Insert your package name. e.g.: Example")
	            @PathVariable String packageName,
	            @Parameter(description = "Insert a class name. e.g.: Family")
	            @PathVariable String className,
	            @Parameter(description = "Insert a model name. e.g.: FamilyModel")
	            @PathVariable String modelName,
	            @RequestBody Map<String, Object> requestBody)
	            throws ReflectiveOperationException, IOException {
	        reflectionService.addElementToList(packageName, className, modelName, requestBody);
	        return ResponseEntity.ok("Element added successfully");
	    }
		
		
		
		 //================Search Operation===========
		@Operation(summary = "Search an element from a model",
				description = "Search element from a model by specifying its Package name, Class name and Method name")	
		@GetMapping("{packageName}/{className}/{methodName}/search")
		public <T> List<T> fetchItemListWithSearch(
				@Parameter(description = "Insert a package name. e.g.: Example")
		        @PathVariable String packageName,
		        @Parameter(description = "Insert a class name. e.g.: Family")
		        @PathVariable String className,
		        @Parameter(description = "Insert a method name. e.g.: Family")
		        @PathVariable String methodName,
		        @Parameter(description = "Search by attribute name e.g.: Name")
		        @RequestParam(defaultValue = "Name") String attributeName,
		        @Parameter(description = "Search by value. e.g.: Elie")
		        @RequestParam(defaultValue = "Elie") String searchValue)
		        throws IllegalArgumentException, InvocationTargetException, ReflectiveOperationException, IOException {
		    return reflectionService.fetchItemListWithSearch(packageName, className, methodName, attributeName, searchValue);
		}
		
		
		
		
		// ===========Delete Operation ================
		@Operation(summary = "Delete an element from a model based on Attribute name and Value. This will delete everything which has has the same attribute and value but within a specific package name",
					description = "Delete an element from a model based Attribute name and its corresponding value by specifying the Package name, and Class name")
	    @DeleteMapping("{packageName}/{className}/deleteByAttribute")
	    public String deleteElementbyAttribute(
	    		@Parameter(description = "Insert a package name. e.g.: Example")
	    		 @PathVariable("packageName") String packageName,
	    		 @Parameter(description = "Insert a class name. e.g.: Family")
	             @PathVariable("className") String className,
	             @Parameter(description = "Specify the attribute name e.g.: name")
	             @RequestParam("attributeName") String attributeName,
	             @Parameter(description = "Specify the value e.g.: Elie")
	             @RequestParam("attributeValue") String attributeValue) throws IllegalArgumentException, 
													InvocationTargetException, ReflectiveOperationException, IOException
	    {
	    	reflectionService.deleteElementbyAttribute(packageName,className,attributeName,attributeValue);
	        return "Deleted Successfully";
	    }
		
		// ===========Delete Operation by Attribute based on a specific XMI file ================
				@Operation(summary = "Delete a specific element from a model based on Attribute name and Value. This will delete a specific element on a specific XMI file name",
							description = "Delete an element from a model based Attribute name and its corresponding value by specifying the Package name, and Class name. In this example you can delete a complete family or a family member. e.g: Son")
			    @DeleteMapping("{packageName}/{className}/{xmiFileName}/deleteByAttribute")
			    public String deleteElementbyAttributeXMI(
			    		@Parameter(description = "Insert a package name. e.g.: Example")
			    		 @PathVariable("packageName") String packageName,
			    		 @Parameter(description = "Insert a class name. e.g.: Daughter or Family (in case you want to delete a complete Family)")
			             @PathVariable("className") String className,
			             @Parameter(description = "Specify the attribute name e.g.: firstName or Attribute name (e.g: 'name' in case you want to delete an entire family)")
			             @RequestParam("attributeName") String attributeName,
			             @Parameter(description = "Specify the value e.g.: Solange or provide a family name (e.g: Elie in case you want to delete a specific family)")
			             @RequestParam("attributeValue") String attributeValue,
			             @Parameter(description = "Insert an xmi file name. e.g.: Family2")
			             @PathVariable("xmiFileName") String xmiFileName
			    		) throws IllegalArgumentException, 
															InvocationTargetException, ReflectiveOperationException, IOException
			    {
			    	reflectionService.deleteElementbyAttributeXMI(packageName,className,attributeName,attributeValue,xmiFileName);
			        return "Deleted Successfully";
			    }
				
	
		// ===========Delete by class Operation================
				@Operation(summary = "Delete an element from a model based on a class name. This will delete every class of the same name of the same package",
							description = "Delete an element from a model based on class Name by specifying the Package name, and Class name")
			    @DeleteMapping("{packageName}/{className}/deletebyClass")
			    public String deleteElementsByClassName(
			    		@Parameter(description = "Insert a package name. e.g.: Example")
			    		 @PathVariable("packageName") String packageName,
			    		 @Parameter(description = "Insert a class name. e.g.: Son")
			             @PathVariable("className") String className
			    			) throws IllegalArgumentException, 
															InvocationTargetException, ReflectiveOperationException, IOException
			    {
			    	reflectionService.deleteElementsByClassName(packageName,className);
			        return "Deleted Successfully";
			    }
				
				
				// ===========Delete by class with a specific xmi Operation================
				@Operation(summary = "Delete an element from a model based on Class name on specified XMI file name. This will delete a class based on a specific XMI file",
							description = "Delete an element from a model based on Class name for a specific XMI file name by passing the Package name, and Class name and the target XMI file name")
			    @DeleteMapping("{packageName}/{className}/{xmiFileName}/deleteClassByXMI")
			    public String deleteClassNameBasedXMI(
			    		@Parameter(description = "Insert a package name. e.g.: Example")
			    		 @PathVariable("packageName") String packageName,
			    		 @Parameter(description = "Insert a class name. e.g.: Son")
			             @PathVariable("className") String className,
			             @Parameter(description = "Insert an xmi file name. e.g.: Family2")
			             @PathVariable("xmiFileName") String xmiFileName
			    			) throws IllegalArgumentException, 
															InvocationTargetException, ReflectiveOperationException, IOException
			    {
			    	reflectionService.deleteClassNameBasedXMI(packageName,className, xmiFileName);
			        return "Deleted Successfully";
			    }	
				
				// ===========PUT based on attribute name and value with a specific xmi Operation================
				@Operation(summary = "Update an element from a model based on Class name and a specific XMI file name",
						description = "Update an element from a model based on Class name for a specific XMI file name by passing the Package name, and Class name and the target XMI file name")
				@PutMapping("/{packageName}/{className}/{xmiFileName}/update")
				public String updateElement(
						@Parameter(description = "Insert a package name. e.g.: Example")
				        @PathVariable("packageName") String packageName,
				        @Parameter(description = "Insert a class name. e.g.: Son")
				        @PathVariable("className") String className,
				        @Parameter(description = "Insert an attribute name in which to perform an update. e.g.: firstName")
				        @RequestParam("attributeName") String attributeName,
				        @Parameter(description = "Insert the current attribute value to be updated. e.g.: Axl")
				        @RequestParam("attributeValue") String attributeValue,
				        @Parameter(description = "Insert the new attribute value. e.g.: Marco")
				        @RequestParam("updatedValue") String updatedValue,
				        @Parameter(description = "Insert an xmi file name to operate on. e.g.: Family2")
				        @PathVariable("xmiFileName") String xmiFileName)
						
				        throws ReflectiveOperationException, FileNotFoundException {
				    reflectionService.updateElement(packageName, className, xmiFileName, attributeName, attributeValue, updatedValue);
				    return "Updated Successfully";
				}

			
				// ===========POST or ADD AN ELEMENT TO THE EXISTING ELEMENTS ON A specific xmi FILE===
				@Operation(summary = "Add an new element to a model on specific XMI file name through the specification of where to attach the new element.",
						description = "Add a new element to a model on a specific XMI file name by specifying where to add the new element. Here we pass the Package name, Parent class name and the target XMI file name, Child Class name, etc")
				@PostMapping("/{packageName}/{parentClassName}/{xmiFileName}/addExisting")
				public String addElement(
						@Parameter(description = "Insert a package name. e.g.: Example")
				        @PathVariable("packageName") String packageName,
				        @Parameter(description = "Insert a parent class name. e.g.: Family")
				        @PathVariable("parentClassName") String parentClassName,
				        @Parameter(description = "Specify the xmi file name on which to perform operation. e.g.: Family2")
				        @PathVariable("xmiFileName") String xmiFileName,
				        @Parameter(description = "Specify the parent containment name. e.g.: familys")
				        @RequestParam("parentContainmentName") String parentContainmentName,
				        @Parameter(description = "We would like to add a new element where it has the corresponding attribute name. e.g.: name")
				        @RequestParam("attributeNameToMatch") String attributeNameToMatch,
				        @Parameter(description = "We would like to add a new element where it has the corresponding attribute value. e.g.: Esri (remember to surround it with the double quotes)")
				        @RequestParam("attributeValueToMatch") Object attributeValueToMatch,
				        @Parameter(description = "Specify which class to add a new element. e.g: Son")
				        @RequestParam("childClassName") String childClassName,
				        @Parameter(description = "Specify the child containment name. e.g: sons")
				        @RequestParam("childContainmentName") String childContainmentName,
				        @RequestBody Map<String, Object> attributes)
				        throws ReflectiveOperationException, IOException {
				    reflectionService.addElement(packageName, parentClassName, attributes,  parentContainmentName, attributeNameToMatch,  attributeValueToMatch, childClassName,
				    		childContainmentName, xmiFileName);
				    return "Element Added Successfully";
				}
				
				
				//=============================================================================
				/*
				@PostMapping("/addFamily")
				public String addFamily(@RequestBody Map<String, Object> familyRequest) {
				    try {
				        reflectionService.addFamily(
				                familyRequest.get("packageName").toString(),
				                familyRequest.get("xmiFileName").toString(),
				                familyRequest.get("familyName").toString(),
				                (List<Map<String, Object>>) familyRequest.get("familyMembers"),
				                (Map<String, Object>) familyRequest.get("attributes")
				        );
				        return "Family added successfully.";
				    } catch (ReflectiveOperationException | IOException e) {
				        e.printStackTrace();
				        return "Error adding family.";
				    }
				}
				*/
				
		
				 //================ADD OR CREATE A NEW INSTANCE===========
				@Operation(summary = "Add a new instance to the model",
						description = "Add new element to the model by specifying its Package name, Class name and the Parent class name and specify the xmi file where to attach the newly created instance")
				@PostMapping("/{packageName}/{parentClassName}/{className}/{xmiFileName}/addNew")
			    public ResponseEntity<String> addFamily(
			    		@Parameter(description = "Insert your package name. e.g.: Example")
			            @PathVariable String packageName,
			            @Parameter(description = "Insert a class name . e.g.: Family")
			            @PathVariable String className,
			            @Parameter(description = "Specify the xmi file name on which to perform operation. e.g.: Family2")
				        @PathVariable("xmiFileName") String xmiFileName,
			            @Parameter(description = "Insert the parent class name. e.g.: FamilyModel")
			            @PathVariable String parentClassName,
			            @RequestBody Map<String, Object> requestBody)
			            throws ReflectiveOperationException, IOException {
			        reflectionService.addFamily(packageName, className, parentClassName, xmiFileName, requestBody);
			        return ResponseEntity.ok("Element added successfully");
			    }

				

}
