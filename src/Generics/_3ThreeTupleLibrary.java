package Generics;
class TwoTuple1<A,B>{
	A ob1;
	B ob2;
	TwoTuple1(A o1, B o2){
		ob1 = o1;
		ob2 = o2;
	}
	public String toString(){
		return "  ( "+ob1+", "+ob2+" )  ";
	}
}
class ThreeTuple<A,B, C> extends TwoTuple1{
	C ob3;
	ThreeTuple(A o1, B o2, C o3){
		super(o1,o2);
		ob3 = o3 ;
	}
	public String toString(){
		return "  ( "+ob1+", "+ob2+" , "+ ob3+ " )  ";
	}
}
class FourTuple<A,B, C,D> extends ThreeTuple{
	D ob4;
	FourTuple(A o1, B o2, C o3, D o4){
		super(o1,o2, o3);
		ob4 = o4 ;
	}
	public String toString(){
		return "  ( "+ob1+", "+ob2+" , "+ ob3+ " , "+ob4 +" )  ";
	}
}
public class _3ThreeTupleLibrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoTuple1<String,String> genObj = new TwoTuple1<String,String>("Abdullah ", "Khan") ;
		System.out.println(genObj.toString());

		ThreeTuple<String,String, String> genObj3 = new ThreeTuple<String,String, String>("Abdullah ", "Khan", "CM") ;
		System.out.println(genObj3.toString());

		FourTuple<String,String, Double, Integer> genObj4 = new FourTuple<String,String, Double, Integer>("Abdullah ", "Khan", 100.3 , 1000) ;
		System.out.println(genObj4.toString());
	}
}
