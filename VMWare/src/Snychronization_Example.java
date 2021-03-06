/**
 * CC150 Locks Example
 * @author lorreina
 *
 */
public class Snychronization_Example {
	public class MyClass extends Thread {
		MyObject obj;
		String name;
		public MyClass (MyObject obj, String name) {
			this.obj = obj;
			this.name = name;
		}
		
		public void run() {
			obj.foo(name);
		}
	}
	
	public class MyObject {
		public synchronized void foo(String name) {
			try {
				System.out.println("Thread " + name + ".foo(): starts.");
				Thread.sleep(3000);
				System.out.println("Thread " + name + ".foo(): ends.");
			} catch (InterruptedException exc) {
				System.out.println("Thread " + name + " interrupted.");
			}
		}
	}
	
	/* different ref - both threads c an call MyObject.foo() */
	public void test1() {
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		MyClass thread1 = new MyClass(obj1, "1");
		MyClass thread2 = new MyClass(obj2, "2");
		
		thread1.start();
		thread2.start();
	}
	
	
	/* same ref to obj. Only one will be allowed to call foo, and the other will be forced to wait. */
	public void test2() {
		MyObject obj = new MyObject();
		MyClass thread1 = new MyClass(obj, "1");
		MyClass thread2 = new MyClass(obj, "2");
		
		thread1.start();
		thread2.start();
	}
	
	
	public static void main(String[] args) {
		Snychronization_Example tmp = new Snychronization_Example();
		tmp.test1();
//		tmp.test2();
	}
}
