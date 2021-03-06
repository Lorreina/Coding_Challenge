import java.util.HashMap;

/**
 * LeetCode
 * 325. Maximum Size Subarray Sum Equals k
 * @author lorreina
 *
 */
public class Maximum_Size_Subarray_Sum_Equals_k {
	public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = i + 1;
            } else {
                int diff = sum - k;
                if (map.containsKey(diff)) {
                    maxLen = Math.max(maxLen, i - map.get(diff));
                }
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
