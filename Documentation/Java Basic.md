
# 1 HelloWorld

### 1.1 HelloWorld
```java
package _1HelloWorld;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld");
	}
}

```

# 2 I/o

### 2.1 InputInt_Float_doubleValue
```java
package _2Input;

import java.util.Scanner;

public class InputInt_Float_doubleValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var;
		Scanner x = new Scanner(System.in);
		var = x.nextInt();
		double doub= x.nextDouble();
		System.out.println("int value is :"+var+" Double value is :"+doub);	

	}

}

```
### 2.2 InputString
```java
package _2Input;

import java.util.Scanner;

public class InputString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s,t,u,v,w;
		String cc = null;
		System.out.println(cc);
		Scanner x = new Scanner(System.in);
		s = x.next();// object.next() is recommended 
		t = x.next();
		u = x.next();
		v = x.nextLine();//skipped this portion
		w = x.nextLine();
		System.out.println(s);
		System.out.println(t);
		System.out.println(u);
		System.out.println(v);
		System.out.println(w);
	}
}

```
### 2.3 StaticValueDecleration
```java
package _2Input;

public class StaticValueDecleration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "Hi Abdullah";
		System.out.println(x);
	}
}

```

# 3 If Else

### 3.1 IfElse
```java
package _3IfElse;
import java.util.*;
public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x = new Scanner(System.in);
		int val = x.nextInt();
		if (val == 20){
			System.out.println("The value is :"+ val);
		}
		else if (val > 20){
			System.out.println("The value is :"+ val);
		}
		else if (val < 20){
			System.out.println("The value is :"+ val);
		}
		else
			System.out.println("not satisfied");

	}

}

```


# 4 All Loop
### 4.1 AllLoops
```java
package _4Loops;

public class AllLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		int y;
		int z;
		for (x = 0;x<10;x++){
			System.out.print(x+" ");
		}
		System.out.println();
		y = 12;
		while (y<30){
			System.out.print(y+" ");
			y++;
		}
		System.out.println();
		z  =20;
		do{
			System.out.print(z+" ");
			z++;
		}while(z<34);
	}
}

```
### 4.2 LabelledLoops
```java
package _4Loops;

public class LabelledLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loop1: for(int i = 0;i<100;i++){
			System.out.println(" ");
			if(i>=10)
				break;
			for (int j = 0;j<100;j++){
				System.out.print(" * ");
				if (j == i)
					continue Loop1 ;
			}
		}
	}
}

```

# 5 Switch Case

