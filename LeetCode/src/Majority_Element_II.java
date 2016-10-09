import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 229. Majority Element II
 * @author lorreina
 *
 */
public class Majority_Element_II {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int major1 = nums[0];
        int major2 = nums[1];
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major1) {
                count1++;
            } else if (nums[i] == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                major2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major1) {
                count1 += 1;
            }
            if (nums[i] == major2) {
                count2 += 1;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(major1);
        }
        
        if (major2 != major1 && count2 > nums.length / 3) {
            res.add(major2);
        }
        
        return res;
    }
}
