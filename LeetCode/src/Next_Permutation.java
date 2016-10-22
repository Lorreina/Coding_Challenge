/**
 * LeetCode
 * 31. Next Permutation
 * @author lorreina
 *
 */
public class Next_Permutation {
	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int start = nums.length - 2;
        for (; start >= 0; start--) {
            if (nums[start] < nums[start + 1]) {
                break;
            }
        }
        
        if (start < 0) {
            // reverse
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
            
            return;
        }
        
        int end = nums.length - 1;
        for (; end > start; end--) {
            if (nums[end] > nums[start]) {
                break;
            }
        }
                
        // swap start and end
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        
        // reverse between start + 1 to nums.length - 1
        start = start + 1;
        end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        
        return;
    }
	
	public static void main(String[] args) {
		Next_Permutation tmp = new Next_Permutation();
//		int[] nums = {1,9,8,23,17,4,6};
//		int[] nums = {1,73,2,34,6,5,0};
		int[] nums = {1,5,1};
		tmp.nextPermutation(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			System.out.print(", ");
		}
	}
}
