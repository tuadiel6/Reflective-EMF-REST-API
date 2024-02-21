# Reflective-EMF-REST-API
Dynamic EMF-REST API to expose the EMF data repository as REST endpoints for remote access

# SCENARIO-BASED TESTING TO EVALUATE THE APPROACH
Inspired by scenario-based testing we defined a set of scenarios to evaluate our approach in terms of effectiveness.
Each scenario covers several steps, that are used to ensure that every single functionality of a system is working as expected.
### Scenario S1: Load a model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S1 | Loading a complete model| Get a complete model from the repository  | .../Architecturemodeling/Component/all and .../Architecturemodeling/Connector/all| a complete model is retrived from the repository | Retrieved model is diplayed in the web UI.



 
> [!NOTE]
> The depicted illustration presents the outcome observed on the web UI when the entire model is loaded from the repository. This process involves invoking two endpoints: one for loading the components and another for loading the connectors.

<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S1.png" >
<p align="center"> Fig.1. Load a complete model</p>

### Scenario S2: Add a component to the existing model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S2 | Create a component | Add a component to the existing model  | .../Architecturemodeling/ArchitectureModel/ Component/ArchitectureModel/newElement| A new component is added to the existing model ”ArchitecturalModel.xmi”. | The newly created component is reflected in the ArchitecturalModel.xmi on the server.

> [!NOTE]
> The depicted illustration presents the outcome observed when a new component is created on the web UI and the newly created component is reflected in the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S2.png" >
<p align="center"> Fig.2. Add a component to the model</p>

### Scenario S3: Create a connector with a defined source and target

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S3 | Create a connector | Create a connector with a defined source and target elements to link components within the model  | .../Architecturemodeling/ArchitectureModel/ Connector/ArchitectureModel/newEopposite? fieldType=Component| A new connector is created via web UI and links components within the model server | A connector is created through the web UI, and the connection between components is observed on both the web UI and the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when a new connector is created with a defined source and target on the web UI. The connector takes the name of the ***{SourceComponent}_{TargetComponent}***. The newly created connector with the name ***Actuator_AWS IoT Core*** and the changes are reflected in the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S3.png" >
<p align="center"> Fig.3. Create a connector</p>

### Scenario S4: Update the name of the component

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S4 | Update a component | Update the name of the component  | .../Architecturemodeling/Component/ ArchitectureModel/update attributeName=name &attributeValue=Actuator& updatedValue=Sensor| Component name is updated from ”Actuator” to ”Sensor”via web UI | The component’s name is modified via web UI and the changes are subsequently reflected in the model server

> [!NOTE]
> The depicted illustration presents the outcome observed when the name of the component is updated from the web UI. A component named ***Actuator*** is updated to ***Sensor*** and the changes are propagated on the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S4.png" >
<p align="center"> Fig.4. Update the name of the component</p>

