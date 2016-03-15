
public class Single_Number {
	public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (Integer) null;
        }
        
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = value ^ nums[i];
        }
        return value;
    }
}
