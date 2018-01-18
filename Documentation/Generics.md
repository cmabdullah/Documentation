# Now I am following [Thinking In Java](https://goo.gl/vmjMJs) & [The complete referrence](https://bit.do/cmabdullah)Book 

## A Simple Generics Example
```java
package _20Generics;
public class _1ASimpleGenericsExample {
	public static  < E > void printAtrray(E[] x){
		//iterate through an array
		for(E element : x) {
		//for(E element = 0 ;  element<inputArray.length ; element++) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O', 'X' };
		printAtrray(intArray);
		printAtrray(charArray);
	}
}
```

## Generic Bounded Type Parameters
```java
package _20Generics;
public class _2Generic_BoundedTypeParameters {
	//determines the largest of three Comparable objects
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
	T max = x;   // assume x is initially the largest
	if(y.compareTo(max) > 0) {
		max = y;   // y is the largest so far
	}
	if(z.compareTo(max) > 0) {
		max = z;   // z is the largest now
	}
	return max;  
	}
	// returns the largest object 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum( 3, 4, 5 ));
		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));
		System.out.printf("Max of %s, %s and %s is %s\n","pear","apple", "orange", maximum("pear", "apple", "orange"));
	}
}
```

## Comparable

```java
package _20Generics;
public class _3Comparable {
	// determines the largest of three Comparable objects
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;   // assume x is initially the largest
		if(y.compareTo(max) > 0) {
			max = y;   // y is the largest so far
		}
		if(z.compareTo(max) > 0) {
			max = z;   // z is the largest now                 
		}
		return max;   // returns the largest object   
	}
	public static void main(String args[]) {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum( 3, 4, 5 ));
		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));
		System.out.printf("Max of %s, %s and %s is %s\n","pear","apple", "orange", maximum("pear", "apple", "orange"));
	}
}
```

## A Simple Generic Example Page 316HS
```java
package _20Generics;
class Gen<T>{
	// T is used to declere an object called obj
	T obj;// declare an object of type T
	//now ob will be object of type T	
	// Pass the constructor a reference to
	// an object of type T.
	Gen(T o){// look it is a peremeter, o of type T
		obj = o;// this means that actual type of o is determined by the type passed to T, when a Gen object is created.
	}
	//return ob;
	//obj is type T, also it is return type...
	T getob(){
		return obj;
	}
	//show type of T
	void showType(){
		System.out.println("Type of T is "+ obj.getClass().getName());
	}
}
public class _4ASimpleGenericExamplePage316HS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<Integer> iob;//Integer is a type of argument, that is passed to Gen type parameter T. Thus for this decleration obj is type Integer
		iob = new Gen<Integer>(88);
		iob.showType();
		int v = iob.getob();
		System.out.println("Value: "+v);
		Gen<String> strOb = new Gen<String>("Generic Test");
		strOb.showType();
		String str = strOb.getob();
		System.out.println("Value: "+str);
	}
}
```


## How Generics Improve Type Safety

```java
package _20Generics;
class NonGen{
	Object ob;
	NonGen(Object o){
		ob = o;
	}
	Object getob(){
		return ob;
	}
	void showType(){
		System.out.println("Type of ob is : "+ob.getClass().getName());
	}
}
public class _5HowGenericsImproveTypeSafety {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonGen oib = new NonGen(99);
		oib.showType();
		int v = (Integer)oib.getob();
		System.out.println("Value : "+v);
		NonGen stroib = new NonGen("Non generics Test");
		stroib.showType();
		String str = (String)stroib.getob();
		System.out.println("Value : "+str);
	}
}
```

## Generic Class With Two Type Parameters

```java
package _20Generics;
class TwoGen<T,V>{
	T ob1;
	V ob2;
	TwoGen(T o1, V o2){
		ob1 = o1;
		ob2 = o2;
	}
	void showTypes(){
		System.out.println("Type of T is "+ob1.getClass().getName());
		System.out.println("Type of V is "+ob2.getClass().getName());
	}
	T getob1(){
		return ob1;
	}
	V getob2(){
		return ob2;
	}
}
public class _6GenericClassWithTwoTypeParameters {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoGen<Integer, String> tgobj = new TwoGen<Integer, String>(100, "CM");
		tgobj.showTypes();
		int v = tgobj.getob1();
		System.out.println("Value : "+v);
		String str = tgobj.getob2();
		System.out.println("Value : "+str);
	}
}
```

