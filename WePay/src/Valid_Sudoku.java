/**
 * LeetCode
 * 36. Valid Sudoku
 * @author lorreina
 *
 */
public class Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
            if (!checkCol(board, i)) {
                return false;
            }
            if (!checkBlock(board, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkRow(char[][] board, int i) {
        int[] nums = new int[9];
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                continue;
            }
            if (nums[board[i][j] - '1'] == 1) {
               return false; 
            }
            nums[board[i][j] - '1'] = 1;
        }
        return true;
    }
    
    private boolean checkCol(char[][] board, int j) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][j] == '.') {
                continue;
            }
            if (nums[board[i][j] - '1'] == 1) {
                return false;
            }
            nums[board[i][j] - '1'] = 1;
        }
        return true;
    }
    
    private boolean checkBlock(char[][] board, int index) {
        int row = (index / 3) * 3;
        int col = (index - row) * 3;
        int[] nums = new int[9];
        
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (nums[board[i][j] - '1'] == 1) {
                    return false;
                }
                nums[board[i][j] - '1'] = 1;
            }
        }
        return true;
    }
}
