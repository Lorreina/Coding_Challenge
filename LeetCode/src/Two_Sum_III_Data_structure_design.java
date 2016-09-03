import java.util.LinkedHashMap;

/**
 * LeetCode
 * 170. Two Sum III - Data structure design
 * @author lorreina
 *
 */
public class Two_Sum_III_Data_structure_design {
	public class TwoSum {
	    /*
	    LinkedHashSet<Integer> nums = new LinkedHashSet<Integer> ();
	    HashSet<Integer> sum = new HashSet<Integer> ();
	    */
	    
	    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer> ();
	    
	    
	    // Add the number to an internal data structure.
		public void add(int number) {
		    /*
		    if (nums.contains(number)) {
		        sum.add(number + number);
		    } else {
		        for (int n : nums) {
		            sum.add(n + number);
		        }
		        nums.add(number);
		    }
		    */
		    if (map.containsKey(number)) {
		        map.put(number, 2);
		    } else {
		        map.put(number, 1);
		    }
		    
		}

	    // Find if there exists any pair of numbers which sum is equal to the value.
		public boolean find(int value) {
		    /*
		    return sum.contains(value);
		    */
		    
		    for (int num : map.keySet()) {
		        int diff = value - num;
		        if (map.containsKey(diff)) {
		            if (diff == num) {
		                if (map.get(diff) == 2) {
		                    return true;
		                }
		            } else {
		                return true;
		            }
		        }
		    }
		    
		    return false;
		}
	}


	// Your TwoSum object will be instantiated and called as such:
	// TwoSum twoSum = new TwoSum();
	// twoSum.add(number);
	// twoSum.find(value);
}
