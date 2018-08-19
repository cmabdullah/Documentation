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
## 18 Determines If The Path It References Exists Within The FileSystem
```java
import java.io.File;

public class _17DeterminesIfThePathItReferencesExistsWithinTheFileSystem {

	public static void main(String[] args) {
		File file = new File("input.txt");
		System.out.println(file.exists());
	}
}
```

# 
## 18 Read File Information
```java
import java.io.File;
public class _18ReadFileInformation {
	
	public static void main(String[] args) {
		File file = new File("input.txt"); 
		System.out.println("File Exists: "+file.exists()); 
			if(file.exists()) {
				System.out.println("Absolute Path: "+file.getAbsolutePath()); 
				System.out.println("Is Directory: "+file.isDirectory()); 
				System.out.println("Parent Path: "+file.getParent()); 
				if(file.isFile()) {
				System.out.println("File size: "+file.length());
				System.out.println("File LastModified: "+file.lastModified()); 
				} 
			else {
				for(File subfile: file.listFiles()) { 
					System.out.println("\t"+subfile.getName());
				} 
			}
		}
	}
}
```

# 
## 19 Copy Text File Sample
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _19CopyTextFileSample {

	public static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;
			while((s = reader.readLine()) != null) {
				data.add(s); }
		}
		return data; 
	}
	public static void writeFile(List<String> data, File destination) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter(destination))) {
			for(String s: data) { writer.write(s);
			writer.newLine(); }
			} 
		}
	public static void main(String[] args) throws IOException{
		File source = new File("Zoo.csv");
		File destination = new File("ZooCopy.csv");
		List<String> data = readFile(source);
		for(String record: data) { System.out.println(record);
		}
		writeFile(data,destination);
	}
}
```

# 
## 20 Object Stream Sample
```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//animal class start
class Animal implements Serializable { 
	private static final long serialVersionUID = 1L; 
	private String name;
	private int age;
	private char type;
	public Animal(String name, int age, char type) { 
		this.name = name;
		this.age = age;
		this.type = type;
	}
	public String getName() { 
		return name; 
	} 
	public int getAge() { 
		return age; 
	} 
	public char getType() { 
		return type; 
	}
	public String toString() {
	return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	} 
}

//end animal class
public class _20ObjectStreamSample {

	public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>(); 
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(dataFile)))) { 
			while(true) {
				Object object = in.readObject(); 
				if(object instanceof Animal)
					animals.add((Animal)object); 
			}
		} catch (EOFException e) { // File end reached
		}
		return animals; 
	}

	public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for(Animal animal: animals) out.writeObject(animal);
		} 
	}

	public static void main(String[] args)  throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>(); 
		animals.add(new Animal("Tommy Tiger",5,'T')); 
		animals.add(new Animal("Peter Penguin",8,'P'));
		File dataFile = new File("animal.data"); 
		createAnimalsFile(animals,dataFile); 
		System.out.println(getAnimals(dataFile));
	}
}
```

# 
## 21 Sample Print Writer
```java
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _21SamplePrintWriter {

	public static void main(String[] args) throws IOException{
		File source = new File("Zoo.csv");
		try (PrintWriter out = new PrintWriter(
		new BufferedWriter(new FileWriter(source)))) { 
		out.print("Today's weather is: "); 
		out.println("Sunny");
		out.print("Today's temperature at the zoo is: "); 
		out.print(1/3.0);
		out.println('C');
		out.format("It has rained 10.12 inches this year"); 
		out.println();
		out.printf("It may rain 21.2 more inches this year");
		}
	}
}
```

# 
## 22 SystemIn Sample Old Way
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _22SystemInSampleOldWay {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
		new InputStreamReader(System.in));
		String userInput = reader.readLine();
		System.out.println("You entered the following: "+userInput);
	}
}
```


# 
## 23 Console Sample New Way
```java
import java.io.Console;

public class _23ConsoleSampleNewWay {

	public static void main(String[] args) {
		Console console = System.console(); 
		if(console != null) {
		String userInput = console.readLine();
		console.writer().println ("You entered the following: "+userInput); }
	}
}
```


