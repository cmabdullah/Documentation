package Generics;
import java.util.*;
class Automobile{

}
class Holder3<T>{
	T ob;
	Holder3(T o){
		ob = o;
	}
	void set(T o){
		ob = o;
	}
	T get(){
		return ob;
	}
}
public class _1SimpleGenericsProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder3<Automobile> obj = new Holder3<Automobile>(new Automobile());
		obj.get();
		//obj.set("aaa");
		System.out.println("Generics");

	}

}
