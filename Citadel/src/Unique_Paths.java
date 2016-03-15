
public class Unique_Paths {
	public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        
        if (m == 1 || n == 1) {
            return 1;
        }
        
        int[][] solution = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            solution[0][i] = 1;
        }
        
        for (int j = 0; j < m; j++) {
            solution[j][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                solution[j][i] = solution[j - 1][i] + solution[j][i - 1];
            }
        }
        return solution[m - 1][n - 1];
    }
}
