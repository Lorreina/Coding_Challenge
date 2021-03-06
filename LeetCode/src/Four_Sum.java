import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode
 * 18. 4Sum
 * @author lorreina
 *
 */

public class Four_Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<> ();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> tmp = threeSum(nums, i + 1, target - nums[i], nums[i]);
            result.addAll(tmp);
        }
        
        return result;
    }
    
    
    private List<List<Integer>> threeSum(int[] nums, int start, int target, int first) {
        List<List<Integer>> result = new ArrayList<> ();
        for (int i = start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, target-nums[i], result, first, nums[i]);
        }
        
        return result;
    }
    
    private void twoSum(int[] nums, int start, int target, List<List<Integer>> result, int first, int second) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            if (i > start && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j--;
                continue;
            }
            if (nums[i] + nums[j] == target) {
                ArrayList<Integer> tmp = new ArrayList<Integer> ();
                tmp.add(first);
                tmp.add(second);
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                result.add(tmp);
                i++; 
                j--;
            } else if (nums[i] + nums[j] > target){
                j--;
            } else if (nums[i] + nums[j] < target) {
            	i++;
            }
        }
        return;
    }
}
