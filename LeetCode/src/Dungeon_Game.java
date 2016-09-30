/**
 * LeetCode
 * 174. Dungeon Game
 * @author lorreina
 *
 */
public class Dungeon_Game {
	public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] path = new int[m][n];
        int[][] blood = new int[m][n];
        
        path[0][0] = dungeon[0][0];
        blood[0][0] = dungeon[0][0];
        
        for (int i = 1; i < m; i++) {
            path[i][0] = path[i - 1][0] + dungeon[i][0];
            blood[i][0] = Math.min(blood[i - 1][0], path[i][0]);
        }
        
        for (int j = 1; j < n; j++) {
            path[0][j] = path[0][j - 1] + dungeon[0][j];
            blood[0][j] = Math.min(blood[0][j - 1], path[0][j]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = Math.min(blood[i - 1][j], path[i - 1][j] + dungeon[i][j]);
                int left = Math.min(blood[i][j - 1], path[i][j - 1] + dungeon[i][j]);
                
                if (left > up) {
                    blood[i][j] = left;
                    path[i][j] = path[i][j - 1] + dungeon[i][j];
                } else if (left < up) {
                    blood[i][j] = up;
                    path[i][j] = path[i - 1][j] + dungeon[i][j];
                } else {
                    // left == up
                    blood[i][j] = left;
                    path[i][j] = Math.max(path[i - 1][j], path[i][j - 1]) + dungeon[i][j];
                }
            }
        }
        
        if (blood[m - 1][n - 1] >= 0) {
            return 1;
        } else {
            return -blood[m - 1][n - 1] + 1;
        }
    }
	
	public static void main(String[] args) {
		Dungeon_Game tmp = new Dungeon_Game();
		int[][] dungeon = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
		System.out.println(tmp.calculateMinimumHP(dungeon));
	}
}
