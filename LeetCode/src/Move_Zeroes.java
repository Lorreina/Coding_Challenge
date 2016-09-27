/**
 * LeetCode
 * 283. Move Zeroes
 * @author lorreina
 *
 */
public class Move_Zeroes {
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }
        
        for (int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }
        
        return;
    }
}
