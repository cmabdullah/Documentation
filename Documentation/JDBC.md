# JDBC in java



> How to connect Java application with Oracle and Mysql database using JDBC?

> What is the difference between Statement and PreparedStatement interface?

> How to print total numbers of tables and views of a database using JDBC ?

> How to store and retrieve images from Oracle database using JDBC?

> How to store and retrieve files from Oracle database using JDBC?

## Example to Connect Java Application with mysql database
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/***
 * 
mysql> create database sonoo; 
Query OK, 1 row affected (0.01 sec)

mysql> use sonoo; 
Database changed
mysql> create table emp(id int(10),name varchar(40),age int(3)); 
Query OK, 0 rows affected (0.04 sec)

mysql> 
 * **/
public class MysqlCon {
	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/sonoo?autoReconnect=true&useSSL=false","root","rootcm");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}


```


### 01 JDBC Show Value From Database

```java
/****

mysql> SELECT * FROM EMP.Employees;
+----+------+-------+----------+
| id | age  | first | last     |
+----+------+-------+----------+
|  1 |   21 | cm    | abdullah |
+----+------+-------+----------+
1 row in set (0.00 sec)

*/
//STEP 1. Import required packages
import java.sql.*;
public class _01JDBC_ShowValueFromDatabase {
	// JDBC driver name and database URL
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				//Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}//end main
}//end FirstExample
```

## 02 JDBC Statement Update

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _02JDBC_Statement_Update {
	// JDBC driver name and database URL
	public static void main(String[] args) {
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();
			String sql = "UPDATE Employees set age=30 WHERE id=1";
			//Let us check if it returns a true Result Set or not. 
			Boolean ret = stmt.execute(sql);
			System.out.println("Return value is : " + ret.toString() );

			// Let us update age of the record with ID = 103;
			int rows = stmt.executeUpdate(sql);
			System.out.println("Rows impacted : " + rows );
			// Let us select all the records and display them.
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				//Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}//end main
}//end JDBCExample
```

## 03 JDBC Prepared Statement Update
```java
//STEP 1. Import required packages
import java.sql.*;
public class _03JDBC_PreparedStatement_Update {
	
	public static void main(String[] args) {
	
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Execute a query
			System.out.println("Creating statement...");

			String sql = "UPDATE Employees set age=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			//Bind values into the parameters.
			stmt.setInt(1, 100);  // This would set age, here age is 100 @cm
			stmt.setInt(2, 11); // This would set ID , here 11 is the index number @cm
			// Let us update age of the record with ID = 102;
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows );
			// Let us select all the records and display them.
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set	       
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				//Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}//end main
}//end JDBCExample
```

## 03 JDBC Prepared Statement Update
```java
//STEP 1. Import required packages
import java.sql.*;
public class _03JDBC_PreparedStatement_Update {
	
	public static void main(String[] args) {
	
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Execute a query
			System.out.println("Creating statement...");

			String sql = "UPDATE Employees set age=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			//Bind values into the parameters.
			stmt.setInt(1, 100);  // This would set age, here age is 100 @cm
			stmt.setInt(2, 11); // This would set ID , here 11 is the index number @cm
			// Let us update age of the record with ID = 102;
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows );
			// Let us select all the records and display them.
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set	       
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				//Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}//end main
}//end JDBCExample
```


```java

```
```java

```
```java

```
```java

```
```java

```
```java

```
```java

```

