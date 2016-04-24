/**
 * LeetCode
 * 334. Increasing Triplet Subsequence
 * @company: Facebook
 * @author lorreina
 *
 */
public class Increasing_Triplet_Subsequence {
	public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        
        int i;
        int a = nums[0];
        int b = a;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
            } else {
                b = nums[i];
                break;
            }
        }
        i++;
        int a1 = a;
        for (; i < nums.length; i++) {
            if (nums[i] < a1) {
                a1 = nums[i];
            } else if (nums[i] > a1 && nums[i] < a) {
                a = a1;
                b = nums[i];
            } else if (nums[i] <= b && nums[i] > a) {
                b = nums[i];
            } else if (nums[i] > b) {
                return true;
            }
        }
        return false;
    }
}
