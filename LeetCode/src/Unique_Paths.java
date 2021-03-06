/**
 * LeetCode
 * 62. Unique Paths
 * @author lorreina
 *
 */
public class Unique_Paths {
	public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        int[] dpTmp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dpTmp[j] = 1;
                } else {
                    dpTmp[j] = dpTmp[j - 1] + dp[j];
                }
            }
            int[] tmp = dp;
            dp = dpTmp;
            dpTmp = tmp;
        }
        
        return dp[dp.length - 1];
    }
	
	public static void main(String[] args) {
		int m = 1;
		int n = 2;
		Unique_Paths tmp = new Unique_Paths();
		System.out.println(tmp.uniquePaths(m, n));
	}
}
