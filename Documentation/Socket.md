
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

### 02LocalPortScanner2
```java
package com.abdullah._04javaSockets;
import java.io.IOException;
import java.net.ServerSocket;
//➜  ~ netstat -a
public class _02LocalPortScanner2 {

	public static void main(String[] args) {
		int port = 1;
		int openport = 0;
		while (port <=65535) {
			try {
				ServerSocket server  = new ServerSocket(port);
				//System.out.println("port is free");
			} catch (IOException e) {
				System.out.println("Port "+port +" is open ");
				openport++;
			}
			port++;
		}
		System.out.println("total open port is : "+openport);
		

	}

}
```

### 03 TCPServer
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class _03TCPServer {
/**
➜  ~ telnet 127.0.0.1 9090
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
Hello client!
hi cm abdullah
Connection closed by foreign host.
➜  ~ 
//when we send data via tcp first we create a connection
 * once the tcp connection is established  tcp gruntee that data arrived
 * the end, or it will tell you that an error occurred. 
 * **/
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket  = new ServerSocket(9090);//bind with this port number....
		System.out.println("witing for clients....");
		Socket socket = serverSocket.accept();
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);//write message
		out.println("Hello client!");
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));//read message....
		String clientInput = input.readLine();
		System.out.println(clientInput);
		input.close();
		out.close();
		socket.close();
		serverSocket.close();
	}
}

```



### 04MultiUserServer
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class _04MultiUserServer {
/**
➜  ~ telnet 127.0.0.1 9090
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
Hello client!
cannot create multi connection at a time
 * **/
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket serverSocket  = new ServerSocket(9090);
			System.out.println("witing for clients....");
			boolean stop = false;
			while(!stop) {
				Socket socket = serverSocket.accept();
				PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				out.println("Hello client!");
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String clientInput = input.readLine();
				System.out.println(clientInput);
				input.close();
				out.close();
				socket.close();
			}
			serverSocket.close();			
		} catch (Exception e) {
			System.out.println("Exception thrown....");
		}

	}
}

```
### 05 MultiThreadedServer
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread{
	private Socket socket = null;
	public ClientThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			out.println("Hello client!");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientInput = input.readLine();
			System.out.println(clientInput);
			input.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}



