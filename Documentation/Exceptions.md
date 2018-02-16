# Now I am following [Thinking In Java](https://goo.gl/vmjMJs) & [The complete referrence](https://bit.do/cmabdullah)Book 

## Array Index Out Of Bounds Exception
```java
/**
➜  src pwd
/Users/abdullah/Documents/workspace/workspaceTwo/Exception/src
➜  src ls
ArithmaticException.java               ArrayIndexOutOfBoundsExceptionCm.java
ArrayIndexOutOfBoundsExceptionCm.class MultipleCatchClauses.java
➜  src javac ArrayIndexOutOfBoundsExceptionCm.java 
➜  src java ArrayIndexOutOfBoundsExceptionCm 10 20 
Primitiv addition result is : 30
➜  src  
*/
public class ArrayIndexOutOfBoundsExceptionCm {

	public static void main(String[] args) {
		try {
			String x = new String(args[0]);
			String y = new String(args[1]);
			String z = new String(args[2]);
			int a = Integer.parseInt(x);
			int b = Integer.parseInt(y);
			int c = Integer.parseInt(z);
			System.out.println("Primitiv addition result is : "+(a+b));			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception :"+e);
		}
	}
}

```
