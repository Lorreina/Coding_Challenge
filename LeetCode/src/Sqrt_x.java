/**
 * LeetCode
 * 69. Sqrt(x)
 * @author lorreina
 *
 */
public class Sqrt_x {
	public int mySqrt(int x) {
        if (x == 0) {
            return 0; 
        }
        
        if (x < 4) {
            return 1;
        }
        
        return helper(x, 2, Math.min(x / 2, 46340));
    }
    
    private int helper(int x, int start, int end) {
        if (start == end) {
            return start;
        } else if (start == end - 1) {
            if (end * end <= x) {
                return end;
            } else {
                return start;
            }
        } else {
            int mid = start + (end - start) / 2;
            int exp = mid * mid;
            if (exp == x) {
                return mid;
            } else if (exp > x) {
                return helper(x, start, mid - 1);
            } else {
                return helper(x, mid, end);
            }
        }
    }
    
    public static void main(String[] args) {
    	Sqrt_x tmp = new Sqrt_x();
    	int x = 2147395599;
    	System.out.println(tmp.mySqrt(x));
    }
}
