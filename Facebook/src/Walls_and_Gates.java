import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/**
 * LeetCode
 * 286. Walls and Gates
 * @company: Facebook
 * @author lorreina
 *
 */
public class Walls_and_Gates {
	public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<Integer> queue = new ArrayDeque<Integer> ();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(i * n + j);
                }
            }
        }
        
        while (queue.size() > 0) {
            int num = queue.poll();
            int x = num / n;
            int y = num % n;
            int val = rooms[x][y];
            
            // up
            if (x > 0 && rooms[x - 1][y] > (val + 1)) {
                rooms[x - 1][y] = val + 1;
                queue.add((x - 1) * n + y);
            }
            
            // down
            if (x < m - 1 && rooms[x + 1][y] > (val + 1)) {
                rooms[x + 1][y] = val + 1;
                queue.add((x + 1) * n + y);
            }
            
            // left
            if (y > 0 && rooms[x][y - 1] > (val + 1)) {
                rooms[x][y - 1] = val + 1;
                queue.add(x * n + y - 1);
            }
            
            // down
            if (y < n - 1 && rooms[x][y + 1] > (val + 1)) {
                rooms[x][y + 1] = val + 1;
                queue.add(x * n + y + 1);
            }
        }
    }
	
	public static void main(String[] args) {
		int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1}, {0,-1,2147483647,2147483647}};
		wallsAndGates(rooms);
		for (int i = 0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(rooms[i]));
		}
	}
}
