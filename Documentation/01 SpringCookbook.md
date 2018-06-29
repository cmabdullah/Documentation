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
## 
```java

```