## Generic Bounded Types
```java
package _20Generics;
class Stars<T extends Number>{// upper bounded type
	//this specify that T can only be replaced by superclass.
	T[] nums;
	Stars(T[] o){
		nums = o;
	}
	double average(){
		double sum = 0;
		for (int i=0;i<nums.length;i++){
			sum = sum+nums[i].doubleValue();	
		}
		return sum/nums.length;
	}
}
public class _7GenericBoundedTypes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer inums[] = {1,2,3,4,5};
		Stars<Integer> iob = new Stars<Integer>(inums);
		double v = iob.average();
		System.out.println("iob average is :"+v);
		Double dnums[] = {1.1,2.2,3.3,4.4,5.5};
		Stars<Double> dob = new Stars<Double>(dnums);
		double w = dob.average();
		System.out.println("iob average is :"+w);
		// This won't compile because String is not a
		// subclass of Number.
		//String snums[] = {"1","2","3","4","5"};
		//Stars<String> sob = new Stars<String>(snums);
		//String St = sob.average();
		//System.out.println("iob average is :"+St);
	}
}
```
## Using Wild Card Argument

```java
package _20Generics;
class Stats<T extends Number>{// state is a parameterized type
	T[] nums;
	Stats(T[] o){
		nums = o;
	}
	double average(){
		double sum = 0.0;
		for (int i = 0; i<nums.length; i++){
			sum = sum + nums[i].doubleValue();
		}
		return sum/nums.length ;
	}
	boolean samAvg(Stats<?>  ob){// ? Wild Card Argument. it represent unknown type
		if (average() == ob.average()){
			return true;
		}
		else
			return false;
	}
}
public class _8UsingWildCardArgument {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer inums[] = {1,2,3,4,5};
		Stats<Integer> iob = new Stats<Integer>(inums);
		double v = iob.average();
		System.out.println("iob average is :"+v);
		Double dnums[] = {1.1,2.2,3.3,4.4,5.5};
		Stats<Double> dob = new Stats<Double>(dnums);
		double w = dob.average();
		System.out.println("dob average is :"+w);
		Float fnums[] = {1.0F,2.0F,3.0F,4.0F,5.0F};
		Stats<Float> fob = new Stats<Float>(fnums);
		double f = fob.average();
		System.out.println("fob average is :"+f);
		System.out.println("average of iob and dob is :");
		if (iob.samAvg(dob))
			System.out.println("Thay are same");
		else
			System.out.println("Mismatch");
		if (iob.samAvg(fob))
			System.out.println("Thay are same");
		else
			System.out.println("Mismatch");
	}
}
```

## Bounded Wild Cares Page 329

```java
package _20Generics;
//Bounded wildcard arguments.

//two dimentional coordinates.
class TwoD{
	int x,y;
	TwoD(int a, int b){
		x = a;
		y = b;
	}
}
//three dimentional coordinates.
class ThreeD extends TwoD{
	int z;
	ThreeD(int a,int b, int c){
		super(a,b);
		z = c;
	}
}
class FourD extends ThreeD{
	int t;
	FourD(int a,int b,int c, int d){
		super(a,b,c);
		t = d;
	}
}
class Coords<T extends TwoD>{
	T[]  coords;
	Coords(T[] o){
		coords = o;
	}
}

public class _9BoundedWildCaresPage329 {
	static void showXY(Coords<?> c){
		System.out.println("X Y Coordinates : ");
		for (int i = 0; i<c.coords.length; i++){
			System.out.println(c.coords[i].x+" "+c.coords[i].y+" ");
			System.out.println();
		}
	}
	static void showXYZ(Coords<? extends ThreeD> c){
		System.out.println("X Y Z Coordinates : ");
		for (int i = 0; i<c.coords.length; i++){
			System.out.println(c.coords[i].x+" "+c.coords[i].y+" "+c.coords[i].z);
			System.out.println();
		}
	}	
	static void showAll(Coords<? extends FourD> c){
		System.out.println("X Y Z T Coordinates : ");
		for (int i = 0; i<c.coords.length; i++){
			System.out.println(c.coords[i].x+" "+c.coords[i].y+" "+c.coords[i].z+" "+c.coords[i].t);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoD td[] = { 
				new TwoD(0, 0),
				new TwoD(7, 9),
				new TwoD(18, 4),
				new TwoD(-1, -23)
				};

		Coords<TwoD> tdlocs = new Coords<TwoD>(td);
		System.out.println("Contents of tdlocs.");
		showXY(tdlocs);

		FourD fd[] = {
				new FourD(1, 2, 3, 4),
				new FourD(6, 8, 14, 8),
				new FourD(22, 9, 4, 9),
				new FourD(3, -2, -23, 17)
				};
		Coords<FourD> fdlocs = new Coords<FourD>(fd);
		System.out.println("Contents of fdlocs.");
		// These are all OK.
		showXY(fdlocs);
		showXYZ(fdlocs);
		showAll(fdlocs);		
	}
}
```

## Generic Method 

