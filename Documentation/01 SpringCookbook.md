# Now I am following [Thinking In Java](https://goo.gl/vmjMJs) & [The complete referrence](https://bit.do/cmabdullah)Book 

# 01 Hello World
## AppConfig.java
```java
package com.springcookbook.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan
(basePackages = {"com.springcookbook.controller"})
public class AppConfig {

}
```
## ServletInitializer.java
```java
package com.springcookbook.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?> [0] ;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {AppConfig.class} ;
	}
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/"} ;
	}
}

```
## HelloController.java
```java
package com.springcookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return "Hello World";
	}
}

```

# 02 Using Spring in a standared java app
## AppConfig.java
```java
package com.springcookbook.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springcookbook.main.User;

@Configuration

public class AppConfig {
	@Bean
	public User admin() {
		User u = new User();
		u.setName("Abdullah Khan");
		u.setSkill("Java programmer");
		return u;
	}
}

```
## User.java
```java
package com.springcookbook.main;

public class User {
	private String name;
	private String skill;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}

```
## Main.java
```java
package com.springcookbook.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcookbook.config.AppConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class);
		User admin = (User)springContext.getBean("admin");
		System.out.println("Admin NAme : "+ admin.getName());
		System.out.println("Admin Skill : "+admin.getSkill());
		springContext.close();
	}

}

```

# Using bean via dependency injection



## AppConfig.java
```java
package com.springcookbook.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import junc.User;

@Configuration
@EnableWebMvc
//"com.springcookbook.service",
@ComponentScan(basePackages = {"com.springcookbook.service","com.springcookbook.controller"})
public class AppConfig {
	
	/***
	@Bean
	public User admin() {
		User u = new User();
		u.setName("Abdullah Khan");
		u.setSkill("Java programmer");
		return u;
	}
	****/
	/****
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db1?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("rootcm");
		return dataSource;
	}
	
	****/
}

```

## ServletInitializer.java
```java
package com.springcookbook.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?> [0] ;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {AppConfig.class} ;
	}
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/"} ;
	}
}

```

## UserService.java
```java
package com.springcookbook.service;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {
	public int findNumberOfUsers() {
		return 10;
	}
}

```
## HelloController.java
```java
package com.springcookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcookbook.service.UserService;
@Controller
public class HelloController {
	@Autowired
	UserService userService;
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		//+userService.findNumberOfUsers()
		return "number of users "+userService.findNumberOfUsers();
	}
}
```

# 03 Associating a route to a controller method




## AppConfig.java
```java
package com.springcookbook.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import junc.User;

@Configuration
@EnableWebMvc
//"com.springcookbook.service",
@ComponentScan(basePackages = {"com.springcookbook.service","com.springcookbook.controller"})
public class AppConfig {
	
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver reslover = new InternalResourceViewResolver();
		reslover.setViewClass(JstlView.class);
		reslover.setPrefix("/WEB-INF/jsp/");
		reslover.setSuffix(".jsp");
		return reslover;
	}
}

```

## ServletInitializer.java
```java
package com.springcookbook.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?> [0] ;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {AppConfig.class} ;
	}
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/"} ;
	}
}

```

## UserController.java
```java
package com.springcookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/user/list")
	public void userList() {
		
	}
}

```
## list.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
there are many users
</body>
</html>
```



## 
```java

```


