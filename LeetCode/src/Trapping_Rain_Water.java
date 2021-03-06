import java.util.Stack;

/**
 * LeetCode
 * 42. Trapping Rain Water
 * @author lorreina
 *
 */
public class Trapping_Rain_Water {
	public int trap(int[] height) {
		if (height == null || height.length <= 2) {
			return 0;
		}
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer> ();
		int hi = 0;
		
		for (int i = 1; i < height.length; i++) {
			if (height[i] < height[hi]) {
				stack.push(height[i]);
			} else {
				while (!stack.isEmpty()) {
					sum += height[hi] - stack.pop();
				}
				hi = i;
			}
		}
		
		int end = hi;
		stack.clear();
		hi = height[height.length - 1];
		for (int i = height.length - 2; i >= end; i--) {
			if (height[i] < height[hi]) {
				stack.push(height[i]);
			} else {
				while (!stack.isEmpty()) {
					sum += height[hi] - stack.pop();
				}
				hi = i;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		Trapping_Rain_Water tmp = new Trapping_Rain_Water();
		System.out.println(tmp.trap(height));
	}
}
