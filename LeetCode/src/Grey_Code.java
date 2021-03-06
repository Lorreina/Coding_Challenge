import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 89. Gray Code
 * @author lorreina
 *
 */
public class Grey_Code {
    public List<Integer> grayCode(int n) {
        return helper(n);
    }
    
    private List<Integer> helper(int n) {
        List<Integer> res = new ArrayList<Integer> ();
        
        if (n == 0) {
            res.add(0);
            return res;
        }
        
        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        } else {
            List<Integer> last = helper(n - 1);
            res.addAll(last);
            int plus = 1 << (n - 1);
            for (int i = last.size() - 1; i >= 0; i--) {
                int num = plus + last.get(i);
                res.add(num);
            }
            return res;
        }
    }
}
