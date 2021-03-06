import java.util.ArrayList;
import java.util.Random;

/**
 * LeetCode
 * 398. Random Pick Index
 * @author lorreina
 *
 */
public class Random_Pick_Index {
	public class Solution {
	    int[] nums;
	    Random rand;
	    public Solution(int[] nums) {
	        this.nums = nums;
	        this.rand = new Random();
	    }
	    
	    public int pick(int target) {
	        ArrayList<Integer> indexs = new ArrayList<Integer> ();
	        for (int i = 0; i < this.nums.length; i++) {
	            if (nums[i] == target) {
	                indexs.add(i);
	            }
	        }
	        
	        int n = rand.nextInt(indexs.size());
	        return indexs.get(n);
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int param_1 = obj.pick(target);
	 */
}
