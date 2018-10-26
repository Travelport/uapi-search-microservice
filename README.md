Travelport uAPI Air Search Reference Implementation Java
===============
### Overview:
The reference implementation was completed in Java using the Spring Boot to consume Travelport Universal API. The workflow this implementation is showcasing is the air search. Minimum fields to complete this workflow have been done using best practices in Java, TDD, and restful web services. The implementation is meant as a starting point for anyone to consume uAPI and additional modifiers can be added for additional business cases. 


## Software requirements:
1. Integrated development environment (IDE) - Eclipse Oxygen [www.eclipse.org/oxygen/](https://eclipse.org/oxygen/)
2. Dependency management - Apache Maven 3.5.2 [www.maven.apache.org/download/cgi](https://maven.apache.org/download.cgi)
3. Servlet framework - Springboot version 1.5.9 [www.spring.io](https://spring.io/)
4. Connection library - Apache CXF 3.2.1 [www.cxf.apache.org](http://cxf.apache.org/)
5. Postman - [www.getpostman.com](https://www.getpostman.com/)

### Credentials
1. Application.yml are the credentials that will need to be populated before sending a request
2. Directory location of application.yml: uAPISearch_Java\src\main\resources\application.yml
3. The four fields to populate are: username, password, branch, and endpoint
4. It is best practice to set these fields via environment variables

## Run project

### Travelport API type: uAPI [(Universal API)](https://support.travelport.com/webhelp/uapi/uAPI.htm)
* Version: 18.5
* Schema: v_45_0
* Workflow: [Air Search](https://support.travelport.com/webhelp/uapi/uAPI.htm#Air/Low_Fare_Shopping/Low_Fare_Shopping_(Synchronous).htm)
* WSDL used for Air Search include: air_v45_0, common_v_45_0, and universal_v45_0

### Eclipse

1. Clone the project
2. Open Eclipse and import the project into the workspace
3. Open terminal on Eclipse: Go to Window/Show View/Terminal
4. CD (change directory) to the root folder of the project where the pom.xml lives
5. Run command "mvn install"
6. Run application.java as a "Java Application"  

#### Testing
1. All tests are located inside src/test
2. Run ...test.java by running as a "Junit Test"

### Postman  
1. Run the Project as a Java Application
2. Open postman and make a post request
3. URL set to: http://localhost:8090/catalogofferings 
4. Set headers for the request with:
 	* Key set to: Content-Type
 	* Value set to: application/json 
5. In the "body" tab make a JSON request with the objects found in the models.
6. You can view the request schema at http://localhost:8090/swagger-ui.html
7. Example of a body for the request:

		{
			"CatalogOfferingsRequestAir" : {
			"offersPerPage" : 5,
			"PassengerCriteria" : [
			{
				"value" : "ADT",
				"number" : 1
			}
			],
			"SearchCriteriaFlight" : [
			{
			"@type" : "SearchCriteriaFlight",
				"departureDate" : "2018-09-22",
				"From" : 
				{
					"value" : "DEN"
				},
				"To" : 
				{
					"value" : "LAX"
				}
			}
			],
			"SearchModifiersAir":
			{
				"@type" : "SearchModifiersAir",
					"CarrierPreference" : 
					{
					"@type" : "CarrierPreference",
						"type" : "Prohibited",
						"carriers" : ["WN"]
					}
				},
				"PseudoCityInfo" : 
				{
					"value" : "PCC"
				}
			}
		}
8. Click "Send"