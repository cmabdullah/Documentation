# Servlet In Java


## 01 HelloWorld
```java
package com.abdullah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _01HelloWorld extends HttpServlet {
	  private String message;
	  public void init() throws ServletException{
	      // Do required initialization
	      message = "Hello World";
	  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type 
		response.setContentType("text/html");
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}
	public void destroy(){
	      // do nothing.
	  }
}
```


### 02 GET Method Example Using URL

#### _02GETMethodExampleUsingURL.java
```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8081/ServletTP/ShowCm?first_name=CM&last_name=Khan
// @WebServlet("/_02GETMethodExampleUsingURL")
public class _02GETMethodExampleUsingURL extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Using GET Method to Read Form Data";
		String docType =
		"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n" +
		" <li><b>First Name</b>: "
		+ request.getParameter("first_name") + "\n" +
		" <li><b>Last Name</b>: "
		+ request.getParameter("last_name") + "\n" +
		"</ul>\n" +
		"</body></html>");
	}
}

```

#### _02GETMethodExampleUsingForm.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ShowCm" method="GET">
		First Name: <input type="text" name="first_name"> <br />
		Last Name: <input type="text" name="last_name" /> 
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
```
#### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <servlet>
    <servlet-name>abc</servlet-name>
    <servlet-class>com.abdullah._02GETMethodExampleUsingURL</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abc</servlet-name>
    <url-pattern>/ShowCm</url-pattern>
  </servlet-mapping>
</web-app>
```

### 03 POST Method Example Using Form
#### _03POSTMethodExampleUsingForm.java
```java
package com.abdullah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _03POSTMethodExampleUsingForm extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// Set response content type response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Using GET Method to Read Form Data";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
			"<html>\n" +
			"<head><title>" + title + "</title></head>\n" 
			+ "<body bgcolor=\"#f0f0f0\">\n" +
			"<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n" +
			" <li><b>First Name</b>: "
			+ request.getParameter("first_name") + "\n" +
			" <li><b>Last Name</b>: "
			+ request.getParameter("last_name") + "\n" + "</ul>\n" +
			"</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```
#### _03POSTMethodExampleUsingForm.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ShowCm3" method="POST">
		First Name: <input type="text" name="first_name"> <br />
		Last Name: <input type="text" name="last_name" /> 
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
```

#### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <servlet>
    <servlet-name>abc</servlet-name>
    <servlet-class>com.abdullah._02GETMethodExampleUsingURL</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abc</servlet-name>
    <url-pattern>/ShowCm</url-pattern>
  </servlet-mapping>
  <servlet>
    <servlet-name>abcd</servlet-name>
    <servlet-class>com.abdullah._03POSTMethodExampleUsingForm</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abcd</servlet-name>
    <url-pattern>/ShowCm3</url-pattern>
  </servlet-mapping>
</web-app>
```









### 04 Passing Checkbox Data To Servlet Program
#### _04PassingCheckboxDataToServletProgram.java
```java
package com.abdullah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _04PassingCheckboxDataToServletProgram extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		String title = "Reading Checkbox Data";
		String docType =
		"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n" 
		+ "<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n" 
		+ "<ul>\n" +
			" <li><b>Maths Flag : </b>: "
			+ request.getParameter("maths") + "\n" +
			" <li><b>Physics Flag: </b>: "
			+ request.getParameter("physics") + "\n" +
			" <li><b>Chemistry Flag: </b>: "
			+ request.getParameter("chemistry") + "\n" 
		+ "</ul>\n" +
		"</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
```
#### _04PassingCheckboxDataToServletProgram.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ShowCm4" method="POST" target="_blank">
		<input type="checkbox" name="maths" checked="checked" /> Maths 
		<input type="checkbox" name="physics" /> Physics
		<input type="checkbox" name="chemistry" checked="checked" /> Chemistry
		<input type="submit" value="Select Subject" />
	</form>
