# JDBC in java
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

