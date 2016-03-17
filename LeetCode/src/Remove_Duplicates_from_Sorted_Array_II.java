/**
 * LeetCode
 * 80. Remove Duplicates from Sorted Array II
 * @author lorreina
 *
 */
public class Remove_Duplicates_from_Sorted_Array_II {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int dup = 1; // the total number of elements that left
        int count = 1; // count the times that each integer occurs, allowed up to 2 times otherwise drop it
        int last = nums[0]; // the value of last left integer
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                nums[dup] = nums[i];
                last = nums[i];
                count = 1;
                dup++;
            } else {
                if (count == 1) {
                    nums[dup] = nums[i];
                    dup++;
                    count = 2;
                }
            }
        }
        
        return dup;
    }
}
