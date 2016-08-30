import java.util.ArrayList;
import java.util.HashMap;

/**
 * LeetCode
 * 380. Insert Delete GetRandom O(1)
 * @author lorreina
 *
 */
public class Insert_Delete_GetRandom {
	public static class RandomizedSet {
	    // resizable array to store each element, didn't remove any element
	    ArrayList<Integer> array;
	    // key = element value, value = element's index in the array
	    HashMap<Integer, Integer> map;
	    java.util.Random rand = new java.util.Random();
	    
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        array = new ArrayList<Integer> ();
	        map = new HashMap<Integer, Integer> ();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        // element val is alrealy in the set
	        if (map.containsKey(val)) {
	            return false;
	        }
	        // add new element to the set
	        map.put(val, array.size());
	        array.add(val);
	        
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if (map.containsKey(val)) {
	            // swap the element with the last element in the array.
	        	// then remove the last element of the current array.
	            int index = map.get(val);
	            int last = array.get(array.size() - 1);
	            map.put(last, index);
	            array.set(index, last);
	            array.remove(array.size() - 1);
	            
	            // removet the element from hashmap.
	            map.remove(val);
	            return true;
	        }
	        return false;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	int index = rand.nextInt(array.size());
	        return array.get(index);
	    }
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */
	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(0));
		System.out.println(obj.remove(0));
		System.out.println(obj.insert(-1));
		System.out.println(obj.remove(0));
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		
	}
}
