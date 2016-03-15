/**
 * LeetCode
 * 274. H-Index
 * @author lorreina
 *
 */
public class H_Index {
	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        // use extra array to store the frequency of possible h values.
        // possible h range is 0 ~ citations.length.
        int[] nums = new int[citations.length + 1];
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] <= citations.length) {
                nums[citations[i]]++;
            } else {
                nums[citations.length]++;
            }
        }
        
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
        	// sum is the total number of integers that above i.
            sum = sum + nums[i];
            // meet h-index requirement.
            if (sum >= i) { 
                return i;
            }
        }
        return 0;
    }
}
