import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 219. Contains Duplicate II
 * @author lorreina
 *
 */

public class Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }
        
        if (nums == null || nums.length <= 1) {
            return false;
        }
     
        
        if (nums.length <= k) {
            HashSet<Integer> set = new HashSet<Integer> ();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
            }
        } else {
             HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
             for (int i = 0; i < k + 1; i++) {
                 if (map.containsKey(nums[i])) {
                     return true;
                 }
                 map.put(nums[i], i);
             }
             for (int j = k + 1; j < nums.length; j++) {
                 if (map.containsKey(nums[j])) {
                     if (j - map.get(nums[j]) > k){
                         map.put(nums[j], j);
                     } else {
                        return true; 
                     }
                 }
                 map.put(nums[j], j);
             }
        }
        
        return false;
    }
}
