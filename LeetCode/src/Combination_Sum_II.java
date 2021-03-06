import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode
 * 40.  Combination Sum II
 * @author lorreina
 *
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<> ();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        
        dfs(candidates, target, 0, new ArrayList<Integer> (), res);
        
        return res;
    }
    
    private void dfs(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (target < candidates[i]) {
                return;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
        
    }
}
