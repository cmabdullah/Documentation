
> yp  https://www.youtube.com/watch?v=gpIUfj3KaOc&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3


# Lambda Expression
#### in this course

1. Understanding Lamdas
2. Using Lambdas
3. Functional interface
4. Method references
5. Collection improvements

#### Why lambdas

> Enable functional programming, lambda enable us to write functional programming in java.

> readable and concise code

> Easier to use API and libraries

> Enable support for parallel processing

#### Why fouctional programming

> functional programming really write better code more read
able code and so maintainable code.


## 05 Passing Behavior in OOP

### Greeter
```java
package _05PassingBehaviorinOOP;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		HelloWorldGreeting hellogreeting = new HelloWorldGreeting();
		greeter.greet(hellogreeting);
	}
}
```

### Greeting
```java
package _05PassingBehaviorinOOP;

public interface Greeting {
	public void perform();
}
```

### HelloWorldGreeting
```java
package _05PassingBehaviorinOOP;

public class HelloWorldGreeting implements Greeting {

	@Override
	public void perform() {
		System.out.println("Hello world");
	}
}
```


> Lambda creat these entities which are just functions they are called lambda expressions, which are just functions which donot belongs to a class , they are not methods of classthye are just functions which exist in isolation, functions can be treted as values. 

### 
```java

```
### 
```java

```


