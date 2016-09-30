/**
 * LeetCode
 * @author lorreina
 *
 */
public class Patching_Array {
	public int minPatches(int[] nums, int n) {
        int size = 0;
        int i = 0;
        long miss = 1;
        int count = 0;
        
        if (nums != null) {
            size = nums.length;
        }
        
        while (miss <= n) {
            if (i < size && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                count += 1;
                miss += miss;
            }
        }
        
        return count;
    }
}
