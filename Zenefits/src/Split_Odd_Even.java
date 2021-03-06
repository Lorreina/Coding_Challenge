import java.util.Arrays;

public class Split_Odd_Even {
	public static void splitArray(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		
		int left = 0, right = nums.length - 1;
		
		while (left < right) {
			if (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
				swap(nums, left, right);
			} else if (nums[left] % 2 == 0) {
				right--;
			} else {
				left++;
			}
		}
	}
	
	private static void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		splitArray(nums);
		System.out.println(Arrays.toString(nums));
	}
}
