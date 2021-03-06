/**
 * LeetCode
 * 91. Decode Ways
 * @author lorreina
 *
 */
public class Decode_Ways {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = 1;
        char[] nums = s.toCharArray();
        
        for (int i = 2; i < dp.length; i++) {
            if (nums[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            
            if (nums[i - 2] == '1' || (nums[i - 2] == '2' && nums[i - 1] >= '0' && nums[i - 1] <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		Decode_Ways tmp = new Decode_Ways();
		String s = "10";
		System.out.println(tmp.numDecodings(s));
	}
}
