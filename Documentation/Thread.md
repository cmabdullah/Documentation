
# 01 Basic Multithreading

### 01 Sequential Processing
```java
package _01BasicMultithreading;
class Runner1{
	public void startRunning() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Runner 1 " +i);
		}
	}
}
class Runner2{
	public void startRunning() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Runner 2 " +i);
		}
	}
}
public class _01SequentialProcessing {

	public static void main(String[] args) {

		Runner1 runner1 = new Runner1();
		Runner2 runner2 = new Runner2();
		
		runner1.startRunning();
		runner2.startRunning();

	}
}
/*******
Runner 1 0
Runner 1 1
Runner 1 2
Runner 1 3
Runner 1 4
Runner 1 5
Runner 1 6
Runner 1 7
Runner 1 8
Runner 1 9
Runner 1 10
Runner 1 11
Runner 1 12
Runner 1 13
Runner 1 14
Runner 1 15
Runner 1 16
Runner 1 17
Runner 1 18
Runner 1 19
Runner 2 0
Runner 2 1
Runner 2 2
Runner 2 3
Runner 2 4
Runner 2 5
Runner 2 6
Runner 2 7
Runner 2 8
Runner 2 9
Runner 2 10
Runner 2 11
Runner 2 12
Runner 2 13
Runner 2 14
Runner 2 15
Runner 2 16
Runner 2 17
Runner 2 18
Runner 2 19
*/
```

### 02 Starting ThreadsI Runnable
```java
package _01BasicMultithreading;
class Runner3 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Runner 3 " +i);
		}
	}
}
class Runner4 implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Runner 4 " +i);
		}
	}
}
public class _02StartingThreadsIRunnable {

	public static void main(String[] args) {
		Thread runner3 = new Thread(new Runner3());
		Thread runner4 = new Thread(new Runner4());
		runner3.start();
		runner4.start();
	}
}

/********
Runner 4 0
Runner 4 1
Runner 4 2
Runner 3 0
Runner 4 3
Runner 3 1
Runner 4 4
Runner 3 2
Runner 3 3
Runner 3 4
Runner 4 5
Runner 3 5
Runner 4 6
Runner 4 7
Runner 3 6
Runner 4 8
Runner 3 7
Runner 4 9
Runner 3 8
Runner 4 10
Runner 3 9
Runner 3 10
Runner 3 11
Runner 4 11
Runner 3 12
Runner 4 12
Runner 3 13
Runner 3 14
Runner 4 13
Runner 3 15
Runner 4 14
Runner 4 15
Runner 4 16
Runner 3 16
Runner 3 17
Runner 3 18
Runner 4 17
Runner 3 19
Runner 4 18
Runner 4 19
*/
```

