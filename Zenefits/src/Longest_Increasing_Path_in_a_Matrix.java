import java.util.ArrayDeque;
/**
 * LeetCode
 * 329. Longest Increasing Path in a Matrix
 * @author lorreina
 *
 */

//BFS
public class Longest_Increasing_Path_in_a_Matrix {
	public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] best = new int[matrix.length][matrix[0].length];
        int row = matrix[0].length;
        int x, y, index;
        int result = 1;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (best[i][j] >= 1) {
                    continue;
                }
                best[i][j] = 1;
                ArrayDeque<Integer> queue = new ArrayDeque<Integer> ();
                queue.add(i * row + j);
                while (!queue.isEmpty()) {
                    index = queue.poll();
                    x = index / row;
                    y = index - x * row;
                    int path = best[x][y] + 1;
                    // up
                    if (x > 0) {
                        if (matrix[x - 1][y] < matrix[x][y]) {
                            if (best[x - 1][y] < path) {
                                best[x - 1][y] = path;
                                result = Math.max(result, path);
                                queue.add((x - 1) * row + y);
                            }
                        }
                    }
                    
                    // down
                    if (x < matrix.length - 1) {
                        if (matrix[x + 1][y] < matrix[x][y]) {
                            if (best[x + 1][y] < path) {
                                best[x + 1][y] = path;
                                result = Math.max(result, path);
                                queue.add((x + 1) * row + y);
                            }
                        }
                    }
                    
                    // left
                    if (y > 0) {
                        if (matrix[x][y - 1] < matrix[x][y]) {
                            if (best[x][y - 1] < path) {
                                best[x][y - 1] = path;
                                result = Math.max(result, path);
                                queue.add(x * row + y - 1);
                            }
                        }
                    }
                    
                    // right
                    if (y < row - 1) {
                        if (matrix[x][y + 1] < matrix[x][y]) {
                            if (best[x][y + 1] < path) {
                                best[x][y + 1] = path;
                                result = Math.max(result, path);
                                queue.add(x * row + y + 1);
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
