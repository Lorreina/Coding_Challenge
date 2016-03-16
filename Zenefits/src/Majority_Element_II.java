import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 229. Majority Element II
 * @author lorreina
 *
 */

public class Majority_Element_II {
	// There should be at most 2 different elements in nums more than n/3
    // So we can find at most 2 elements based on Boyer-Moore Majority Vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer> ();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int count1 = 0, count2 = 0;
        int m = 0, n = 0;
        
        for (int x : nums) {
            if (m == x) {
                count1++;
            } else if (n == x) {
                count2++;
            } else if (count1 == 0) {
                m = x;
                count1 = 1;
            } else if (count2 == 0) {
                n = x;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int x : nums) {
            if (x == m) {
                count1++;
            } else if (x == n) {
                count2++;
            }
        }
        
        if (count1 > nums.length / 3) {
            result.add(m);
        }
        
        if (count2 > nums.length / 3) {
            result.add(n);
        }
        
        return result;
    }
}
