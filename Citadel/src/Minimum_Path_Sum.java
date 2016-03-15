
public class Minimum_Path_Sum {
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return (Integer) null;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] solution = new int[m][n];
        solution[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            solution[i][0] = solution[i - 1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            solution[0][j] = solution[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                solution[i][j] = Math.min(solution[i - 1][j], solution[i][j - 1]) + grid[i][j];
            }
        }
        
        return solution[m - 1][n - 1];
    }
}
