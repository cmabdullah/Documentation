# Learning resources Servlet and JSP Tutorial for Beginners 2018 (Telusko)
# file > new Dymanic Web Project
Give project name , then everything default
Go > java Resources > create new Sarvlet
GIve package name, classname,
Mark doGet mehtod
Go > file > HTML file, > create new html file 'index.html'


## 01 Hello World

### index.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello world
</body>
</html>
```

## 02 add two number

### index.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="get">
	Enter 1st number : <input type = "text" name = "num1"><br>
	Enter 2nd number : <input type = "text" name = "num2"><br>
	<input type ="submit">
	</form>
</body>
</html>
```

### AddServlet.java
```java
package com.cm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	//service() not data as get or post
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i =Integer.parseInt( req.getParameter("num1"));
		int j =Integer.parseInt( req.getParameter("num2"));
		int k = i+j;
		PrintWriter out = res.getWriter();
		out.println("Add result is : "+k);
	}
}
```
### web.xml // deployment descriptor
```html
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>

<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>
</web-app>
```

> Get request is used to fetched data

> Post request is used to submit data

### 03 Get and Post method


### index.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
	Enter 1st number : <input type = "text" name = "num1"><br>
	Enter 2nd number : <input type = "text" name = "num2"><br>
	<input type ="submit">
	</form>
</body>
</html>
```

### AddServlet.java
```java
package com.cm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	//doPost() is used to import data
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i =Integer.parseInt( req.getParameter("num1"));
		int j =Integer.parseInt( req.getParameter("num2"));
		int k = i+j;
		PrintWriter out = res.getWriter();
		out.println("Add result is : "+k);
	}
}
```
### web.xml
```html
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>

<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>
</web-app>
```


## 04 calling servlet to servlet

### index.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
	Enter 1st number : <input type = "text" name = "num1"><br>
	Enter 2nd number : <input type = "text" name = "num2"><br>
	<input type ="submit">
	</form>
</body>
</html>
```


### AddServlet.java
```java
package com.cm;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i =Integer.parseInt( req.getParameter("num1"));
		int j =Integer.parseInt( req.getParameter("num2"));
		int k = i+j;
		req.setAttribute("k", k); //transfer attribute, here "k" is key, k is value 
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);
	}
}
```
### SqServlet.java
```java
package com.cm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int k =(int) req.getAttribute("k");
		k = k*k;
		PrintWriter out = res.getWriter();
		out.println("multiplication result is : "+k);
	}
}
```
### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>

<servlet>
<servlet-name>pqr</servlet-name>
<servlet-class>com.cm.SqServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>pqr</servlet-name>
<url-pattern>/sq</url-pattern>
</servlet-mapping>

</web-app>
```

## 05 sendRedirect | URL Rewriting

### index.html

```xml
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="get">
	Enter 1st number : <input type = "text" name = "num1"><br>
	Enter 2nd number : <input type = "text" name = "num2"><br>
	<input type ="submit">
	</form>
</body>
</html>
```

### AddServlet.java

```java
package com.cm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i =Integer.parseInt( req.getParameter("num1"));
		int j =Integer.parseInt( req.getParameter("num2"));
		int k = i+j;
		res.sendRedirect("sq?k="+k);
	}
}

```

### SqServlet.java

```java
package com.cm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int k =Integer.parseInt( req.getParameter("k"));
		k = k*k;
		PrintWriter out = res.getWriter();
		out.println("multiplication result is : "+k);
	}
}
```

### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>

<servlet>
<servlet-name>pqr</servlet-name>
<servlet-class>com.cm.SqServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>pqr</servlet-name>
<url-pattern>/sq</url-pattern>
</servlet-mapping>

</web-app>
```


## 06 sendRedirect | URL Rewriting,  using annotation

### index.html

```xml
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="get">
	Enter 1st number : <input type = "text" name = "num1"><br>
	Enter 2nd number : <input type = "text" name = "num2"><br>
	<input type ="submit">
	</form>
</body>
</html>
```

### AddServlet.java

```java
package com.cm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;// nnotation package
@WebServlet(urlPatterns = {"/add"}) // used annotation
public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i =Integer.parseInt( req.getParameter("num1"));
		int j =Integer.parseInt( req.getParameter("num2"));
		int k = i+j;
		res.sendRedirect("sq?k="+k);
	}
}

```

### SqServlet.java

```java
package com.cm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;// nnotation package
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/sq"}) // used annotation
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int k =Integer.parseInt( req.getParameter("k"));
		k = k*k;
		PrintWriter out = res.getWriter();
		out.println("multiplication result is : "+k);
	}
}
```




## 07 HttpSession Session Management

### index.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="get">
	Enter 1st number : <input type = "text" name = "num1"><br>
	Enter 2nd number : <input type = "text" name = "num2"><br>
	<input type ="submit">
	</form>
</body>
</html>
```

### AddServlet.java

```java
package com.cm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int str1 =Integer.parseInt(req.getParameter("num1"));
		int str2 =Integer.parseInt(req.getParameter("num2"));

		HttpSession session = req.getSession();
		session.setAttribute("num1", str1);
		session.setAttribute("num2", str2);
		
		res.sendRedirect("sq");
	}
}

```

### SqServlet.java

```java
package com.cm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/sq"})
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		int p = (int)session.getAttribute("num1");
		int q = (int)session.getAttribute("num2");
		int sum = p+q;
		PrintWriter out = res.getWriter();
		out.println("Name is : "+p);
		out.println("Name is : "+q);
		out.println("Sum result is : "+sum);
	}
}
```

### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>

<servlet>
<servlet-name>pqr</servlet-name>
<servlet-class>com.cm.SqServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>pqr</servlet-name>
<url-pattern>/sq</url-pattern>
</servlet-mapping>

</web-app>
```





## 08 use Cookie for session Management

### index.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="get">
	Enter 1st number : <input type = "text" name = "num1"><br>
</body>
</html>
```

### AddServlet.java

```java
package com.cm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String str1 =req.getParameter("num1");
		Cookie cookie = new Cookie("num1", str1);
		res.addCookie(cookie);	
		res.sendRedirect("sq");
	}
}
```

### SqServlet.java

```java
package com.cm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;
@WebServlet(urlPatterns = {"/sq"})
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();//cookie
		String str = null;
		for (Cookie c :  cookies) {
			if (c.getName().equals("num1")) {
				str = c.getValue();
			}
		}
		PrintWriter out = res.getWriter();

		out.println("The Cookie is : "+str);
	}
}
```

### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>

</web-app>
```


## 09 use URL rewriting Session Management

### index.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="get">
	Enter 1st number : <input type = "text" name = "num1"><br>
</body>
</html>
```

### AddServlet.java

```java
package com.cm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String str1 =req.getParameter("num1");
		res.sendRedirect("sq?num1="+str1);
	}
}
```

### SqServlet.java

```java
package com.cm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;
@WebServlet(urlPatterns = {"/sq"})
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		String str = req.getParameter("num1");
		PrintWriter out = res.getWriter();
		out.println("The Cookie is : "+str);
	}
}

```

### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

<servlet>
<servlet-name>abc</servlet-name>
<servlet-class>com.cm.AddServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>abc</servlet-name>
<url-pattern>/add</url-pattern>
</servlet-mapping>

</web-app>
```


















### index.html

```xml

```