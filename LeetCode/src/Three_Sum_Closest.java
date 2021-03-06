import java.util.Arrays;

/**
 * LeetCode
 * 16. 3Sum Closest
 * @author lorreina
 *
 */
public class Three_Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        int[] copy = new int[nums.length];
        
        for (int i = 0; i < copy.length; i++) {
            copy[i] = nums[i];
        }
        
        Arrays.sort(copy);
        
        int minDiff = helper(copy, nums[0], target - nums[0]);
        
        for (int i = 1; i < copy.length; i++) {
            int diff = helper(copy, nums[i], target - nums[i]);
            if (Math.abs(diff) < Math.abs(minDiff)) {
                minDiff = diff;
                int a = 1;
            }
        }
        
        return target + minDiff;
    }
    
    // two closest helper
    private static int helper(int[] copy, int curr, int target) {
        int minDiff = 0;
        boolean isFirst = true;
        boolean isCurrent = true;
        
        int i = 0, j = copy.length - 1;
        int diff;
        
        while (i < j) {
            if (copy[i] == curr && isCurrent) {
                i++;
                isCurrent = false;
                continue;
            } else if (copy[j] == curr && isCurrent) {
                j--;
                isCurrent = false;
                continue;
            }
            
            diff = copy[i] + copy[j] - target;
            if (diff == 0) {
                return 0;
            }
            
            if (isFirst) {
                minDiff = diff;
                isFirst = false;
            } else if (isFirst || Math.abs(diff) < Math.abs(minDiff)) {
                minDiff = diff;
            }
            
            if (diff < 0) {
                i++;
            } else {
                j--;
            }
        }
        
        return minDiff;
    }
    
    public static void main(String[] args) {
    	int[] nums = {0, 1, 2};
    	int target = 0;
    	
    	System.out.println(threeSumClosest(nums, target));
    }
}
