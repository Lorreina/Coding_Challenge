import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode
 * 39. Combination Sum
 * @author lorreina
 *
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<> ();
        helper(res, new ArrayList<Integer> (), candidates, 0, target);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> curr, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(curr);
            return;
        }
        
        for (int i = start ; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            } else {
               ArrayList<Integer> list = new ArrayList<Integer> ();
               list.addAll(curr);
               list.add(candidates[i]);
               helper(res, list, candidates, i, target - candidates[i]);
            }
        }
        
        return;
        
    }
}
