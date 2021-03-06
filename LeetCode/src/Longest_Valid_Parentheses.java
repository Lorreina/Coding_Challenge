import java.util.Stack;

/**
 * LeetCode
 * 32. Longest Valid Parentheses
 * @author lorreina
 *
 */
public class Longest_Valid_Parentheses {
	public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int longest = 0;
        int[] count = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer> ();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int left = stack.pop();
                    if (left > 0) {
                        count[i] = (i - left + 1) + count[left - 1];
                    } else {
                        count[i] = i - left + 1;
                    }
                    longest = Math.max(longest, count[i]);
                }
            }
        }
        
        return longest;
    }
}