### 04 Thread Join
```java
package _01BasicMultithreading;
class Runner7 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Runner 7 " +i);
		}
	}
}
class Runner8 extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Runner 8 " +i);
		}
	}
}
public class _04ThreadJoin {

	public static void main(String[] args) {
		Runner7 runner7 = new Runner7();
		Runner8 runner8 = new Runner8();
		runner7.start();
		runner8.start();
		
		try {
			runner7.join();//execute both thread , then execute Finished this task.....
			runner8.join();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("Finished this task.....");
	}
}
/*********
Runner 8 0
Runner 7 0
Runner 8 1
Runner 7 1
Runner 8 2
Runner 7 2
Runner 8 3
Runner 7 3
Runner 8 4
Runner 8 5
Runner 7 4
Runner 8 6
Runner 7 5
Runner 8 7
Runner 7 6
Runner 8 8
Runner 8 9
Runner 7 7
Runner 8 10
Runner 7 8
Runner 8 11
Runner 7 9
Runner 7 10
Runner 7 11
Runner 7 12
Runner 7 13
Runner 8 12
Runner 7 14
Runner 8 13
Runner 8 14
Runner 8 15
Runner 7 15
Runner 8 16
Runner 7 16
Runner 8 17
Runner 7 17
Runner 7 18
Runner 7 19
Runner 7 20
Runner 8 18
Runner 7 21
Runner 8 19
Runner 7 22
Runner 8 20
Runner 7 23
Runner 8 21
Runner 7 24
Runner 7 25
Runner 7 26
Runner 7 27
Runner 7 28
Runner 8 22
Runner 7 29
Runner 8 23
Runner 8 24
Runner 8 25
Runner 8 26
Runner 8 27
Runner 7 30
Runner 8 28
Runner 7 31
Runner 8 29
Runner 8 30
Runner 8 31
Runner 7 32
Runner 8 32
Runner 7 33
Runner 8 33
Runner 7 34
Runner 8 34
Runner 7 35
Runner 7 36
Runner 8 35
Runner 7 37
Runner 7 38
Runner 7 39
Runner 8 36
Runner 7 40
Runner 8 37
Runner 7 41
Runner 8 38
Runner 8 39
Runner 8 40
Runner 7 42
Runner 8 41
Runner 8 42
Runner 8 43
Runner 8 44
Runner 8 45
Runner 8 46
Runner 8 47
Runner 8 48
Runner 8 49
Runner 8 50
Runner 8 51
Runner 8 52
Runner 8 53
Runner 8 54
Runner 8 55
Runner 8 56
Runner 8 57
Runner 8 58
Runner 8 59
Runner 8 60
Runner 8 61
Runner 8 62
Runner 8 63
Runner 8 64
Runner 8 65
Runner 8 66
Runner 8 67
Runner 7 43
Runner 8 68
Runner 8 69
Runner 8 70
Runner 8 71
Runner 8 72
Runner 8 73
Runner 8 74
Runner 8 75
Runner 8 76
Runner 8 77
Runner 8 78
Runner 8 79
Runner 7 44
Runner 8 80
Runner 7 45
Runner 8 81
Runner 7 46
Runner 8 82
Runner 8 83
Runner 8 84
Runner 8 85
Runner 8 86
Runner 8 87
Runner 8 88
Runner 8 89
Runner 8 90
Runner 8 91
Runner 8 92
Runner 8 93
Runner 8 94
Runner 8 95
Runner 8 96
Runner 8 97
Runner 8 98
Runner 8 99
Runner 8 100
Runner 8 101
Runner 8 102
Runner 8 103
Runner 8 104
Runner 8 105
Runner 8 106
Runner 8 107
Runner 8 108
Runner 8 109
Runner 8 110
Runner 8 111
Runner 8 112
Runner 8 113
Runner 8 114
Runner 8 115
Runner 8 116
Runner 8 117
Runner 8 118
Runner 8 119
Runner 8 120
Runner 8 121
Runner 8 122
Runner 8 123
Runner 8 124
Runner 7 47
Runner 7 48
Runner 7 49
Runner 7 50
Runner 7 51
Runner 7 52
Runner 8 125
Runner 8 126
Runner 8 127
Runner 7 53
Runner 7 54
Runner 7 55
Runner 7 56
Runner 8 128
Runner 7 57
Runner 8 129
Runner 7 58
Runner 7 59
Runner 8 130
Runner 8 131
Runner 8 132
Runner 8 133
Runner 8 134
Runner 8 135
Runner 8 136
Runner 8 137
Runner 8 138
Runner 8 139
Runner 8 140
Runner 8 141
Runner 8 142
Runner 8 143
Runner 8 144
Runner 8 145
Runner 8 146
Runner 8 147
Runner 8 148
Runner 8 149
Runner 8 150
Runner 8 151
Runner 8 152
Runner 8 153
Runner 8 154
Runner 8 155
Runner 8 156
Runner 8 157
Runner 8 158
Runner 7 60
Runner 8 159
Runner 8 160
Runner 8 161
Runner 8 162
Runner 8 163
Runner 8 164
Runner 8 165
Runner 8 166
Runner 8 167
Runner 8 168
Runner 8 169
Runner 8 170
Runner 8 171
Runner 8 172
Runner 8 173
Runner 8 174
Runner 8 175
Runner 8 176
Runner 8 177
Runner 8 178
Runner 8 179
Runner 7 61
Runner 8 180
Runner 8 181
Runner 8 182
Runner 8 183
Runner 8 184
Runner 8 185
Runner 8 186
Runner 8 187
Runner 8 188
Runner 7 62
Runner 8 189
Runner 7 63
Runner 8 190
Runner 8 191
Runner 8 192
Runner 8 193
Runner 8 194
Runner 8 195
Runner 8 196
Runner 8 197
Runner 8 198
Runner 8 199
Runner 7 64
Runner 7 65
Runner 7 66
Runner 7 67
Runner 7 68
Runner 7 69
Runner 7 70
Runner 7 71
Runner 7 72
Runner 7 73
Runner 7 74
Runner 7 75
Runner 7 76
Runner 7 77
Runner 7 78
Runner 7 79
Runner 7 80
Runner 7 81
Runner 7 82
Runner 7 83
Runner 7 84
Runner 7 85
Runner 7 86
Runner 7 87
Runner 7 88
Runner 7 89
Runner 7 90
Runner 7 91
Runner 7 92
Runner 7 93
Runner 7 94
Runner 7 95
Runner 7 96
Runner 7 97
Runner 7 98
Runner 7 99
Runner 7 100
Runner 7 101
Runner 7 102
Runner 7 103
Runner 7 104
Runner 7 105
Runner 7 106
Runner 7 107
Runner 7 108
Runner 7 109
Runner 7 110
Runner 7 111
Runner 7 112
Runner 7 113
Runner 7 114
Runner 7 115
Runner 7 116
Runner 7 117
Runner 7 118
Runner 7 119
Runner 7 120
Runner 7 121
Runner 7 122
Runner 7 123
Runner 7 124
Runner 7 125
Runner 7 126
Runner 7 127
Runner 7 128
Runner 7 129
Runner 7 130
Runner 7 131
Runner 7 132
Runner 7 133
Runner 7 134
Runner 7 135
Runner 7 136
Runner 7 137
Runner 7 138
Runner 7 139
Runner 7 140
Runner 7 141
Runner 7 142
Runner 7 143
Runner 7 144
Runner 7 145
Runner 7 146
Runner 7 147
Runner 7 148
Runner 7 149
Runner 7 150
Runner 7 151
Runner 7 152
Runner 7 153
Runner 7 154
Runner 7 155
Runner 7 156
Runner 7 157
Runner 7 158
Runner 7 159
Runner 7 160
Runner 7 161
Runner 7 162
Runner 7 163
Runner 7 164
Runner 7 165
Runner 7 166
Runner 7 167
Runner 7 168
Runner 7 169
Runner 7 170
Runner 7 171
Runner 7 172
Runner 7 173
Runner 7 174
Runner 7 175
Runner 7 176
Runner 7 177
Runner 7 178
Runner 7 179
Runner 7 180
Runner 7 181
Runner 7 182
Runner 7 183
Runner 7 184
Runner 7 185
Runner 7 186
Runner 7 187
Runner 7 188
Runner 7 189
Runner 7 190
Runner 7 191
Runner 7 192
Runner 7 193
Runner 7 194
Runner 7 195
Runner 7 196
Runner 7 197
Runner 7 198
Runner 7 199
Finished this task....
*/
```

