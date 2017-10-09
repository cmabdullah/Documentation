package Generics;
//page 621
class TwoTuple<A,B>{
	A ob1;
	B ob2;
	TwoTuple(A o1, B o2){
		ob1 = o1;
		ob2 = o2;
	}
	public String toString(){
		return "  ( "+ob1+", "+ob2+" )  ";
	}
}
public class _2TupleLibrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoTuple<String,String> genObj = new TwoTuple<String,String>("Abdullah ", "Khan") ;
		System.out.println(genObj.toString());
	}
}