</body>
</html>
```

#### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <servlet>
    <servlet-name>abc</servlet-name>
    <servlet-class>com.abdullah._02GETMethodExampleUsingURL</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abc</servlet-name>
    <url-pattern>/ShowCm</url-pattern>
  </servlet-mapping>
  <servlet>
    <servlet-name>abcd</servlet-name>
    <servlet-class>com.abdullah._03POSTMethodExampleUsingForm</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abcd</servlet-name>
    <url-pattern>/ShowCm3</url-pattern>
  </servlet-mapping>
  
  <servlet>
    <servlet-name>abcde</servlet-name>
    <servlet-class>com.abdullah._04PassingCheckboxDataToServletProgram</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abcde</servlet-name>
    <url-pattern>/ShowCm4</url-pattern>
  </servlet-mapping>
    
</web-app>
```



### 05 Reading All Form Parameters
#### _05ReadingAllFormParametersjava
```java
package com.abdullah;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _05ReadingAllFormParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading All Form Parameters";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<table width=\"100%\" border=\"1\" align=\"center\">\n" 
				+ "<tr bgcolor=\"#949494\">\n" +
				"<th>Param Name</th><th>Param Value(s)</th>\n"+ "</tr>\n");
		Enumeration paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement(); 
			out.print("<tr><td>" + paramName + "</td>\n<td>"); 
			String[] paramValues = request.getParameterValues(paramName); // Read single valued data
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<i>No Value</i>");
				else
					out.println(paramValue);
			} else {
				//Read multiple valued data 
				out.println("<ul>");
				for(int i=0; i < paramValues.length; i++) {
					out.println("<li>" + paramValues[i]);
				}
				out.println("</ul>");
			}
		}
		out.println("</tr>\n</table>\n</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```
#### _05ReadingAllFormParametersjava.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ShowCm5" method="POST" target="_blank">
		<input type="checkbox" name="maths" checked="checked" />  Maths
		<input type="checkbox" name="physics" /> Physics
		<input type="checkbox" name="chemistry" checked="checked" /> Chemistry
		<input type="submit" value="Select Subject" />
	</form>
</body>
</html>
```

#### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
   <servlet>
    <servlet-name>abcde5</servlet-name>
    <servlet-class>com.abdullah._05ReadingAllFormParameters</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abcde5</servlet-name>
    <url-pattern>/ShowCm5</url-pattern>
  </servlet-mapping>  

</web-app>
```






### 06 HTTP Header Request Example
#### _06HTTPHeaderRequestExample.java
```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_06HTTPHeaderRequestExample")
public class _06HTTPHeaderRequestExample extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "HTTP Header Request Example";
		String docType =
		"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n"+
		"<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n" +
		"<table width=\"100%\" border=\"1\" align=\"center\">\n" 
		+ "<tr bgcolor=\"#949494\">\n"
		+ "<th>Header Name</th><th>Header Value(s)</th>\n"
		+ "</tr>\n");
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String paramName = (String)headerNames.nextElement(); 
			out.print("<tr><td>" + paramName + "</td>\n");
			String paramValue = request.getHeader(paramName);
			out.println("<td> " + paramValue + "</td></tr>\n"); 
		}
		out.println("</table>\n</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

```
### 07 HTTP Response Header
#### _07HTTPResponseHeader.java
```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/_07HTTPResponseHeader")
public class _07HTTPResponseHeader extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set refresh, autoload time as 5 seconds 
		response.setIntHeader("Refresh", 5);
		// Set response content type 

		response.setContentType("text/html");

		// Get current time
		Calendar calendar = new GregorianCalendar(); 
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE); 
		int second = calendar.get(Calendar.SECOND); 
		if(calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
		PrintWriter out = response.getWriter();
		String title = "Auto Refresh Header Setting"; 
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n"+ 
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + 
				"</h1>\n" + 
				"<p>Current Time is: " + CT + 
				"</p>\n");

	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
```
### 08 HTTP Status Code Example
#### _08HTTPStatusCodeExample.java
```java
package com.abdullah;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
type Status report
message Need authentication!!!
description The client must first authenticate itself with the proxy.
 */
public class _08HTTPStatusCodeExample extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set error code and reason. 
		response.sendError(407, "Need authentication!!!" );
	  // Method to handle POST method request.
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```
### 09 LogFilter
#### _09LogFilter.java
```java
package com.abdullah;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/_09ServletLogFilter")
public class _09LogFilter implements Filter {
	public void init(FilterConfig config) throws ServletException{
		// Get init parameter
		String testParam = config.getInitParameter("test-param");
		//Print the init parameter
		System.out.println("Test Param: " + testParam); 
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
					throws java.io.IOException, ServletException {
		// Get the IP address of client machine. 
		String ipAddress = request.getRemoteAddr();
		// Log the IP address and current timestamp.
		System.out.println("IP "+ ipAddress + ", Time "
				+ new Date().toString());
		// Pass request back down the filter chain
		chain.doFilter(request,response);
	}
	public void destroy( ){
		/* Called before the Filter instance is removed
	      from service by the web container*/
	}
}
```
#### _09LogFilter.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cma" method="filter">

