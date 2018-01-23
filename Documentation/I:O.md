# Now I am following [Thinking In Java](https://goo.gl/vmjMJs) & [The complete referrence](https://bit.do/cmabdullah)Book 

# Reading/Writing Character
## 01 Copying character from one file to another file
```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _01ReadingANdWritingCharacters {

	public static void main(String[] args) {

		File inp = new File("input.txt");//create file
		File outp = new File("output.txt");
		FileReader inFile = null;
		FileWriter outFile = null;
		try {
			inFile = new FileReader(inp);//open file
			outFile = new FileWriter(outp);
			int ch;
			while ((ch = inFile.read())!=-1) {
				outFile.write(ch);
			}
			System.out.println("File write successfully");
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		finally{
			try {
				inFile.close();
				outFile.close();
			}catch(IOException e) {
				
			}
		}
	}
}

```




# Reading/Writing Byte
## 02 Writing byte to a file
```java
import java.io.FileOutputStream;
import java.io.IOException;

public class _02ReadingAndByte {
	public static void main(String[] args) {
		// Declear and initialize a byte array
		byte cities[] = {'D','H','A','K','A','\n', 'B', 'A', 'R','I','S','A','L'};
		FileOutputStream outp = null;//create an output file stream
		try {
			outp = new FileOutputStream("Result.txt");// connect to output file Result.txt
			outp.write(cities);// write data to the stream
			outp.close();
		}catch(IOException e) {
			System.out.println(e);
			System.exit(-1);
		}
		System.out.println("Result is made successfully");
	}
}
```








# 
## 03 Reading Byte From Terminal
```java
import java.io.FileInputStream;
import java.io.IOException;
/****
➜  src git:(master) ✗ ls
CopyingCharacter.java               _03ReadingByteFromFile.class
_01ReadingANdWritingCharacters.java _03ReadingByteFromFile.java
_02ReadingAndByte.java              city.txt
➜  src git:(master) ✗ javac _03ReadingByteFromFile.java   
➜  src git:(master) ✗ java _03ReadingByteFromFile city.txt
Dhaka
Borisal
Amtali
➜  src git:(master) ✗ 
 * ***/
public class _03ReadingByteFromFile {
	public static void main(String[] args) {
		FileInputStream infile = null;
		int b;
		try {
			infile = new FileInputStream(args [0]);// connect infile stream to requires file
			while ((b = infile.read()) != -1) {
				System.out.print((char)b);
			}
			infile.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
```

# 
## ~~04 Reading ByteFrom File~~
```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _04ReadingByteFromFile {

	public static void main(String[] args) {
		File infile = new File("input.txt");
		File outFile = new File("outfile.txt");
		FileReader ins = null;
		FileWriter outs = null;
		try {
			ins = new FileReader(infile);
			//System.out.print("File read successfully");
			outs = new FileWriter(outFile);
			int ch;
			//System.out.println("Read character : "+ins.read());
			while ((ch = ins.read()) != -1) {
				outs.write(ch);	
			}
			System.out.println("Success");
		}catch(IOException e) {
			System.out.print(e);
			System.exit(-1);
		}
		finally {
			try {
				ins.close();
				outs.close();
			}catch(IOException e) {
				
			}
		}
	}
}
```

# 
## 05 Copying Byte From One File To Another File
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _05CopyingByteFromOneFileToAnotherFile {

	public static void main(String[] args) {
		FileInputStream inFile = null;// input stream
		FileOutputStream outFile = null;
		byte byteRead;
		try {
			inFile = new FileInputStream("input.txt");//open file
			outFile = new FileOutputStream("out.txt");
			do {
				byteRead = (byte)inFile.read();
				outFile.write(byteRead);
			}while(byteRead != -1);
			System.out.println("Success");
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException e) {	
			System.out.println(e.getMessage());
		}
		finally {
			try {
				inFile.close();
				outFile.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
```

# 
## 06 Read Write Primitive Value
```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _06ReadWritePrimitiveValue {

	public static void main(String[] args) throws Exception {
		File primitive = new File("prim.dat");
		FileOutputStream fos = new FileOutputStream(primitive);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(2018);//write primitive data to prim.dat
		dos.writeBoolean(true);
		dos.writeDouble(2018.001);
		dos.writeChar('F');
		dos.close();
		fos.close();
		//read data from file
		FileInputStream fis = new FileInputStream(primitive);
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readDouble());
		fis.close();
		dis.close();	
	}
}
```

# 
## 07 Using A Single File For Storing And Retriving
```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07UsingASingleFileForStoringAndRetriving {
	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		File intFile = new File("inputN.txt");
		try {
			dos =new DataOutputStream(new FileOutputStream(intFile));
			for (int x = 0; x<20; x++) {
				int y;
				y = (int)(Math.random()*100);
				dos.writeInt(y);
				//System.out.println(y);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				dos.close();
			}catch(IOException e) {
				
			}
		}
		
		//read int form file
		try {
			dis = new DataInputStream(new FileInputStream(intFile));
			for (int i = 0; i<20;i++) {
				int n;
				n = dis.readInt();
				System.out.print(n+" ");
			}
		}catch(IOException e) {
			System.out.println(e.getCause());
		}
		finally {
			try {
				dis.close();
			}catch(IOException e) {
				
			}
		}
	}
}
```

# 
## 08 Concatennating And Buffering File
```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class _08ConcatennatingAndBufferingFile {

	public static void main(String[] args) throws IOException{
		System.out.println("Hello");
		FileInputStream file1 = null;
		FileInputStream file2 = null;
		//Declere file3 to store value
		SequenceInputStream file3 = null;
		file1 = new FileInputStream("text1.dat");
		file2 = new FileInputStream("text2.dat");
		file3 = new SequenceInputStream(file1,file2);
		BufferedInputStream inBuffer = new BufferedInputStream(file3);//create buffer i/o
		BufferedOutputStream outBuffer = new BufferedOutputStream(System.out);
		//read and write till end
		int ch;
		while ((ch= inBuffer.read()) != -1) {
			outBuffer.write(ch);
		}
		inBuffer.close();
		outBuffer.close();
		file1.close();
		file2.close();
	}
}
```

# 
## 09 Create File Interactively From Keyboard (Depredicted)
```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class _09CreateFileInteractivelyFromKeyboard {
	static DataInputStream din = new DataInputStream(System.in);
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("invert.dat"));
		//reading from the console
		System.out.println("Enter code number");
		st = new StringTokenizer(din.readLine());
		int code = Integer.parseInt(st.nextToken());
		System.out.println("Enter number of items");
		st = new StringTokenizer(din.readLine());
		int items = Integer.parseInt(st.nextToken());
		System.out.println("Enter Cost");
		st = new StringTokenizer(din.readLine());
		double cost =new Double(st.nextToken()).doubleValue();
		//Writing to the file "invent.dat"
		dos.writeInt(code);
		dos.write(items);
		dos.writeDouble(cost);
		dos.close();
		//processing data drom the file
		DataInputStream dis = new DataInputStream(new FileInputStream("invert.dat"));
		int codeNumber = dis.readInt();
		int totalItems = dis.readInt();
		double itemCost = dis.readDouble();
		//double totalCost = totalItems*itemCost;
		dis.close();
		//writing to console
		System.out.println();
		System.out.println("Code number : "+codeNumber);
		System.out.println("total Items"+totalItems);
		System.out.println("item Cost"+itemCost);
		//System.out.println("total Cost"+totalCost);
	}
}
```

# 
## 10 Use Buffer Reader To Read Character From Terminal
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _10UseBufferReaderToReadCharacterFromConsole {

	public static void main(String[] args) throws IOException{
		
		char c;
		BufferedReader br = null;
		br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 'q' to quite");
		do {
			c = (char)br.read();
			System.out.print(c);
		}while(c !='q');
	}
}
```

