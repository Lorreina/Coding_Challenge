import java.util.Stack;

/**
 * LeetCode
 * 232. Implement Queue using Stacks
 * @author lorreina
 *
 */
public class Implement_Queue_using_Stacks {
	class MyQueue {
	    private Stack<Integer> stack1 = new Stack<Integer> ();
	    private Stack<Integer> stack2 = new Stack<Integer> ();
	    
	    // Push element x to the back of queue.
	    public void push(int x) {
	        stack2.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if (stack1.isEmpty()) {
	            swap();
	        }
	        stack1.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        if (stack1.isEmpty()) {
	            swap();
	        }
	        return stack1.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return stack1.isEmpty() && stack2.isEmpty();
	    }
	    
	    private void swap() {
	        while (!stack2.isEmpty()) {
	            stack1.push(stack2.pop());
	        }
	    }
	}
}
