/**
 * LeetCode
 * 153. Find Minimum in Rotated Sorted Array
 * @author lorreina
 *
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (Integer) null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int start, int end) {
        if (end == start) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (nums[mid] > nums[end]) {
            return helper(nums, mid + 1, end);
        } else {
            return helper(nums, start, mid - 1);
        }
    }
}
