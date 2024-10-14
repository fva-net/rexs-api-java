# How-to build on your local pc?

## Requirements

* Java 17
* Maven 3.8.5 ([http://maven.apache.org](http://maven.apache.org))
* (Optional) Lombok ([https://projectlombok.org/](https://projectlombok.org/)) (only if you use an IDE like Eclipse)


## IDE Support

To use these projects in an IDE you will need the [project Lombok](https://projectlombok.org/) agent. Full instructions can be found on the Lombok website. The sign that you need to do this is a lot of compiler errors to do with missing methods and fields.


## Build the package

1. Install Java and create a `JAVA_HOME` environment variable that points to the location of your JDK

	`set PATH=C:\develop\lib\jdk-17.0.2\bin;%PATH%`

	`set JAVA_HOME=C:\develop\lib\jdk-17.0.2`

2. Install Maven and create Maven environment variables

	`set PATH=C:\develop\lib\apache-maven-3.8.5\bin;%PATH%`

	`set M2_HOME=C:\develop\lib\apache-maven-3.8.5`

	`set M2=%M2_HOME%\bin`

3. Run `mvn clean package` in the root directory of the application

4. Navigate to `api/target` where you find the `rexs-api-java-0.9.0.jar`


## Run the Command Line Interface

1. Build the package

2. Navigate to `cli/target` where you find the `rexs-api-java-cli-0.9.0.jar`

3. Run `java -jar rexs-api-java-cli-0.9.0.jar --help`
