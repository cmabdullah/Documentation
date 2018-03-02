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


### This sample code has been written based on the environment and database setup done in the previous chapter.

```java
//STEP 1. Import required packages
/****

mysql> SELECT * FROM EMP.Employees;
+----+------+-------+----------+
| id | age  | first | last     |
+----+------+-------+----------+
|  1 |   21 | cm    | abdullah |
+----+------+-------+----------+
1 row in set (0.00 sec)

*/
import java.sql.*;
public class SimpleCode {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/EMP?autoReconnect=true&useSSL=false";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "rootcm";
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
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
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main
}//end FirstExample
```

## JDBC update value
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {
	// JDBC driver name and database URL
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
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
