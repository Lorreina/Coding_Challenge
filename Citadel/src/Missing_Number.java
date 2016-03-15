
public class Missing_Number {
	public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (Integer) null;
        }
        int n = nums.length;
        int sum = (n + 1) * n / 2;
        for (int i = 0; i < n; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}
