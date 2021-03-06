
/**
 * 一个array，找一个所有左边都比它小，右边都比它大的数
 * 其实用array左右扫两遍，存左边目前最大值，和右边目前最小值，然后再扫一遍比较就可以了
 */

public class Find_Peak {
	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int[] maxFromLeft = new int[nums.length];
		int[] minFromRight = new int[nums.length];
		
		maxFromLeft[0] = nums[0];
		minFromRight[0] = nums[nums.length - 1];
		
		for (int i = 1; i < nums.length; i++) {
			maxFromLeft[i] = Math.max(maxFromLeft[i - 1], nums[i]);
			minFromRight[nums.length - i - 1] = Math.max(minFromRight[nums.length - i], nums[nums.length - i - 1]);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (maxFromLeft[i] == minFromRight[i]) {
				return nums[i];
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {23, 90, 50, 60, 80, 75, 74, 35};
		System.out.println(findPeakElement(nums));
	}
}
