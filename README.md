# Reflective-EMF-REST-API
Dynamic EMF-REST API to expose the EMF data repository as REST endpoints for remote access

# SCENARIO-BASED TESTING TO EVALUATE THE APPROACH
Inspired by scenario-based testing we defined a set of scenarios to evaluate our approach in terms of effectiveness.
Each scenario covers several steps, that are used to ensure that every single functionality of a system is working as expected.
## Scenario S1: Load a model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S1 | Loading a complete model| Get a complete model from the repository  | .../Architecturemodeling/Component/all  .../Architecturemodeling/Connector/all| a complete model is retrived from the repository | Retrieved model is diplayed in the web UI.



 
> [!NOTE]
> The depicted illustration presents the outcome observed on the web UI when the entire model is loaded from the repository. This process involves invoking two endpoints: one for loading the components and another for loading the connectors.

<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S1.png" >
<p align="center"> Fig.1. Load a complete model</p>

## Scenario S2: Add a component to the existing model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S2 | Create a component | Add a component to the existing model  | .../Architecturemodeling/ArchitectureModel/ Component/ArchitectureModel/newElement| A new component is added to the existing model ”ArchitecturalModel.xmi” | The newly created component is reflected in the ArchitecturalModel.xmi on the server

> [!NOTE]
> The depicted illustration presents the outcome observed when a new component is created from the web UI. The newly created component highlighted in red is created and the addition of a new component is reflected in the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S2.png" >
<p align="center"> Fig.2. Add a component to the model</p>

## Scenario S3: Create a connector with a defined source and target

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S3 | Create a connector | Create a connector with a defined source and target elements to link components within the model  | .../Architecturemodeling/ArchitectureModel/ Connector/ArchitectureModel/newEopposite? fieldType=Component| A new connector is created via web UI and links components within the model server | A connector is created through the web UI, and the connection between components is observed on both the web UI and the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when a new connector is created with a defined source and target to connect two components from the web UI. The connector takes the name of the ***{SourceComponent}_{TargetComponent}***. The newly created connector highlighted in red is created with the name ***Actuator_AWS IoT Core*** and the changes are reflected in the model on the server. For the sec of visibility, the name of the connector is not shown on the web UI.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S3.png" >
<p align="center"> Fig.3. Create a connector</p>

## Scenario S4: Update the name of the component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S4 | Update a component | Update the name of the component  | .../Architecturemodeling/Component/ ArchitectureModel/update attributeName=name &attributeValue=Actuator& updatedValue=Sensor| Component name is updated from ”Actuator” to ”Sensor”via web UI | The component’s name is modified via web UI and the changes are subsequently reflected in the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when the name of the component is updated from the web UI. A component named ***Actuator*** is updated to ***Sensor*** as highlighted in red and the changes are propagated to the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S4.png" >
<p align="center"> Fig.4. Update the name of the component</p>

## Scenario S5: Delete a connector

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S7 | Delete a component | Delete the connector from the model | .../Architecturemodeling/Connector/ ArchitectureModel/deleteByAttribute? attributeName=name& attributeValue=Actuator_AWS IoT Core| A connector named ”Actuator_AWS IoT Core” is deleted from the model via web UI. | The connector is deleted from the model via web Ui and the deletion is also reflected in the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when the connector is deleted from the web UI. A connector named ***Actuator_AWS IoT Core*** is deleted and the changes are reflected in the model on the server. The vacant area highlighted in red in the illustration signifies the location where the connector has been removed.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S7.png" >
<p align="center"> Fig.5. Delete a connector</p>

## Scenario S6: Delete an isolated component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S5 | Delete an isolated component  | Delete a component from the model that is not connected to others | .../Architecturemodeling/Component/ ArchitectureModel/deleteByAttribute? attributeName=name&attributeValue=Sensor| A component named ”Sensor” is deleted from the model via web UI | The component is deleted from the model using the web UI and this deletion is also reflected in the model server

> [!NOTE]
> The displayed image showcases the result of deleting a component through the web UI. Specifically, the deletion of a component named ***Sensor*** is performed via the web UI, and these modifications are synchronized with the model on the server. The vacant area highlighted in red in the illustration signifies the location where the component has been removed.
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S5.png" >
<p align="center"> Fig.6. Delete an isolated component</p>

## Scenario S7: Delete a component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S6 | Delete a component | Delete the component from the model that is connected via connectors | .../Architecturemodeling/Component/ ArchitectureModel/deleteByAttribute? attributeName=name&attributeValue=Sensor| A component named ”Sensor” is deleted from the model via web UI | The component is deleted from the model using the web UI and this deletion is not reflected in the model since an error is reported in the browser console

> [!NOTE]
> The depicted illustration presents the outcome observed when the name of the component is updated from the web UI. A component named ***Actuator*** is updated to ***Sensor*** and the changes are propagated on the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S4.png" >
<p align="center"> Fig.6. Delete a component</p>

## Scenario S8: Delete a model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S8 | Delete a model | Delete an entire model | .../Architecturemodeling/ArchitectureModel /ArchitectureModel/deleteClassByXMI| An entire model named ”ArchitectureModel” is deleted via Web UI | The complete model has been deleted through the web UI, and the modifications have been reflected back to the model server.

> [!NOTE]
> The depicted illustration presents the outcome observed when the entire model is deleted from the web UI. A model named ***ArchitectureModel*** is deleted as shown in the console and the changes are propagated on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S8.png" >
<p align="center"> Fig.8. Delete a model</p>

