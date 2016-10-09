/**
 * LeetCode
 * 50. Pow(x, n) 
 * @author lorreina
 *
 */
public class Pow_x_n {
	public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        if (n == Integer.MIN_VALUE) {
            return 1.0 / x * myPow(x, n + 1);
        }
        
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        
        double tmp = x;
        double pow = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                pow *= tmp;
            }
            tmp = tmp * tmp;
            n = n >> 1;
        }
        
        if (isNegative) {
            return 1.0 / pow;
        }
        
        return pow;
    }
	
	public static void main(String[] args) {
		Pow_x_n tmp = new Pow_x_n();
		double x = 8.88023;
		int n = 3;
		System.out.println(tmp.myPow(x, n));
	}
}
