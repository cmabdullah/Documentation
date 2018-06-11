### https://github.com/FasterXML/jackson


```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.8.9</version>
</dependency>
		
		
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.8.9</version>
</dependency>


<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.8.9</version>
</dependency>

```


# 01 JacksonTester
```java


# Basic APP

```java
package com.abdullah.JacksonAPI;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class _01JacksonTester {
	public static void main( String[] args ){
		System.out.println( "Hello World!" );

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
		//map json to student
		try{
			Student student = mapper.readValue(jsonString, Student.class);
			System.out.println(student);
			jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student); 
			System.out.println(jsonString);
		}
		catch (JsonParseException e) { e.printStackTrace();}
		catch (JsonMappingException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }

	}
}

class Student {
	private String name;
	private int age;
	public Student(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return "Student [ name: "+name+", age: "+ age+ " ]";
	}

```