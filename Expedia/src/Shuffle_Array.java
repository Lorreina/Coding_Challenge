import java.util.Arrays;

public class Shuffle_Array {
	public static int[] shuffle(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] == 1 && nums[j] == 0) {
				nums[i] = 0;
				nums[j] = 1;
				i++;
				j--;
			} else if (nums[i] == 0) {
				i++;
			} else if (nums[j] == 1) {
				j--;
			}
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 0, 1, 0, 1};
		nums = shuffle(nums);
		System.out.println(Arrays.toString(nums));
	}
}
