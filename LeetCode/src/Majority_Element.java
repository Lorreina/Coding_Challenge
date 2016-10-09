/**
 * LeetCode
 * 169. Majority Element
 * @author lorreina
 *
 */
public class Majority_Element {
	public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++; 
            } else if (count == 0) {
                majority = nums[i];
                count = 1;
            } else {
                count--;
            }
            
        }
        
        return majority;
    }
}
