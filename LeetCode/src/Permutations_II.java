import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode
 * 47. Permutations II
 * @author lorreina
 *
 */
public class Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        if (nums == null || nums.length ==0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        
        return helper(list);
    }
    
    List<List<Integer>> helper(List<Integer> list) {
        List<List<Integer>> res = new ArrayList<> ();
        
        if (list.size() == 1) {
            res.add(new ArrayList<Integer> (list));
            return res;
        }
        
        int last = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(0);
            list.remove(0);
            
            if (i == 0 || x != last) {
                List<List<Integer>> sub = helper(list);
                for (int j = 0; j < sub.size(); j++) {
                    sub.get(j).add(0, x);
                }
                res.addAll(sub);
            }
            last = x;
            
            list.add(x);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	Permutations_II tmp = new Permutations_II();
    	int[] nums = {1,2,3};
    	List<List<Integer>> res = tmp.permuteUnique(nums);
    	
    	for (int i = 0; i < res.size(); i++) {
    		for (int j = 0; j < res.get(i).size(); j++) {
    			System.out.print(res.get(i).get(j));
    			System.out.print(" ");
    		}
    		System.out.print("\n");
    	}
    }
}
