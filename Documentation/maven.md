## An easy way to look at the default configurations of the super POM is by running the following command: mvn help:effective-pom.

> mvn help:effective-pom

##The order of execution depends on the order in which the goal(s) and the build
phase(s) are invoked. For example, consider the command below. The clean and package arguments are build phases while thedependency:copy- dependencies is a goal.

> mvn clean dependency:copy-dependencies package

## 

> mvn post-clean


> mvn compile

> maven-antrun-plugin:run

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.abdullah</groupId>
	<artifactId>nazmul</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>nazmul</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-antrun-plugin</artifactId>
				<version>1.1</version>
				<executions>
					<execution>
						<id>id.pre-site</id>
						<phase>pre-site</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo>pre-site phase</echo>
							</tasks>
						</configuration>
					</execution>
					<execution>
						<id>id.site</id>
						<phase>site</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo>site phase</echo>
							</tasks>
						</configuration>
					</execution>
					<execution>
						<id>id.post-site</id>
						<phase>post-site</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo>post-site phase</echo>
							</tasks>
						</configuration>
					</execution>
					<execution>
						<id>id.site-deploy</id>
						<phase>site-deploy</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo>site-deploy phase</echo>
							</tasks>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>

```

#### Result

	➜  nazmul git:(master) ✗ mvn site
	[INFO] Scanning for projects...
	[INFO]
	[INFO] ------------------------< com.abdullah:nazmul >-------------------------
	[INFO] Building nazmul 0.0.1-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO]
	[INFO] --- maven-antrun-plugin:1.1:run (id.pre-site) @ nazmul ---
	[INFO] Executing tasks
	     [echo] pre-site phase
	[INFO] Executed tasks
	[INFO]
	[INFO] --- maven-site-plugin:3.3:site (default-site) @ nazmul ---
	[WARNING] Report plugin org.apache.maven.plugins:maven-project-info-reports-plugin has an empty version.
	[WARNING]
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING]
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[INFO] configuring report plugin org.apache.maven.plugins:maven-project-info-reports-plugin:2.9
	[INFO] Relativizing decoration links with respect to project URL: http://maven.apache.org
	[INFO] Rendering site with org.apache.maven.skins:maven-default-skin:jar:1.0 skin.
	[INFO] Generating "Dependencies" report    --- maven-project-info-reports-plugin:2.9
	[WARNING] The repository url 'https://repo.maven.apache.org/maven2' is invalid - Repository 'central' will be blacklisted.
	[INFO] Generating "Dependency Convergence" report    --- maven-project-info-reports-plugin:2.9
	[INFO] Generating "Dependency Information" report    --- maven-project-info-reports-plugin:2.9
	[INFO] Generating "About" report    --- maven-project-info-reports-plugin:2.9
	[INFO] Generating "Plugin Management" report    --- maven-project-info-reports-plugin:2.9
	[INFO] Generating "Plugins" report    --- maven-project-info-reports-plugin:2.9
	[INFO] Generating "Summary" report    --- maven-project-info-reports-plugin:2.9
	[INFO]
	[INFO] --- maven-antrun-plugin:1.1:run (id.site) @ nazmul ---
	[INFO] Executing tasks
	     [echo] site phase
	[INFO] Executed tasks
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 21.653 s
	[INFO] Finished at: 2018-04-05T08:05:22+06:00
	[INFO] ------------------------------------------------------------------------
	➜  nazmul git:(master) ✗



# BUILDPROFILES


### Profile Activation

### Profile Activation Examples
### Profile Activation via Environment Variables page 38

> mvn test


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.abdullah</groupId>
	<artifactId>nazmul</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>nazmul</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<profiles>
		<profile>
			<id>test</id>
			<activation>
				<property>
					<name>env</name>
					<value>test</value>
				</property>
			</activation>
		</profile>
	</profiles>


</project>

```

