# Generics 617-746 => 129 page

### Exercise 1: (1) Use Holders with the typeinfo.pets library to show that a Holders that is specified to hold a base type can also hold a derived type.

### Exercise 2: (1) Create a holder class that holds three objects of the same type, along with the methods to store and fetch those objects and a constructor to initialize all three.

### Exercise 3 : (1) Create and test a SixTuple generic. 

### Exercise 4: (3) "Generify" innerclasses/Sequence.java.

### Exercise 5: (2) Remove the type parameter on the Node class and modify the rest of the code in LinkedStack.java to show that an inner class has access to the generic type parameters of its outer class.

### Exercise 6: (1) Use RandomList with two more types in addition to the one shown in main( ).

### Exercise 7: (2) Use composition instead of inheritance to adapt Fibonacci to make it Iterable.

### Exercise 8: (2) Following the form of the Coffee example, create a hierarchy of StoryCharacters from your favorite movie, dividing them into GoodGuys and BadGuys. Create a generator for StoryCharacters, following the form of CoffeeGenerator.

### Exercise 9: (1) Modify GenericMethods.java so that f( ) accepts three arguments, all of which are of a different parameterized type.

### Exercise 10: (1) Modify the previous exercise so that one of f( )’s arguments is non- parameterized.

### Exercise 11: (1) Test New.java by creating your own classes and ensuring that New will work properly with them.

### Exercise 12: (1) Repeat the previous exercise using explicit type specification.

### Exercise 13: (4) Overload the fill( ) method so that the arguments and return types are the specific subtypes of Collection: List, Queue and Set. This way, you don’t lose the type of container. Can you overload to distinguish between List and LinkedList?

### Exercise 14: (1) Modify BasicGeneratorDemo.java to use the explicit form of creation for the Generator (that is, use the explicit constructor instead of the generic create( ) method).

### Exercise 15: (1) Verify the previous statement.

### Exercise 16: (2) Add a SixTuple to Tuple.java, and test it in TupleTest2 .j ava.

### Exercise 17: (4) Study the JDK documentation for EnumSet. You’ll see that there’s a clone( ) method defined. However, you cannot clone( ) from the reference to the Set interface passed in Sets.java. Can you modify Sets.java to handle both the general case of a Set interface as shown, and the special case of an EnumSet, using clone( ) instead of creating a new HashSet?

### Exercise 18: (3) Following the form of BankTeller.java, create an example where
BigFish eat LittleFish in the Ocean.

### Exercise 19: (2) Following the form of Store.java, build a model of a containerized cargo ship.

### Exercise 20: (1) Create an interface with two methods, and a class that implements that interface and adds another method. In another class, create a generic method with an argument type that is bounded by the interface, and show that the methods in the interface are callable inside this generic method. In main( ), pass an instance of the implementing class to the generic method.

### Exercise 21: (4) Modify ClassTypeCapture.java by adding a Map<String,Class<?>>, a method addType(String typename, Class<?> kind), and a method createNew(String typename). createNew( ) will either produce a new instance of the class associated with its argument string, or produce an error message.

### Exercise 22: (6) Use a type tag along with reflection to create a method that the argument version of newInstance( ) to create an object of a class with a constructor that has arguments.

### Exercise 23: (1) Modify FactoryConstraint.java so that create( ) takes an argument.

### Exercise 24: (3) Modify Exercise 21 so that factory objects are held in the Map instead of Class<?>.

### Exercise 25: (2) Create two interfaces and a class that implements both. Create two generic methods, one whose argument parameter is bounded by the first interface and one whose argument parameter is bounded by the second interface. Create an instance of the class that implements both interfaces, and show that it can be used with both generic methods.

### Exercise 26: (2) Demonstrate array covariance using Numbers and Integers. 

### Exercise 27: (2) Show that covariance doesn’t work with Lists, using Numbers and
Integers, then introduce wildcards.

### Exercise 28: (4) Create a generic class Generic1<T> with a single method that takes an argument of type T. Create a second generic class Generic2<T> with a single method that returns an argument of type T. Write a generic method with a contravariant argument of the first generic class that calls its method. Write a second generic method with a covariant argument of the second generic class that calls its method. Test using the typeinfo.pets library.

### Exercise 29: (5) Create a generic method that takes as an argument a Holder<List<?>>. Determine what methods you can and can’t call for the Holder and for the List. Repeat for an argument of List<Holder<?>>.

### Exercise 30: (2) Create a Holder for each of the primitive wrapper types, and show that autoboxing and autounboxing works for the set( ) and get( ) methods of each instance.

### Exercise 31: (1) Remove all the generics from MultipleInterfaceVariants.java and modify the code so that the example compiles.

### Exercise 32: (1) Verify that FixedSizeStack in GenericCast.java generates exceptions if you try to go out of its bounds. Does this mean that bounds-checking code is not required?

### Exercise 33: (3) Repair GenericCast.java using an ArrayList.

### Exercise 34: (4) Create a self-bounded generic type that contains an abstract method that takes an argument of the generic type parameter and produces a return value of the generic type parameter. In a non-abstract method of the class, call the abstract method and return its result. Inherit from the self-bounded type and test the resulting class.

### Exercise 35: (1) Modify CheckedList.java so that it uses the Coffee classes defined in this chapter.

### Exercise 36: (2) Add a second parameterized exception to the Processor class and demonstrate that the exceptions can vary independently.

### Exercise 37: (2) Add a new mixin class Colored to Mixins.java, mix it into Mixin, and show that it works.

### Exercise 38: (4) Create a simple Decorator system by starting with basic coffee, then providing decorators of steamed milk, foam, chocolate, caramel and whipped cream.

### Exercise 39: (1) Add a new mixin class Colored to DynamicProxyMixin.java, mix it into mixin, and show that it works.

### Exercise 40: (3) Add a speak( ) method to all the pets in typeinfo.pets. Modify Apply.java to call the speak( ) method for a heterogeneous collection of Pet.

### Exercise 41: (1) Modify Fill2.java to use the classes in typeinfo.pets instead of the Coffee classes.

### Exercise 42: (5) Create two separate classes, with nothing in common. Each class should hold a value, and at least have methods that produce that value and perform a modification upon that value. Modify Functional.java so that it performs functional operations on collections of your classes (these operations do not have to be arithmetic as they are in Functional.java).