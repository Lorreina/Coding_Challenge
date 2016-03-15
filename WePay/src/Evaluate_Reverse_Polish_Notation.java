import java.util.Stack;

/**
 * LeetCode
 * 150. Evaluate Reverse Polish Notation My Submissions Question
 * @author lorreina
 *
 */
public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer> ();
        for (int i = 0; i < tokens.length; i++) {
            char tmp = tokens[i].charAt(0);
            if ((tmp >= '0' && tmp <= '9') || (tmp == '-' && tokens[i].length() > 1)) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int result = calculate(stack.pop(), stack.pop(), tmp);
                stack.push(result);
            }
        }
        return stack.pop();
    }
    
    private int calculate(int y, int x, char op) {
        if (op == '+') {
            return x + y;
        } else if (op == '-') {
            return x - y;
        } else if (op == '*') {
            return x * y;
        } else {
            return x / y;
        }
    }
}
