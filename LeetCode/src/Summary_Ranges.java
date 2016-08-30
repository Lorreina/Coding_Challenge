import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 228. Summary Ranges
 * @author lorreina
 *
 */
public class Summary_Ranges {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        
        int start = 0;
        
        for (int i = 1; i < nums.length; i++) {
            // not consecutive
            if (nums[i] != (nums[i - 1] + 1)) {
                if ((i - 1) == start) {
                    res.add(Integer.toString(nums[start]));
                } else {
                    res.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[i - 1]));
                }
                start = i;
            }
        }
        
        if (start == (nums.length - 1)) {
            res.add(Integer.toString(nums[start]));
        } else {
            res.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[nums.length - 1]));
        }
        
        return res;
    }
}
