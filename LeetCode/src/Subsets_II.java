import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<> ();
        result.add(new ArrayList<Integer> ());
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        int count = 0;
        result.add(new ArrayList<Integer> ());
        result.get(1).add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int n = result.size();
            if (nums[i] == nums[i - 1]) {
            	count++;
            } else {
            	count = 0;
            }
            for (int j = 0; j < n; j++) {
            	List<Integer> tmp = result.get(j);
            	if (count > 0) {
            		if (tmp.size() < count || tmp.get(tmp.size() - count) != nums[i]) {
            			continue;
            		}
            	}
            	tmp.add(nums[i]);
                result.add(new ArrayList<Integer> (tmp));
                tmp.remove(tmp.size() - 1);
            }
        }
        return result;
    }	
	
	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(subsetsWithDup(nums));
	}
}
