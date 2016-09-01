/**
 * LeetCode
 * 303. Range Sum Query - Immutable
 * @author lorreina
 *
 */
public class Range_Sum_Query_Immutable {
	public class NumArray {
	    int[] sum;
	    public NumArray(int[] nums) {
	        this.sum = new int[nums.length];
	        if (nums.length > 0) {
	            sum[0] = nums[0];
	            for (int i = 1; i < nums.length; i++) {
	                sum[i] = sum[i - 1] + nums[i];
	            }
	        }
	    }

	    public int sumRange(int i, int j) {
	        if (this.sum.length == 0) {
	            return 0;
	        }
	        if (i == 0) {
	            return this.sum[j];
	        } else {
	            return this.sum[j] - sum[i - 1];
	        }
	    }
	}


	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
}