### 5.1 SwitchCase
```java
package _5SwitchCase;
import java.util.*;
public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		Scanner ob = new Scanner(System.in);
		x = ob.nextInt();
		switch(x){
			case 1 : {
				System.out.println("one");
				break;
			}
			case 2 : {
				System.out.println("two");
				break;
			}
			case 3 : {
				System.out.println("three");
				break;
			}
			case 4 : {
				System.out.println("four");
				break;
			}
			default:{
				System.out.println("not match");
			}
		}
	}
}

```
# 6 Arrays
### 6.1 OneDimensionArrays
```java
package _6Arrays;
import java.util.*;
public class OneDimensionArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// static assign 
		//applicable for int and double or float :p
		int[] arr1 = new int[3];
		int[] arr2 = new int[5];
		//int arr[] = new int[5] ;
		arr1[0] = 10;
		arr1[1] = 15;
		arr1[2] = 20;
		for (int i = 0;i<arr1.length;i++){
			System.out.print(arr1[i]+" ");
		}
		System.out.println(" ");
		
		System.out.println("iterate through an array");
		for (int x: arr1){
			System.out.print(x+" ");
		}
		//Dynamic assign
		Scanner x = new Scanner(System.in);
		for (int i = 0;i<arr2.length;i++){
			arr2[i] = x.nextInt();
		}
		for (int i = 0;i<arr2.length;i++){
			System.out.print(arr2[i]+" ");
		}
	}
}

```
### 6.2 OneDimensionStringArrays
```java
package _6Arrays;
import java.util.*;
public class OneDimensionStringArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ar1 = new String[3];//string declaration
		String[] ar2 = new String[6];
		//static assign
		ar1[0] = "Khan";
		ar1[1] = "C M";
		ar1[2] = "Abdullah";
		for (int i = 0;i<ar1.length;i++){
			System.out.print(ar1[i] + " ");
		}
		System.out.println(" ");//end
		
		System.out.println("iterate through an array");
		for (String x: ar1){
			System.out.print(x+" ");
		}
		
		//dynamic assign
		Scanner x = new Scanner(System.in);
		for(int i = 0;i<ar2.length;i++){
			ar2[i] = x.next();
		}
		
		for(int i = 0;i<ar2.length;i++){
			System.out.print(ar2[i] + " ");
		}
	}
}

```
### 6.3 TwoDimensionArrays
```java
package _6Arrays;
import java.util.*;
public class TwoDimensionArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Static decleration
		int[][] tarr1 = {
				{2,3,4},
				{5,6,7},
				{9,10,11}
				};
		System.out.print("Static value is :");
		for (int i = 0; i<tarr1.length;i++){
			for (int j = 0;j<tarr1.length;j++){
				System.out.print(tarr1[i][j] +" ");
			}
			System.out.println(" ");	
		}
		System.out.print("Input value dynamically :\n");
		int row = 3,column = 3;	
		int[][] tarr2 = new int[row][column];
		Scanner x = new Scanner(System.in);
		for (int i = 0; i<row;i++){
			for (int j = 0;j<column;j++){
				tarr2[i][j] = x.nextInt();
			}	
		}
		//print
		System.out.print("Dynamic value is :\n");
		for (int i = 0; i<row;i++){
			for (int j = 0;j<column;j++){
				System.out.print(tarr2[i][j] +" ");
			}
			System.out.println(" ");	
		}

		System.out.print("outer loop tarr3.length,inner loop  tarr3[i].length:\n");
		int[][] tarr3 = new int[3][3];
		Scanner y = new Scanner(System.in);
		for (int i = 0; i<tarr3.length;i++){
			for (int j = 0;j<tarr3[i].length;j++){
				tarr3[i][j] = y.nextInt();
			}	
		}
		//print
		System.out.print("Dynamic value is :\n");
		for (int i = 0; i<tarr3.length;i++){
			for (int j = 0;j<tarr3[i].length;j++){
				System.out.print(tarr3[i][j] +" ");
			}
			System.out.println(" ");	
		}
	}
}

```
### 6.4 TwoDimensionStringArrays
```java
package _6Arrays;
import java.util.*;
public class TwoDimensionStringArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][]  n = new String[2][2];
		n[0][1] = "abdullah" ;//static declaration
		
		String[][] cartoons = {
		        { "Flintstones", "Fred", "Wilma", "Pebbles", "Dino" },
		        { "Rubbles", "Barney", "Betty", "Bam Bam" },
		        { "Jetsons", "George", "Jane", "Elroy", "Judy", "Rosie", "Astro" },
		        { "Scooby Doo Gang", "Scooby Doo", "Shaggy", "Velma", "Fred", "Daphne" } 
		        };
		for (int i = 0;i<cartoons.length;i++){
			for (int j = 0; j<cartoons[i].length;j++){
			System.out.print(cartoons[i][j] +" ");
			}
			System.out.print("\n");
		}		
		
		String[][] ars = new String[3][3];
		int i,j;
		//take input
		System.out.print("\n Take input :\n ");
		Scanner x = new Scanner(System.in);
		for (i = 0;i<3;i++){
			for (j = 0; j<3;j++){
				ars[i][j] = x.next();
			}
		}
		//print
		for (i = 0;i<3;i++){
			for (j = 0; j<3;j++){
			System.out.print(ars[i][j] +" ");
			}
			System.out.print("\n");
		}
	}
}

```
# 7 Multiple Clases
### 7.1 MultipleClassInOne
```java
package _7MultipleClases;

class subClass{
	String name;
}

public class MultipleClassInOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subClass obj = new subClass(); ///object declaration of _02SubClass
		subClass obj1 = new subClass();///object declaration of _02SubClass
		obj.name = "Abdullah";
		obj1.name = " Khan";
		System.out.print(obj.name);
		System.out.print(obj1.name);
	}
}

```
# 8 Type Casting
### 8.1 Automatic
```java
package _8TypeCasting;

public class Automatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		byte y = 10;
		x = y;
		System.out.println(x);
	}
}

```
### 8.2 Menual
```java
package _8TypeCasting;

public class Menual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		double y = 20.45;
		byte z;
		byte a = (byte)x;
		int b = (int)y;
		float c = (float)y;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}

```
# 9 Operators
### 9.1 Arithmatic
```java
package _9Operators;

public class Arithmatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b, x,y,z,q;
		a= 30;
		b= 20;
		x = a+b;
		y = a-b;
		z = a*b;
		q = a/b;
		System.out.println("add :"+x);
		System.out.println("sub :"+y);
		System.out.println("mul :"+z);
		System.out.println("div :"+q);
		

	}

}

```
### 9.2 Assignment
```java
package _9Operators;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//assignment operator assign somevalue from one variable to another
		int x ;
		x = 1000;//1000 assigns on variable x;
		System.out.println(x);
	}
}

```
### 9.3 Bitwise
```java
/**
Reference https://www.tutorialspoint.com/java/java_bitwise_operators_examples.htm
 * */
package _9Operators;

public class Bitwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 60;	/* 60 = 0011 1100 */
		int b = 13;	/* 13 = 0000 1101 */
	    int c = 0;

	    c = a & b;        /* 12 = 0000 1100 */
	    System.out.println("a & b = " + c );

	    c = a | b;        /* 61 = 0011 1101 */
	    System.out.println("a | b = " + c );

	    c = a ^ b;        /* 49 = 0011 0001 */
	    System.out.println("a ^ b = " + c );

	    c = ~a;           /*-61 = 1100 0011 */
	    System.out.println("~a = " + c );

	    c = a << 2;       /* 240 = 1111 0000 */
	    System.out.println("a << 2 = " + c );

	    c = a >> 2;       /* 15 = 1111 */
	    System.out.println("a >> 2  = " + c );

	    c = a >>> 2;      /* 15 = 0000 1111 */
	    System.out.println("a >>> 2 = " + c );

	}

}

```
### 9.4 ConditionalOrThe
```java
package _9Operators;

public class ConditionalOrThe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,z;
		x = 100;
		y = 200;	
		z = (x>y) ? x : y;
		System.out.println(z);
	}
}

```
### 9.5 IncrementAndDecrement
```java
package _9Operators;

public class IncrementAndDecrement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		x = 20;
		y = 30;
		System.out.println(x);
		System.out.println(y);
		System.out.println("post increment : X++ = "+(x++));
		System.out.println("X is :"+x);
		System.out.println("pre increment  : ++X = "+(++x));
	}
}

```
### 9.5 Logical
```java
package _9Operators;

public class Logical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 500;
		int b = 20;
		int x  = 100;
		if (a<b && x == 100)
			System.out.println("AND operation Success");
		if (a<b || x == 100)
			System.out.println("OR operation Success");
	}
}

```
### 9.6 Relational
```java
package _9Operators;

public class Relational {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 20;
		System.out.println(a);
		System.out.println(b);
		System.out.println("a < b  :"+(a<b));
		System.out.println("a > b  :"+(a>b));
		System.out.println("a == b :"+(a==b));
		System.out.println("a != b :"+(a !=b ));
		System.out.println("a <= b :"+(a<=b));
		System.out.println("a >= b :"+(a>=b));
	}
}

```
### 9.7 SpecialOrDot
```java
package _9Operators;

class subClass{
	String name;
}
public class SpecialOrDot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subClass obj = new subClass(); 
		obj.name = "Abdullah";// Dot operator
		System.out.print(obj.name);
	}
}
```
# 10 Strings
### 10.1 BasicStrings
```java
package _10Strings;

public class BasicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String x = " Abdullah " ;
        String y = "Khan" ;
        System.out.println("Convert String toLowercase : "+x.toLowerCase());
        System.out.println("Convert String toUpperCase : "+x.toUpperCase());
        System.out.println("Replace all a appearence with b is: "+x.replace('a','b'));
        System.out.println("Remove white space from beginning and end : "+x.trim());
        System.out.println("Return true if X equal Y : "+x.equals(y));
        System.out.println("Return true if X equal Y , ignoring the case of character : "+x.equalsIgnoreCase(y));
        System.out.println("Our country name is: "+x.length());
        System.out.println("Gives nth char is  : "+x.charAt(2));
        System.out.println("Compare two String : "+x.compareTo(y));
        System.out.println("Concat two String  : "+x.concat(y));
        System.out.println("Substring from nth Char: "+x.substring(4));
        System.out.println("Substring from nth Char up to mth char: "+x.substring(4,7));
        System.out.println("Creat a string object of paremeter p  : "+String.valueOf(x));
        System.out.println("String representation : "+x.toString());
        System.out.println("Given the position of the first occurrence of Z in the string X: "+x.indexOf('x'));
        System.out.println("Given the position of Z that occurs after nth position in the string X: "+x.indexOf('x',3));
        System.out.println("Convert the parameter value to string : "+String.valueOf(x));
	}
}

```
### 10.2 StringBufferClass
```java
package _10Strings;

public class StringBufferClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer obj = new StringBuffer("BanglaDesh");
        ///Modify Characters
        obj.setCharAt(4,'d');
        System.out.println("Modify Characters : "+obj);
        //appending string
        System.out.println("Appended String : "+obj.append("hi"));
	}
}

```
# 11 Vector


