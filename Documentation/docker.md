
docker run -d centos
docker run -d centos tail /dev/null

docker exec -it centos bash
ps -ef
kill =9 1
ps -ef
yum install java


# build docker image
docker build -t spring-boot-docker .
docker run -t -d -p 8080:8080 spring-boot-docker





## Ubuntu image
```Docker
	#[Using Docker ubuntu latest] 
	FROM ubuntu:xenial 
	MAINTAINER szlynas@gmail.com 




	RUN apt-get update 
	RUN apt-get install -y wget software-properties-common 


	#notices-0.0.1-SNAPSHOT

	#[Setting up working directory] 
	WORKDIR /root 




	#[Setup JAVA] 
	ADD ./jdk-8u181-linux-x64.tar.gz /root
	RUN update-alternatives --install /usr/bin/java java /root/jdk1.8.0_181/bin/java 100 
	RUN update-alternatives --install /usr/bin/javac javac /root/jdk1.8.0_181/bin/javac 100 
	RUN update-alternatives --install /usr/bin/javaws javaws /root/jdk1.8.0_181/bin/javaws 100 
	RUN java -version 




	#[Setup Maven] 
	RUN wget http://www.eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz 
	RUN tar -xvf apache-maven-3.3.9-bin.tar.gz 
	env PATH /root/apache-maven-3.3.9/bin:$PATH 
	RUN mvn -v 
	RUN rm apache-maven-3.3.9-bin.tar.gz 




	#[Setup and run tomcat] 

	RUN wget http://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.32/bin/apache-tomcat-8.5.32.tar.gz
	RUN tar -xvf apache-tomcat-8.5.32.tar.gz 
	RUN rm apache-tomcat-8.5.32.tar.gz 
	RUN rm -rfv apache-tomcat-8.5.32/webapps/* 



	RUN apt install -y git
	RUN git clone https://github.com/lynas/SpringMvcJavaConfig.git 
	RUN mvn -f SpringMvcJavaConfig/pom.xml package 
	RUN mv /root/deployments/ROOT.war apache-tomcat-8.5.32/webapps/ 

```

docker build -t ubuntu_xenial  . 
docker run -t  -d -p 8088:8080 ubuntu_xenial


root@2a44cb44bb75:~/apache-tomcat-8.5.32/bin# pwd
/root/apache-tomcat-8.5.32/bin
root@2a44cb44bb75:~/apache-tomcat-8.5.32/bin# ./startup.sh
Using CATALINA_BASE:   /root/apache-tomcat-8.5.32
Using CATALINA_HOME:   /root/apache-tomcat-8.5.32
Using CATALINA_TMPDIR: /root/apache-tomcat-8.5.32/temp
Using JRE_HOME:        /usr
Using CLASSPATH:       /root/apache-tomcat-8.5.32/bin/bootstrap.jar:/root/apache-tomcat-8.5.32/bin/tomcat-juli.jar
Tomcat started.







# My project

#[Using Docker ubuntu latest] 
FROM ubuntu:xenial 
MAINTAINER cmabdullah21@gmail.com 




RUN apt-get update 
RUN apt-get install -y wget software-properties-common 


#notices-0.0.1-SNAPSHOT

#[Setting up working directory] 
WORKDIR /root 




#[Setup JAVA] 

RUN wget --continue --no-check-certificate -O jdk-8u181-linux-x64.tar.gz --header "Cookie: oraclelicense=a" http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-x64.tar.gz
RUN tar -xvf jdk-8u181-linux-x64.tar.gz


RUN update-alternatives --install /usr/bin/java java /root/jdk1.8.0_181/bin/java 100 
RUN update-alternatives --install /usr/bin/javac javac /root/jdk1.8.0_181/bin/javac 100 
RUN update-alternatives --install /usr/bin/javaws javaws /root/jdk1.8.0_181/bin/javaws 100 
RUN java -version 




#[Setup Maven] 
RUN wget http://www.eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz 
RUN tar -xvf apache-maven-3.3.9-bin.tar.gz 
env PATH /root/apache-maven-3.3.9/bin:$PATH 
RUN mvn -v 
RUN rm apache-maven-3.3.9-bin.tar.gz 




#[Setup and run tomcat] 

RUN wget http://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.32/bin/apache-tomcat-8.5.32.tar.gz
RUN tar -xvf apache-tomcat-8.5.32.tar.gz 
RUN rm apache-tomcat-8.5.32.tar.gz 
RUN rm -rfv apache-tomcat-8.5.32/webapps/* 



#RUN apt install -y git
#RUN git clone https://github.com/lynas/SpringMvcJavaConfig.git 
#RUN mvn -f SpringMvcJavaConfig/pom.xml package 
#RUN mv /root/deployments/ROOT.war apache-tomcat-8.5.32/webapps/ 

ADD /notices-0.0.1-SNAPSHOT.war /root
#RUN mv /root/notices-0.0.1-SNAPSHOT.war apache-tomcat-8.5.32/webapps/ROOT.war 

RUN mv /root/notices-0.0.1-SNAPSHOT.war /root/apache-tomcat-8.5.32/webapps/ROOT.war

