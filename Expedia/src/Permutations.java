import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 46. Permutations
 * @author lorreina
 *
 */
public class Permutations {
	int[] mark;
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        mark = new int[nums.length];
        
        helper(nums, new ArrayList<Integer> ());
        
        return result;
    }
    
    private void helper(int[] nums, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<Integer> (tmp));
        } else {
            for (int i = 0; i < mark.length; i++) {
                if (mark[i] == 0) {
                    mark[i] = 1;
                    tmp.add(nums[i]);
                    helper(nums, tmp);
                    tmp.remove(tmp.size() - 1);
                    mark[i] = 0;
                }
            }
        }
    }
}