### 11.0 VectorBasicTools
```java
package _11Vector;

import java.util.Vector;

public class VectorBasicTools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;//n = index
		Vector obj = new Vector();
		String anArray[] = new String[n];
		System.out.println("01. obj.size();");
		System.out.println("02. obj.capacity();");
		System.out.println("03. obj.ensureCapacity(n);");
		System.out.println("04. obj.addElement(obj);");
		System.out.println("05. obj.insertElementAt(obj, n);");
		System.out.println("06. obj.elementAt(n);");
		System.out.println("07. obj.elementAt(n);");
		System.out.println("08. obj.set(n, obj);");
		System.out.println("09. obj.firstElement();");
		System.out.println("10. obj.lastElement();");
		System.out.println("11. obj.removeElement(obj);");
		System.out.println("12. obj.removeElementAt(n);");
		System.out.println("13. obj.removeAllElements();");
		System.out.println("14. obj.remove(obj);");
		System.out.println("15. obj.remove(n);");
		System.out.println("16. obj.clear();");
		System.out.println("17. obj.copyInto(anArray);");
	}
}

```






### 11.1 Size
```java
package _11Vector;

import java.util.Vector;

public class _01_Size {

	public static void main(String[] args) {
		Vector obj = new Vector();
		int x;
		x = obj.size();
		System.out.println(x);
	}
}

```
### 11.2 capacity
```java
package _11Vector;

import java.util.Vector;

public class _02_capacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		int x,y;
		x = obj.capacity();
		obj.ensureCapacity(50);
		System.out.println(x);
		System.out.println(obj.capacity());
	}
}

```
### 11.3 AddElementAndElementAt
```java
package _11Vector;

import java.util.Vector;

public class _03_AddElementAndElementAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
	}
}

```
### 11.4 SetAndGet
```java
package _11Vector;

import java.util.Vector;

public class _04_SetAndGet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
		obj.set(2, "Set KK");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.get(i));
		}
	}
}

```
### 11.5 InsertElementAt_AndRemoveElementAt
```java
package _11Vector;

import java.util.Vector;

public class _05_InsertElementAt_AndRemoveElementAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
		obj.insertElementAt("CM Abdullah", 3);
		System.out.println("After insert \n");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.get(i));
		}
		
		obj.removeElementAt(0);
		System.out.println("After Remove Element \n");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.get(i));
		}
	}
}

```
### 11.6 RemoveElement_And_RemoveAllElements
```java
package _11Vector;

import java.util.Vector;

public class _06RemoveElement_And_RemoveAllElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
		obj.removeElement("EE");
		System.out.println("\nAfter remove EE ");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.get(i));
		}
		obj.removeAllElements();
		System.out.println("\nAfter remove All element ");
		System.out.println("Size of vector is :"+obj.size());
	}
}

```
### 11.7 Remove_And_Clear
```java
package _11Vector;

import java.util.Vector;

public class _07Remove_And_Clear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
		obj.remove("GG");//removing element GG
		obj.remove(4);	//removing index 4
		
		System.out.println("After removing :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
		obj.clear();
		System.out.println("\nAfter clear ");
		System.out.println("Size of vector is :"+obj.size());
	}
}

```
### 11.8 FirstElement_And_LastElement
```java
package _11Vector;

import java.util.Vector;

public class _08_FirstElement_And_LastElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is : ");
			System.out.println(obj.elementAt(i));
		}
		System.out.println("\nFirst element is :"+obj.firstElement());
		System.out.println("\nLast element is :"+obj.lastElement());

	}

}

```
### 11.9 isEmpty_And_contains
```java
package _11Vector;

import java.util.Vector;

public class _09_isEmpty_And_contains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		
		String obj1 = "Object oriented Porgramming" ;
		System.out.println("The string is : "+obj1);
		
		int p1 = obj1.indexOf('i');
		System.out.println("first index of \"i\" is : "+p1);
		int p2 = obj1.lastIndexOf('i');
		System.out.println("last index of \"i\" is : "+p2);
		int p3 = obj1.lastIndexOf("Porgr");
		System.out.println("index of  \"Progr\" is : "+p3);
		
		int p4 = obj1.indexOf('i', 10);
		System.out.println("first index of \"i\" after 10 elements is : "+p4);
		int p5 = obj1.lastIndexOf('i', 10);
		System.out.println("last index \"i\" after 10 elements is : "+p5);
		int p6 = obj1.lastIndexOf('i', 12);
		System.out.println("last index \"i\" after 12 elements is : "+p2);
	}
}

```
### 11.10 indexOf_And_lastIndexOf
```java
package _11Vector;

public class _10indexOf_And_lastIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

```
### 11.11 copyIntro
```java
package _11Vector;

import java.util.Vector;

public class _11_copyIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		obj.addElement("AA");
		obj.addElement("BB");
		obj.addElement("CC");
		obj.addElement("DD");
		obj.addElement("EE");
		obj.addElement("FF");
		obj.addElement("GG");
		obj.addElement("HH");
		obj.addElement("II");
		System.out.println("The elements are :");
		for (int i = 0; i<obj.size(); i++){
			System.out.print("Element at "+i+" is  : ");
			System.out.println(obj.elementAt(i));
		}
		
		int y = obj.size();
		String listArray[] = new String[y];
		obj.copyInto(listArray);
		System.out.println("\n\nAfter copy an string ");
		for (int i = 0;i<y ;i++){
			System.out.println(listArray[i]);
		}
	}
}

```
# 12 WrapperClass
### 12.1 PrimitiveToWrapperClassObject
```java
package _12WrapperClass;

import java.util.Vector;

public class _01PrimitiveToWrapperClassObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		String name = "C M Abdullah Khan";
		int roll = 01;//Primitive integer 
		float marks = 94.8f;
		char grade = 'A' ;
		boolean pass = true;
		Integer r = new Integer(roll);//Primitive integer To Wrapper Class Object
		Float m = new Float(marks);
		Character g = new Character(grade);
		Boolean p = new Boolean(pass);	
		obj.addElement(r);
		obj.addElement(m);
		obj.addElement(g);
		obj.addElement(p);
		for (int i = 0;i<obj.size();i++){
			System.out.println("Element at "+i+" is : "+ obj.elementAt(i));
		}
	}
}

```
### 12.2 PrimitiveToStringObject
```java
package _12WrapperClass;

import java.util.Vector;

public class _02PrimitiveToStringObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		String name = "C M Abdullah Khan";
		int roll = 01;//Primitive integer 
		float marks = 94.8f;
		String r,m;
		r = Integer.toString(roll);//Primitive To String Object
		m = Float.toString(marks);
		obj.addElement(r);
		obj.addElement(name);
		obj.addElement(m);
		for (int i = 0;i<obj.size();i++){
			System.out.println("Element at "+i+" is : "+ obj.elementAt(i));
		}
	}
}

```
### 12.3 StringObjectToWrapperClassObject
```java
package _12WrapperClass;

import java.util.Vector;

public class _03StringObjectToWrapperClassObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector obj = new Vector();
		String name ; //name is string object
		Integer roll; //roll is wrapper class object
		Float marks;  //maarks is wrapper class object

		String n = "C M Abdullah Khan";
		String r = "01";//Primitive integer 
		String m = "94.8";
		name = n;
		roll = Integer.valueOf(r);//String Object To Wrapper Class Object
		marks = Float.valueOf(m);
		obj.addElement(name);
		obj.addElement(roll);
		obj.addElement(marks);
		for (int i = 0;i<obj.size();i++){
			System.out.println("Element at "+i+" is : "+ obj.elementAt(i));
		}
	}
}

```
### 12.4 WrapperClassObjectToPrimitiveType
```java
package _12WrapperClass;

public class _04WrapperClassObjectToPrimitiveType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer I = new Integer(100);//Wrapper Class Object
		Float F = new Float(20);
		int i = I.intValue();//Wrapper Class Object To Primitive Type
		float f = F.floatValue();
		System.out.println("I is : "+I+" \t\ti is :"+i);
		System.out.println("F is : "+F+" \t\tf is :"+f);
	}
}

```
### 12.5 AutoBoxingUnBoxing
```java
package _12WrapperClass;

public class _05AutoBoxingUnBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double d_object = 20.5;
		double d_primitive = d_object.doubleValue();
		System.out.println("We can use this feature to convert primitive datatype to object datatype");
		System.out.println(d_primitive);

	}

}

```
### 12.6 EnumeratedType
```java
package _12WrapperClass;

public class _06EnumeratedType {
	enum Days{
		Friday,Saturday,Sunday,Monday,Tuesday,Wednesday,Thursday
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Days d: Days.values()){
			weekend(d);
		}
	}
	private static void weekend(Days d){
		if (d.equals(Days.Friday)){
			System.out.println("value = "+d+" is \ta holiday");
		}
		else{
			System.out.println("value = "+d+" is \ta working day");
		}
	}
}

```
### 12.7 AnnoTations
```java
package _12WrapperClass;
import java.lang.*;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@interface MySingle{
	int value();
}
public class _07AnnoTations {
	
	@MySingle (100)
	public static void myMeth(){
		_07AnnoTations ob = new _07AnnoTations();
		try{
			Method m = ob.getClass().getMethod("myMeth");
			MySingle anno = m. getAnnotation(MySingle.class);
			System.out.println("the value is :"+anno.value());
		}
		catch (NoSuchMethodException exc){
			System.out.println("Method not found !!");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth();
	}
}

```
# 13 Methods
### 13.1 AbstractMethod
```java
package _13Methods;
abstract class Ac{
	void display(){
		System.out.println("Abstruct CM!!!");
	}
}
public class AbstractMethod extends Ac{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractMethod obA = new AbstractMethod();
		obA.display();
	}
}
```

