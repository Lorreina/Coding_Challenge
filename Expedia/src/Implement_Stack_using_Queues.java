import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode
 * 225. Implement Stack using Queues
 * @author lorreina
 *
 */
public class Implement_Stack_using_Queues {
	class MyStack {
	    // Push element x onto stack.
	    Queue<Integer> queue1 = new LinkedList<Integer> ();
	    Queue<Integer> queue2 = new LinkedList<Integer> ();
	    
	    public void push(int x) {
	        queue1.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        moveItems();
	        queue1.poll();
	        swap();
	    }

	    // Get the top element.
	    public int top() {
	        moveItems();
	        int item = queue1.poll();
	        swap();
	        queue1.offer(item);
	        return item;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue1.isEmpty();
	    }
	    
	    private void moveItems() {
	        while (queue1.size() > 1) {
	            queue2.offer(queue1.poll());
	        }
	    }
	    
	    private void swap() {
	        Queue<Integer> tmp = queue1;
	        queue1 = queue2;
	        queue2 = tmp;
	    }
	    
	    
	}
}
