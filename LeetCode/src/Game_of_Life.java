/**
 * LeetCode
 * 289. Game of Life
 * @author lorreina
 *
 */
public class Game_of_Life {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLives(board, i, j);
                if (board[i][j] == 1) {
                    if (lives == 2 || lives == 3) {
                        board[i][j] = 3;
                    }
                } else if (board[i][j] == 0) {
                    if (lives == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
        
        return;
    }
    
    private int getLives(int[][] board, int ii, int jj) {
        int lives = 0;
        
        for (int i = Math.max(0, ii - 1); i < Math.min(board.length, ii + 2); i++) {
            for (int j = Math.max(0, jj - 1); j < Math.min(board[0].length, jj + 2); j++) {
                lives += (board[i][j] & 1);
            }
        }
        
        lives -= (board[ii][jj] & 1);
        
        return lives;
    }
}
