import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode
 * 407. Trapping Rain Water II
 * @author lorreina
 *
 */
public class Trapping_Rain_Water_II {
	public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length ==0) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        if (m <= 2 || n <= 2) {
            return 0;
        }
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell> (m * n, new Comparator<Cell> () {
            public int compare(Cell c1, Cell c2) {
                return Integer.compare(c1.h, c2.h);
            }
        });
        boolean[][] visited = new boolean[m][n];
        
        for (int j = 0; j < heightMap[0].length; j++) {
            queue.add(new Cell(0, j, heightMap[0][j]));
            queue.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        for (int i = 1; i < heightMap.length - 1; i++) {
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        
        int water = 0;
        int[] xplus = {1, -1, 0, 0};
        int[] yplus = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + xplus[i];
                int newY = curr.y + yplus[i];
                
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) {
                    continue;
                }
                
                visited[newX][newY] = true;
                water += Math.max(0, curr.h - heightMap[newX][newY]);
                queue.offer(new Cell(newX, newY, Math.max(curr.h, heightMap[newX][newY])));
            }
        }
        
        return water;
    }
    
    private class Cell{
        int x;
        int y;
        int h;
        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
