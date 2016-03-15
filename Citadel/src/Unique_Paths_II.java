
public class Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] solution = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        solution[0][0] = 1;
        
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                solution [0][i] = 0;
            } else {
                solution[0][i] = solution[0][i - 1];
            }
        }
        
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1) {
                solution[j][0] = 0;
            } else {
                solution[j][0] = solution[j - 1][0];
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[j][i] == 1) {
                    solution[j][i] = 0;
                } else {
                    solution[j][i] = solution[j - 1][i] + solution[j][i - 1];
                }
            }
        }
        return solution[m - 1][n - 1];
    }
}
