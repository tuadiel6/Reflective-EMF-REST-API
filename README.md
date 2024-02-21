# Reflective-EMF-REST-API
Dynamic EMF-REST API to expose the EMF data repository as REST endpoints for remote access

# SCENARIO-BASED TESTING TO EVALUATE THE APPROACH
Inspired by scenario-based testing we defined a set of scenarios to evaluate our approach in terms of effectiveness.
Each scenario covers several steps, that are used to ensure that every single functionality of a system is working as expected.

| Id| Category| Scenario| Endpoint| Expected Results| Observed Results|
| ------------- | ------------- | ------------- | ------------- |------------- |------------- |
| S1  |Loading a complete model| Get a complete model from the repository  | .../Architecturemodeling/Component/all and .../Architecturemodeling/Connector/all| a complete model is retrived from the repository | Retrieved model is diplayed in the web UI.
| Content Cell  | Content Cell  |


### Scenario 1: 
> [!NOTE]
> The depicted illustration presents the outcome observed when the entire model is loaded from the repository. This process involves invoking two endpoints: one for loading the components and another for loading the connectors.

<img src="https://github.com/tuadiel6/Reflective-EMF-REST-API/blob/main/Figures/S1.png" >
<p align="center"> Fig.1. Load a complete model</p>
