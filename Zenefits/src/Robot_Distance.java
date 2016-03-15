import java.util.ArrayDeque;
import java.util.ArrayList;

public class Robot_Distance {
	public static int distance(int[][] location) {
		int[][] original = new int[location.length][location[0].length];
		int[][] isMarked = new int[location.length][location[0].length];
		ArrayList<Integer> robot = new ArrayList<Integer> ();
		int row = location[0].length;
		for (int i = 0; i < location.length; i++) {
			for (int j = 0; j < location[0].length; j++) {
				if (location[i][j] == 1) {
					robot.add(i * row + j);
					isMarked[i][j] = 1;
				} else if (location[i][j] == -1) {
					original[i][j] = -1;
					isMarked[i][j] = 1;
				}
			}
		}
		
		int[][][] dis = new int[robot.size()][location.length][row];
		int x, y;
		int index;
		for (int i = 0; i < robot.size(); i++) {
			dis[i] = copy(original);
			int[][] marked = copy(isMarked);
			ArrayDeque<Integer> queue = new ArrayDeque<Integer> ();
			queue.add(robot.get(i));
			while(!queue.isEmpty()) {
				index = queue.poll();
				x = index / row;
				y = index - x * row;
				
				if (x > 0) {
					if (marked[x - 1][y] == 0) {
						dis[i][x - 1][y] = dis[i][x][y] + 1;
						marked[x - 1][y] = 1;
						queue.add((x - 1) * row + y);
					}
				}
				// down
				if (x < location.length - 1) {
					if (marked[x + 1][y] == 0) {
						dis[i][x + 1][y] = dis[i][x][y] + 1;
						marked[x + 1][y] = 1;
						queue.add((x + 1) * row + y);
					}
				}
				
				// left
				if (y > 0) {
					if (marked[x][y - 1] == 0) {
						dis[i][x][y - 1] = dis[i][x][y] + 1;
						marked[x][y - 1] = 1;
						queue.add(x * row + y - 1);
					}
				}
				
				// down
				if (y < row - 1) {
					if (marked[x][y + 1] == 0) {
						dis[i][x][y + 1] = dis[i][x][y] + 1;
						marked[x][y + 1] = 1;
						queue.add(x * row + y + 1);
					}
				}
			}
		}
		
		int minDis = Integer.MAX_VALUE;
		for (int i = 0; i < location.length; i++) {
			for (int j = 0; j < location[0].length; j++) {
				if (isMarked[i][j] == 0) {
					int sum = 0;
					for (int k = 0; k < robot.size(); k++) {
						sum += dis[k][i][j];
					}
					minDis = Math.min(minDis, sum);
				}
			}
		}
		
		return minDis;
	}
	
	private static int[][] copy(int[][] original) {
		int[][] copyArray = new int[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[0].length; j++) {
				copyArray[i][j] = original[i][j];
			}
		}
		return copyArray;
	}
	
	public static void main(String[] args) {
		int[][] location = {{0,0,0,0,1}, {0,1,-1,0,0}, {0,-1,0,0,0}, {0,0,0,1,0}, {0,0,0,0,0}};
		System.out.println(distance(location));
	}
}
