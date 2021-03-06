import java.util.Stack;

/**
 * LeetCode
 * 232. Implement Queue using Stacks
 * @author lorreina
 *
 */
public class Implement_Queue_using_Stacks {
	class MyQueue {
	    Stack<Integer> pushStack;
	    Stack<Integer> popStack;
	    
	    public MyQueue() {
	        this.pushStack = new Stack<Integer> ();
	        this.popStack = new Stack<Integer> ();
	    }
	    
	    // Push element x to the back of queue.
	    public void push(int x) {
	        pushStack.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if (popStack.isEmpty()) {
	            while (!pushStack.isEmpty()) {
	                popStack.push(pushStack.pop());
	            }
	        }
	        popStack.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        if (popStack.isEmpty()) {
	            while (!pushStack.isEmpty()) {
	                popStack.push(pushStack.pop());
	            }
	        }
	        return popStack.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return (popStack.isEmpty() && pushStack.isEmpty());
	    }
	}
}