public class _05MultithreadedServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket  = new ServerSocket(9090);
			boolean stop = false;
			while(!stop) {
				System.out.println("witting for connection....");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client is connected");
				ClientThread clientThread = new ClientThread(clientSocket);
				clientThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

```

### 06 InetAddress
```java
package com.abdullah._04javaSockets;
import java.net.InetAddress;

public class _06InetAddress {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
			
			InetAddress address2 = InetAddress.getByName("google.com");
			System.out.println(address2.getHostAddress());
			System.out.println(address2.getHostName());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

```

### 07 TCPClient
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class _07TCPClient {
	public static void main(String[] args) {
		try {
			InetAddress serverAddress = InetAddress.getByName("localhost");
			System.out.println(serverAddress.getHostAddress());
			Socket socket = new Socket(serverAddress , 9090);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(input.readLine());
			out.println("Hello server!!!");
			out.close();
			input.close();
			socket.close();
			
		}catch(UnknownHostException e) { 
			System.out.println(e.toString());
		}catch(IOException e) { 
			System.out.println(e.toString());
		}catch(IllegalArgumentException e) { 
			System.out.println(e.toString());
		}catch(Exception e) { 
			System.out.println(e.toString());
		}
		
	}	
}
```
### 08 RemotePortScanner
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class _08RemotePortScanner {
//pc connected ip to local area network....
//i will test this programm later
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		String targetIp = "";
		int fromPort = 0;
		int toPort = 0;
		System.out.println("please enter ip address");
		try {
			targetIp = reader.readLine();
		} catch (Exception e) {
			System.out.println("Cannot read this ip address : "+e.toString());
		}
		boolean isValid = false;
		while(!isValid) {
			try {
				System.out.println("please enter the first port : ");
				String portString = reader.readLine();
				fromPort = Integer.parseInt(portString);
				if (fromPort >= 0 && fromPort <=65536) {
					isValid = true;
				}else {
					System.out.println("invalid port ");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Please insert a number "+e.toString());
			} catch (Exception e) {
				System.out.println("Cannot read the first port ...."+e.toString());
			}
		}
		
		isValid = false;
		while(!isValid) {
			try {
				System.out.println("please enter the last port : ");
				String portString = reader.readLine();
				toPort = Integer.parseInt(portString);
				if (toPort >= 0 && toPort <=65536) {
					if (toPort >= fromPort) {
						isValid = true;
					}
				}else {
					System.out.println("invalid port ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please insert a number "+e.toString());
			} catch(Exception e) {
				System.out.println("Cannot read the last port ...."+e.toString());
			}
		}
		
		int port = fromPort;
		while(port >= fromPort && port<= toPort) {
			try {
				Socket socket  = new Socket(targetIp, port);
				System.out.println("Your ip address is : "+ targetIp + " and port number is : "+port+" this port is listening state......");
				socket.close();
			} catch(UnknownHostException e) { 
				System.out.println("Unknown host exception : "+e.toString());
			} catch(IOException e) { 
				System.out.println("Port : "+port+" is not open...."+e.toString());
			} catch(IllegalArgumentException e) { 
				System.out.println(e.toString());
			} catch(Exception e) { 
				System.out.println(e.toString());
			}
			port++;
		}
	}
}
```


### 09 Ping
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class _09Ping {

	public static void main(String[] args) {
		String hostAddress = "google.com";
		try {
			InetAddress host = InetAddress.getByName(hostAddress);
			System.out.println(host.isReachable(1000));
			Process p = Runtime.getRuntime().exec("ping"+ hostAddress);
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String commandOutput = "";
			boolean isReachable = true;
			while((commandOutput = inputStream.readLine()) != null) {
				System.out.println(commandOutput);
				/***
				if (commandOutput.contains("Destination host unreachable ...")) {
					isReachable = false;
					break;
				}
				* */
			}
			/****
			if (isReachable) {
				System.out.println("host is reachable....");
			}else {
				System.out.println("Host is not reachable....");
			}
			***/
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

```


### 10 ValidateIPAddresses
```java
package com.abdullah._04javaSockets;
public class _10ValidateIPAddresses {

	public static void main(String[] args) {
		String ipAddress = "172.0.0.1";
		/***
		//dependency apache commons validator api
		InetAddressValidator validator = new InetAddressValidator();
		boolean isValid = validator.isValid(ipAddress);
		if (isValid) {
			System.out.println("Ip address is Valid "+ ipAddress);
		}else {
			System.out.println("Ip address is not valid "+ipAddress);
		}
		***/
		
		boolean isValid = validateIpAddress(ipAddress);//our own method
		if (isValid) {
			System.out.println("Ip address is Valid "+ ipAddress);
		}else {
			System.out.println("Ip address is not valid "+ipAddress);
		}
		
		

	}
	public static boolean validateIpAddress(String ipAddress) {
		String [] number = ipAddress.split("\\.");
		if (number.length != 4) {
			return false;
		}
		for (String str : number) {
			int i = Integer.parseInt(str);
			if (i<0 || i>255) {
				return false;
			}
		}
		return true;
	}
}

```

### 11 NetworkInterfaceClass
```java
package com.abdullah._04javaSockets;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.List;

public class _11NetworkInterfaceClass {

	public static void main(String[] args) {
		// a network interface is point of interconnection between a computer on public and private network.... 
		// a network interface is generally network interface card....
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
			//NetworkInterface networkInterface = NetworkInterface.getByName("lo0");

			if (networkInterface != null) {
				System.out.println("NIC Name " + networkInterface.getName());
				System.out.println("NIC display name "+networkInterface.getDisplayName());
				//returns null dont know why?????
				System.out.println("NIC Get Hardware Adddress (MAC) "+convertByteToString(networkInterface.getHardwareAddress()));
				System.out.println("MTU "+networkInterface.getMTU());
				System.out.println("Index "+networkInterface.getIndex());
				
				NetworkInterface parentInterface = networkInterface.getParent();
				if (parentInterface != null) {
					System.out.println("Parent interface "+ parentInterface.getDisplayName());
				}else {
					System.out.println("No parent address.....");
				}
				
				System.out.println("Is loopback ! "+networkInterface.isLoopback());
				System.out.println("Is up "+networkInterface.isUp());
				System.out.println("Is virtual "+networkInterface.isVirtual());
				System.out.println("Support Multicust "+networkInterface.supportsMulticast());
				
				List<InterfaceAddress> list  = networkInterface.getInterfaceAddresses();
				for (InterfaceAddress interfaceAddress : list) {
					System.out.println("Ip address : "+interfaceAddress.getAddress().getHostAddress());
				}
				System.out.println("");
			}else {
				System.out.println("interface not found......");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static String convertByteToString(byte [] mac) {
		
		if (mac == null)
			return null;

		StringBuilder sb = new StringBuilder(18);
		for (byte b : mac) {
			if (sb.length() > 0 )
				sb.append(':');
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
}

```


### 12 URLandWebScraping
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12URLandWebScraping {

	public static void main(String[] args) throws IOException {
		System.out.println("hii");
		URL url = new URL("http://finance.yahoo.com/q?s=ORCL");
		URLConnection myurl = url.openConnection();//return input stream object
		BufferedReader in = new BufferedReader(new InputStreamReader(myurl.getInputStream()));
		String inputLine;
		String pattern = "<span id=\"yfs_184_orcl\">(.+?)</span>";
		Pattern r = Pattern.compile(pattern);
		while((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			if (inputLine.contains("yfs_184_orcl")) {
				Matcher m = r.matcher(inputLine);
				if (m.find()) {
					System.out.println(m.group(1));
				}
			}
		}
		in.close();
	}
}

```


### 13 URLandWebScrapingCM
```java
package com.abdullah._04javaSockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13URLandWebScrapingCM {

	public static void main(String[] args) throws IOException {
		System.out.println("hii");
		URL url = new URL("http://finance.yahoo.com/q?s=ORCL");
		URLConnection myurl = url.openConnection();//return input stream object
		BufferedReader in = new BufferedReader(new InputStreamReader(myurl.getInputStream()));
		String inputLine;
		
		while((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			
		}
		in.close();
	}
}

```


### 01 UDPClient
```java
package com.abdullah._05JavaUDPprogramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class _01UDPClient {

	public static void main(String[] args) {
		/**
		 *  UDP is connection less protocol that does not create connection between source and destination 
		 *  Instead it delivered package as soon as possible
		 *  with UDP you just send packets of data (Datagrams) to some
		 *  ip address on the network.
		 *  you have no guarantee that data will arrived or not.
		 *  also no guarantee that about the order of data.
		 *  UDP is less protocol overhead then TCP
		 *  if multiple UDP packet arrived at the destination all of them
		 *  must wait in a queue before all their preceding packets are
		 *  processed at a time.
		 *  because it strictly process one packet at a time....
		 *  the application program using the service of UDP 
		 *  must fulfill all additional requirements....
		 *  to send data put data into DatagramPacket
		 *  and send the packet using datagram socket
		 *  in UDP everything about datagram, including address to which
		 *  is directed is included in the packet itself.
		 *  socket only know the local port on which to listen
		 *  in the packet itself.
			➜  src git:(master) ✗ javac com/abdullah/_05JavaUDPprogramming/_01UDPClient.java
			➜  src git:(master) ✗ java com/abdullah/_05JavaUDPprogramming/_01UDPClient     
			From Server : Hello client!!!!
		 * */
		
		try {
			//this constructor take an integer represent a port number
			// it can be any integer....
			//you only specify local port to connect to......
			DatagramSocket clientSocket = new DatagramSocket(0);
			//DatagramSocket clientSocket = new DatagramSocket();
			byte [] sendData = new byte[1024];//store outgoing data
			byte [] receiveData = new byte[1024];//sore incomming data
			//amount of data 65535 -20(ip address) -8(UDP Header) = 65508
			InetAddress serverAddress = InetAddress.getByName("localhost");
			clientSocket.setSoTimeout(3000);//set timeout period
			String StringSendData = "hello Server!!!";
			sendData = StringSendData.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,serverAddress,9090);
			clientSocket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			receiveData = receivePacket.getData();
			String stringReceiveData = new String(receiveData);
			System.out.println("From Server : "+stringReceiveData);
			clientSocket.close(); 
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

```

### 02UDPServer
```java
package com.abdullah._05JavaUDPprogramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class _02UDPServer {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(9090);
			byte [] receiveData = new byte[1024];//sore incomming data
			byte [] sendData = new byte[1024];//store outgoing data

			while(true) {
				
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				String  receiveDataFromClient = new String( receivePacket.getData());
				System.out.println("Received data from client : " + receiveDataFromClient);
				
				String stringData = "Hello client!!!!";
				sendData = stringData.getBytes();
				InetAddress clientIpAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,clientIpAddress , port);
				socket.send(sendPacket);	
				
			}
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}
	}

}

```

### 03UDPServerOnlyReceiveData
```java
package com.abdullah._05JavaUDPprogramming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//this server only receive data
public class _03UDPServerOnlyReceiveData {
/***
 * this is different from tcp server,
 * tcp server produce seperate thread to process each client request
 * tcp server process defferent client request independently
 * udp server accept both client using single thread
 * as experiment purpose we created 2 client
 * _04UDPClient04
 * _05UDPClient05
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {

		DatagramSocket socket = new DatagramSocket(9090);
		byte[] receiveData = new byte[1024];// sore incomming data

		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socket.receive(receivePacket);
			String receiveDataFromClient = new String(receivePacket.getData());
			System.out.println("Received data from client : " + receiveDataFromClient);
		}
	}
}

```


### 04 UDPClient04
```java
package com.abdullah._05JavaUDPprogramming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//this client only send data
public class _04UDPClient04 {

	public static void main(String[] args) throws IOException {

		DatagramSocket clientSocket = new DatagramSocket(0);
		byte[] sendData = new byte[1024];// store outgoing data
		// amount of data 65535 -20(ip address) -8(UDP Header) = 65508
		InetAddress serverAddress = InetAddress.getByName("localhost");
		boolean stop = false;
		while (!stop) {
			String StringSendData = "Client 04  message";
			sendData = StringSendData.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
			clientSocket.send(sendPacket);
		}
		clientSocket.close();
	}
}

```


### 05 UDPClient05
```java
package com.abdullah._05JavaUDPprogramming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//this client only send data
public class _05UDPClient05 {

	public static void main(String[] args) throws IOException {

		DatagramSocket clientSocket = new DatagramSocket(0);
		byte[] sendData = new byte[1024];// store outgoing data
		// amount of data 65535 -20(ip address) -8(UDP Header) = 65508
		InetAddress serverAddress = InetAddress.getByName("localhost");
		boolean stop = false;
		while (!stop) {
			String StringSendData = "Client 05 message";
			sendData = StringSendData.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
			clientSocket.send(sendPacket);
		}
		clientSocket.close();
	}
}

```
# _07FileTransferApplication

## FileTransferApplicationServerSide
### 
```java
package com.abdullah._07FileTransferApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
Last login: Tue Aug 21 20:25:39 on ttys001
➜  src git:(master) ✗ pwd
/Users/cmabdullahkhan/Documents/workspace/CollectionFramework/JavaSockets/src
➜  src git:(master) ✗ javac com/abdullah/_07FileTransferApplication/_01FileTransferApplicationServerSide.java
➜  src git:(master) ✗ java com/abdullah/_07FileTransferApplication/_01FileTransferApplicationServerSide      
hii
witing for clients....
File name : IELTS.md has been requested by 127.0.0.1
Absolute path is : /Users/cmabdullahkhan/Documents/workspace/CollectionFramework/JavaSockets/src/IELTS.md
File has sent successfully...
 * */
public class _01FileTransferApplicationServerSide {

	public static void main(String[] args) {
		System.out.println("hii");
		try {
			ServerSocket serverSocket  = new ServerSocket(9090);//bind with this port number....
			System.out.println("witing for clients....");
			boolean isStopped = false;
			while(!isStopped) {
				Socket clientSocket = serverSocket.accept();
				ClientThread clientThread = new ClientThread(clientSocket);
				clientThread.start();
			}
			
			
		} catch (Exception e) {
			System.out.println("port is already opened , please assigne another port ...."+e.toString());
		}
	}

}

```

## FileTransferApplicationClientSide

### 
```java
package com.abdullah._07FileTransferApplication;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.validator.routines.InetAddressValidator;

public class _02FileTransferApplicationClientSide {

	public static void main(String[] args) {
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
			String ipAddress = "";
			String fileName = "";
			boolean isValid = false;

			while (!isValid) {
				System.out.println("Please enter valid server Ip : ");
				// read ip address
				ipAddress = reader.readLine();
				InetAddressValidator validator = new InetAddressValidator();
				isValid = validator.isValid(ipAddress);
			}

			System.out.println("Please enter file name : ");
			fileName = reader.readLine();
			Socket socket = new Socket(ipAddress, 9090);
			InputStream inputByte = socket.getInputStream();
			BufferedInputStream input = new BufferedInputStream(inputByte);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//send file
			out.println(fileName);
			int code = input.read();
			if (code == 1) {
				BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(
						"/Users/cmabdullahkhan/Documents/Eworkspace/JavaSockets/src/" + fileName));
				byte[] buffer = new byte[1024];
				int byteRead = 0;
				while ((byteRead = input.read()) != -1) {
					System.out.println(".");
					outputFile.write(buffer, 0, byteRead);
					outputFile.flush();
				}
				outputFile.close();
				System.out.println("File : " + fileName + " has successfully downloaded...");
			} else {
				System.out.println("File is not present...");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}

```

# SimpleWebServerApplication

## ClinetThread

### 
```java
package com.abdullah._08SimpleWebServerApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClinetThread extends Thread{
	
	private Socket socket;
	private boolean isStop ;
	private BufferedReader in;
	private PrintWriter out;
	private File file;
	final static String CRLF = "\r\n";
	
	
	public ClinetThread(Socket socket) {
		this.socket = socket;
		this.isStop = false;
	}
	
	public void run() {
		try {
			
			while (!isStop) {
				//create buffered reader
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//create print writer....
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				String line = "";
				String httpHeader = "";//store html header....
				String htmlFile = ""; //store required html file....
				while (true) {
					line = in.readLine();//read each line
					if (line.equals(CRLF) || line.equals("")) {//end of the header...
						break;
					}
					httpHeader = httpHeader + line + "\n" ;
					
					if (line.contains("GET")) {
						//extract the html file....
						int beginIndex = line.indexOf("/");
						int endIndex = line.indexOf(" HTTP");
						htmlFile = line.substring(beginIndex+1, endIndex);
					}
				}
				System.out.println(httpHeader);//print http header....
				processRequest(htmlFile);
				closeConnection();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public void processRequest(String htmlFile) throws IOException {
		File file = new File(htmlFile);//create file variable
		System.out.println("Absolute path is : "+file.getAbsolutePath());
		if (file.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			//send http head (HTTP 200 ok)
			out.print("HTTP/1.0 200 OK"+CRLF);
			Date date = new Date();
			out.print("Date : "+date.toString() + CRLF);
			out.print("Server : Java tiny web Server "+CRLF);
			out.print("Content-Type : text/html"+CRLF);
			out.print("Content-Legth : "+file.length()+CRLF);
			out.println("Content-Type : text/html ; charset=iso-8859-1"+CRLF);
			//end of the header....
			
			String line = "" ;
			while ((line = reader.readLine()) != null) {//read the line from html file
				out.println(line);//write the line to the socket connection
			}
	
		} else { //if file doesnot exist
			//send http head (404 not found)
			out.print("HTTP/1.0 404 Not Found"+CRLF);
			Date date = new Date();
			out.print("Date : "+date.toString() + CRLF);
			out.print("Server : Java tiny web Server "+CRLF);
			out.print("Connnection : Closed"+CRLF);
			out.println("Content-Type : text/html ; charset=iso-8859-1"+CRLF);
			//end of the header....
			
			//send file not found
			out.println("<html><head>");
			out.println("<title>404 not found</title>");
			out.println("</head><body>");
			out.println("<h1>Not Found</h1>");
			out.println("<p> the request url /" +htmlFile + " was not found");
			out.println("</body></html>");
			out.println(CRLF);	
		}
	}
	
	private void closeConnection() {
		try {
			out.close();
			in.close();
			socket.close();
			isStop = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

```

## Main

### 
```java
package com.abdullah._08SimpleWebServerApplication;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			Socket clientSocket = serverSocket.accept();//accept client request
			System.out.println("Client " +clientSocket.getInetAddress().getHostAddress()+ " is connected");
			ClinetThread clinetThread = new ClinetThread(clientSocket);
			clinetThread.start();

		} catch (Exception e) {
			System.out.println("Port is open "+e.toString());
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


### 
```java

```


### 
```java

```









