/**
 * LeetCode
 * 42. Trapping Rain Water
 * @author lorreina
 *
 */

public class Trapping_Rain_Water {
	public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int result = 0;
        int left = 0, right = height.length - 1;
        
        // find the left and right edge which can hold water
        while (left < right - 2) {
            if (height[left] <= height[left + 1]) {
                left++;
            } else {
                break;
            }
        }
        while (right > left + 2) {
            if (height[right - 1] >= height[right]) {
                right--;
            } else {
                break;
            }
        }
        
        int lb = 0;
        int rb = 0;
        while (left < right) {
            lb = height[left];
            rb = height[right];
            if (lb <= rb) {
                // add volum until an edge larger than the left edge
                while (left < right) {
                    left++;
                    if (lb >= height[left]) {
                        result = result + lb - height[left];
                    } else {
                        break;
                    }
                }
            } else {
                // add volum until an edge larger than the right volum
                while (left < right) {
                    right--;
                    if (rb >= height[right]) {
                        result = result + rb - height[right];
                    } else {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}
