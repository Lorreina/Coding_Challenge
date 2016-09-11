/**
 * LeetCode
 * 361. Bomb Enermy
 * @author lorreina
 *
 */
public class Bomb_Enermy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        // up to down
        int[][] utd = new int[m][n];
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'E') {
                   count += 1;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                }  
                utd[i][j] = count;
            }
        }
        
        // down to up
        int[][] dtu = new int[m][n];
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 'E') {
                   count += 1;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                }  
                dtu[i][j] = count;
            }
        }
        
        // left to right
        int[][] ltr = new int[m][n];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') {
                   count += 1;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                }  
                ltr[i][j] = count;
            }
        }
        
        // right to left
        int[][] rtl = new int[m][n];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                   count += 1;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                }  
                rtl[i][j] = count;
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            	if (grid[i][j] == '0') {
            		res = Math.max(res, utd[i][j] + dtu[i][j] + ltr[i][j] + rtl[i][j]);
            	}
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	char[][] grid = {{'O', 'E','0','0'}, {'E','0','W','E'}, {'0','E','0','0'}};
    	Bomb_Enermy tmp = new Bomb_Enermy();
    	System.out.println(tmp.maxKilledEnemies(grid));
    }
}