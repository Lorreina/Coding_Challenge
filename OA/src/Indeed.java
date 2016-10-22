
public class Indeed {
	public static int findMaxSum(int[] array, int threshold) {
		// initialize pointers and sum variable
        int left = 0, right = 1, currSum = array[0], maxSum = 0;
        
        // while loop
        while (right < array.length) {
            if (currSum <= threshold) {
                maxSum = Math.max(maxSum, currSum);
                currSum += array[right];
                right++;
            } else {
                currSum -= array[left];
                left++;
            }
        }
		
//		for (int i = 0; i < nums.length; i++) {
//			currSum += nums[i];
//			while (currSum > threshold && left <= i) {
//				currSum -= nums[left];
//				left++;
//			}
//			
//			maxSum = Math.max(currSum, maxSum);
//		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 3, 5, 1, 7};
//		int[] nums = {4, 8, 2};
		int threshold = 10;
//		int threshold = 1;
		System.out.println(findMaxSum(nums, threshold));
	}
}
