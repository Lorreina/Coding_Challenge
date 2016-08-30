/**
 * LeetCode
 * 384. Shuffle an Array
 * @author lorreina
 *
 */
public class Shuffle_an_Array {
	public class Solution {
	    java.util.Random rand;
	    int[] nums;
	    int[] origin;
	    
	    public Solution(int[] nums) {
	        rand = new java.util.Random();
	        this.nums = new int[nums.length];
	        this.origin = new int[nums.length];
	        System.arraycopy(nums, 0, this.nums, 0, nums.length);
	        System.arraycopy(nums, 0, this.origin, 0, nums.length);
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        for (int i = 0; i < nums.length; i++) {
	            nums[i] = origin[i];
	        }
	        return nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        for (int i = 0; i < nums.length; i++) {
	            int index = rand.nextInt(nums.length);
	            int tmp = nums[i];
	            nums[i] = nums[index];
	            nums[index] = tmp;
	        }
	        
	        return nums;
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
}