### 13.2 ConstructorsMethod
```java
package _13Methods;
class BB{
	int a, k;
	double b;
	String c;
	public BB(){
		System.out.println("System is working!!!");
	}
	
	public BB(int x){
		a =x;
		System.out.println("int value is : "+a);
	}
	public BB(double y){
		b = y;
		System.out.println("double value is :"+b);
	}
	public BB(String z){
		c = z;
		System.out.println("String value is :"+c);
	}
	int display1(){
		k = a*a;
		return k;
	}
}
public class ConstructorsMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d;
		BB ob = new BB();
		BB ob1 = new BB(20);
		BB ob2 = new BB(30.4);
		BB ob3 = new BB("Abdullah");
		d = ob1.display1();
		System.out.println("The return multiplication result is : "+d);
	}
}

```

### 13.3 GettingReturnValue
```java
package _13Methods;
class AA{
	int i,j,k;
	int display(){
		k = i+j;
		return k;
	}
}
public class GettingReturnValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA obj = new AA();
		int result;
		obj.i = 200;
		obj.j = 30;
		result = obj.display();
		System.out.println(result);
	}
}

```

### 13.4 MethodParameters
```java
package _13Methods;
class AAA{
	int i,j,k;
	void setValue(int x,int y){
		i = x;
		j = y;
	}
	int display(){
		k = i+j;
		return k;
	}
}
public class MethodParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA obj = new AAA();
		int result;
		obj.setValue(3000, 499);
		result = obj.display();
		System.out.println(result);
	}
}

```

