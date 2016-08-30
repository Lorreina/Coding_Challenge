
public class Reverse_integer {
	public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
       
        int isPositive = 1;
        
        if (x < 0) {
            isPositive = -1;
        }
        
        long result = 0;
        int digit = 0;
        while (x != 0) {
            digit = Math.abs(x % 10);
            x = x / 10;
            result = result * 10 + digit;
            if (isPositive == 1) {
                if (result > Integer.MAX_VALUE) {
                    return 0;
                }
            } else {
                if (-result < Integer.MIN_VALUE) {
                    return 0;
                }
            }
        }
        
        return (int)result;
    }
	 
	 public static void main(String[] args) {
		 System.out.println(reverse(-2147483648));
	 }
}
