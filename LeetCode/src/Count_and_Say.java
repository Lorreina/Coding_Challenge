/**
 * LeetCode
 * 38. Count and Say
 * @author lorreina
 *
 */
public class Count_and_Say {
	public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        
        int l = 0, r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        int maxLeft = height[l], maxRight = height[r];
        while (l < r) {
            if (height[l] < maxLeft) {
                l++;
                continue;
            }
            if (height[r] < maxRight) {
                r--;
                continue;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            maxLeft = height[l];
            maxRight = height[r];
            if (height[l] >= height[r]) {
                r--;
            } else {
                l++;
            }
        }
        
        return max;
        
    }
}
