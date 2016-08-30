import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        if (nums == null || nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
            	continue;
            }
            ArrayList<ArrayList<Integer>> tmp = twoSum(nums, i + 1, -nums[i]);
            if (tmp.size() == 0) {
                continue;
            }
            for (int j = 0; j < tmp.size(); j++) {
                tmp.get(j).add(0, nums[i]);
                result.add(tmp.get(j));
            }
        }
        
        return result;
    }
    
    private static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int start, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
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
        
        return result;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, -1, -1, 0};
    	List<List<Integer>> result = threeSum(nums);
    	for (int i = 0; i < result.size(); i++) {
    		for (int j = 0; j < result.get(0).size(); j++) {
    			System.out.print(result.get(i).get(j));
    			System.out.print(", ");
    		}
    		System.out.println();
    	}
    }
}
