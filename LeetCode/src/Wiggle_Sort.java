/**
 * LeetCode
 * 280. Wiggle Sort
 * @author lorreina
 *
 */
public class Wiggle_Sort {
	public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1] < 0) == flag) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
            flag = !flag;
        }
        
        return;
    }
}