### 05 Thread Volatile
```java
package _01BasicMultithreading;
class Worker implements Runnable{
	//private boolean isTerminated = false;//read from cash memory
	private volatile boolean isTerminated = false;//read from main memory(ram)
	int i = 1;
	@Override
	public void run() {
		while(!isTerminated) {
			System.out.println("Hello from worker......" +(i++));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean isTerminated() {
		return isTerminated;
	}
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	
}
public class _05ThreadVolatile {

	public static void main(String[] args) {
		Worker worker = new Worker();
		Thread thread = new Thread(worker);
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.setTerminated(true);
		System.out.println("Finished.......");
	}
}
/*******
Hello from worker......1
Hello from worker......2
Hello from worker......3
Hello from worker......4
Hello from worker......5
Hello from worker......6
Hello from worker......7
Hello from worker......8
Hello from worker......9
Hello from worker......10
Finished.......
*/
```
### 06 Thread Dead lock
```java
package _01BasicMultithreading;

public class _06ThreadDeadlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Two process blocked each other is called dedlock");
		System.out.println("Deadlock is a situation in which two or more competing actions are each waiting for the other to finish, and thus neither ever does\n" + 
				"Databases  deadlock happens when two processes each within its own transaction updates two rows of information but in the opposite order. \n"
				+ "For example, process A updates row 1 then row 2 in the exact timeframe that process B updates row 2 then row 1 !!!\n" + 
				"Operating system  a deadlock is a situation which occurs when a process or thread enters a waiting state \n"
				+ "because a resource requested is being held by another waiting process, which in turn is waiting for \n"
				+ "another resource held by another waiting process");
	}
}
/********
Two process blocked each other is called dedlock
Deadlock is a situation in which two or more competing actions are each waiting for the other to finish, and thus neither ever does
Databases  deadlock happens when two processes each within its own transaction updates two rows of information but in the opposite order. 
For example, process A updates row 1 then row 2 in the exact timeframe that process B updates row 2 then row 1 !!!
Operating system  a deadlock is a situation which occurs when a process or thread enters a waiting state 
because a resource requested is being held by another waiting process, which in turn is waiting for 
another resource held by another waiting process
*/
```
### 07 Thread Live lock
```java
package _01BasicMultithreading;

public class _07ThreadLivelock {
//class intransic lock
	public static void main(String[] args) {
		System.out.println("A thread often acts in response to the action of another thread\n" + 
				" If the other thread's action is also a response to the action of another thread   livelock !!!\n" + 
				"Livelocked threads are unable to make further progress. \n"
				+ "However, the threads are not blocked  \n"
				+ "they are simply too busy responding to each other to resume work\n" + 
				"Like two people attempting to pass each other in a narrow corridor: \n"
				+ "A moves to his left to let B pass, while B moves to his right to let A pass. \n"
				+ "They are still blocking each other, A moves to his right, while B moves to his left ... \n"
				+ " still not good");

	}

}
/******
Two process blocked each other is called dedlock
Deadlock is a situation in which two or more competing actions are each waiting for the other to finish, and thus neither ever does
Databases  deadlock happens when two processes each within its own transaction updates two rows of information but in the opposite order. 
For example, process A updates row 1 then row 2 in the exact timeframe that process B updates row 2 then row 1 !!!
Operating system  a deadlock is a situation which occurs when a process or thread enters a waiting state 
because a resource requested is being held by another waiting process, which in turn is waiting for 
another resource held by another waiting process
*/
```
### 08 Thread Synchronized I
```java
package _01BasicMultithreading;

public class _08ThreadSynchronizedI {
	
	public static int counter = 0;
	//public static void increment() {//result 15820
	public static synchronized void increment() {	//synchronized define thread 1 is waiting for thread 2, thread 2 is waiting for thread 1
		++counter; // when thread 1 is incrementing counter variable, that time other thread are blocked
	}
	public static void process() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					//System.out.println("Threas 1");
					increment();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					//System.out.println("Threas 2");
					increment();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		process();
		System.out.println(counter);

	}
}
/**
 * 20000
 */
```
### 09 Synchronized Blocks
```java
package _01BasicMultithreading;

public class _09SynchronizedBlocks {
	private static int count1 = 0;
	private static int count2 = 0;
	
	public synchronized static void add() {
		// when execute this method blocks all other threads...
		count1++;
	}
	public synchronized static void addAgain() {
		count2++;
	}
	
	public static void comput() {
		add();
		addAgain();
	}
	
	public static void main(String[] args) {
		
		Thread t1 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					comput();
				}
				
			}
		});
		
		Thread t2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					comput();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count 1 : "+count1 + " Count 2 : "+ count2);
	}
}
/**
Count 1 : 200 Count 2 : 200
*/
```
### 10 Synchronized Blocks Solution
```java
package _01BasicMultithreading;

public class _10SynchronizedBlocksSolution {
	private static int count1 = 0;
	private static int count2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public  static void add() {
		// when execute this method blocks all other threads...
		//synchronized(_10SynchronizedBlocksSolution.class) {//when execute this method block or lock all other threads... in the same class
			// how we get read of , we can not lock whole class, we can lock just an object
		synchronized(lock1) {	
			count1++;
		}
	}
	public static void addAgain() {
		//synchronized(_10SynchronizedBlocksSolution.class) {
		synchronized(lock2) {	// now thread1 dont wait thread2
			//they are totally independent
			count2++;
		}
	}
	
	public static void comput() {
		add();
		addAgain();
	}
	
	public static void main(String[] args) {
		
		Thread t1 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					comput();
				}
			}
		});
		
		Thread t2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					comput();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count 1 : "+count1 + " Count 2 : "+ count2);
	}
}

/****
Count 1 : 200 Count 2 : 200
*/
```
### 11 Waitand Notify
```java
package _01BasicMultithreading;
class Processor{
	public void produce() throws InterruptedException{
		synchronized (this) {//we are going to synchronized class itself....
			System.out.println("We are in the produce method.....");
			wait();
			System.out.println("Again produce method....");
		}	
	}
	public void consume() throws InterruptedException{
		synchronized (this) {
			System.out.println("Consume method");
			notify();//notify notify waiting thread.... that it can wait up...
			//notify is non deterministic.....
			//if any statement after notify method.... then notify() does not notify immediately to waiting thread....
			Thread.sleep(900);
		}
	}
}
public class _11WaitandNotify {

	public static void main(String[] args) {
		Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/*****
We are in the produce method.....
Consume method
Again produce method....
*/

```
### 12 Producerand Consumer
```java
package _01BasicMultithreading;

import java.util.ArrayList;
import java.util.List;

class Processor2{
	
	private final int LIMIT = 5;
	private final int BOTTOM = 0 ;
	private int value = 0;
	private final Object lock = new Object();
	private List<Integer> list = new ArrayList<>();
	public void produce() throws InterruptedException{
		synchronized (lock) {
			while(true) {
				if (list.size() == LIMIT) {
					System.out.println("Waiting for removing item....");
					lock.wait();
				}else {
					System.out.println("Adding : "+value);
					list.add(value);
					value++;
					lock.notify();
					/****
					 * every iteration we have to call notify() method
					 * in order to tell the other thread, okay if you want to do something 
					 * with this consumer method, you can get the lock
					 * if we get some code after notify() then it cannot control to the other thread.....
					 * */
					/****
					 * question: when we called notify method that time why its not hand back to the other thread?
					 * notify method will run inside this thread.
					 * when it get wait() it transfer control to the another thread...
					 * and lost operation of given method....
					 * */
				}
				Thread.sleep(300);
			}
		}	
	}
	public void consume() throws InterruptedException{
		synchronized (lock) {
			while(true) {
				if (list.size() == BOTTOM) {
					System.out.println("Waiting for adding item to the list....");
					lock.wait();
				}else {
					System.out.println("Removed : "+list.remove(--value));
					lock.notify();
				}
				Thread.sleep(300);
			}
		}
	}
}
public class _12ProducerandConsumer {

	public static void main(String[] args) {
		Processor2 processor = new Processor2();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/****
Adding : 0
Adding : 1
Adding : 2
Adding : 3
Adding : 4
Waiting for removing item....
Removed : 4
Removed : 3
Removed : 2
Removed : 1
Removed : 0
Waiting for adding item to the list....
Adding : 0
Adding : 1
Adding : 2
Adding : 3
Adding : 4
Waiting for removing item....
Removed : 4
Removed : 3
Removed : 2
Removed : 1
Removed : 0
*/
```
### 13 Thread Lock
```java
package _01BasicMultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _13ThreadLock {
	public static int counter = 0;
	public static Lock lock = new ReentrantLock();//it is equivalent as synchronized method
	/***
	 * Thread t1 and t2 is not able to run increment() at a same time
	 * coz they are locking on the same lock.
	 * 
	 * */
	public static void increment() {
		lock.lock();
		try {
			for(int i = 0; i<100000000; i++) {
				counter++;
			}
		} finally {
			lock.unlock();//unlock this thread...
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
				
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
	}
}
/**
 * 200000000
 */
```
### 14 Producer Consumer With Locks
```java
package _01BasicMultithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker2 {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void producer() throws InterruptedException {

		lock.lock();
		System.out.println("Producer method....");
		condition.await();// same as wait
		System.out.println("Producer again....");
		lock.unlock();

	}

	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("Consumer method....");
		condition.signal();// same as notify
		lock.unlock();

	}
}

public class _14ProducerConsumerWithLocks {

	public static void main(String[] args) {
		Worker2 worker2 = new Worker2();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					worker2.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					worker2.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//System.out.println("Done.....");
	}
}

/****
Producer method....
Consumer method....
Producer again....
*/
```
### 15 Semaphores II
```java
package _01BasicMultithreading;
/*****
 * Semaphore maintain set of permits
 * 	-acquire() -> if permit is available then takes it.
 *  -release() -> adds a permit....
 *  Semaphore just keep the number of count available
 *  Semaphore(int permit, boolean fair)
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downlader{
	
	INSTANCE ;
	
	private Semaphore semaphore = new Semaphore(3, true);
	
	public void downloadData() {
		try {
			semaphore.acquire();
			download();
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
	
	public void download() {
		System.out.println("Downloading data from web......");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class _15SemaphoresII {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Downlader.INSTANCE.downloadData();
					
				}
			});
		}
	}
}

/****
Downloading data from web......
Downloading data from web......
Downloading data from web......



Downloading data from web......
Downloading data from web......
Downloading data from web......


Downloading data from web......

Downloading data from web......
Downloading data from web......


Downloading data from web......

Downloading data from web......
Downloading data from web......



Downloading data from web......
Downloading data from web......
Downloading data from web......


Downloading data from web......

Downloading data from web......
Downloading data from web......



Downloading data from web......
Downloading data from web......
*/

```
### 16 Thread Executors
```java
package _01BasicMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*****
 * 1. ExecutorService executorService = Executors.newCachedThreadPool();
 * -going to an executorService that can dynamically
 * reuse threads
 * 
 * -before starting a job -> it going to check wheather thare are
 * any threads that finished the job....reuse them
 * 
 * -if there are no waiting threads -> it is going to 
 * create another one
 * -good for the processor.... effective solution
 * 
 * 2. ExecutorService executorService = Executors.newFixedThreadPool(3);
 * -maximize the number of threads
 * if we want to start a job -> if all threads are busy, we have to wait for one thread to terminate
 * 
 * 3. ExecutorService executorService = Executors.newSingleThreadExecutor();
 * It uses a single thread for the job
 * 
 * execute() -> runnable + callback
 * submit() -> runnable
 * */



class Worker3 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class _16ThreadExecutors {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		//ExecutorService executorService = Executors.newFixedThreadPool(3);
		//ExecutorService executorService = Executors.newSingleThreadExecutor();//behlf like single thread
		for (int i = 0; i < 6; i++) {
			executorService.submit(new Worker3());//new objects are created.....
		}
		executorService.shutdown();//not access any new thread, no new task will accepted, but running thread was not terminated immediately
	}
}

/****
0
0
0
0
0
0
1
1
1
1
1
1
2
2
2
2
2
2
3
3
3
3
3
3
4
4
4
4
4
4
5
5
5
5
5
5
6
6
6
6
6
6
7
7
7
7
7
7
8
8
8
8
8
8
9
9
9
9
9
9
10
10
10
10
10
10
*/
```
### 17 Callable And Future
```java
package _01BasicMultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class Processor5 implements Callable<String>{
	private int id;
	public Processor5(int id) {
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(500);
		return "Id : "+id;
	}
}
public class _17CallableAndFuture {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<String>> list = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			Future<String> future = executorService.submit(new Processor5(i+1));
			list.add(future);
		}
		
		for (Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();//not access any new thread, no new task will accepted, but running thread was not terminated immediately
	}
}
/****
Id : 1
Id : 2
Id : 3
Id : 4
Id : 5
*/
```


