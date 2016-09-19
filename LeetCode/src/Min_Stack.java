import java.util.Stack;

public class Min_Stack {
	public static class MinStack {
	    Stack<Integer> stack;
	    Stack<Integer> min;

	    /** initialize your data structure here. */
	    public MinStack() {
	        stack = new Stack<Integer> ();
	        min = new Stack<Integer> ();
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        if (min.isEmpty() || min.peek() >= x) {
	            min.push(x);
	        }
	    }
	    
	    public void pop() {
	        if (stack.pop().equals(min.peek())) {
	            min.pop();
	        }
	        
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return min.peek();
	    }
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	
	public static void main (String[] args) {
		MinStack tmp = new MinStack();
		tmp.push(512);
		tmp.push(-1024);
		tmp.push(-1024);
		tmp.push(512);
		tmp.pop();
		System.out.println(tmp.getMin());
		tmp.pop();
		System.out.println(tmp.getMin());
		tmp.pop();
		System.out.println(tmp.getMin());
	}
}
