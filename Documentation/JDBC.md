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


## 07 Date And Time Data Types
```java
//import java.sql.Date;
//import java.sql.Time;
//import java.sql.Timestamp;
//page 61
public class _07DateAndTimeDataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Get standard date and time
		java.util.Date javaDate = new java.util.Date(); 
		long javaTime = javaDate.getTime(); 
		System.out.println("The Java Date is:" +javaDate.toString());
		//Get and display SQL DATE
		java.sql.Date sqlDate = new java.sql.Date(javaTime); 
		System.out.println("The SQL DATE is: " + sqlDate.toString());
		//Get and display SQL TIME
		java.sql.Time sqlTime = new java.sql.Time(javaTime); 
		System.out.println("The SQL TIME is: " + sqlTime.toString());
		//Get and display SQL TIMESTAMP 
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime); 
		System.out.println("The SQL TIMESTAMP is: " + sqlTimestamp.toString());
	}
}
```


## 08 JDBC Transections Commit And Rollback

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//page 63
public class _08JDBC_TransectionsCommitAndRollback {

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
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//STEP 4: Set auto commit as false.
			conn.setAutoCommit(false);
			//STEP 5: Execute a query to create statment with
			// required arguments for RS example.
			System.out.println("Creating statement...");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//STEP 6: INSERT a row into Employees table
			System.out.println("Inserting one row....");
			String SQL = "INSERT INTO Employees " + "VALUES (106, 20, 'Rita', 'Tez')";
			stmt.executeUpdate(SQL);

			//STEP 7: INSERT one more row into Employees table 
			SQL = "INSERT INTO Employees " +"VALUES (107, 22, 'Sita', 'Singh')";
			stmt.executeUpdate(SQL);
			//STEP 8: Commit data here.
			System.out.println("Commiting data here....");
			conn.commit();
			//STEP 9: Now list all the available records.
			String sql = "SELECT id, first, last, age FROM Employees"; 
			ResultSet rs = stmt.executeQuery(sql); 
			System.out.println("List result set for reference....");

			printRs(rs);
			//STEP 10: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			// If there is an error then rollback the changes.
			System.out.println("Rolling back data here....");
			try{
				if(conn!=null)
					conn.rollback();
			}catch(SQLException se2){
				se2.printStackTrace();
			}//end try
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}//end main
}
```


## 09 JDBC Transections Commit And Rollbacks SavePoint
```java
//page 70
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
public class _09JDBC_TransectionsCommitAndRollbackSSavePoint {

	public static void printRs(ResultSet rs) throws SQLException{ //Ensure we start with first row
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
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");	

			//STEP 4: Set auto commit as false.
			conn.setAutoCommit(false);
			//STEP 5: Execute a query to delete statment with // required arguments for RS example. 
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			//STEP 6: Now list all the available records.
			String sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("List result set for reference....");
			printRs(rs);
			// STEP 7: delete rows having ID grater than 104
			// But save point before doing so.
			Savepoint savepoint1 = conn.setSavepoint("ROWS_DELETED_1");
			System.out.println("Deleting row....");
			String SQL = "DELETE FROM Employees " +
					"WHERE ID = 107";
			stmt.executeUpdate(SQL);
			// oops... we deleted too wrong employees!
			//STEP 8: Rollback the changes afetr save point 2.
			conn.rollback(savepoint1);
			// STEP 9: delete rows having ID grater than 104
			// But save point before doing so.
			Savepoint savepoint2 = conn.setSavepoint("ROWS_DELETED_2");
			System.out.println("Deleting row....");
			SQL = "DELETE FROM Employees " +
					"WHERE ID = 107";
			stmt.executeUpdate(SQL);
			//STEP 10: Now list all the available records.
			sql = "SELECT id, first, last, age FROM Employees";
			rs = stmt.executeQuery(sql);
			System.out.println("List result set for reference....");

			printRs(rs);
			//STEP 10: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			// If there is an error then rollback the changes.
			System.out.println("Rolling back data here....");
			try{
				if(conn!=null)
					conn.rollback();
			}catch(SQLException se2){
				se2.printStackTrace();
			}//end try
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}//end try
}//end main
```

## 10 JDBC Exceptions
```java
// page 75
import java.sql.*;
public class _10JDBC_Exceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");	
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();
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
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main
}//end JDBCExample
```

## 11 JDBC Batch Processing
```java
//page 80
import java.sql.*;
public class _11JDBC_BatchProcessing {
	public static void printRows(Statement stmt) throws SQLException{ 
		System.out.println("Displaying available rows...");
		// Let us select all the records and display them.
		String sql = "SELECT id, first, last, age FROM Employees"; 
		ResultSet rs = stmt.executeQuery(sql);
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
		rs.close();
	}//end printRows()

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			// Create statement
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			// Set auto-commit to false
			conn.setAutoCommit(false);
			// First, let us select all the records and display them.
			printRows( stmt );
			// Create SQL statement
			String SQL = "INSERT INTO Employees (id, first, last, age) " +
					"VALUES(200,'Zia', 'Ali', 30)";

			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);
			// Create one more SQL statement
			SQL = "INSERT INTO Employees (id, first, last, age) " +
					"VALUES(201,'Raj', 'Kumar', 35)";
			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);
			// Create one more SQL statement
			SQL = "UPDATE Employees SET age = 35 " +
					"WHERE id = 100";
			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);
			// Create an int[] to hold returned values
			int[] count = stmt.executeBatch();
			//Explicitly commit statements to apply changes
			conn.commit();
			// Again, let us select all the records and display them.
			printRows( stmt );
			// Clean-up environment
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
}
```

## 12 JDBC Batching With PrepareStatement Object
```java
import java.sql.*;
//page 86
public class _12JDBCBatchingWithPrepareStatementObject {

