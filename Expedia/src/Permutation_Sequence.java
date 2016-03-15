import java.util.ArrayList;

/**
 * LeetCode
 * 60. Permutation Sequence
 * @author lorreina
 *
 */
public class Permutation_Sequence {
	public String getPermutation(int n, int k) {
        int ways = 1;
        for (int i = 1; i < n; i++) {
            ways = ways * i;
        }
        if (k > (ways * n)) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int digit;
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        
        for (int i = 1; i < n; i++) {
            digit = (k - 1) / ways;
            result.append(String.valueOf(list.get(digit)));
            list.remove(digit);
            k = k - digit * ways;
            ways = ways / (n - i);
        }
        result.append(String.valueOf(list.get(0)));
        
        return result.toString();
    }
}
