# REFLECTIVE EMF-REST-API
Dynamic EMF-REST API approach to expose the EMF model as REST endpoints for remote access.

# SCENARIO-BASED TESTING TO EVALUATE THE APPROACH
Inspired by scenario-based testing we defined a set of scenarios to evaluate our approach in terms of effectiveness.
Each scenario covers several steps, that are used to ensure that every single functionality of a system is working as expected. Scenario S1 represents the initial model, while scenarios S2-S8 are mutations of S1.
## Scenario S1: Load a model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S1 | Load a  model| Get a complete model from the repository  | .../Architecturemodeling/Component/all  .../Architecturemodeling/Connector/all| A complete model consisting of both components and connectors is retrieved from the repository | The retrieved model, which includes both components and connectors, is displayed in the web UI
 
> [!NOTE]
> The depicted illustration presents the outcome observed on the web UI when the entire model is loaded from the repository. This process involves invoking two endpoints: one for loading the components and another for loading the connectors.

<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S1.png" >
<p align="center"> Fig.1. Load a complete model from the repository</p>

## Scenario S2: Add a component to the existing model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S2 | Create a component | Add a component to the existing model  | .../Architecturemodeling/ArchitectureModel/ Component/ArchitectureModel/newElement| A new component is added to the existing model ”ArchitecturalModel.xmi” | The newly created component is reflected in the ArchitecturalModel.xmi on the server

> [!NOTE]
> The depicted illustration presents the outcome observed when a new component is created from the web UI. The newly created component, highlighted in red, is successfully created, and the addition of a new component is reflected in the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S2.png" >
<p align="center"> Fig.2. Add a component to the model</p>

## Scenario S3: Create a connector with a defined source and target

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S3 | Create a connector | Create a connector with a defined source and target elements to establish a link between components within the model  | .../Architecturemodeling/ArchitectureModel/ Connector/ArchitectureModel/newEopposite? fieldType=Component| A new connector is created via web UI and links components within the model server | A connector is created through the web UI, and the link between components is observed on both the web UI and the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when a new connector is created with a defined source and target to connect two components from the web UI. The connector takes the name of the ***{SourceComponent}_{TargetComponent}***. The newly created connector highlighted in red is created with the name ***Actuator_AWS IoT Core*** and the changes are reflected in the model on the server. For the sec of visibility, the name of the connector is not shown on the web UI.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S3.png" >
<p align="center"> Fig.3. Create a connector</p>

## Scenario S4: Update the name of the component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S4 | Update a component | Update the name of the component  | .../Architecturemodeling/Component/ ArchitectureModel/update attributeName=name &attributeValue=Actuator& updatedValue=Sensor| Component name is updated from ”Actuator” to ”Sensor” via web UI | The component’s name is modified via web UI and the changes are subsequently reflected in the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when the name of the component is updated from the web UI. A component named ***Actuator*** is updated to ***Sensor*** as highlighted in red and the changes are propagated to the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S4.png" >
<p align="center"> Fig.4. Update the name of the component</p>

## Scenario S5: Delete an isolated component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S5 | Delete an isolated component  | Delete a component from the model that is not connected to others | .../Architecturemodeling/Component/ ArchitectureModel/deleteByAttribute? attributeName=name&attributeValue=Adaptor| A component named ”Adaptor” is deleted from the model via web UI | The component is deleted from the model using the web UI and this deletion is also reflected on the model server

> [!NOTE]
> The displayed image showcases the result of deleting a component that is not connected with other component(s). Specifically, the deletion of a component named ***Adaptor*** is performed via the web UI, and these modifications are synchronized with the model on the server. The vacant area highlighted in red in Fig.6. in the illustration signifies the location where the component has been removed.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/Isolated.png" >
<p align="center"> Fig.5. An isolated component to be deleted (highlighted in red)</p>
<br>
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/Isolated2.png" >
<p align="center"> Fig.6. After the deletion of an isolated component</p>

## Scenario S6: Delete a component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S6 | Delete a component | Delete the component from the model that is connected via connectors | .../Architecturemodeling/Component/ ArchitectureModel/deleteByAttribute? attributeName=name&attributeValue=AWSIoTCore| A component named ”AWS IoT Core” is deleted from web UI | The deletion of the component from the web UI doesn't sync with the model because an error is reported in the web UI, highlighting inconsistencies in the model
> [!NOTE]
> Deleting a component may lead to inconsistencies in the XMI model in the repository if the component is connected to others via connectors. This can result in pending connectors with unset source or target references. For example, in Fig.7, the deletion of a component named ***Sensor*** leaves the connector named ***Sensor_AWS IoT Core*** (highlighted in red in the server) with an unset source, violating model conformance constraints and rendering the model invalid. In Fig.8, the illustrated scenario demonstrates the consequences of attempting to delete another component from the web UI when the model is already invalid. An error message pops up when trying to remove a component named ***AWS IoT Core***. Consequently, the deletion of the ***AWS IoT Core*** component from the server's model does not take place.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/Connected.png" >
<p align="center"> Fig.7. Delete a connected component that leads to inconsistencies</p>
<br>
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S6.png" >
<p align="center"> Fig.8. Delete a component when a model is invalid</p>

## Scenario S7: Delete a connector

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S7 | Delete a connector | Delete the connector from the model | .../Architecturemodeling/Connector/ ArchitectureModel/deleteByAttribute? attributeName=name& attributeValue=Actuator_AWS IoT Core| A connector named ”Actuator_AWS IoT Core” is deleted from the model via web UI. | The connector is deleted from the model via web Ui and the deletion is also reflected in the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when the connector is deleted from the web UI. A connector named ***Actuator_AWS IoT Core*** is deleted and the changes are reflected in the model on the server. The vacant area highlighted in red in the illustration signifies the location where the connector has been removed.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S7.png" >
<p align="center"> Fig.9. Delete a connector</p>

## Scenario S8: Delete a model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S8 | Delete a model | Delete an entire model | .../Architecturemodeling/ArchitectureModel /ArchitectureModel/deleteClassByXMI| An entire model named ”ArchitectureModel” is deleted via Web UI | The complete model has been deleted through the web UI, and the modifications have been reflected back to the model server

> [!NOTE]
> The illustrated figure showcases the result observed when the complete model, named ***ArchitectureModel***, is deleted from the web UI. The deletion is reflected in the console, and the corresponding changes are propagated to the server.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S8.png" >
<p align="center"> Fig.10. Delete an entire model</p>

> [!IMPORTANT]
> This video serves as a brief demonstration, showcasing scenarios used to assess our approach.

[![IMAGE ALT TEXT](https://img.youtube.com/vi/Sp0p2JpNM-Y/0.jpg)](https://www.youtube.com/watch?v=Sp0p2JpNM-Y "SCENARIO-BASED TESTING")