### 13.5 Methods
```java
package _13Methods;
class A{
	int i,j,k;
	void display(){
		k = i*j;
		System.out.println(k);
	}
}
public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A();
		obj.i = 20;
		obj.j = 30;
		obj.display();
	}
}

```

### 13.2 MethodsOverLoading
```java
package _13Methods;
class CCC{
	int a,b,c,r;
	CCC(){
		System.out.println("MO is working!!!");
	}
	CCC(double x){
		System.out.println("the double value is : "+x);
	}
	CCC(int x,int y, int z){
		a = x;
		b = y;
		c = z;
	//	System.out.println("Addition result of three int "+a+b+c);
	}
	int show(){
		r = a+b+c;
		return r;
	}
}
public class MethodsOverLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int results;
		CCC objC1 = new CCC();
		CCC objC2 = new CCC(30.5);
		CCC objC3 = new CCC(30, 40,50);
		results = objC3.show();
		System.out.println("The return result is :"+results);

	}

}

```

### 13.6 NestingOfMethod
```java
package _13Methods;
class NM{
	int a,b,c;
	NM(int x,int y){
		a = x;
		b = y;
	}	
	int largest(){
		if (a>=b)
			return a;
		else
			return b;
	}
	void display(){
		System.out.println(largest());
	}		
}
public class NestingOfMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NM ob = new NM(20,30);
		ob.display();
	}
}

```

### 13.7 OverrIdingMethod
```java
package _13Methods;
class Super{
	int x;
	Super(int x){
		this.x = x;
	}
	void display(){
		System.out.println("Super X = "+x);
	}
}
class Sub extends Super{
	int y;
	Sub(int x,int y){
		super(x);
		this.y = y;
	}
	void display(){
		System.out.println("Super X = "+x);
		System.out.println("Sub Y   = "+y);
	}
}
public class OverrIdingMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub obj = new Sub(100,200);
		obj.display();
	}
}
```

### 13.8 PrivateMethod
```java
/**
 * not completed
 */
package _13Methods;
class AccessPrivetMathod_C {
	private final void foo() {
		
	}
}
public class PrivateMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessPrivetMathod_C  b = new AccessPrivetMathod_C() ;
		//	b.foo(); 
	}
}

```

### 13.9 ProtectedMethod
```java
package _13Methods;
class AccessProtectedChiled {
	protected void displayResult(){
		System.out.println("Hi i am protected, Protected method accessed by any class or method in the same package,\nand inherited by any subclass of its class");
	}
}
public class ProtectedMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessProtectedChiled ob2 = new AccessProtectedChiled();
		ob2.displayResult();
	}
}

```

### 13.10 StaticMethod
```java
package _13Methods;

class StaticMembersSub {
	static float mult(float x, float y){
		return x*y;	
	}
	static float divide(float x, float y){
		return x/y;	
	}
}
public class StaticMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float x = 20;
		float a = StaticMembersSub.mult(x, 30);
		float b = StaticMembersSub.divide(30, 10);
		System.out.println("Mult   "+a);
		System.out.println("Divide "+b);
	}
}

```

# 14 Public Privat Protected

