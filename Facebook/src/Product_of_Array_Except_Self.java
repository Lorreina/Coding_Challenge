
public class Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int right = nums[nums.length - 1];
        
        // result[i] stores the product from num[0] ~ num[i - 1]
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // right is the product from nums[n - 1] ~ nums[i + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        
        return result;
    }
}
