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
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/s2.png" >
<p align="center"> Fig.2. Add a component to model</p>

### Scenario S3: Add a component to the existing model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S3 | Create a component | Add a component to the existing model  | .../Architecturemodeling/ArchitectureModel/ Component/ArchitectureModel/newElement| A new component is added to the existing model ”ArchitecturalModel.xmi”. | The newly created component is reflected in the ArchitecturalModel.xmi on the server.

> [!NOTE]
> The depicted illustration presents the outcome observed when a new component is created on the web UI and the newly created component is reflected in the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/s2.png" >
<p align="center"> Fig.2. Add a component to model</p>

### Scenario S4: Add a component to the existing model

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| -------------| ------------- | ------------- | ------------- | ------------- |------------- |
| S4 | Create a component | Add a component to the existing model  | .../Architecturemodeling/ArchitectureModel/ Component/ArchitectureModel/newElement| A new component is added to the existing model ”ArchitecturalModel.xmi”. | The newly created component is reflected in the ArchitecturalModel.xmi on the server.

> [!NOTE]
> The depicted illustration presents the outcome observed when a new component is created on the web UI and the newly created component is reflected in the model on the server. 
<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/s2.png" >
<p align="center"> Fig.2. Add a component to model</p>