### 14.1 PublicPrivatProtected
```java
package _14PublicPrivatProtected;
class p{
	public String name;//from anywhare
	private String type;//only within same class
	protected String size;//same package only
	p(){
		this.name = "Apple";
		this.type = "fruits";
		this.size = "not large";
	}
	void display(){
		System.out.println("Type : "+type);
	}
}
public class PublicPrivatProtected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p obj = new p();
		System.out.println("Name : "+obj.name);
	//	System.out.println(obj.type); //only within same class
		System.out.println("Size : "+obj.size);
		obj.display();
	}
}
```

# 15 Inheritance

### 15.1 HierArchical
```java
package _15Inheritance;
public class HierArchical {
	public void methodB(){
	System.out.println("method of Class B");
	}
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	B obj1 = new B();
	C obj2 = new C();
	D obj3 = new D();
	obj1.methodA();
	obj2.methodA();
	obj3.methodA();
	}
}
class A{
	public void methodA(){
	System.out.println("method of Class A");
	}
} 
class B extends A{
	public void methodB(){
	System.out.println("method of Class B");
	}
}
class C extends A{
	public void methodC(){
	System.out.println("method of Class C");
	}
}
class D extends A{
	public void methodD(){
	System.out.println("method of Class D");
	}
}
```

### 15.2 Multilevel
```java
package _15Inheritance;
public class Multilevel extends Y{
	public void methodZ(){
	System.out.println("class Z method");
	}
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Multilevel obj5 = new Multilevel();
	obj5.methodX(); //calling grand parent class method
	obj5.methodY(); //calling parent class method
	obj5.methodZ(); //calling local method
	}
}
class X{
	public void methodX(){
	System.out.println("Class X method");
	}
}
class Y extends X{
	public void methodY(){
	System.out.println("class Y method");
	}
}
```

### 15.3 Single
```java
package _15Inheritance;
class Room{//inherited room
	int l,b;
	Room(int i,int j){
		l = i;
		b = j;	
	}
	int area(){
		return l*b;
	}
}
class BedRoom  extends Room{//pass the value to superclass
	int hight;
	BedRoom(int d, int e, int f){
		super (d,e);
		hight = f;
	}
	int volume(){
		return (l*b*hight);
	}
}
public class Single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BedRoom  obj = new BedRoom (14,12 , 10);
		int area = obj.area();//superclass method
		int volume = obj.volume();//base class method
		System.out.println(area);
		System.out.println(volume);		
	}
}

```
# 16 Interfaces
### 16.1 BasicInterface
```java
package _16Interfaces;
interface Vehicle1 {
	public void acclaretor();
	public void brak();
	public void stear();
}
class HondaACcord implements Vehicle1 {

	@Override
	public void acclaretor() {
		// TODO Auto-generated method stub
		System.out.println("this is acclaretor() method...");
	}
	@Override
	public void brak() {
		// TODO Auto-generated method stub
		System.out.println("this is brak() method");
	}
	@Override
	public void stear() {
		// TODO Auto-generated method stub
		System.out.println("this is stear() method");
	}
}
public class BasicInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle1 obj = new HondaACcord();
		obj.acclaretor();
		obj.brak();
		obj.stear();

	}

}

```

### 16.2 DefiningInterface
```java
package _16Interfaces;
interface Area{
	final static float pi = 3.1416f;
	float compute (float x,float y);
}
class rectangle implements Area{
	public float compute(float x, float y){
		return (x*y);
	}
}
class circle implements Area{
	public float compute(float x, float y){
		return (pi*x*y);
	}
}
public interface DefiningInterface {
	public static void main(String args[]){
		rectangle obj = new rectangle();
		circle ddd = new circle();
		Area obj1;
		obj1 = obj;
		obj1.compute(20,40);
		System.out.println("Area of rectengle\t"+obj1.compute(20,40));
		obj1 = ddd;
		System.out.println("Area of circle\t\t"+obj1.compute(2,40));
	}
}
```

### 16.3 ExtendingInterface
```java
package _16Interfaces;

interface X{
	int code = 1000;
	String name = "Abdullah" ;
}

interface Y extends X{
	int ff =10;
}
class Z implements X{
	public void display(){
		System.out.println(name);
	}
}

public class ExtendingInterface {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		Z obj = new Z();
		X  obj1;
		obj1 = obj;
	//	System.out.println(obj1.display());
		//obj1.display();

	}

}

```

### 16.4 InterfaceImplements
```java
package _16Interfaces;


interface Students{
	int Roll = 20;
	String Name = "C M Abdullah Khan";
	void Display();
	void GetMarkes();
	void ShowMarkes();
}
class Result implements Students{
	int markes  ;
	public void Display(){
		System.out.println("The name is : "+Name);
	}
	public void GetMarkes(){
		markes  = 99;
	}
	public void ShowMarkes(){
		System.out.println("The mark is : "+markes);
	}
}
public class InterfaceImplements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students obj = new Result();
		obj.Display();	
		obj.GetMarkes();
		obj.ShowMarkes();
	}
}

```

### 16.5 InterfaceWithMultipleBaseClass
```java
package _16Interfaces;

interface tutorial{
	float tutoriaal = 29.4f;
	float tutorial();
}
class std{
	int roll;
	void getroll(){
		roll = 200;
	}
	void putroll(){
		getroll();
		System.out.println("roll is :"+roll);
	}
}
class exm extends std{
	int m1,m2;
	float getmarkes(){
		m1 = 20;
		m2 = 30;
		return (m1+m2);
	}
}

class reslt extends exm implements tutorial{
	public float tutorial(){
		System.out.println(tutoriaal);
		return tutoriaal;
	}
}
public class InterfaceWithMultipleBaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reslt obj22 = new reslt();
		obj22.tutorial();
		obj22.putroll();
	}
}

```

