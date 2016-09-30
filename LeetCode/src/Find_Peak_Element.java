/**
 * LeetCode
 * 162. Find Peak Element
 * @author lorreina
 *
 */
public class Find_Peak_Element {
	public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        
        if (start == end - 1) {
            if (nums[start] > nums[end]) {
                return start;
            } else {
                return end;
            }
        }
        
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid] < nums[mid - 1]) {
            return helper(nums, start, mid - 1);
        } else {
            return helper(nums, mid + 1, end);
        }
    }
}