#### Result

	➜  nazmul git:(master) ✗ mvn test 
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] ------------------------< com.abdullah:nazmul >-------------------------
	[INFO] Building nazmul 0.0.1-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ nazmul ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /Users/abdullah/Documents/ServletAndJsp/nazmul/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ nazmul ---
	[INFO] Changes detected - recompiling the module!
	[INFO] Compiling 1 source file to /Users/abdullah/Documents/ServletAndJsp/nazmul/target/classes
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ nazmul ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /Users/abdullah/Documents/ServletAndJsp/nazmul/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ nazmul ---
	[INFO] Changes detected - recompiling the module!
	[INFO] Compiling 1 source file to /Users/abdullah/Documents/ServletAndJsp/nazmul/target/test-classes
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ nazmul ---
	[INFO] Surefire report directory: /Users/abdullah/Documents/ServletAndJsp/nazmul/target/surefire-reports

	-------------------------------------------------------
	 T E S T S
	-------------------------------------------------------
	Running com.abdullah.nazmul.AppTest
	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 sec

	Results :

	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 4.109 s
	[INFO] Finished at: 2018-04-06T17:43:04+06:00
	[INFO] ------------------------------------------------------------------------
	➜  nazmul git:(master)


> maven-antrun-plugin



```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.abdullah</groupId>
	<artifactId>nazmul</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>nazmul</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<profiles>
		<profile>
			<id>test</id>
			<activation>
				<property>
					<name>env</name>
					<value>test</value>
				</property>
			</activation>
		</profile>
	</profiles>




	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-antrun-plugin</artifactId>
				<version>1.1</version>
				<executions>



					<execution>
						<id>id.clean</id>
						<phase>clean</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo>clean phase</echo>
							</tasks>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>
```

#### reslut

	➜  nazmul git:(master) ✗ mvn clean
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] ------------------------< com.abdullah:nazmul >-------------------------
	[INFO] Building nazmul 0.0.1-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ nazmul ---
	[INFO] Deleting /Users/abdullah/Documents/ServletAndJsp/nazmul/target
	[INFO] 
	[INFO] --- maven-antrun-plugin:1.1:run (id.clean) @ nazmul ---
	[INFO] Executing tasks
	     [echo] clean phase
	[INFO] Executed tasks
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 2.039 s
	[INFO] Finished at: 2018-04-06T17:54:49+06:00
	[INFO] ------------------------------------------------------------------------
	➜  nazmul git:(master) ✗ 


>  mvn clean

	➜  nazmul git:(master) ✗ mvn clean
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] ------------------------< com.abdullah:nazmul >-------------------------
	[INFO] Building nazmul 0.0.1-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ nazmul ---
	[INFO] Deleting /Users/abdullah/Documents/ServletAndJsp/nazmul/target
	[INFO] 
	[INFO] --- maven-antrun-plugin:1.1:run (id.clean) @ nazmul ---
	[INFO] Executing tasks
	     [echo] clean phase
	[INFO] Executed tasks
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 2.039 s
	[INFO] Finished at: 2018-04-06T17:54:49+06:00
	[INFO] ------------------------------------------------------------------------
	➜  nazmul git:(master)


> mvn clean package


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.abdullah</groupId>
	<artifactId>nazmul</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>nazmul</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<profiles>
		<profile>
			<id>test</id>
			<activation>
				<property>
					<name>env</name>
					<value>test</value>
				</property>
			</activation>
		</profile>
	</profiles>




	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-antrun-plugin</artifactId>
				<version>1.1</version>
				<executions>



					<execution>
						<id>id.clean</id>
						<phase>clean</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo>clean phase</echo>
							</tasks>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>
