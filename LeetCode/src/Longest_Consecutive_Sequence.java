import java.util.HashSet;

/**
 * LeetCode
 * 128. Longest Consecutive Sequence
 * @author lorreina
 *
 */
public class Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<Integer> ();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int m = n + 1;
                while (set.contains(m)) {
                    m += 1;
                }
                res = Math.max(res, m - n);
            }
        }
        
        return res;
     }
}
