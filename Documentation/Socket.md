
### 01 Local Port Scanner
```java
package com.abdullah._04javaSockets;
import java.io.IOException;
import java.net.ServerSocket;

public class _01LocalPortScanner1 {

	public static void main(String[] args) {

			try {
				ServerSocket server  = new ServerSocket(3306);
				System.out.println("server object created successfully");

			} catch (IOException e) {
				//if port is used by another application
				System.out.println("Port is open ");//if port is used by another application
				//if port is open server object cannot be created
			}
	}
}
```

### 
```java

```

### 
```java

```



### 
```java

```
### 
```java

```


