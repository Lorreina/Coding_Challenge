import java.util.ArrayList;
import java.util.HashMap;

/**
 * LeetCode
 * 381. Insert Delete GetRandom O(1) - Duplicates allowedß
 * @author lorreina
 *
 */
public class Insert_Delete_GetRandom_all_duplicate {
	public static class RandomizedCollection {
	    ArrayList<Integer> array;
	    HashMap<Integer, ArrayList<Integer>> map;
	    java.util.Random rand = new java.util.Random();

	    /** Initialize your data structure here. */
	    public RandomizedCollection() {
	        array = new ArrayList<Integer> ();
	        map = new HashMap<Integer, ArrayList<Integer>> ();
	    }
	    
	    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	    public boolean insert(int val) {
	        if (!map.containsKey(val)) {
	            ArrayList<Integer> thisArray = new ArrayList<Integer>();
	            thisArray.add(array.size());
	            map.put(val, thisArray);
	            array.add(val);
	            return true;
	        } else {
	            map.get(val).add(array.size());
	            array.add(val);
	            return false;
	        }
	    }
	    
	    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	    public boolean remove(int val) {
	        if (map.containsKey(val)) {
	            ArrayList<Integer> thisArray = map.get(val);
	            int lastElement = array.remove(array.size() - 1);
	            if (lastElement == val) {
	                thisArray.remove(thisArray.size() - 1);
	            } else {
	                int index = thisArray.remove(thisArray.size() - 1);
	                if (index >= array.size()) {
	                	System.out.println("whoops");
	                }
	                array.set(index, lastElement);
	                ArrayList<Integer> lastElementList = map.get(lastElement);
	                for (int i = lastElementList.size() - 1; i >= 0; i--) {
	                	if (lastElementList.get(i) == array.size()) {
	                		lastElementList.set(i, index);
	                	}
	                }
	            }
	            
	            if (thisArray.size() == 0) {
	                map.remove(val);
	            }
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    /** Get a random element from the collection. */
	    public int getRandom() {
	        int index = rand.nextInt(array.size());
	        return array.get(index);
	    }
	}

	/**
	 * Your RandomizedCollection object will be instantiated and called as such:
	 * RandomizedCollection obj = new RandomizedCollection();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */
	
	public static void main(String[] args) {
		RandomizedCollection obj = new RandomizedCollection();
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.insert(2));
		System.out.println(obj.insert(2));
		
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(2));
		
		System.out.println(obj.insert(1));
		System.out.println(obj.remove(2));
		
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}
}
