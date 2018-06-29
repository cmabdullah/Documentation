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
## 
```java

```

