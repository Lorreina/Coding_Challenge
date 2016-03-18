
public class Find_the_Duplicate_Number {
	// same idea as the find the entry of cycled linked list.
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (Integer) null;
        }
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
