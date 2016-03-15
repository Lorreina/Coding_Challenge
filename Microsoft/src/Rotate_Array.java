
public class Rotate_Array {
	public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[(nums.length - k + i) % nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = result[i];
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2};
		rotate(nums, 1);
	}
}	
