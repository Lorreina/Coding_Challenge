import java.util.ArrayDeque;
import java.util.Arrays;

public class Police_Children_Distance {
	public static int[][] distance(int[][] location) {
		int[][] dis = new int[location.length][location[0].length];
		int[][] marked = new int[location.length][location[0].length];
		ArrayDeque<Integer> queue = new ArrayDeque<Integer> ();
		int row = location[0].length;
		for (int i = 0; i < location.length; i++) {
			for (int j = 0; j < location[0].length; j++) {
				if (location[i][j] == 1) {
					queue.add(i * row + j);
					dis[i][j] = 0;
					marked[i][j] = 1;
				} else if (location[i][j] == 2) {
					dis[i][j] = -1;
					marked[i][j] = 1;
				}
			}
		}
		
		int x, y;
		int index;
		while (!queue.isEmpty()) {
			index = queue.poll();
			x = index / row;
			y = index - x * row;
			// up
			if (x > 0) {
				if (marked[x - 1][y] == 0) {
					dis[x - 1][y] = dis[x][y] + 1;
					marked[x - 1][y] = 1;
					queue.add((x - 1) * row + y);
				}
			}
			// down
			if (x < location.length - 1) {
				if (marked[x + 1][y] == 0) {
					dis[x + 1][y] = dis[x][y] + 1;
					marked[x + 1][y] = 1;
					queue.add((x + 1) * row + y);
				}
			}
			
			// left
			if (y > 0) {
				if (marked[x][y - 1] == 0) {
					dis[x][y - 1] = dis[x][y] + 1;
					marked[x][y - 1] = 1;
					queue.add(x * row + y - 1);
				}
			}
			
			// down
			if (y < row - 1) {
				if (marked[x][y + 1] == 0) {
					dis[x][y + 1] = dis[x][y] + 1;
					marked[x][y + 1] = 1;
					queue.add(x * row + y + 1);
				}
			}
		}
		
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[0].length; j++) {
				if (marked[i][j] == 0) {
					dis[i][j] = -1;
				}
			}
		}
		
		return dis;
	}
	
	public static void main(String[] args) {
		int[][] location = {{1,0,0},{0,0,0},{0,0,1}};
		int[][] dis = distance(location);
		for (int i = 0; i < dis.length; i++) {
			System.out.println(Arrays.toString(dis[i]));
		}
	}
}