<input type="submit" value="Submit" />
</form>
</body>
</html>
```
#### web.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
 
  
<filter>
   <filter-name>LogFilter</filter-name>
   <filter-class>com.abdullah._09LogFilter</filter-class>
   <init-param>
      <param-name>test-param</param-name>
      <param-value>Initialization Paramter</param-value>
   </init-param>
</filter>

<filter-mapping>
   <filter-name>LogFilter</filter-name>
   <url-pattern>/cma</url-pattern>
</filter-mapping>
  
</web-app>
```
### 10 Setting Cookies With Servlet
#### _10SettingCookiesWithServlet.java
```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/_10SettingCookiesWithServlet")
public class _10SettingCookiesWithServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create cookies for first and last names.
		Cookie firstName = new Cookie("first_name",request.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));
		// Set expiry date after 24 Hrs for both the cookies.
		firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		// Add both the cookies in the response header. 
		response.addCookie( firstName ); 
		response.addCookie( lastName );
		// Set response content type 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Setting Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" + 
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" + 
				"<ul>\n" +
					" <li><b>First Name</b>: " + request.getParameter("first_name") + "\n" + 
					" <li><b>Last Name</b>: " + request.getParameter("last_name") + "\n" + 
				"</ul>\n" +
				"</body></html>");
	}
}
```


#### _10SettingCookiesWithServlet.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ShowCm10" method="GET">
		First Name: <input type="text" name="first_name"> <br />
		Last Name: <input type="text" name="last_name" /> 
	<input type="submit" value="Submit" />
	</form>
</body>
</html>
```

#### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <servlet>
    <servlet-name>abcde11</servlet-name>
    <servlet-class>com.abdullah._11ReadingCookiesWithServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>abcde11</servlet-name>
    <url-pattern>/ShowCm11</url-pattern>
  </servlet-mapping>
 
</web-app>
```




### 11 Reading Cookies With Servlet
#### _11ReadingCookiesWithServlet.java

```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/_11ReadingCookiesWithServlet")
public class _11ReadingCookiesWithServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		// Set response content type 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading Cookies Example";
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" ); 
		if( cookies != null ){
			out.println("<h2> Found Cookies Name and Value</h2>"); 
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				out.print("Name : " + cookie.getName( ) + ", ");
				out.print("Value: " + cookie.getValue( )+" <br/>");
			} 
		}else{
			out.println(
					"<h2>No cookies founds</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
```
### 12 Delete Cookies With Servlet
#### _12DeleteCookiesWithServlet.java
```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/_12DeleteCookiesWithServlet")
public class _12DeleteCookiesWithServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		// Set response content type response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Delete Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" );
		if( cookies != null ){
			out.println("<h2> Cookies Name and Value</h2>"); 
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if((cookie.getName( )).compareTo("first_name") == 0 ){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.print("Deleted cookie : " +
						cookie.getName( ) + "<br/>");
				}
				out.print("Name : " + cookie.getName( ) + ", "); 
				out.print("Value: " + cookie.getValue( )+" <br/>");
			}
		}else{
			out.println(
					"<h2>No cookies founds</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
```

