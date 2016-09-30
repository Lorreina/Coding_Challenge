/**
 * LeetCode
 * 304. Range Sum Query 2D - Immutable
 * @author lorreina
 *
 */
public class Range_Sum_Query_2D_Immutable {
	public class NumMatrix {
	    
	    private int[][] dp;

	    public NumMatrix(int[][] matrix) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return;
	        }
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        // construct dp array
	        // dp[i][j] stores the sum of rectangle (0,0)(i - 1, j - 1)
	        dp = new int[m + 1][n + 1];
	        for (int i = 1; i < m + 1; i++) {
	            for (int j = 1; j < n + 1; j++) {
	                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
	            }
	        }
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	    }
	}


	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.sumRegion(1, 2, 3, 4);
}