### 16.6 InterfaceWithMultipleDeriveClass
```java
package _16Interfaces;

interface Students12 {
	public void display();
	int roll = 200;
	String name  = "Khan" ;

}
class HondaACcord1 implements Students12 {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("this is acclaretor() method");
		System.out.println(name);
		System.out.println(roll);
	}
}

class HondaACcord100 implements Students12 {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("System is working!!!");
		System.out.println(name);
		//System.out.println(roll);
	}
}
class InterfaceWithMultipleDeriveClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students12 obj = new HondaACcord1();
		//Vehicle11 obj = new HondaACcord100();
		obj.display();
		Students12 obj1 = new HondaACcord100();
		obj1.display();
	}
}

```

### 16.7 MultipleInterfaceWithDeriveClass
```java
package _16Interfaces;

interface Abdullah{
	String Nam = "CM";
}
interface Abida{
	int rol = 20;
	void display();
}
class family implements Abdullah, Abida{
	public void display(){
		System.out.println("NAME : "+Nam+"\nRoll : "+rol);
	}
}
public class MultipleInterfaceWithDeriveClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		family ob = new family();
		ob.display();
	}
}

```
# 16.8
### ThreadTest
```java
package _16ThreadsTest;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new A().start();
		new B().start();
		new C().start();

	}

}

```

### A
```java
package _16ThreadsTest;

class A extends Thread{
	public void run(){
		for (int i = 0;i<5;i++){
			System.out.println("\t from thread : i = "+i);
		}
		System.out.println("Exit from A");
	}

}

```

### B
```java
package _16ThreadsTest;

class B extends Thread {
	public void run(){
		for (int j = 0;j<5;j++){
			System.out.println("\t from thread : j = "+j);
		}
		System.out.println("Exit from B");
	}
}

```

### C
```java
package _16ThreadsTest;

class C extends Thread {
	public void run(){
		for (int k = 0;k<5;k++){
			System.out.println("\t from thread : k = "+k);
		}
		System.out.println("Exit from C");
	}

}

```
# 17 Thread
### 17.1 CreatingThreadByImplementingTheRunnableInterface
```java
package _17Thread;
class cm implements Runnable{
	public void run(){
		for (int i = 0 ;i<5;i++){
			System.out.println("\t thread CM "+i);
		}
		System.out.println("End thread threadCm");
	}
}
public class CreatingThreadByImplementingTheRunnableInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cm objCm = new cm();
		Thread threadCm = new Thread(objCm);
		threadCm.start();
		System.out.println("End of the main thread");
	}
}

```

### 17.2 CreatingThreadUsingExtendedThreadAndStart
```java
package _17Thread;

class X extends Thread{
	public void run(){
		System.out.println("Thread X");
	}
}

class Y extends Thread{
	public void run(){
		System.out.println("Thread Y");
	}
}
class Z extends Thread{
	public void run(){
		System.out.println("Thread Z");
	}
}
public class CreatingThreadUsingExtendedThreadAndStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		X obX = new X();
		Y obY = new Y();
		Z obZ = new Z();
		obX.start();
		obY.start();
		obZ.start();
	}
}

```

### 17.3 ThreadPriority
```java
package _17Thread;
import java.util.*;

class D extends Thread{
	public void run(){
        for (int a = 0; a<5; a++){
            System.out.println("from thread G : G = "+a);
        }
        System.out.println("Exit G");
    }
}
class E extends Thread{
	public void run(){
        for (int b = 0; b<5; b++){
            System.out.println("from thread H : H = "+b);
        }
        System.out.println("Exit H");
    }
}
class F extends Thread{
	public void run(){
        for (int c = 0; c<5; c++){
            System.out.println("from thread I : I = "+c);
        }
        System.out.println("Exit I");
    }
}
public class ThreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D objD = new D();
        E objE = new E();
        F objF = new F();
        objD.setPriority(Thread.MIN_PRIORITY);// 
        objE.setPriority(objD.getPriority()+1);
        objF.setPriority(Thread.MIN_PRIORITY);
        
        objD.start();
        objE.start();
        objF.start();
	}
}

```

### 17.4 ThreadSleep
```java
package _17Thread;
class A extends Thread{
	public void run(){
		for (int i = 0;i<10;i++){
			System.out.println("from thread A : i = "+i);
			if (i == 2){
				try {
					sleep(100);
				}
				catch(Exception e){					
				}
			}
		}
		System.out.println("Exit A");
	}
}
class B extends Thread{
	public void run(){
        for (int j = 0; j<10; j++){
            System.out.println("from thread B : j = "+j);
        }
        System.out.println("Exit B");
    }
}
class C extends Thread{
	public void run(){
        for (int k = 0; k<10; k++){
            System.out.println("from thread C : k = "+k);
        }
        System.out.println("Exit C");
    }
}
public class ThreadSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A();
        obj.start();
        new B().start();
        new C().start();
	}
}


```

### 17.5 ThreadStop
```java
package _17Thread;
class I extends Thread{
	public void run(){
		for (int i = 0; i<5;i++){
			System.out.println("Thread I : I = "+i);
		}
	}
}
class J extends Thread{
	public void run(){
		for (int j = 0; j<5;j++){
			System.out.println("Thread J : J = "+j);
		}
	}
}
class K extends Thread{
	public void run(){
		for (int k = 0; k<5;k++){
			if (k == 2){
				System.out.println("\n\nWhen k = "+k+" Thread K must stop");
				stop();
			}
			System.out.println("Thread K : K = "+k);
		}
	}
}

public class ThreadStop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I obI = new I();
		J obJ = new J();
		K obK = new K();
		obI.start();
		obJ.start();
		obK.start();
	}
}

```

