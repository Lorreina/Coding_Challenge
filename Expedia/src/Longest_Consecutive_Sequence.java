import java.util.HashMap;

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
        
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        int left = 0;
        int right = 0;
        int sum = 0;
        
        for (int n : nums) {
            left = 0;
            right = 0;
            sum = 0;
            if (!map.containsKey(n)) {
                if (map.containsKey(n - 1)) {
                    left = map.get(n - 1);
                }
                if (map.containsKey(n + 1)) {
                    right = map.get(n + 1);
                }
                // sum: length of the sequence n is in
                sum = left + right + 1;
                map.put(n, sum);
                // keep track of the max length 
                result = Math.max(sum, result);
                
                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        
        return result;
    }
}
