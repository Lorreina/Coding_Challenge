/**
 * LeetCode
 * 200. Number of Islands
 * @author lorreina
 *
 */
public class Number_of_Islands {
	public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void helper(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        
        // up 
        if (i > 0) {
            if (grid[i - 1][j] == '1') {
                helper(grid, i - 1, j);
            }
        }
        
        // down
        if (i < grid.length - 1) {
            if (grid[i + 1][j] == '1') {
                helper(grid, i + 1, j);
            }
        }
        
        // left
        if (j > 0) {
            if (grid[i][j - 1] == '1') {
                helper(grid, i, j - 1);
            }
        }
        
        // right
        if (j < grid[0].length - 1) {
            if (grid[i][j + 1] == '1') {
                helper(grid, i, j + 1);
            }
        }
    }
}
