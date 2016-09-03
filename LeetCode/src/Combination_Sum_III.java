import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 216. Combination Sum III
 * @author lorreina
 *
 */
public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<> ();
        if (k < 1 || k > 9) {
            return res;
        }
        
        if (n < (1 + k) * k / 2 || k > (19 - k) * k / 2) {
            return res;
        }
        
        helper(res, new ArrayList<Integer> (), 1, k, n);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int start, int k, int target) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<Integer> (curr));
            }
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (i > target) {
                return;
            } else {
                curr.add(i);
                helper(res, curr, i + 1, k - 1, target - i);
                curr.remove(curr.size() - 1);
            }
        }
        
        return;
    }
}
