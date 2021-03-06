/**
 * LeetCode
 * 329. Longest Increasing Path in a Matrix
 * @author lorreina
 *
 */
public class Longest_Increasing_Path_in_a_Matrix {
	public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
                    continue;
                }
                if (i + 1 < matrix.length && matrix[i][j] > matrix[i + 1][j]) {
                    continue;
                }
                if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
                    continue;
                }
                if (j + 1 < matrix[0].length && matrix[i][j] > matrix[i][j + 1]) {
                    continue;
                }
                maxLen = Math.max(maxLen, dfs(matrix, cache, i, j));
            }
        }
        
        return maxLen;
    }
    
    private int dfs(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        
        int max = 1;
        
        // up
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            max = Math.max(max, 1 + dfs(matrix, cache, i - 1, j));
        }
        // down
        if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
            max = Math.max(max, 1 + dfs(matrix, cache, i + 1, j));
        }
        // left
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            max = Math.max(max, 1 + dfs(matrix, cache, i, j - 1));
        }
        // right
        if (j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]) {
            max = Math.max(max, 1 + dfs(matrix, cache, i, j + 1));
        }
        
        cache[i][j] = max;
        return max;
    }
	
	// don't know why this solution time out
    
	/*
	int maxLen = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
                    continue;
                }
                if (i + 1 < matrix.length && matrix[i][j] > matrix[i + 1][j]) {
                    continue;
                }
                if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
                    continue;
                }
                if (j + 1 < matrix[0].length && matrix[i][j] > matrix[i][j + 1]) {
                    continue;
                }
                dfs(matrix, visit, i, j, 0);
            }
        }
        
        return maxLen;
    }
    
    private void dfs(int[][] matrix, boolean[][] visit, int i, int j, int len) {
        visit[i][j] = true;
        
        // up
        if (i > 0 && visit[i - 1][j] == false && matrix[i][j] < matrix[i - 1][j]) {
            dfs(matrix, visit, i - 1, j, len + 1);
        }
        // down
        if (i + 1 < matrix.length && visit[i + 1][j] == false && matrix[i][j] < matrix[i + 1][j]) {
            dfs(matrix, visit, i + 1, j, len + 1);
        }
        // left
        if (j > 0 && visit[i][j - 1] == false && matrix[i][j] < matrix[i][j - 1]) {
            dfs(matrix, visit, i, j - 1, len + 1);
        }
        // right
        if (j + 1 < matrix[0].length && visit[i][j + 1] == false && matrix[i][j] < matrix[i][j + 1]) {
            dfs(matrix, visit, i, j + 1, len + 1);
        }
        
        visit[i][j] = false;
        maxLen = Math.max(maxLen, len + 1);
    }
    */
    
    public static void main(String[] args) {
    	Longest_Increasing_Path_in_a_Matrix tmp = new Longest_Increasing_Path_in_a_Matrix();
    	int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
    	System.out.println(tmp.longestIncreasingPath(matrix));
    }
}
