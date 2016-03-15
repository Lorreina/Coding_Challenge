import java.util.HashSet;

/**
 * LeetCode 202. Happy Number
 * @author lorreina
 *
 */
public class Happy_Number {
	public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer> ();
        if (n == 1) {
            return true;
        }
        set.add(n);
        while (true) {
            n = happy(n);
            if (set.contains(n)) {
                return false;
            }
            if (n == 1) {
                return true;
            } else {
                set.add(n);
            }
        }
    }
    
    private int happy(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10) * (n % 10);
            n = (n - n % 10) / 10;
        }
        return sum;
    }
}
