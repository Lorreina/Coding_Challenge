/**
 * LeetCode
 * 137. Single Number
 * @author lorreina
 *
 */
public class Single_Number_II {
	public int singleNumber(int[] nums) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < nums.length; i++){
	        ones = (ones ^ nums[i]) & ~twos;
	        twos = (twos ^ nums[i]) & ~ones;
	    }
	    return ones;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,1,2,3,1,3};
		Single_Number_II tmp = new Single_Number_II();
		System.out.println(tmp.singleNumber(nums));
	}
}
