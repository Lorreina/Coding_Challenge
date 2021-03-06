/**
 * LeetCode
 * 75. Sort Colors
 * @company: Facebook
 * @author lorreina
 *
 */
public class Sort_Colors {
	public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) {
                swap(nums, i, two);
                two--;
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero);
                zero++;
            }
        }
    }
    
    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2, 0};
    	sortColors(nums);
    }
}