### 17.6 ThreadSynchronized
```java
package _17Thread;

class Global{
	synchronized void CallMe(String msg){
		System.out.print("[ "+msg);
		try {
			Thread.sleep(100);
		}
		catch(Exception e){
			System.out.println("Exception caught !");
		}
		System.out.println(" ]");
	}
}
class Caller implements Runnable{
	String msg;
	Global Target;
	Thread Th;

public Caller (Global Gb, String S){
	Target = Gb;
	msg = S;
	Th = new Thread(this);
	Th.start();
}

public void run(){
		Target.CallMe(msg);
	}
}

public class ThreadSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Global obj = new Global();
		Caller objC1 = new Caller(obj, "Hello");
		Caller objC2 = new Caller(obj, "Java");
		Caller objC3 = new Caller(obj, "Programmer");
		try{
			objC1.Th.join();
			objC2.Th.join();
			objC3.Th.join();
		}
		catch(Exception e){
		System.out.println("Exception Caught !!!!");	
		}
	}
}

```

### 17.7 ThreadYield
```java
package _17Thread;

class P extends Thread{
	public void run(){
		for (int i = 0;i<5;i++){
			if (i==3){
				yield();
			}
			System.out.println("Thread P : P = "+i);
		}
		System.out.println("Exit from Thread P");
	}
}
class Q extends Thread{
	public void run(){
		for (int i = 0;i<5;i++){
			System.out.println("Thread Q : Q = "+i);
		}
		System.out.println("Exit from Thread Q");
	}
}
class R extends Thread{
	public void run(){
		for (int i = 0;i<5;i++){
			System.out.println("Thread R : R = "+i);
		}
		System.out.println("Exit from Thread R");
	}
}
public class ThreadYield {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P oP = new P();
		Q oQ = new Q();
		R oR = new R();
		oP.start();
		oQ.start();
		oR.start();
	}
}

```

# Start 4 thread at a time
```java
package com.abdullah;

import java.time.LocalTime;
import java.util.Scanner;

class A extends Thread{
	long n, value;
	A(long n){
		this.n= n;
	}
	public void run() {
	    System.out.println("Thread A Start Time : "+ LocalTime.now());
		System.out.println("Thread A Started : "+fib(n));
	    System.out.println("Thread A End Time : "+ LocalTime.now());
	}
	long  fib(long  n){
	    if(n<3)
	    	return 1;
	    else
	    return fib(n-2) + fib(n-1);
	}
}

class B extends Thread{
	long n, value;
	B(long n){
		this.n= n;
	}
	public void run() {
	    System.out.println("Thread B Start Time : "+ LocalTime.now());
		System.out.println("Thread B Started : "+fib(n));
	    System.out.println("Thread B End Time : "+ LocalTime.now());
	}
	long  fib(long  n){
	    if(n<3)
	    	return 1;
	    else
	    return fib(n-2) + fib(n-1);
	}
}

class C extends Thread{
	long n, value;
	C(long n){
		this.n= n;
	}
	public void run() {
	    System.out.println("Thread C Start Time : "+ LocalTime.now());
		System.out.println("Thread C Started : "+fib(n));
	    System.out.println("Thread C End Time : "+ LocalTime.now());
	}
	long  fib(long  n){
	    if(n<3)
	    	return 1;
	    else
	    return fib(n-2) + fib(n-1);
	}
}


class D extends Thread{
	long n, value;
	D(long n){
		this.n= n;
	}
	public void run() {
	    System.out.println("Thread D Start Time : "+ LocalTime.now());
		System.out.println("Thread D Started : "+fib(n));
	    System.out.println("Thread D End Time : "+ LocalTime.now());
	}
	long  fib(long  n){
	    if(n<3)
	    	return 1;
	    else
	    return fib(n-2) + fib(n-1);
	}
}

public class Main {

	public static void main(String[] args) {
		long n,o,p,q;
		System.out.println("Enter 4 value for Thread A, B, C, D : ");
		Scanner a = new Scanner(System.in);
		n = a.nextLong();
		o = a.nextLong();
		p = a.nextLong();
		q = a.nextLong();

		A ob1 = new A(n);
		B ob2 = new B(o);
		C ob3 = new C(p);
		D ob4 = new D(q);

		ob1.start();
		ob2.start();
		ob3.start();
		ob4.start();
		System.out.println(Thread.activeCount());
	    

	}
}


```





# 18 ErrorsAndExceptions

### 18.1 MultipleCatchBlock
```java
package _18ErrorsAndExceptions;

public class MultipleCatchBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,10};
		int b = 5;
		try {
			int x = (arr[2]/b) - (arr[1]);
		}
		catch (ArithmeticException e){
			System.out.println("Divided by Zero");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array index error");
		}
		catch(ArrayStoreException e){
			System.out.println("Wrong Datatype");
		}
	}
}

```
# 19 Package

### 19.1 Main
```java
package _19Package;

import _19Package.ocean.Fish;
import _19Package.ocean.cm.*;
import _19Package.ocean.plants.Seaweed;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fish f = new Fish();
		Seaweed s = new Seaweed();
		TestCm x = new TestCm();
		f.display();
		s.sdisplay();
		x.tdisplay();
	}
}

```
### Fish
```java
package _19Package.ocean;

public class Fish {
	public void display(){
		System.out.println("fish class !!!");
	}

}

```
### TestCm
```java
package _19Package.ocean.cm;

public class TestCm {
	public void tdisplay(){
		System.out.println("hi cmm........");
	}

}

```
### Seaweed
```java
package _19Package.ocean.plants;

public class Seaweed {
	public void sdisplay(){
		System.out.println("Seaweed class........");
	}

}

```