/**
 * LeetCode
 * 213. House Robber II
 * @author lorreina
 *
 */
public class House_Robber_II {
	// Dynamic Programming
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // index = 0 is robbed.
        int[] robbed = new int[nums.length];
        // index = 0 is not robbed.
        int[] unrobbed = new int[nums.length];
        
        robbed[0] = nums[0];
        robbed[1] = Math.max(nums[0], nums[1]);
        
        unrobbed[0] = 0;
        unrobbed[1] = nums[1];
        
        for (int i = 2; i < nums.length; i++) {
            robbed[i] = Math.max(robbed[i - 1], robbed[i - 2] + nums[i]);
            unrobbed[i] = Math.max(unrobbed[i - 1], unrobbed[i - 2] + nums[i]);
        }
        
        return Math.max(robbed[nums.length - 2], unrobbed[nums.length - 1]);
    }
}
