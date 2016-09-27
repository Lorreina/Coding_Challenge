/**
 * LeetCode
 * 75. Sort Colors
 * @author lorreina
 *
 */
public class Sort_Colors {
	public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int red = 0;
        int blue = nums.length - 1;
        int p = 0;
        
        while (p <= blue && p >= red) {
            if (nums[p] == 1) {
                p++;
            } else if (nums[p] == 0) {
                swap(p, red, nums);
                while (red <= blue && nums[red] == 0) {
                    red++;
                }
                p = Math.max(p, red);
            } else if (nums[p] == 2) {
                swap(p, blue, nums);
                while (blue >= red && nums[blue] == 2) {
                    blue--;
                }
                p = Math.min(p, blue);
            }
        }
        
        return;
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
