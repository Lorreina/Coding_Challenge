/**
 * LeetCode
 * 33. Search in Rotated Sorted Array 
 * @author lorreina
 *
 */
public class Search_In_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int minIndex = findMin(nums);
        
        if (target == nums[minIndex]) {
            return minIndex;
        }
        
        int start = 0;
        int end = nums.length - 1;
        if (minIndex > 0) {
	        if (target >= nums[0]) {
	            end = minIndex - 1;
	        } else {
	            start = minIndex + 1;
	        }
        }
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    private int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
    
    public static void main(String[] args) {
    	Search_In_Rotated_Sorted_Array tmp = new Search_In_Rotated_Sorted_Array();
    	int[] nums = {1, 3};
    	int target = 3;
    	System.out.println(tmp.search(nums, target));
    }
}
