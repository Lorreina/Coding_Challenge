import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 212. Word Search II
 * @author lorreina
 *
 */
public class Word_Search_II {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String> ();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, root);
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode root) {
        if (board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        int index = c - 'a';
        
        if (root.next[index] == null) {
            return;
        } else {
            root = root.next[index];
        }
        
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '#';
        //up
        if (i > 0) {
            dfs(board, i - 1, j, res, root);
        }
        
        // down 
        if (i < board.length - 1) {
            dfs(board, i + 1, j, res, root);
        }
        
        // left
        if (j > 0) {
            dfs(board, i, j - 1, res, root);
        }
        
        // right
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, res, root);
        }
        
        board[i][j] = c;
        
        return;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode curr = root;
            for (char c : words[i].toCharArray()) {
                int index = c - 'a';
                if (curr.next[index] == null) {
                    curr.next[index] = new TrieNode();
                }
                curr = curr.next[index];
            }
            curr.word = words[i];
        }
        
        return root;
    }
}
