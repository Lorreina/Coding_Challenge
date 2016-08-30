/**
 * LeetCode
 * 376. Wiggle Subsequence
 * @author lorreina
 *
 */
public class Wiggle_Subsequence {
	public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        int res = 1;
        int prev = nums[1] - nums[0];
        int next = 0;
        
        if (prev != 0) {
            res += 1;
        }
        
        for (int i = 2; i < nums.length; i++) {
            next = nums[i] - nums[i - 1];
            if (next == 0) {
                continue;
            }
            if ((next ^ prev) < 0) {
                res = res + 1;
                prev = next;
            } else {
                prev = prev + next;
            }
        }
        
        return res;
    }
}
