
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
	public static class runA implements Runnable {
		Lock lock1;
		Lock lock2;
		public runA(Lock lock1, Lock lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
		}
		public void run() {
			this.lock1.lock();
			System.out.println(Thread.currentThread().getName() + " lock1");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
			this.lock2.lock();
			System.out.println(Thread.currentThread().getName() + " lock2");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
			lock2.unlock();
			lock1.unlock();
		}
	}
	
	public static class runB implements Runnable {
		Lock lock1;
		Lock lock2;
		public runB(Lock lock1, Lock lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
		}
		public void run() {
			this.lock2.lock();
			System.out.println(Thread.currentThread().getName() + " lock2");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
			this.lock1.lock();
			System.out.println(Thread.currentThread().getName() + " lock2");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
			lock1.unlock();
			lock2.unlock();
		}
	}
	public static void main(String[] args) {
		final Lock lock1 = new ReentrantLock();
		final Lock lock2 = new ReentrantLock();

//		Runnable runA = new Runnable() {
//			public void run() {
//				lock1.lock();
//				System.out.println(Thread.currentThread().getName() + " lock1");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				lock2.lock();
//				System.out.println(Thread.currentThread().getName() + " lock2");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				lock2.unlock();
//				lock1.unlock();
//			}
//		};
		
		runA instanceA = new runA(lock1, lock2);
		runB instanceB = new runB(lock1, lock2);
		Thread threadA = new Thread(instanceA, "threadA");
		Thread threadB = new Thread(instanceB, "threadB");
		
//		Thread threadA = new Thread(runA, "threadA");
		threadA.start();

//		Runnable runB = new Runnable() {
//			public void run() {
//				lock2.lock();
//				System.out.println(Thread.currentThread().getName() + " lock2");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				lock1.lock();
//				System.out.println(Thread.currentThread().getName() + " lock1");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				lock1.unlock();
//				lock2.unlock();
//			}
//		};
//
//		Thread threadB = new Thread(runB, "threadB");
		threadB.start();

		
	}
}
