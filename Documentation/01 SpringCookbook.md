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


# 03 Associating a route to a controller method(Data retrive failed from controller to jsp)

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/user/list")
	public void userList(Model model) {
		//model.addAttribute("nbUsers", 20);
		System.out.println(model.addAttribute("nbUsers", 20));
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
${nbUsers}
there are many users
</body>
</html>
```



# 04 Using page template with tiles(I think this tool is not working, dont know why)

## AppConfig.java
```java
package com.springcookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.springcookbook.controller"})
public class AppConfig {
	
	//tiles configuration
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		final String[] definitions = {"/WEB-INF/tiles.xml"};
		tilesConfigurer.setDefinitions(definitions);
		return tilesConfigurer;
	}
	//declere tiles as view resolver
	@Bean
	public ViewResolver tilesViewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		return resolver;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/user/home")
	public String userList() {
		return "home" ;
	}
}
```
## template.java
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
<h1>Spring CookzBook</h1>
</body>
</html>
```


## tiles.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE tiles-definitions PUBLIC
   "-//Apache Software Foundation//DTD Tiles Configuration 2.0//EN"
   "http://tiles.apache.org/dtds/tiles-config_2_0.dtd">
<tiles-definitions>
	<definition name="template"
		template="/WEB-INF/jsp/templates/template.jsp" />
	<definition name="*" extends="template">

		<put-attribute name="body" value="/WEB-INF/jsp/{1}.jsp" />

	</definition>
</tiles-definitions>
```




## 
```java

```


