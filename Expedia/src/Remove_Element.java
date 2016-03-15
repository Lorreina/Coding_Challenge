import java.util.ArrayList;

/**
 * LeetCode
 * 27. Remove Element
 * @author lorreina
 *
 */
public class Remove_Element {
	public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                list.add(nums[i]);
            }
        }
        if (list.size() == 0) {
            return 0;
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        
        return list.size();
    }
}
