import java.util.Arrays;

/**
 * LeetCode
 * 377. Combination Sum IV
 * @author lorreina
 *
 */
public class Combination_Sum_IV {
	public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int[] res = new int[target + 1];
        res[0] = 1;
        
        for(int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                res[i] += res[i - num];
            }
        }
        
        return res[target];
    }
}