```


#### Result

	➜  nazmul git:(master) ✗ mvn clean package
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] ------------------------< com.abdullah:nazmul >-------------------------
	[INFO] Building nazmul 0.0.1-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ nazmul ---
	[INFO] Deleting /Users/abdullah/Documents/ServletAndJsp/nazmul/target
	[INFO] 
	[INFO] --- maven-antrun-plugin:1.1:run (id.clean) @ nazmul ---
	[INFO] Executing tasks
	     [echo] clean phase
	[INFO] Executed tasks
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ nazmul ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /Users/abdullah/Documents/ServletAndJsp/nazmul/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ nazmul ---
	[INFO] Changes detected - recompiling the module!
	[INFO] Compiling 1 source file to /Users/abdullah/Documents/ServletAndJsp/nazmul/target/classes
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ nazmul ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /Users/abdullah/Documents/ServletAndJsp/nazmul/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ nazmul ---
	[INFO] Changes detected - recompiling the module!
	[INFO] Compiling 1 source file to /Users/abdullah/Documents/ServletAndJsp/nazmul/target/test-classes
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ nazmul ---
	[INFO] Surefire report directory: /Users/abdullah/Documents/ServletAndJsp/nazmul/target/surefire-reports

	-------------------------------------------------------
	 T E S T S
	-------------------------------------------------------
	Running com.abdullah.nazmul.AppTest
	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.01 sec

	Results :

	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ nazmul ---
	[INFO] Building jar: /Users/abdullah/Documents/ServletAndJsp/nazmul/target/nazmul-0.0.1-SNAPSHOT.jar
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 3.782 s
	[INFO] Finished at: 2018-04-06T18:05:16+06:00
	[INFO] ------------------------------------------------------------------------
	➜  nazmul git:(master)


## Now go to /Users/abdullah/Documents/ServletAndJsp/nazmul/target/classes

> java com.abdullah.nazmul.App

	➜  classes git:(master) ✗ java com.abdullah.nazmul.App
	Hello World!




# Create new fresh maven project using command page 48

> mvn archetype:generate -DgroupId=com.companyname.bank -DartifactId=consumerBanking -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

#### Result

	➜  ServletAndJsp git:(master) ✗ mvn archetype:generate -DgroupId=com.companyname.bank -DartifactId=consumerBanking -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
	[INFO] Building Maven Stub Project (No POM) 1
	[INFO] --------------------------------[ pom ]---------------------------------
	[INFO] 
	[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
	[INFO] 
	[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
	[INFO] 
	[INFO] 
	[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
	[INFO] Generating project in Batch mode
	Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.pom
	Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.pom (703 B at 1.1 kB/s)
	Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-bundles/2/maven-archetype-bundles-2.pom
	Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-bundles/2/maven-archetype-bundles-2.pom (1.5 kB at 2.4 kB/s)
	Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/maven-archetype-parent/1/maven-archetype-parent-1.pom
	Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/maven-archetype-parent/1/maven-archetype-parent-1.pom (1.3 kB at 2.1 kB/s)
	Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/4/maven-parent-4.pom
	Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/4/maven-parent-4.pom (10.0 kB at 9.8 kB/s)
	Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.jar
	Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.jar (4.3 kB at 2.7 kB/s)
	[INFO] ----------------------------------------------------------------------------
	[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0
	[INFO] ----------------------------------------------------------------------------
	[INFO] Parameter: basedir, Value: /Users/abdullah/Documents/ServletAndJsp
	[INFO] Parameter: package, Value: com.companyname.bank
	[INFO] Parameter: groupId, Value: com.companyname.bank
	[INFO] Parameter: artifactId, Value: consumerBanking
	[INFO] Parameter: packageName, Value: com.companyname.bank
	[INFO] Parameter: version, Value: 1.0-SNAPSHOT
	[INFO] project created from Old (1.x) Archetype in dir: /Users/abdullah/Documents/ServletAndJsp/consumerBanking
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 01:37 min
	[INFO] Finished at: 2018-04-06T18:41:32+06:00
	[INFO] ------------------------------------------------------------------------
	➜  ServletAndJsp git:(master) ✗ 


> mvn clean package

#### then maven will start building project

	➜  consumerBanking git:(master) ✗ mvn clean package
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] ----------------< com.companyname.bank:consumerBanking >----------------
	[INFO] Building consumerBanking 1.0-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ consumerBanking ---
	[INFO] Deleting /Users/abdullah/Documents/ServletAndJsp/consumerBanking/target
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ consumerBanking ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /Users/abdullah/Documents/ServletAndJsp/consumerBanking/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ consumerBanking ---
	[INFO] Changes detected - recompiling the module!
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 1 source file to /Users/abdullah/Documents/ServletAndJsp/consumerBanking/target/classes
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ consumerBanking ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /Users/abdullah/Documents/ServletAndJsp/consumerBanking/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ consumerBanking ---
	[INFO] Changes detected - recompiling the module!
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 1 source file to /Users/abdullah/Documents/ServletAndJsp/consumerBanking/target/test-classes
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ consumerBanking ---
	[INFO] Surefire report directory: /Users/abdullah/Documents/ServletAndJsp/consumerBanking/target/surefire-reports

	-------------------------------------------------------
	 T E S T S
	-------------------------------------------------------
	Running com.companyname.bank.AppTest
	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 sec

	Results :

	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ consumerBanking ---
	[INFO] Building jar: /Users/abdullah/Documents/ServletAndJsp/consumerBanking/target/consumerBanking-1.0-SNAPSHOT.jar
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 4.226 s
	[INFO] Finished at: 2018-04-06T18:53:45+06:00
	[INFO] ------------------------------------------------------------------------
	➜  consumerBanking git:(master) ✗ 

#### then go consumerBanking/target/classes

and exicute command

> java com.companyname.bank.App

	➜  classes git:(master) ✗ java com.companyname.bank.App
	Hello World!
	➜  classes git:(master) ✗








# Apache Maven 3 Cookbook

> mvn -version

create maven project

> mvn archetype:generate

#### Then you will see a rather large list of archetypes. Here we have considered that it is archetype number 1198 named maven-archetype-quickstart.

	Enter version:
	Enter groupId:
	Enter artifactId:
	Enter 1.0-SNAPSHOT:
	Enter package:
	done done

# Pom has 4 major section(page 20)

1. The basic
2. Build Settings
3. Project metadata
4. Environment

# Default lifecycle

1. Validate: validates that all project information is available and is correct f Compile: compiles the source code
2. Compile: compiles the source code
3. Test: runs unit tests within a suitable framework
4. Package: packages the compiled code in its distribution format
5. Integration-test: processes the package in the integration-test environment f Verify: runs checks to verify that the package is valid
6. Verify: runs checks to verify that the package is valid
7. Install: installs the package in the local repository
8. Deploy: installs the  nal package in a remote repository


# Clean lifecycle


1. Pre-clean: executes processes required before project cleaning
2. Clean: removes all files generated by previous builds
4. Post-clean: executes processes required to finalize project cleaning


# Site lifecycle

1. Pre-site: executes processes required before generation of the site 
2. Site: generates the project’s site documentation
3. Post-site: executes processes required to finalize the site generation and prepares the site for deployment
4. Site-deploy: deploys the site documentation to the specified web server


#    Explicit command-line trigger (page 22)


# chapter 2 (Software engineering)

# Goal

1. Build automation
2. Project modularization
3. Dependency management
5. Source code quality checks
6. Test driven development
7. Acceptance testing automation f Deployment automation


# maven-dependency-plugin
# Maven dependencies have six possible scopes

1. Compile: This is the default scope. Compile dependencies are available in the classpaths.
2. Provided: This scope assumes that the JDK or the environment provides dependencies at runtime.
3. Runtime: Dependencies that are required at runtime and are specified in the runtime classpaths.
4. Test: Dependencies required for test compilation and execution.
5. System: Dependency is always available, but the JAR is provided nonetheless.
6. Import: Imports dependencies specified in POM included via the <dependencyManagement/> element.



	$ mvn dependency:analyze
	Analyzes dependencies (used, unused, declared, undeclared)
	$ mvn dependency:analyze-duplicate
	Determines duplicate dependencies
	$ mvn dependency:resolve
	Resolves all dependencies
	$ mvn dependency:resolve-plugin
	 Resolves all plugins
	$ mvn dependency:tree
	Displays dependency trees

# Apache Maven PMD plugin
##### The Apache Maven PMD plugin automatically runs the PMD code analysis tool on the source code and generates a site report with results.


#### This plugin introduces four goals:
1. pmd:pmd creates a PMD site report based on the rulesets and configuration set in the plugin
2. pmd:cpd generates a report for PMD's Copy/Paste Detector (CPD) tool
3. pmd:check verifies that the PMD report is empty and fails the build if it is not
4. pmd:cpd-check verifies that the CPD report is empty and fails the build if it is not


```xml

	<reporting>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-pmd-plugin</artifactId>
				<version>2.5</version>



				<configuration>
					<rulesets>
						<ruleset>/rulesets/basic.xml</ruleset>
						<ruleset>/rulesets/controversial.xml</ruleset>
						<ruleset>http://localhost/design.xml</ruleset>
					</rulesets>
					<sourceEncoding>utf-8</sourceEncoding>
					<minimumTokens>100</minimumTokens>
					<targetJdk>1.7</targetJdk>
				</configuration>
			</plugin>



			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-jxr-plugin</artifactId>
				<version>2.3</version>
			</plugin>
		</plugins>
	</reporting>
```


# We'll use the popular JUnit framework to create a unit test. 

#### JUnit framework 
$ mvn test

$ mvn install



# Selenium is a popular automation testing framework
#### 

> mvn archetype:generate -DgroupId=com.abdullah.maven -DartifactId=MySampleWebAppS -DarchetypeArtifactId=maven-archetype-webapp



