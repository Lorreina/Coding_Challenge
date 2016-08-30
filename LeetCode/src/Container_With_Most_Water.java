/**
 * LeetCode
 * 
 * @author lorreina
 *
 */
public class Container_With_Most_Water {
	public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int maxDepth = 0;
        
        while (left < right) {
        	// change from Math.max & Math.min to this to avoid Time Limit Exceed
            int currDepth = Math.min(height[left], height[right]);
            if (currDepth > maxDepth) {
                int currArea = currDepth * (right - left);
                if (currArea > maxArea) {
                    maxArea = currArea;
                    maxDepth = currDepth;
                }
            }
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] height = new int[15000];
		for (int i = 0; i < height.length; i++) {
			height[i] = height.length - i;
		}
		System.out.println(maxArea(height));
	}
}
