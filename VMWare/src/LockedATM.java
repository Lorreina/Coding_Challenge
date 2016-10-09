import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CC150 Synchrinization adn Locks
 * @author lorreina
 *
 */
public class LockedATM {
	private Lock lock1;
	private Lock lock2;
	private int balance = 100;
	
	public LockedATM() {
		lock1 = new ReentrantLock();
		lock2 = new ReentrantLock(); 
	}
	
	public int withdraw(int value) {
		lock1.lock();
		int tmp = balance;
		try {
			Thread.sleep(100);
			tmp = tmp - value;
			Thread.sleep(100);
			balance = tmp;
		} catch (InterruptedException exc) {
			
		}
		lock1.unlock();
		return balance;
	}
	
	public int deposit(int value) {
		lock1.lock();
		int tmp = balance;
		try {
			Thread.sleep(100);
			tmp = tmp + value;
			Thread.sleep(100);
			balance = tmp;
		} catch (InterruptedException exc) {
			
		}
		lock1.unlock();
		return balance;
	}
	public static void main(String[] args) {
		LockedATM atm = new LockedATM();
		atm.withdraw(10);
		atm.deposit(20);
		System.out.println(atm.balance);
	}
}


