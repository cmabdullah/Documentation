package Generics;
class Amphibian {}
class Vehicle {}
public class _4TupleTest {

	static TwoTuple<String,Integer> f() {
		return new TwoTuple<String,Integer>("hi", 47);
	}
	static ThreeTuple<Amphibian,String,Integer> g() {
		return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
	}
	static FourTuple<Vehicle,Amphibian,String,Integer> h() {
		return new FourTuple<Vehicle,Amphibian,String,Integer>(new Vehicle(), new Amphibian(), "hi", 47);
	}
//	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
//		return new FiveTuple<Vehicle,Amphibian,String,Integer,Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoTuple<String,Integer> ttsi = f();
		System.out.println(ttsi);
		// ttsi.first = "there"; // Compile error: final
		System.out.println(g());
		System.out.println(h());
//		System.out.println(k());

	}

}
