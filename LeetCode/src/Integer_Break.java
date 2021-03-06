/**
 * LeetCode
 * 343. Integer Break
 * @author lorreina
 *
 */
public class Integer_Break {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int x = n / 3;
        int res = n - x * 3;
        if (res == 0) {
            return (int) Math.pow(3, x);
        } else if (res == 1) {
            return (int) Math.pow(3, x - 1) * 4;
        } else {
            return (int) Math.pow(3, x) * 2;
        }
    }
}
