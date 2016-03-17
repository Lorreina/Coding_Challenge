/**
 * LeetCode
 * 26. Remove Duplicates from Sorted Array
 * @author lorreina
 *
 */

// constance space complexity
// O(n) time complexity
public class Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                last = nums[i];
                nums[count] = nums[i];
                count++;
            }
        }
        
        return count;
    }
}