### 13 Session Tracking Example
#### _13SessionTrackingExample.java
```java
package com.abdullah;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/_13SessionTrackingExample")
public class _13SessionTrackingExample extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a session object if it is already not created. 
		HttpSession session = request.getSession(true);
		// Get session creation time.
		Date createTime = new Date(session.getCreationTime()); // Get last access time of this web page.
		Date lastAccessTime =
		new Date(session.getLastAccessedTime());
		String title = "Welcome Back to my website"; Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("ABCD");
		// Check if this is new comer on your web page.
		if (session.isNew()){
		   title = "Welcome to my website";
		session.setAttribute(userIDKey, userID); } else {
		visitCount = (Integer)session.getAttribute(visitCountKey); visitCount = visitCount + 1;
		userID = (String)session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);
		// Set response content type 
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		String docType =
		"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n" +
		"<h2 align=\"center\">Session Infomation</h2>\n" + "<table border=\"1\" align=\"center\">\n" +
		"<tr bgcolor=\"#949494\">\n" +
		" <th>Session info</th><th>value</th></tr>\n" + "<tr>\n" +
		" <td>id</td>\n" +
		" <td>" + session.getId() + "</td></tr>\n" + "<tr>\n" +
		" <td>Creation Time</td>\n" +
		" <td>" + createTime +
		
		" </td></tr>\n" +
		"<tr>\n" +
		" <td>Time of Last Access</td>\n" +
		" <td>" + lastAccessTime +
		" </td></tr>\n" +
		"<tr>\n" +
		" <td>User ID</td>\n" +
		" <td>" + userID +
		" </td></tr>\n" +
		"<tr>\n" +
		" <td>Number of visits</td>\n" +
		" <td>" + visitCount + "</td></tr>\n" + "</table>\n" +
		"</body></html>");
	}
}
```


# 14 File Upload Servlet
> commons-fileupload-1.2.2.jar

> commons-io-1.4.jar

#### _14UploadServlet.java
```java
package com.abdullah;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException; 
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload; 
import org.apache.commons.io.output.*;
//@WebServlet("/_14UploadServlet")
public class _14UploadServlet extends HttpServlet {

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 5000 * 1024; 
	private int maxMemSize = 4 * 1024; 
	private File file ;
	public void init( ){
		// Get the file location where it would be stored. 
		filePath = getServletContext().getInitParameter("file-upload");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request); 
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter( );
		if( !isMultipart ){
			out.println("<html>");
			out.println("<head>"); 
			out.println("<title>Servlet upload</title>"); 
			out.println("</head>"); 
			out.println("<body>");
			out.println("<p>No file uploaded</p>"); 
			out.println("</body>"); 
			out.println("</html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory(); // maximum size that will be stored in memory 
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize. 
		factory.setRepository(new File("/Users/abdullah/Desktop"));
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory); // maximum file size to be uploaded.
		upload.setSizeMax( maxFileSize );
		try{
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);
			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			out.println("<html>");
			out.println("<head>"); 
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			while ( i.hasNext () ){
				FileItem fi = (FileItem)i.next();
				if ( !fi.isFormField () ){
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if( fileName.lastIndexOf("\\") >= 0 ){
						file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ; 
					}else{
						file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ; 
					}
					fi.write( file ) ;
					out.println("Uploaded Filename: " + fileName + "<br>"); 
				}
			}
			out.println("</body>");
			out.println("</html>");
		}catch(Exception ex) {
			System.out.println(ex);
		}	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new ServletException("GET method used with " +getClass( ).getName( )+": POST method required.");

	}
}
```

#### _14UploadServlet.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>File Upload:</h3>
Select a file to upload: <br />
<form action="UploadServlet" method="post" enctype="multipart/form-data">
	<input type="file" name="file" size="50" />
	<br />
	<input type="submit" value="Upload File" /> 
</form>
</body>
</html>
```

#### web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  
<servlet> <servlet-name>UploadServlet</servlet-name>
	<servlet-class>com.abdullah._14UploadServlet</servlet-class>
</servlet>
<servlet-mapping> 
	<servlet-name>UploadServlet</servlet-name> 
	<url-pattern>/UploadServlet</url-pattern>
</servlet-mapping>
  
<context-param>
	<description>Location to store uploaded file</description> 
	<param-name>file-upload</param-name>
	<param-value> /Users/abdullah/windowshdd/apache-tomcat-7.0.82/webapps/data </param-value>
</context-param>
  
</web-app>
```

####
```java

```

####
```java

```

####
```java

```

####
```java

```

####
```java

```

####
```java

```

####
```java

```

####
```java

```

