
public class Minimum_Size_Subarray_Sum {
	public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        
        int p = -1;
        int q = -1;
        sum[0] = nums[0];
        int minLen = 0;
        
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (sum[i] >= s && minLen == 0) {
                minLen = i + 1;
                q = i;
            }
        }
        
        if (minLen == 0) {
            return 0;
        }
        if (sum[0] >= s) {
        	return 1;
        }
        
        for (int i = q; i < nums.length; i++) {
            while (p < i) {
                p++;
                if (sum[i] - sum[p] >= s) {
                    minLen = Math.min(minLen, i - p);
                } else {
                    break;
                }
            }
        }
        
        return minLen;
    }
	
	public static void main(String[] args) {
		int[] nums = {10,2,3};
		System.out.println(minSubArrayLen(6, nums));
	}
}
