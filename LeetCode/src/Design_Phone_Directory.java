import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode
 * 379. Design Phone Directory
 * @author lorreina
 *
 */
public class Design_Phone_Directory {
	public class PhoneDirectory {
	    int maxNumbers;
	    List<Integer> list;
	    Set<Integer> set;

	    /** Initialize your data structure here
	        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	    public PhoneDirectory(int maxNumbers) {
	        this.maxNumbers = maxNumbers;
	        set = new HashSet<Integer> ();
	        list = new ArrayList<Integer> ();
	        for (int i = 0; i < maxNumbers; i++) {
	            list.add(i);
	        }
	        
	    }
	    
	    /** Provide a number which is not assigned to anyone.
	        @return - Return an available number. Return -1 if none is available. */
	    public int get() {
	        if (list.size() == 0) {
	            return -1;
	        }
	        int number = list.remove(0);
	        set.add(number);
	        
	        return number;
	    }
	    
	    /** Check if a number is available or not. */
	    public boolean check(int number) {
	        if (set.contains(number)) {
	            return false;
	        }
	        return true;
	    }
	    
	    /** Recycle or release a number. */
	    public void release(int number) {
	        if (set.contains(number)) {
	            set.remove(number);
	            list.add(number);
	        }
	    }
	}

	/**
	 * Your PhoneDirectory object will be instantiated and called as such:
	 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
	 * int param_1 = obj.get();
	 * boolean param_2 = obj.check(number);
	 * obj.release(number);
	 */
}