	public static void printRows(Statement stmt) throws SQLException{ 
		System.out.println("Displaying available rows...");	
		// Let us select all the records and display them.
		String sql = "SELECT id, first, last, age FROM Employees";
		ResultSet rs = stmt.executeQuery(sql);
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
		rs.close();
	}//end printRows()

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try{

			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			// Create SQL statement
			String SQL = "INSERT INTO Employees(id,first,last,age) " + "VALUES(?, ?, ?, ?)";
			// Create preparedStatemen
			System.out.println("Creating statement...");
			stmt = conn.prepareStatement(SQL);
			// Set auto-commit to false
			conn.setAutoCommit(false);
			// First, let us select all the records and display them.
			printRows( stmt );
			// Set the variables
			stmt.setInt( 1, 400 );
			stmt.setString( 2, "Pappu" );
			stmt.setString( 3, "Singh" );
			stmt.setInt( 4, 33 );
			// Add it to the batch
			stmt.addBatch();
			// Set the variables
			stmt.setInt( 1, 401 );
			stmt.setString( 2, "Pawan" );
			stmt.setString( 3, "Singh" );
			stmt.setInt( 4, 31 );
			// Add it to the batch
			stmt.addBatch();

			// Create an int[] to hold returned values
			int[] count = stmt.executeBatch();
			//Explicitly commit statements to apply changes
			conn.commit();
			// Again, let us select all the records and display them. 
			printRows( stmt );
			// Clean-up environment
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
}
```

## 13 JDBC Streaming Data



```java
//page 96
// Import required packages
import java.sql.*;
import java.io.*;
import java.util.*;

public class _13JDBCStreamingData {

	public static void createXMLTable(Statement stmt) throws SQLException{
		System.out.println("Creating XML_Data table..." ); //Create SQL Statement
		String streamingDataSql = "CREATE TABLE XML_Data " + "(id INTEGER, Data LONG)";
		//Drop table first if it exists.
		try{
			stmt.executeUpdate("DROP TABLE XML_Data");
		}catch(SQLException se){
		}// do nothing
		//Build table.
		stmt.executeUpdate(streamingDataSql);
	}//end createXMLTable

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			System.out.println("Connecting to database..."); 
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false","root","rootcm");
			//Create a Statement object and build table
			stmt = conn.createStatement();
			createXMLTable(stmt);
			//Open a FileInputStream
			File f = new File("/Users/abdullah/Documents/ServletAndJsp/jdbc/src/XML_Data.xml");
			long fileLength = f.length();
			FileInputStream fis = new FileInputStream(f);
			//Create PreparedStatement and stream data
			String SQL = "INSERT INTO XML_Data VALUES (?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,100);
			pstmt.setAsciiStream(2,fis,(int)fileLength);
			pstmt.execute();
			//Close input stream
			fis.close();

			// Do a query to get the row
			SQL = "SELECT Data FROM XML_Data WHERE id=100";
			rs = stmt.executeQuery (SQL);
			// Get the first row
			if (rs.next ()){
				//Retrieve data from input stream
				InputStream xmlInputStream = rs.getAsciiStream (1);
				int c;
				ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
				while (( c = xmlInputStream.read ()) != -1)
					bos.write(c);
				//Print results
				System.out.println(bos.toString());
			}
			// Clean-up environment
			rs.close();
			stmt.close();
			pstmt.close();
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
				if(pstmt!=null)
					pstmt.close();
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
}
```

#### XML_Data.xml
```xml
<?xml version="1.0"?>
<Employee>
<id>100</id>
<first>Zara</first>
<last>Ali</last>
<Salary>10000</Salary>
<Dob>18-08-1978</Dob>
</Employee>
```



```java

```
```java

```
```java

```
```java

```

