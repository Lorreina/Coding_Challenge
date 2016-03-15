/**
 * LeetCode
 * 53. Maximum Subarray
 * @author lorreina
 *
 */
public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (Integer) null;
        }
        
        int[] sum = new int [nums.length];
        sum[0] = nums[0];
        int maxSub = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            maxSub = Math.max(maxSub, sum[i]);
        }
        
        return maxSub;
    }
}
