/**
 * LeetCode 326. Power of Three
 * @author lorreina
 *
 */
public class Power_of_Three {
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        int x = (int) Math.rint(Math.log(n) / Math.log(3));
        if (Math.pow(3, x) - n == 0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	System.out.println(isPowerOfThree(243));
    }
}
