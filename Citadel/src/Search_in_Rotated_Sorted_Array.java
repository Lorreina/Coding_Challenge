
public class Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        
        return searchRotate(nums, 0, nums.length - 1, target);
    }
	
	private int searchRotate(int nums[], int start, int end, int target) {
		if (end - start < 2) {
			return searchRange(nums, start, end, target);
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[mid] > nums[start]) {
			if (nums[start] <= target && target < nums[mid]) {
				return searchBinary(nums, start, mid - 1, target); 
			} else {
				return searchRotate(nums, mid + 1, end, target);
			}
		} else {
			if (target <= nums[end] && target > nums[mid]) {
				return searchBinary(nums, mid + 1, end, target);
			} else {
				return searchRotate(nums, start, mid - 1, target);
			}
		}
	}
	
	private int searchRange(int[] nums, int start, int end, int target) {
		for (int i = start; i < end + 1; i++) {
			if (nums[i] == target) {
				return i;
			}
		}
		return -1;
	}

	private int searchBinary(int[] nums, int start, int end, int target) {
		if (end - start < 2) {
			return searchRange(nums, start, end, target);
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (target < nums[mid]) {
			return searchBinary(nums, start, mid - 1, target);
		} else {
			return searchBinary(nums, mid + 1, end, target);
		}
	}
}
