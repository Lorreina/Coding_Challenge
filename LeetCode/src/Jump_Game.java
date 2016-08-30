/**
 * LeetCode
 * 55. Jump Game
 * @author lorreina
 *
 */
public class Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums[0]; i++) {
            dp[i] = nums[0] - i;
        }
        
        for (int i = 1; i < nums.length - 1; i++) {
            if (dp[i] == 0 && nums[i] == 0) {
                return false;
            }
            if (nums[i] >= nums.length - i - 1) {
                return true;
            }
            if (dp[i] < nums[i]) {
                for (int j = 0; j < nums[i]; j++) {
                    dp[i + j] = nums[i] - j;
                }
            }
        }
        
        return true;
    }
}
