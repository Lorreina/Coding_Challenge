/**
 * 35. Search Insert Position
 * @author lorreina
 *
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return helper(nums,  target, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (target <= nums[start]) {
                return start;
            } else {
                return start + 1;
            }
        }
        
        if (start == end - 1) {
            if (target <= nums[start]) {
                return start;
            } else if (target <= nums[end]) {
                return end;
            } else {
                return end + 1;
            }
        }
        
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return helper(nums, target, start, mid - 1);
        } else {
            return helper(nums, target, mid + 1, end);
        }
    }
}
