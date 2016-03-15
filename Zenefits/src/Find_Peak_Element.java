/**
 * LeetCode
 * 162. Find Peak Element
 * @author lorreina
 *
 */
public class Find_Peak_Element {
	public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
	// log(n) time complexity using binary search
	// 1) if nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1] => mid is peak
	// 2) if nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1] => peak is between start ~ mid - 1
    // 3) if nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1] => peak is between mid + 1 ~ end
	// 4) if nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1] => peak exists at both sides, use either one.
	private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            if (nums[start] > nums[end]) {
                return start;
            } else {
                return end;
            }
        }
        
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if (nums[mid] < nums[mid - 1]) {
            return helper(nums, start, mid - 1);
        }
        return helper(nums, mid + 1, end);
    }
}
