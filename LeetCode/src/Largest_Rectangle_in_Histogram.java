import java.util.Stack;

/**
 * LeetCode
 * 84. Largest Rectangle in Histogram
 * @author lorreina
 *
 */
public class Largest_Rectangle_in_Histogram {
	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int[] area = new int[heights.length];
        Stack<Integer> stack = new Stack<Integer> ();
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                area[index] = (i - index) * heights[index];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            area[index] = (heights.length - index) * heights[index];
        }
        
        stack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                area[index] += (index - i) * heights[index] - heights[index];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            area[index] += (index + 1) * heights[index] - heights[index];
        }
        
        int maxArea = 0;
        for (int i = 0; i < area.length; i++) {
            maxArea = Math.max(maxArea, area[i]);
        }
        
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] heights = {2, 4};
		Largest_Rectangle_in_Histogram tmp = new Largest_Rectangle_in_Histogram();
		System.out.println(tmp.largestRectangleArea(heights));
	}
}
