import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 51. N-Queens
 * @author lorreina
 *
 */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<> ();
        if (n == 0) {
            return res;
        }
        
        char[][] ch = new char[n][n];
        boolean[] used = new boolean[n];
        boolean[] diagonal = new boolean[n * 2 - 1];
        boolean[] antidiagonal = new boolean[n * 2 - 1];
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                ch[i][j] = '.';
            }
        }
        
        dfs(res, ch, 0, n, used, diagonal, antidiagonal);
        
        return res;
    }
    
    private void dfs(List<List<String>> res, char[][] ch, int k, int n, 
                     boolean[] used, boolean[] diagonal, boolean[] antidiagonal) {
        if (k == n) {
            List<String> list = new ArrayList<String> ();
            for (int i = 0; i < ch.length; i++) {
                list.add(String.valueOf(ch[i]));
            }
            res.add(list);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (used[i] == false && diagonal[i + k] == false && antidiagonal[n - k - 1 + i] == false) {
                used[i] = true;
                diagonal[i + k] = true;
                antidiagonal[n - k - 1 + i] = true;
                ch[k][i] = 'Q';
                dfs(res, ch, k + 1, n, used, diagonal, antidiagonal);
                ch[k][i] = '.';
                used[i] = false;
                diagonal[i + k] = false;
                antidiagonal[n - k - 1 + i] = false;
            }
        }
        
        return;
    }
}	
