/**
 * LeetCode
 * 29. Divide Two Integers
 * @author lorreina
 *
 */
public class Divide_Two_Integers {
	public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        
        boolean isNegative = ((dividend ^ divisor) < 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        
        if (divisor > 0) {
            divisor = - divisor;
        }
        
        int res = helper(dividend, divisor);
        if (isNegative) {
            return -res;
        } else {
            return res;
        }
    }
    
    public int helper(int dividend, int divisor) {
        if (divisor == -1) {
            return -dividend;
        }
    	if (dividend > divisor) {
            return 0;
        }
        
        int sum = divisor;
        int count = 1;
        while ((sum + sum) > dividend && (sum + sum) < 0) {
            count += count;
            sum += sum;
        }
        
        return count + helper(dividend - sum, divisor);
    }
    
    public static void main(String[] args) {
    	Divide_Two_Integers tmp = new Divide_Two_Integers();
    	System.out.println(tmp.divide(2147483647, 3));
//    	System.out.println(Integer.MAX_VALUE + 1);
    }
}