```java
package _20Generics;
class GenMathodDemo{
	//determine if an object is in an array
	static <T , V extends T> boolean isInt(T x, V[] y){
		for (int i = 0; i< y.length; i++)
			if (x.equals(y[i]))
				return true;
		return false;
	}
}
public class _10GenericMethod {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer num[] = {1,2,3,4,5};
		GenMathodDemo obj = new GenMathodDemo();
		if (obj.isInt(2, num))
			System.out.println("2 consist in array");
		if (!obj.isInt(7, num))
			System.out.println("7 dose not consist in array");
		String str[] = {"x","y","z","a","b"};
		if (obj.isInt("y", str))
			System.out.println("y consist in array");
		if (!obj.isInt("I",str))
			System.out.println("I dose not consist in array");
	}
}
```

## Generic Constructor

```java
package _20Generics;
class GenCon{
	private double val;
	<T extends Number> GenCon(T o){
		val = o.doubleValue();
	}
	void show(){
		System.out.println(val);
	}
}
public class _11GenericConstructor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenCon obj1 = new GenCon(100);
		GenCon obj2 = new GenCon(100.001);
		obj1.show();
		obj2.show();
	}
}

```


## Generic Interface

```java
package _20Generics;
// ageneric interface example
// A Min/Max interface
interface MinMax<T extends Comparable <T>>{
	T min();
	T max();
}
class Myclass<T extends Comparable<T>> implements MinMax<T>{
	T[] val;
	Myclass(T[] o ){
		val = o;
	}
	public T min(){
		T v = val[0];
		for (int i = 0; i<val.length; i++)
		if (val[i].compareTo(v)<0)
			v = val[i];
		return v;
	}
	public T max(){
		T v = val[0];
		for (int i = 0; i<val.length; i++)
		if (val[i].compareTo(v)>0)
			v = val[i];
		return v;
	}
}
public class _12GenericInterface {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer num[] = {1,2,3,4,5};
		Character chs[] = {'b','r','p','w'};
		Myclass<Integer> obj1 = new Myclass<Integer>(num);
		Myclass<Character> obj2 = new Myclass<Character>(chs);
		System.out.println("Max is : "+obj1.max());
		System.out.println("Min is : "+obj1.min());
		System.out.println("Max is : "+obj2.max());
		System.out.println("Min is : "+obj2.min());

	}
}

```

## Raw Type Legacy Code

```java
package _20Generics;
class Gen1<T>{
	T obj;
	Gen1(T o){
		obj = o ;
	}
	T GetObj(){
		return obj;
	}
}
public class _13RawTypeLegacyCode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create generic object for Integer
		Gen1<Integer> iOb = new Gen1<Integer>(100);
		int x = iOb.GetObj();
		System.out.println(x);
		//create generic object for String
		Gen1<String> sOb = new Gen1<String>("Hii cm");
		String s = sOb.GetObj();
		System.out.println(s);
		//create raw type Gen object
		Gen1 raw =new Gen1(new Double(91.7));
		//cust here is necessary cos type is unknown
		double d = (Double)raw.GetObj();
		System.out.println(d);
	}
}
```

## Generic Super Class
```java
package _20Generics;
//A subclass can add its own type parameters.
class GeN11<T>{
	T obj;// declare an object of type T
	//Pass the constructor a reference to
	//an object of type T.
	GeN11(T o){
		obj = o;
	}
	T getObj1(){
		return obj;
	}
}
//A subclass of Gen that defines a second
//type parameter, called V.
class GeN2<T, V> extends GeN11<T>{
	V obj2;
	GeN2(T oo, V o2){
		super(oo);
		obj2 = o2;
	}
	V getObj2(){
		return obj2 ;
	}
}
public class _14GenericSuperClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeN2<String, Integer> x = new  GeN2<String, Integer>("Value is : ", 99);
		System.out.print(x.getObj1());
		System.out.println(x.getObj2());
	}
}
```

## Generic Sub Class

```java
package _20Generics;
class NonGen1{
	public int num;
	NonGen1(int c){
		num = c;
	}
	int getNum(){
		return num;
	}
}
class G<T>extends NonGen1{
	T obje;
	G(T o, int x){
		super(x);
		obje = o;
	}
	T getObje(){
		return obje;
	}
}
public class _15GenericSubClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	G<String> w = new G<String>("Abdullah", 200) ;
		System.out.println("Subclass Value :\t "+w.getObje());
		System.out.println("Superclass Value :\t "+w.getNum());
	}
}
```


## Rune Time Comparisone

```java
package _20Generics;
class G1<T>{
	T ob;
	G1(T o){
		ob = o;
	}
	T get(){
		return ob;
	}
}
class G2 extends G1<String>{
	G2(String o){
		super(o);
	}
	// A String override of get
	String get(){
		System.out.println("You called string get()");
		return ob;
	}
}
public class _16RuneTimeComparisone {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G2 obj = new G2("Generics Test");
		System.out.println(obj.get());
	}
}
```
