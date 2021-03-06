import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 315. Count of Smaller Numbers After Self
 * @author lorreina
 *
 */
public class Count_of_Smaller_Numbers_After_Self {
	public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> sortList = new ArrayList<Integer> ();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sortList, nums[i]);
            res.add(index);
            sortList.add(index, nums[i]);
        }
        
        int i = 0, j = res.size() - 1;
        while (i < j) {
            int tmp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, tmp);
            i++;
            j--;
        }
        
        return res;
    }
    
    private int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) {
            return 0;
        }
        
        int start = 0, end = list.size() - 1;
        if (target <= list.get(start)) {
            return start;
        }
        if (target > list.get(end)) {
            return end + 1;
        }
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if (target <= list.get(start)) {
            return start;
        } else {
            return end + 1;
        }
    }
    
    public static void main(String[] args) {
    	Count_of_Smaller_Numbers_After_Self tmp = new Count_of_Smaller_Numbers_After_Self();
    	int[] nums = {5,2,6,1};
    	List<Integer> res = tmp.countSmaller(nums);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.print(res.get(i));
    		System.out.print(" ");
    	}
    }
}
