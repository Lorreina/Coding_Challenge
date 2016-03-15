import java.util.Stack;

/**
 * 155. Min Stack
 * @author lorreina
 *
 */
public class Min_Stack {
	Stack<Integer> stack = new Stack<Integer> ();
    int min = Integer.MAX_VALUE;
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return this.min;
    }
}
