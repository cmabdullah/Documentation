package Generics;
import java.util.*;
class Automobile{
//	private Automobile a;
//	public void Holder1(Automobile a){
//		this.a = a;
//	}
//	Automobile get() {
//		return a;
//	}
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
		//Automobile x = "A";
		Holder3<Automobile> obj = new Holder3<Automobile>(new Automobile());
		Automobile a = obj.get() ;
		//obj.set();
		System.out.println("Generics");
	}
}