# 
## 11 Use Buffer Reader To Read String From Terminal
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _11UseBufferReaderToReadStringFromConsole {

	public static void main(String[] args) throws IOException{
		BufferedReader br = null;
		InputStreamReader ir = null;
		ir = new InputStreamReader(System.in);
		br = new BufferedReader(ir);
		String str;
		System.out.println("Enter line of text");
		System.out.println("Enter quite for stop");
		do {
			str = br.readLine();
			System.out.println(str);
		}while(!str.equals("quite"));
	}
}
```
# 
## 12 Use Buffer Reader To Read String Array From Terminal
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _12UseBufferReaderToReadStringArrayFromConsole {

	public static void main(String[] args) throws IOException{
		InputStreamReader ir = null;
		ir = new InputStreamReader(System.in);
		BufferedReader br = null;
		br = new BufferedReader(ir);
		String[] str = new String[100];
		for (int i = 0; i<100;i++) {
			str[i] = br.readLine();
			if (str[i].equals("stop"))
				break;
		}
		for (int i = 0; i<100;i++) {
			if (str[i].equals("stop"))
				break;
			System.out.println(str[i]);			
		}
	}
}
```
# 
## 13 Writing Console Output USing SystemOutWriteMethod
```java

public class _13WritingConsoleOutputUSingSystemOutWriteMethod {

	public static void main(String[] args) {
		int c;
		c = 'A';
		System.out.write(c);	
		System.out.write('\n');	
	}
}
```
# 
## 14 Demonstrate PrintWriter
```java
import java.io.PrintWriter;

public class _14DemonstratePrintWriter {

	public static void main(String[] args) {
		PrintWriter pw = null;
		pw = new PrintWriter(System.out, true);
		pw.println("hi C M ");// do not use print()
		String name = "Abdullah";
		pw.println(name);
	}
}
```
# 
## 15 Display A Text File Input From Terminal
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/***
➜  src git:(master) ✗ ls
Test.txt
_15DisplayATextFileInputFromTerminal.java
➜  src git:(master) ✗ javac _15DisplayATextFileInputFromTerminal.java
➜  src git:(master) ✗ java _15DisplayATextFileInputFromTerminal Test.txt
Bangladesh officially the People's Republic of Bangladesh, is a country in South Asia. It shares land borders with India and Myanmar (Burma). Nepal, Bhutan and China are located near Bangladesh but do not share a border with it.
￿%                                                                              ➜  src git:(master) ✗ 
 * **/
public class _15DisplayATextFileInputFromTerminal {

	public static void main(String[] args) throws IOException {
		int i;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(args[0]);
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Usage: Show File");
			return;
		}
		do {
			i = fin.read();
			System.out.print((char)i);
		}while(i != -1);
		fin.close();
	}
}
```
# 
## 16 Copy One Text File To Another Input From Terminal
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class _16CopyOneTextFileToAnotherInputFromTerminal {

	public static void main(String[] args) throws IOException{
		int i;
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			try {
				fin = new FileInputStream(args[0]);
			}catch(FileNotFoundException e) {
				System.out.println("File not found ");
				return;
			}
			
			try {
				fout = new FileOutputStream(args[1]);
			}catch(FileNotFoundException e) {
				System.out.println("Error not open file");
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Copy file from To");
			return ;
		}
	
		try {
			do {
				i = fin.read();
				if (i != -1) fout.write(i);
			}while(i!= -1);				
		}catch(IOException e) {
			System.out.print("File error");
		}
	fin.close();
	fout.close();
	}
}
```
# 
## 
```java

```