# 
## 24 Console Sample Print
```java
import java.io.Console;
import java.io.IOException;
public class _24ConsoleSamplePrint {

	public static void main(String[] args) throws NumberFormatException, IOException{
		Console console = System.console(); 
		if(console == null) {
		throw new RuntimeException("Console not available"); 
		} 
		else {
		console.writer().println("Welcome to Our Zoo!"); 
		console.format("Our zoo has 391 animals and employs 25 people."); 
		console.writer().println();
		console.printf("The zoo spans 128.91 acres.");
		}
	}
}
```


# 
## 25 Console Read Input Sample
```java
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;

public class _25ConsoleReadInputSample {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Console console = System.console(); 
		if(console == null) {
			throw new RuntimeException("Console not available"); 
		} 
		else {
			console.writer().print("How excited are you about your trip today? "); console.flush();
			String excitementAnswer = console.readLine();
			String name = console.readLine("Please enter your name: ");
			Integer age = null;
			console.writer().print("What is your age? "); 
			console.flush();
			BufferedReader reader = new BufferedReader(console.reader()); 
			String value = reader.readLine();
			age = Integer.valueOf(value);
			console.writer().println();
			console.format("Your name is "+name); 
			console.writer().println();
			console.format("Your age is "+age);
			console.printf("Your excitement level is: "+excitementAnswer);
		}
	}
}
```


# 
## 26 Password Compare Sample
```java
import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class _26PasswordCompareSample {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Console console = System.console(); 
		if(console == null) {
		throw new RuntimeException("Console not available"); 
		} 
		else {
			char[] password = console.readPassword("Enter your password: ");
			console.format("Enter your password again: "); 
			console.flush();
			char[] verify = console.readPassword();
			boolean match = Arrays.equals(password,verify);
			// Immediately clear passwords from memory for(int i=0; i<password.length; i++) {
			for(int i=0; i<verify.length; i++) { 
				verify[i]='x';
			}
			console.format("Your password was "+(match ? "correct": "incorrect"));
		}
	}
}
```



##  _28CharacterStreamsPartI.java
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _28CharacterStreamsPartI {

	public static void main(String[] args) {

		try {
			
			//OutputStreamWriter is used to write charecter support utf 8
			OutputStreamWriter out  =  new OutputStreamWriter(new FileOutputStream("Example4.txt"));
			InputStreamReader in  =  new InputStreamReader(new FileInputStream("Example4.txt"));
			//
			System.out.println(out.getEncoding());
			out.write("Hi cm abdullah");
			out.close();
			System.out.println("Write success");
			
			int data = in.read();
			while (data != -1) {
				System.out.print((char)data);
				data= in.read();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}


```
## _29BufferedStream
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class _29BufferedStream {

	public static void main(String[] args) {
		try {

			// FileWriter read characters insted of bytes
			BufferedReader reader = new BufferedReader(new FileReader("Example4.txt"), 1);
			BufferedWriter writer = new BufferedWriter(new FileWriter("Example5.txt"));
			String line;
			while ((line = reader.readLine()) != null ) {
				writer.write(line);
				writer.newLine();
			}
			writer.close();
			System.out.println("Write Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}


```
## _30System_in
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _30System_in {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the port number :");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		boolean isValid = false;
		
		int port = 0;
		while(!isValid) {
			try {
				String portString = reader.readLine();
				port = Integer.parseInt(portString);
				System.out.println("Port is accepted");
				isValid = true;
			}catch(Exception e) {
				System.out.println("Please insert a number!");
				System.out.println("Please enter port number : ");
			}
		}
		System.out.println("Please enter server ip :");
		String ipAddress = "";
		try {
			ipAddress = reader.readLine();
		} catch (Exception e) {
			System.out.println("Cannot read this ip address ");
		}
		System.out.println("Trying to connect to ip : "+ipAddress +" on port : "+port+".....");
	}
}

```


