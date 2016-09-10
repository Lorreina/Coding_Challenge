/**
 * LeetCode
 * 52. N-Queens II
 * @author lorreina
 *
 */
public class N_Queens_II {
    public int totalNQueens(int n) {
        int res = 0;
        if (n == 0) {
            return res;
        }
        
        boolean[] used = new boolean[n];
        boolean[] diagonal = new boolean[n * 2 - 1];
        boolean[] antidiagonal = new boolean[n * 2 - 1];
        
        return dfs(0, n, used, diagonal, antidiagonal);
    }
    
    private int dfs(int k, int n, 
                     boolean[] used, boolean[] diagonal, boolean[] antidiagonal) {
        if (k == n) {
            return 1;
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (used[i] == false && diagonal[i + k] == false && antidiagonal[n - k - 1 + i] == false) {
                used[i] = true;
                diagonal[i + k] = true;
                antidiagonal[n - k - 1 + i] = true;
                res += dfs(k + 1, n, used, diagonal, antidiagonal);
                used[i] = false;
                diagonal[i + k] = false;
                antidiagonal[n - k - 1 + i] = false;
            }
        }
        
        return res;
    }
}
