import java.util.ArrayList;

public class Connected_Island {
	public static ArrayList<Integer> countConnected(int[][] islands) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if (islands == null || islands.length == 0 || islands[0] == null || islands[0].length == 0) 
			return result;
		
		for (int i = 0; i < islands.length; i++) {
			for (int j = 0; j < islands[0].length; j++) {
				if (islands[i][j] == 1) {
					result.add(helper(islands, i, j));
				}
			}
		}
		
		return result;
	}
	
	private static int helper(int[][] islands, int i, int j) {
		int count = 1;
		islands[i][j] = 0;
		
		// up
		if (i - 1 >= 0 && islands[i - 1][j] == 1) {
			count += helper(islands, i - 1, j);
		}
		
		// down
		if (i + 1 < islands.length && islands[i + 1][j] == 1) {
			count += helper(islands, i + 1, j);
		}
		
		// left
		if (j - 1 >= 0 && islands[i][j - 1] == 1) {
			count += helper(islands, i, j - 1);
		}
		
		// right
		if (j + 1 < islands[0].length && islands[i][j + 1] == 1) {
			count += helper(islands, i, j + 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
//		int[][] islands = {{1,1,1,0}, {1,0,1,0},{1,1,1,0}};
		int[][] islands = {{1,0,0,1}, {1,0,0,1}, {1,1,0,0}};
		System.out.println(countConnected(islands));
	}
}
