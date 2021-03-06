import java.util.HashSet;

/**
 * LeetCode
 * 36. Valid Sudoku
 * @author lorreina
 *
 */
public class Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        HashSet<Character> set = new HashSet<Character> ();
        for (int i = 0; i < board.length; i++) {
            set.clear();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        
        for (int j = 0; j < board[0].length; j++) {
            set.clear();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        
        for (int k = 0; k < 9; k += 3) {
            for (int p = 0; p < 9; p += 3) {
            	set.clear();
                for (int i = k; i < k + 3; i++) {
                    for (int j = p; j < p + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        if (set.contains(board[i][j])) {
                            return false;
                        }
                        set.add(board[i][j]);
                    }
                }
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[9][9];
		matrix[0][1] = 5;
		matrix[0][8] = 6;
		matrix[1][4] = 1;
		matrix[1][5] = 4;
		matrix[3][5] = 9;
		matrix[3][6] = 2;
		matrix[4][0] = 5;
		matrix[4][5] = 2;
		matrix[5][7] = 3;
		matrix[6][3] = 5;
		matrix[6][4] = 4;
		matrix[7][0] = 3;
		matrix[7][6] = 4;
		matrix[7][7] = 2;
		matrix[8][3] = 2;
		matrix[8][4] = 7;
		matrix[8][6] = 6;
		
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (matrix[i][j] == 0) {
					board[i][j] = '.';
				} else {
					board[i][j] = (char) (matrix[i][j] + '0');
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		Valid_Sudoku tmp = new Valid_Sudoku();
		System.out.println(tmp.isValidSudoku(board));
	}
}
