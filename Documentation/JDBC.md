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

## 04 JDBC Callable Statement Store Procedure

	CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmpName`
	(IN EMP_ID INT, OUT EMP_FIRST VARCHAR(255))
	BEGIN
	SELECT first INTO EMP_FIRST FROM Employees 
	WHERE id = EMP_ID;
	END


```java
//STEP 1. Import required packages
import java.sql.*;

//store procedure process
/***
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmpName`
(IN EMP_ID INT, OUT EMP_FIRST VARCHAR(255))
BEGIN
SELECT first INTO EMP_FIRST FROM Employees 
WHERE id = EMP_ID;
END
 * */
public class _04JDBC_CallableStatementStoreProcedure {
	
	public static void main(String[] args) {

		CallableStatement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "{call getEmpName (?, ?)}";
			stmt = conn.prepareCall(sql);
			//Bind IN parameter first, then bind OUT parameter 
			int empID = 9;
			stmt.setInt(1, empID); // This would set ID as 102 // Because second parameter is OUT so register it 
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			//Use execute method to run stored procedure.
			System.out.println("Executing stored procedure..." );
			stmt.execute();
			//Retrieve employee name with getXXX method
			String empName = stmt.getString(2);
			System.out.println("Emp Name with ID:" + empID + " is " + empName);
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
}//end JDBCExample
```

## 05 JDBC Navigating A ResultSet
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _05JDBC_NavigatingAResultSet {

	public static void main(String[] args) { 
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Execute a query to create statment with
			// required arguments for RS example.
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT id, first, last, age FROM Employees";	   
			ResultSet rs = stmt.executeQuery(sql);
			// Move cursor to the last row.
			System.out.println("Moving cursor to the last...");
			rs.last();
			//STEP 5: Extract data from result set
			System.out.println("Displaying record...");
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

			// Move cursor to the first row.
			System.out.println("Moving cursor to the first row...");
			rs.first();
			//STEP 6: Extract data from result set 
			System.out.println("Displaying record..."); //Retrieve by column name
			id = rs.getInt("id");
			age = rs.getInt("age");
			first = rs.getString("first");
			last = rs.getString("last");
			//Display values
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);

			// Move cursor to the first next row.
			System.out.println("Moving cursor to the next row...");
			rs.next();
			//STEP 7: Extract data from result set
			System.out.println("Displaying record...");
			id  = rs.getInt("id");
			age = rs.getInt("age");
			first = rs.getString("first");
			last = rs.getString("last");
			//Display values
			System.out.print("ID: " + id); 
			System.out.print(", Age: " + age); 
			System.out.print(", First: " + first); 
			System.out.println(", Last: " + last);

			//STEP 8: Clean-up environment
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
}//end JDBCExample
```

## 06 JDBC Updating A ResultSet

	Connecting to database...
	Creating statement...
	List result set for reference....
	ID: 100, Age: 18, First: Zara, Last: Ali
	ID: 101, Age: 25, First: Mahnaz, Last: Fatma
	ID: 102, Age: 35, First: Zahid, Last: Khan
	ID: 103, Age: 30, First: Sumit, Last: Mittal

	List result set showing new ages...
	ID: 100, Age: 23, First: Zara, Last: Ali
	ID: 101, Age: 30, First: Mahnaz, Last: Fatma
	ID: 102, Age: 40, First: Zahid, Last: Khan
	ID: 103, Age: 35, First: Sumit, Last: Mittal

	Inserting a new record...
	List result set showing new set...
	ID: 100, Age: 23, First: Zara, Last: Ali
	ID: 101, Age: 30, First: Mahnaz, Last: Fatma
	ID: 102, Age: 40, First: Zahid, Last: Khan
	ID: 103, Age: 35, First: Sumit, Last: Mittal
	ID: 104, Age: 40, First: John, Last: Paul

	List the record before deleting...
	ID: 101, Age: 30, First: Mahnaz, Last: Fatma
	List result set after deleting one records...
	ID: 100, Age: 23, First: Zara, Last: Ali
	ID: 102, Age: 40, First: Zahid, Last: Khan
	ID: 103, Age: 35, First: Sumit, Last: Mittal
	ID: 104, Age: 40, First: John, Last: Paul

	Goodbye!


```java
//STEP 1. Import required packages
import java.sql.*;

public class _06JDBC_UpdatingAResultSet {

	public static void printRs(ResultSet rs) throws SQLException{
		//Ensure we start with first row
		rs.beforeFirst();
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
		System.out.println();
	}//end printRs()	
	
	public static void main(String[] args) {
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Execute a query to create statment with
			// required arguments for RS example.
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//STEP 5: Execute a query
			String sql = "SELECT id, first, last, age FROM Employees"; 
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("List result set for reference....");
			printRs(rs);
			//STEP 6: Loop through result set and add 5 in age 
			//Move to BFR postion so while-loop works properly 
			rs.beforeFirst();
			//STEP 7: Extract data from result set 
			while(rs.next()){
				//Retrieve by column name
				int newAge = rs.getInt("age") + 5;
				rs.updateDouble( "age", newAge );
				rs.updateRow();
			}
			System.out.println("List result set showing new ages..."); printRs(rs);
			// Insert a record into the table.
			//Move to insert row and add column data with updateXXX() 
			System.out.println("Inserting a new record..."); 
			rs.moveToInsertRow();
			rs.updateInt("id",104);
			rs.updateString("first","John"); rs.updateString("last","Paul");
			rs.updateInt("age",40);
			//Commit row
			rs.insertRow();
			System.out.println("List result set showing new set...");
			printRs(rs);
			// Delete second record from the table.
			// Set position to second record first
			rs.absolute( 2 );
			System.out.println("List the record before deleting...");
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
			//Delete row
			rs.deleteRow();
			System.out.println("List result set after deleting one records...");

			printRs(rs);
			//STEP 8: Clean-up environment
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
}
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

