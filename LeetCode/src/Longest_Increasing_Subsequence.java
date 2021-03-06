import java.util.Arrays;

/**
 * LeetCode
 * 300. Longest Increasing Subsequence
 * @author lorreina
 *
 */
public class Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp[i] represents the smallest starter of subsequences of length (i + 1)
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int x : nums) {
            // index is the index that x should be insert to (or found)
            int index = Arrays.binarySearch(dp, 0, len, x);
            if (index < 0) {
                // not found, return index to insert
                index = -(index + 1);
            }
            
            dp[index] = x;
            if (index == len) {
                // found longer subsequence
                len++;
            }
        }
        
        return len;
        
    }
}
