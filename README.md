<!-- 
  Copyright (C) 2020 FVA GmbH
  
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at
  
    http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations under
  the License.
-->
# REXS-API

The REXS API library contains core utility classes for the REXS interface.

ATTENTION: The current status of the REXS API is not yet fully covered by Javadoc and unit tests. For this reason we cannot publish a first version yet. Before using this stand productively, you should therefore test sufficiently.


## Requirements

* Java SDK 1.8
* Maven 3.6.2 ([http://maven.apache.org](http://maven.apache.org))
* (Optional) Lombok ([https://projectlombok.org/](https://projectlombok.org/)) (only if you use an IDE like Eclipse)


## IDE Support

To use these projects in an IDE you will need the [project Lombok](https://projectlombok.org/) agent. Full instructions can be found on the Lombok website. The sign that you need to do this is a lot of compiler errors to do with missing methods and fields.


## Build the package

1. Install Java and create a `JAVA_HOME` environment variable that points to the location of your JDK

	`set PATH=C:\develop\lib\jdk1.8.0_121\bin;%PATH%`
	
	`set JAVA_HOME=C:\develop\lib\jdk1.8.0_121`

2. Install Maven and create Maven environment variables

	`set PATH=C:\develop\lib\apache-maven-3.6.2\bin;%PATH%`
	
	`set M2_HOME=C:\develop\lib\apache-maven-3.6.2`
	
	`set M2=%M2_HOME%\bin`

3. Run `mvn clean package` in the root directory of the application

4. Navigate to `distribution/target` where you find the `rexs-api-1.0.0.jar`


## Next steps

* Complete unit tests
* Complete the Javadoc
* Publish the project to Maven Central Repository