# 02 Concurrent Library

### 01 Count Down Latches
```java
package _02ConcurrentLibrary;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

///**
// * This is used to synchronize one or more tasks by forcing them to wait for the completion of a set of operations being performed by other tasks
// * 
// * 		- You give an initial count to a CountDownLatch object, and any task that calls await()
// * 				on that object will block until the count reaches zero
// * 
// * 		- Other tasks may call countDown() on the object to reduce the count, presumably when a task finishes its job
// * 		- A CountDownLatch is designed to be used in a one-shot fashion; the count cannot be reset !!!
// * 				If you need a version that resets the count, you can use a CyclicBarrier instead
// * 
// * 		- The tasks that call countDown() are not blocked when they make that call. Only the call to await() is blocked until the count reaches zero
// * 
// * 		A typical use is to divide a problem into n independently solvable tasks and create a CountDownLatch with a value of n.
// * 		When each task is finished it calls countDown() on the latch. Tasks waiting for the problem to be solved call await() 
// * 		on the latch to hold themselves back until it is completed
// *
// */

class Worker implements Runnable {

	private int id;
	private CountDownLatch latch;
	//private Random random;
	
	public Worker(int id, CountDownLatch latch) {
		this.latch = latch;
		this.id = id;
		//this.random = new Random();
	}

	public void run() {
		doWork();
		latch.countDown();//decrement the value of countdown.....
	}

	public void doWork() {
		try {
			System.out.println("Thread with ID "+this.id+" starts working...");
			Thread.sleep(1000);
			//Thread.sleep(this.random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class _01CountDownLatches {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++)
			executorService.execute(new Worker(i+1,latch));
		
		try {
			latch.await();//wait for every single worker to finish this job......
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All the prerequisites are done...");
		
		executorService.shutdown(); 
	}
}
/****
Thread with ID 1 starts working...
Thread with ID 2 starts working...
Thread with ID 3 starts working...
Thread with ID 4 starts working...
Thread with ID 5 starts working...
All the prerequisites are done...
*/
```
### 02 Cyclic Barriers
```java
package _02ConcurrentLibrary;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Latch --> multiple threads can wait for each other
 *
 * A CyclicBarrier is used in situations where you want to create a group of
 * tasks to perform work in parallel + wait until they are all finished before
 * moving on to the next step -> something like join() -> something like
 * CountDownLatch
 * 
 * CountDownLatch: one-shot event CyclicBarrier: it can be reused over and over
 * again
 * 
 * + cyclicBarrier has a barrier action: a runnable, that will run automatically
 * when the count reaches 0 !!
 * 
 * new CyclicBarrier(N) -> N threads will wait for each other
 *
 * WE CAN NOT REUSE LATCHES BUT WE CAN REUSE CyclicBarriers --> reset() !!!
 * 
 */

class Worker2 implements Runnable {

	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;

	public Worker2(int id, CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
		this.random = new Random();
		this.id = id;
	}

	@Override
	public void run() {
		doWork();
	}

	private void doWork() {
		System.out.println("Thread with ID " + id + " starts the task...");
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread with ID " + id + " finished...");

		try {
			cyclicBarrier.await();
			System.out.println("After await...");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public String toString() { return ""+this.id; };
}

public class _02CyclicBarriers {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("We are able to use the trained neural network...");
			}
		});
		
		for(int i=0;i<5;++i)
			executorService.execute(new Worker2(i+1, barrier));
		
		executorService.shutdown();
	}
}
/****
Thread with ID 1 starts the task...
Thread with ID 2 starts the task...
Thread with ID 3 starts the task...
Thread with ID 4 starts the task...
Thread with ID 5 starts the task...
Thread with ID 2 finished...
Thread with ID 3 finished...
Thread with ID 4 finished...
Thread with ID 5 finished...
Thread with ID 1 finished...
We are able to use the trained neural network...
After await...
After await...
After await...
After await...
After await...
*/
```
### 03 Blocking Queues
```java
package _02ConcurrentLibrary;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * 	BlockingQueue -> an interface that represents a queue that is thread safe
 * 		Put items or take items from it ...
 * 
 * 		For example: one thread putting items into the queue and another thread taking items from it
 * 			at the same time !!!
 * 				We can do it with producer-consumer pattern !!!
 * 
 * 		put() putting items to the queue
 * 		take() taking items from the queue
 * 
 */

class FirstWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;
	
	public FirstWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		int counter = 0;
		while(true) {
			try {
				blockingQueue.put(counter);
				System.out.println("Putting item to the queue..... "+counter);
				counter++;
	            Thread.sleep(10);

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }	
		}
		
	}
}

class SecondWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;
	
	public SecondWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
	            System.out.println("Taking item from the queue....."+blockingQueue.take());
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
	}
}

public class _03BlockingQueues {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

		FirstWorker firstWorker = new FirstWorker(queue);
		SecondWorker secondWorker = new SecondWorker(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
		
	}
}
/*****
Putting item to the queue..... 0
Taking item from the queue.....0
Putting item to the queue..... 1
Putting item to the queue..... 2
Putting item to the queue..... 3
Putting item to the queue..... 4
Putting item to the queue..... 5
Putting item to the queue..... 6
Putting item to the queue..... 7
Putting item to the queue..... 8
Putting item to the queue..... 9
Putting item to the queue..... 10
Taking item from the queue.....1
Putting item to the queue..... 11
Taking item from the queue.....2
Putting item to the queue..... 12
Taking item from the queue.....3
Putting item to the queue..... 13
Taking item from the queue.....4
Putting item to the queue..... 14
Taking item from the queue.....5
Putting item to the queue..... 15
Taking item from the queue.....6
Putting item to the queue..... 16
Taking item from the queue.....7
Putting item to the queue..... 17
Taking item from the queue.....8
Putting item to the queue..... 18
*/

```
### 04 Delay Queues
```java
package _02ConcurrentLibrary;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * This is an unbounded BlockingQueue of objects that implement the Delayed
 * interface
 * 
 * - DelayQueue keeps the elements internally until a certain delay has expired
 * 
 * - an object can only be taken from the queue when its delay has expired !!! -
 * 
 * We cannot place null items in the queue - The queue is sorted so that the
 * object at the head has a delay that has expired for the longest time.
 * 
 * If no delay has expired, then there is no head element and poll( ) will
 * return null
 * 
 * size() return the count of both expired and unexpired items !!!
 *
 */
/***
 * output
 * This is first message...... 
 * This is third message......
 * This is second message......
 * 
 * */
class DelayedWorker implements Delayed {

	private long duration;
	private String message;

	public DelayedWorker(long duration, String message) {
		this.duration = System.currentTimeMillis() + duration;
		this.message = message;
	}

	@Override
	public int compareTo(Delayed otherDelayed) {
		if (this.duration < ((DelayedWorker) otherDelayed).getDuration()) {
			return -1;
		}
		
		if (this.duration > ((DelayedWorker) otherDelayed).getDuration()) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public long getDelay(TimeUnit timeUnit) {
		return timeUnit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
public class _04DelayQueues {

	public static void main(String[] args) {

		BlockingQueue<DelayedWorker> blockingQueue = new DelayQueue<DelayedWorker>();

		try {
			blockingQueue.put(new DelayedWorker(1000, "This is first message......"));
			blockingQueue.put(new DelayedWorker(10000, "This is second message......"));
			blockingQueue.put(new DelayedWorker(4000, "This is third message......"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (!blockingQueue.isEmpty()) {
			try {
				System.out.println(blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
```
### 05 Priority Blocking Queues I
```java
package _02ConcurrentLibrary;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * It implements the BlockingQueue interface
 * 
 * 	- unbounded concurrent queue
 * 	- it uses the same ordering rules as the java.util.PriorityQueue class -> have to implement the COmparable interface
 * 			The comparable interface will determine what will the order in the queue
 * 
 * 			The priority can be the same compare() == 0 case
 * 
 *  - no null items !!!
 * 
 *
 */

class FirstWorker2 implements Runnable {

	private BlockingQueue<String> blockingQueue;
	
	public FirstWorker2(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put("B");
			blockingQueue.put("H");
			blockingQueue.put("F");
            Thread.sleep(1000);
            blockingQueue.put("A");
            Thread.sleep(1000);
            blockingQueue.put("E");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	
	}
}

class SecondWorker2 implements Runnable {

	private BlockingQueue<String> blockingQueue;
	
	public SecondWorker2(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

public class _05PriorityBlockingQueuesI {

	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();

		FirstWorker2 firstWorker = new FirstWorker2(queue);
		SecondWorker2 secondWorker = new SecondWorker2(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
		
	}
}
/**
A
B
E
*/
```
### 06 Priority Blocking Queues II
```java
package _02ConcurrentLibrary;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * It implements the BlockingQueue interface
 * 
 * 	- unbounded concurrent queue
 * 	- it uses the same ordering rules as the java.util.PriorityQueue class -> have to implement the COmparable interface
 * 			The comparable interface will determine what will the order in the queue
 * 
 * 			The priority can be the same compare() == 0 case
 * 
 *  - no null items !!!
 * 
 *
 */

class FirstWorker3 implements Runnable {

	private BlockingQueue<Integer> blockingQueue;
	
	public FirstWorker3(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put(100);
			blockingQueue.put(5);
			blockingQueue.put(50);
            Thread.sleep(1000);
            blockingQueue.put(3);
            Thread.sleep(1000);
            blockingQueue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	
	}
}

class SecondWorker3 implements Runnable {

	private BlockingQueue<Integer> blockingQueue;
	
	public SecondWorker3(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

public class _06PriorityBlockingQueuesII {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

		FirstWorker3 firstWorker = new FirstWorker3(queue);
		SecondWorker3 secondWorker = new SecondWorker3(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
		
	}
}
/***
3
3
5
50
100
*/
```
### 07 Priority Blocking Queues III
```java
package _02ConcurrentLibrary;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * It implements the BlockingQueue interface
 * 
 * 	- unbounded concurrent queue
 * 	- it uses the same ordering rules as the java.util.PriorityQueue class -> have to implement the COmparable interface
 * 			The comparable interface will determine what will the order in the queue
 * 
 * 			The priority can be the same compare() == 0 case
 * 
 *  - no null items !!!
 * 
 *
 */
class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Person otherPersonObject) {
		//return name.compareTo(otherPersonObject.getName());
		return Integer.compare(this.age,otherPersonObject.getAge());
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getAge() {
		return age;
	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	
	@Override
	public String toString() { 
		return "Name: "+name + " Age: "+age;
	}
	
}
class FirstWorker4 implements Runnable {

	private BlockingQueue<Person> blockingQueue;
	
	public FirstWorker4(BlockingQueue<Person> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put(new Person(70, "Abdullah"));
			blockingQueue.put(new Person(75, "Abida"));
			blockingQueue.put(new Person(50, "Rafid"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(50, "Rafi"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(50, "Sarim"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	
	}
}

class SecondWorker4 implements Runnable {

	private BlockingQueue<Person> blockingQueue;
	
	public SecondWorker4(BlockingQueue<Person> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

public class _07PriorityBlockingQueuesIII {

	public static void main(String[] args) {
		
		BlockingQueue<Person> queue = new PriorityBlockingQueue<>();

		FirstWorker4 firstWorker = new FirstWorker4(queue);
		SecondWorker4 secondWorker = new SecondWorker4(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();	
	}
}

/****
Name: Rafid Age: 50
Name: Sarim Age: 50
Name: Rafi Age: 50
Name: Abdullah Age: 70
Name: Abida Age: 75
*/
```
### 08 Concurrent Maps
```java
package _02ConcurrentLibrary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstWorker5 implements Runnable {

	private ConcurrentMap<String, Integer> map;
	
	public FirstWorker5(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			map.put("B",1);
			map.put("H",2);
			map.put("F",3);
            Thread.sleep(1000);
            map.put("A",4);
            Thread.sleep(1000);
            map.put("E",5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	
	}
}

class SecondWorker5 implements Runnable {

	private ConcurrentMap<String, Integer> map;
	
	public SecondWorker5(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("E"));
            Thread.sleep(1000);
            System.out.println(map.get("B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

public class _08ConcurrentMaps {

	public static void main(String[] args) {
		
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

		FirstWorker5 firstWorker = new FirstWorker5(map);
		SecondWorker5 secondWorker = new SecondWorker5(map);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
        
        List<String> list = new ArrayList<>();
        List<String> list2 = Collections.synchronizedList(list);
        
	}
}
/****
4
5
1
*/
```
### 09 Thread Exchangers
```java
package _02ConcurrentLibrary;


import java.util.concurrent.Exchanger;

/**
 * With the help of Exchanger -> two threads can exchange objects
 * 
 * exchange() -> exchanging objects is done via one of the two exchange()
 * methods
 * 
 * 	For example: genetic algorithms, training neural networks
 *
 */

class FirstWorker6 implements Runnable {

	private int counter;
	private Exchanger<Integer> exchanger;

	public FirstWorker6(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		while (true) {

			counter = counter + 1;
			System.out.println("FirstWorker incremented the counter: " + counter);
			
			try {
				counter = exchanger.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class SecondWorker6 implements Runnable {

	private int counter;
	private Exchanger<Integer> exchanger;

	public SecondWorker6(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		while (true) {

			counter = counter - 1;
			System.out.println("SecondWorker decremented the counter: " + counter);
			
			try {
				counter = exchanger.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class _09ThreadExchangers {

	public static void main(String[] args) {

		Exchanger<Integer> exchanger = new Exchanger<>();

		new Thread(new FirstWorker6(exchanger)).start();
		new Thread(new SecondWorker6(exchanger)).start();

	}
}
/***
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
SecondWorker decremented the counter: 0
FirstWorker incremented the counter: 1
SecondWorker decremented the counter: -1
FirstWorker incremented the counter: 0
*/
```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```
### 
```java

```


