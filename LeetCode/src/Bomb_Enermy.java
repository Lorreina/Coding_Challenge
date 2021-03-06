/**
 * LeetCode
 * 361. Bomb Enermy
 * @author lorreina
 *
 */
public class Bomb_Enermy {
	// Solution 2: dp (versin 2)
	public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int maxKill = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] leftToRight = new int[m][n];
        int[][] rightToLeft = new int[m][n];
        int[][] topToBottom = new int[m][n];
        int[][] bottomToTop = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'E') {
                leftToRight[i][0] = 1;
            }
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 'E') {
                    leftToRight[i][j] = leftToRight[i][j - 1] + 1;
                } else if (grid[i][j] == '0') {
                    leftToRight[i][j] = leftToRight[i][j - 1];
                }
            }
            
            if (grid[i][n - 1] == 'E') {
                rightToLeft[i][n - 1] = 1;
            }
            
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    rightToLeft[i][j] = rightToLeft[i][j + 1] + 1;
                } else if (grid[i][j] == '0') {
                    rightToLeft[i][j] = rightToLeft[i][j + 1];
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 'E') {
                topToBottom[0][j] = 1;
            }
            
            for (int i = 1; i < m; i++) {
                if (grid[i][j] == 'E') {
                    topToBottom[i][j] = topToBottom[i - 1][j] + 1;
                } else if (grid[i][j] == '0') {
                    topToBottom[i][j] = topToBottom[i - 1][j];
                }
            }
            if (grid[m - 1][j] == 'E') {
                bottomToTop[m - 1][j] = 1;
            }
            for (int i = m - 2; i >= 0; i--) {
                if (grid[i][j] == 'E') {
                    bottomToTop[i][j] = bottomToTop[i + 1][j] + 1;
                } else if (grid[i][j] == '0') {
                    bottomToTop[i][j] = bottomToTop[i + 1][j];
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    maxKill = Math.max(maxKill, leftToRight[i][j] + rightToLeft[i][j] + topToBottom[i][j] + bottomToTop[i][j]);
                    if (maxKill == 4) {
                    	System.out.println("Found!");
                    }
                }
            }
        }
        
        return maxKill;
    }
	
	// Solution 1: dp
	/*
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
    */
    
    public static void main(String[] args) {
    	char[][] grid = {{'0', 'E','0','0'}, {'E','0','W','E'}, {'0','E','0','0'}};
    	Bomb_Enermy tmp = new Bomb_Enermy();
    	System.out.println(tmp.maxKilledEnemies(grid));
    }
}
