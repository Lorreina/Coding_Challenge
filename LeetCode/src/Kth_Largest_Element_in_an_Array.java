import java.util.Random;

/**
 * LeetCode
 * 215. Kth Largest Element in an Array
 * @author lorreina
 *
 */
public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        // shuffle the input array to gurantee O(n) time complexity.
        shuffle(nums);
        
        k = nums.length - k;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int index = partition(nums, left, right);
            if (index == k) {
                break;
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        
        return nums[k];
    }
    
    private int partition(int[] nums, int left, int right) {
        int lp = left - 1;
        int rp = right;
        int pivot = nums[right];
        
        while (true) {
            while (lp < rp && nums[++lp] < pivot);
            while (rp > lp && nums[--rp] > pivot);
            if (lp >= rp) {
                break;
            } else {
                swap(nums, lp, rp);
            }
        }
        
        swap(nums, lp, right);
        
        return lp;
    }
    
    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int rand = random.nextInt(i + 1);
            swap(nums, i, rand);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(3));
		}
	}
}
