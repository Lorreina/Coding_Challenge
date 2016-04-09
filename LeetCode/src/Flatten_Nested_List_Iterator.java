import java.util.Iterator;
import java.util.List;
import java.util.Stack;


public class Flatten_Nested_List_Iterator {
	public class NestedIterator implements Iterator<Integer> {
		private Stack<List<NestedInteger>> stack;
	    private Stack<Integer> index;
	    
	    public NestedIterator(List<NestedInteger> nestedList) {
	        this.stack = new Stack<List<NestedInteger>> ();
	        this.index = new Stack<Integer> ();
	        if (nestedList != null && nestedList.size() != 0) {
	            this.stack.push(nestedList);
	            this.index.push(-1);
	        }
	    }

	    @Override
	    public Integer next() {
	        Integer result = stack.peek().get(index.peek()).getInteger();
	        return result;
	    }

	    @Override
	    public boolean hasNext() {
	        while(stack.size() > 0 && index.peek() == stack.peek().size() - 1) {
	            index.pop();
	            stack.pop();
	        }
	        
	        if (stack.size() == 0) {
	            return false;
	        } else {
	           index.push(index.pop() + 1);
	        }
	        
	        NestedInteger tmp = null;
	        while (true) {
	            tmp = stack.peek().get(index.peek());
	            if (tmp.isInteger()) {
	                break;
	            } else {
	                if (tmp.getList() == null || tmp.getList().size() == 0) {
	                    return this.hasNext();
	                }
	                stack.push(tmp.getList());
	                index.push(0);
	            }
	        }
	        return true;
	    }
	}
	
	public interface NestedInteger {
    	// @return true if this NestedInteger holds a single integer, rather than a nested list.
    	public boolean isInteger();
    	// @return the single integer that this NestedInteger holds, if it holds a single integer
    	// Return null if this NestedInteger holds a nested list
    	public Integer getInteger();
    	// @return the nested list that this NestedInteger holds, if it holds a nested list
    	// Return null if this NestedInteger holds a single integer
    	public List<NestedInteger> getList();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
