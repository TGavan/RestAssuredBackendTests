# Pre-requisites for running the tests : 
- These are the integration tests written in Java with help of Rest Assured library
- Tests are written in Java
- Build tool is gradle
- Java must be installed on your system (Version 8 or higher)
- Gradle must be installed on the system
- By default, tests will be running based on the URL defined in profile1(Under src/test/resources)
- Additional profiles can be added as per the need (for QA, Stage or different environments)



# How to run the tests :  
- Clone the repo 
- Under src/test/resources you will see the profile1.properties
- From command prompt run below command 
 ```gradle clean test -Dprofile=profile1```
- once the tests are executed report extent report can be found under build > reports > tests > test > ExtentReportTestNG.html

