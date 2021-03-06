/**
 * CC150 Threads Example
 * @author lorreina
 *
 */
public class Threads_Example {
	public static class RunnableThreadExample implements Runnable {
		public int count = 0;
		
		public void run() {
			System.out.println("RunnableThread starting.");
			try {
				while (count < 5) {
					System.out.println("innner" + System.currentTimeMillis());
					Thread.sleep(500);
					count++;
				}
			} catch (InterruptedException exc) {
				System.out.println("RunnableThread interrupted.");
			}
			System.out.println("RunnableThread terminating.");
		}
	}
	
	public static class ThreadExample extends Thread {
		int count = 0;
		
		public void run() {
			System.out.println("Thread starting.");
			try {
				while (count < 5) {
					Thread.sleep(500);
					System.out.println("In Thread, count is " + count);
					count++;
				}
			} catch (InterruptedException exc) {
				System.out.println("Thread interrupted.");
			}
			System.out.println("Thread terminating.");
		}
	}
	
	public static void main(String[] args) {
//		RunnableThreadExample instance = new RunnableThreadExample();
//		Thread thread = new Thread(instance);
//		thread.start();
//		
//		while (instance.count < 5) {
//			try {
//				System.out.println("outter" + System.currentTimeMillis());
//				Thread.sleep(250);
//			} catch (InterruptedException exc) {
//				exc.printStackTrace();
//			}
//		}
		ThreadExample instance = new ThreadExample();
		instance.start();
		
		while (instance.count < 5) {
			try {
				System.out.println("outside: " + instance.count);
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
}
