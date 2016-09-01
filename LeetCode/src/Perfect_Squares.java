/**
 * LeetCode
 * 279. Perfect Squares
 * @author lorreina
 *
 */
public class Perfect_Squares {
    public static int numSquares(int n) {
        if (n <= 1) {
            return n;
        }
        
        int sq = findSquare(n);
        return 1 + numSquares(n - sq);
    }
    
    private static int findSquare(int n) {
        for (int i = n; i >= 1; i--) {
            int root = (int) Math.sqrt(n);
            if (root * root == i) {
                return i;
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
    	System.out.println(numSquares(4));
    }
}
