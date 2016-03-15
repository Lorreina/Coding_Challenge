import java.util.Stack;
/**
 * LeetCode
 * 20. Valid Parentheses
 * @author lorreina
 *
 */
public class Valid_Parentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character> ();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (isLeft(tmp)) {
                stack.push(tmp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isPair(tmp, stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isLeft(char tmp) {
        if (tmp == '(' || tmp == '[' || tmp == '{') {
            return true;
        }
        return false;
    }
    
    private boolean isPair(char right, char left) {
        if (right == '}' && left == '{') {
            return true;
        }
        if (right == ']' && left == '[') {
            return true;
        }
        if (right == ')' && left == '(') {
            return true;
        }
        
        return false;
    }
}
