/**
 * LeetCode
 * 167. Two Sum II - Input array is sorted
 * @author lorreina
 *
 */
public class Two_Sum_II_Input_array_is_sorted {
	public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
