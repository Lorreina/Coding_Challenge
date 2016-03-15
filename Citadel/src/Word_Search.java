
public class Word_Search {
	public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    board[i][j] = ' ';
                    if (helper(board, word, i, j, 1)) {
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    
    private static boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        // left
        if (j > 0 && board[i][j - 1] == word.charAt(index)) {
            board[i][j - 1] = ' ';
            if (helper(board, word, i, j - 1, index + 1)) {
                return true;
            }
            board[i][j - 1] = word.charAt(index);
        }
        
        // right
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(index)) {
            board[i][j + 1] = ' ';
            if (helper(board, word, i, j + 1, index + 1)) {
                return true;
            }
            board[i][j + 1] = word.charAt(index);
        }
        
        // up
        if (i > 0 && board[i - 1][j] == word.charAt(index)) {
            board[i - 1][j] = ' ';
            if (helper(board, word, i - 1, j, index + 1)) {
                return true;
            }
            board[i - 1][j] = word.charAt(index);
        }
        
        // down
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(index)) {
            board[i + 1][j] = ' ';
            if (helper(board, word, i + 1, j, index + 1)) {
                return true;
            }
            board[i + 1][j] = word.charAt(index);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    	String word = "ABCCED";
    	System.out.println(exist(board, word));
    }
}
