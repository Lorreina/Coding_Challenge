import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * Lexicographical Numbers
 * @author lorreina
 *
 */
public class Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer> ();
        
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr = curr * 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr = curr / 10;
                }
                curr = curr / 10 + 1;
            }
        }
        
        return res;
    }
}
