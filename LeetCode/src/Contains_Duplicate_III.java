import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 220. Contains Duplicate III
 * @author lorreina
 *
 */
public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <=0 || t < 0) {
            return false;
        }
        
        if (nums == null || nums.length <= 1) {
            return false;
        }
        
        if (t == 0) {
            return containsNearbyDuplicate(nums, k);
        }
        
        HashMap<Long, Long> map = new HashMap<Long, Long> ();
        
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            
            if (map.containsKey(bucket)) {
                return true;
            } 
            if (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) {
                return true;
            } 
            if (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) {
                return true;
            }
            
            if (map.size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            
            map.put(bucket, remappedNum);
        }
        
        return false;
    }
    
    // reuse the code of Contains Duplicate II
    private boolean containsNearbyDuplicate(int[] nums, int k) {
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
