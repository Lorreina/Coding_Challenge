/**
 * LeetCode
 * 221. Maximal Square
 * @company: Facebook, Airbnb
 * @author lorreina
 *
 */
public class Maximal_Square {
	public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] b = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    b[i][j] = Math.min(b[i - 1][j - 1], Math.min(b[i][j - 1], b[i - 1][j])) + 1;
                    res = Math.max(res, b[i][j]);
                }
            }
        }
        
        return res * res;
    }
}
