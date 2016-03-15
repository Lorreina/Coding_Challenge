import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Search_II {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String> ();
        if (words == null || words.length == 0) {
            return result;
        }
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return result;
        }
        
        HashSet<String> set = new HashSet<String> ();
        ArrayList<String> list = new ArrayList<String> ();
        
        for (String word : words) {
            if (set.contains(word)) {
                result.add(word);
            } else {
                boolean isNotExist = false;
                for (int i = 0; i < list.size(); i++) {
                    if (word.indexOf(list.get(i)) >= 0) {
                        isNotExist = true;
                        break;
                    }
                }
                if (!isNotExist) {
                    if (exist(word, board)) {
                        result.add(word);
                        addToSet(set, word);
                    } else {
                        list.add(word);
                    }
                }
            }
        }
        
        return result;
    }
    
    private void addToSet(HashSet<String> set, String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String subString = word.substring(i, j + 1);
                if (!set.contains(subString)) {
                   set.add(subString); 
                }
            }
        }
        return;
    }
    
    private boolean exist(String word, char[][] board) {
        if (word == null || word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    board[i][j] = ' ';
                    if (helper(board, word, i, j, 1)) {
                        board[i][j] = word.charAt(0);
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        // left
        if (j > 0 && board[i][j - 1] == word.charAt(index)) {
            board[i][j - 1] = ' ';
            if (helper(board, word, i, j - 1, index + 1)) {
                board[i][j - 1] = word.charAt(index);
                return true;
            }
            board[i][j - 1] = word.charAt(index);
        }
        
        
        // right
        if (j < board[i].length - 1 && board[i][j + 1] == word.charAt(index)) {
            board[i][j + 1] = ' ';
            if (helper(board, word, i, j + 1, index + 1)) {
                board[i][j + 1] = word.charAt(index);
                return true;
            }
            board[i][j + 1] = word.charAt(index);
        }
        
        // up
        if (i > 0 && board[i - 1][j] == word.charAt(index)) {
            board[i - 1][j] = ' ';
            if (helper(board, word, i - 1, j, index + 1)) {
                board[i - 1][j] = word.charAt(index);
                return true;
            }
            board[i - 1][j] = word.charAt(index);
        }
        
        // down
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(index)) {
            board[i + 1][j] = ' ';
            if (helper(board, word, i + 1, j, index + 1)) {
                board[i + 1][j]  = word.charAt(index);
                return true;
            }
            board[i + 1][j]  = word.charAt(index);
        }
        
        return false;
    }
}
