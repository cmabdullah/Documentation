### https://javaexpertshub.blogspot.com/2016/09/how-to-deploy-java-web-site-to-heroku.html

### http://sourabhbajaj.com/mac-setup/Heroku/README.html

### https://www.youtube.com/watch?v=FLuGA9dweaI

> ➜  ~ brew install heroku-toolbelt

> ➜  ~ heroku update

> ➜  ~ heroku login

	➜  ~ heroku login
	heroku: Enter your login credentials
	Email: a.kium.khan@gmail.com
	Password: **************
	Logged in as a.kium.khan@gmail.com



### Create Java Web Application with Maven 

Let us create a sample java web site  with the help of maven using command:

> mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp

It will ask for project group id  , artifactid and pakaging type as shown below, mention the packaging type war.

	[INFO] Generating project in Interactive mode
	Define value for property 'groupId': : com.example
	Define value for property 'artifactId': : demoapp
	Packaging type war
	 packaging type 'war' can be deployed to java server like tomcat.
	If you already have Web Application  then convert it to maven 
	if you already have build  your  application  then simply convert it to maven application by creating a pom.xml file init.

#### sample pom.xml is here

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>war</packaging>

<name>Maven Quick Start Archetype</name>
<url>http://maven.apache.org</url>

<dependencies>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.8.2</version>
<scope>test</scope>
</dependency>
</dependencies>
</project>
```

# Webapp Runner

Webapp Runner allows you to launch an application in a Tomcat container on any computer that has a JRE installed. No previous steps to install Tomcat are required when using Webapp Runner. It’s just a jar file that can be executed and configured using the java command.

Configure maven to download Webapp Runner     

```xml
       <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>2.3</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals><goal>copy</goal></goals>
                    <configuration>
                        <artifactItems>
                            <artifactItem>
                         <groupId>com.github.jsimone</groupId>
                        <artifactId>webapp-runner</artifactId>
                                <version>8.0.30.2</version>
                     <destFileName>webapp-runner.jar</destFileName>
                            </artifactItem>
                        </artifactItems>
                    </configuration>
                </execution>
            </executions>
        </plugin>
```


# Deploy website  to Heroku

1. Create a Procfile
2. You declare how you want your application executed in Procfile in the project root. Create this file with a single line:


> web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war



# Commit your changes to Git:

> $ git init

> $ git add .

> $ git commit -m "Ready to deploy"

### Create the app:

> $ heroku create demowebsite

It will show message like this:

	Creating demowebsite... done, stack is cedar-14
	http://demowebsite.herokuapp.com/ | git@heroku.com:demowebsite.git


Deploy your code:

> $ git push heroku master

The application is now deployed. Ensure that at least one instance of the app is running:

> $ heroku ps:scale web=1

Congratulations! Your web app should now be up and running on Heroku. Open it in your browser with:

> $ heroku open
