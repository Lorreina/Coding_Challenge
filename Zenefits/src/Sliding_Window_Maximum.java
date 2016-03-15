import java.util.ArrayDeque;

/**
 * LeetCode
 * 239. Sliding Window Maximum
 * @author lorreina
 *
 */

// use a queue to store the temporary max value

public class Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<Integer> ();
        
        for (int i = 0; i < nums.length; i++) {
        	// discard the element that is out of the window size
            if (queue.size() > 0 && queue.peek() <= i - k) {
                queue.poll();
            }
            
            // discard element which is in the window but smaller than the newly come element
            // these smaller element are useless
            while (queue.size() > 0 && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            
            // add the index into queue, the result array contains value.
            queue.offer(i);
            if (i >= k - 1) {
                result[index] = nums[queue.peek()];
                index++;
            }
        }
        
        return result;
    }
}
