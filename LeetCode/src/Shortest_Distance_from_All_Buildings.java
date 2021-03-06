import java.util.ArrayList;

/**
 * LeetCode
 * 317. Shortest Distance from All Buildings
 * @author lorreina
 *
 */
public class Shortest_Distance_from_All_Buildings {
	int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int m, n;
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];
        int countBuilding = 0;
        
        // bfs to update count table and dist table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, dist, count, i, j, countBuilding);
                    countBuilding++;
                }
            }
        }
        
        // find the minimum distance
        int minDis = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && count[i][j] == countBuilding) {
                    if (minDis == -1) {
                        minDis = dist[i][j];
                    } else {
                        minDis = Math.min(minDis, dist[i][j]);
                    }
                }
            }
        }
        
        return minDis;
    }
    
    private void bfs(int[][] grid, int[][] dist, int[][] count, int i, int j, int cnt) {
        ArrayList<Integer> xList = new ArrayList<Integer> ();
        ArrayList<Integer> yList = new ArrayList<Integer> ();
        xList.add(i);
        yList.add(j);
        
        int dis = 0;
        while (xList.size() > 0) {
            dis++;
            ArrayList<Integer> xListNew = new ArrayList<Integer> ();
            ArrayList<Integer> yListNew = new ArrayList<Integer> ();
            for (int k = 0; k < xList.size(); k++) {
                int x = xList.get(k);
                int y = yList.get(k);
                
                for (int p = 0; p < 4; p++) {
                    int newX = x + dx[p];
                    int newY = y + dy[p];
                    
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0 && count[newX][newY] == cnt) {
                        count[newX][newY]++;
                        dist[newX][newY] += dis;
                        xListNew.add(newX);
                        yListNew.add(newY);
                    }
                }
            }
            xList = xListNew;
            yList = yListNew;
        }
    }
    
    public static void main(String[] args) {
    	Shortest_Distance_from_All_Buildings tmp = new Shortest_Distance_from_All_Buildings();
    	int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
    	System.out.println(tmp.shortestDistance(grid));
    }
}
