import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode
 * 417. Pacific Atlantic Water Flow
 * @author lorreina
 *
 */
public class Pacific_Atlantic_Water_Flow {
	// Solution: BFS
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]> ();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<Integer> xQueue = new ArrayDeque<Integer> ();
        Queue<Integer> yQueue = new ArrayDeque<Integer> ();
        xQueue.add(0);
        yQueue.add(0);
        pacific[0][0] = true;
        for (int i = 1; i < m; i++) {
            xQueue.add(i);
            yQueue.add(0);
            pacific[i][0] = true;
        }
        
        for (int j = 1; j < n; j++) {
            xQueue.add(0);
            yQueue.add(j);
            pacific[0][j] = true;
        }
        
        while (!xQueue.isEmpty()) {
            int i = xQueue.poll();
            int j = yQueue.poll();
            
            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                
                if (x >= 0 && x < m && y >= 0 && y < n &&  pacific[x][y] == false) {
                    if (matrix[x][y] >= matrix[i][j]) {
                        pacific[x][y] = true;
                        xQueue.add(x);
                        yQueue.add(y);
                    }
                }
            }
        }
        
        
        xQueue.add(m - 1);
        yQueue.add(n - 1);
        atlantic[m - 1][n - 1] = true;
        for (int i = 0; i < m - 1; i++) {
            xQueue.add(i);
            yQueue.add(n - 1);
            atlantic[i][n - 1] = true;
        }
        
        for (int j = 0; j < n - 1; j++) {
            xQueue.add(m - 1);
            yQueue.add(j);
            atlantic[m - 1][j] = true;
        }
        
        while (!xQueue.isEmpty()) {
            int i = xQueue.poll();
            int j = yQueue.poll();
            checkBoth(pacific, i, j, res);
            
            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                
                if (x >= 0 && x < m && y >= 0 && y < n &&  atlantic[x][y] == false) {
                    if (matrix[x][y] >= matrix[i][j]) {
                        atlantic[x][y] = true;
                        xQueue.add(x);
                        yQueue.add(y);
                        
                    }
                }
            }
        }
        
        return res;
    }
    
    private void checkBoth(boolean[][] pacific, int x, int y, List<int[]> res) {
        if (pacific[x][y] == true) {
            int[] pos = new int[2];
            pos[0] = x;
            pos[1] = y;
            res.add(pos);
        }
        
        return;
    }
    
    public static void main(String[] args) {
    	
    	Pacific_Atlantic_Water_Flow tmp = new Pacific_Atlantic_Water_Flow();
//    	int[][] matrix = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
    	int[][] matrix = {{1,2}, {4,3}};
    	List<int[]> res = tmp.pacificAtlantic(matrix);
    	for (int[] pos : res) {
    		System.out.print(pos[0]);
    		System.out.print(", ");
    		System.out.println(pos[1]);
    	}
    }
}
