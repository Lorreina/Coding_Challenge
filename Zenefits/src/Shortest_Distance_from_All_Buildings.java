import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 * LeetCode
 * 317. Shortest Distance from All Buildings
 * @author lorreina
 *
 */

// the same question as the robot problem
// using bfs to each starting point (robot or building)

public class Shortest_Distance_from_All_Buildings {
	public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int row = grid[0].length;
        ArrayList<Integer> root = new ArrayList<Integer> ();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    root.add(i * row + j);
                }
            }
        }
        
        if (root.size() == 0) {
            return -1;
        }
        
        int[][][] dis = new int[root.size()][grid.length][row];
        int x, y, index;
        for (int i = 0; i < root.size(); i++) {
            dis[i] = copy(grid);
            int[][] marked = copy(grid);
            ArrayDeque<Integer> queue = new ArrayDeque<Integer> ();
            queue.add(root.get(i));
            
            while (!queue.isEmpty()) {
                index = queue.poll();
                x = index / row;
                y = index - x * row;
                int path = dis[i][x][y] + 1;
                // up
                if (x > 0) {
                    if (marked[x - 1][y] == 0) {
                        dis[i][x - 1][y] = path;
                        marked[x - 1][y] = 1;
                        queue.add((x - 1) * row + y);
                    }
                }
                
                // down
                if (x < grid.length - 1) {
                    if (marked[x + 1][y] == 0) {
                        dis[i][x + 1][y] = path;
                        marked[x + 1][y] = 1;
                        queue.add((x + 1) * row + y);
                    }
                }
                
                // left
                if (y > 0) {
                    if (marked[x][y - 1] == 0) {
                        dis[i][x][y - 1] = path;
                        marked[x][y - 1] = 1;
                        queue.add(x * row + y - 1);
                    }
                }
                
                // right
                if (y < row - 1) {
                    if (marked[x][y + 1] == 0) {
                        dis[i][x][y + 1] = path;
                        marked[x][y + 1] = 1;
                        queue.add(x * row + y + 1);
                    }
                }
            }
        }
        
        int path = Integer.MAX_VALUE;
        boolean hasPath = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int sum = 0;
                    boolean isValid = true;
                    for (int k = 0; k < root.size(); k++) {
                        if (dis[k][i][j] == 0) {
                            isValid = false;
                            break;
                        }
                        sum += dis[k][i][j];
                    }
                    if (isValid) {
                        path = Math.min(path, sum);
                        hasPath = true;
                    }
                }
            }
        }
        
        if (hasPath) {
            return path - root.size();
        } else {
            return -1;
        }
    }
    
    private static int[][] copy(int[][] matrix) {
        int[][] copyed = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copyed[i][j] = matrix[i][j];
            }
        }
        
        return copyed;
    }
	
	public static void main(String[] args) {
		int[][] location = {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
		System.out.println(shortestDistance(location));
	}
}
