import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 46. Permutations
 * @author lorreina
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        
        return helper(list);
    }
    
    private List<List<Integer>> helper(List<Integer> list) {
        List<List<Integer>> res = new ArrayList<> ();
        if (list.size() == 1) {
            res.add(new ArrayList<Integer>(list));
            return res;
        }
        
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(0);
            list.remove(0);
            
            List<List<Integer>> sub = helper(list);
            for (int j = 0; j < sub.size(); j++) {
                sub.get(j).add(0, x);
            }
            res.addAll(sub);
            
            list.add(x);
        }
        
        return res;
    }
}
