import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 364. Nested List Weight Sum II
 * @author lorreina
 *
 */
public class Nested_List_Weight_Sum_II {
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
	public class Solution {
	    public int depthSumInverse(List<NestedInteger> nestedList) {
	        return helper(nestedList, 0);
	    }
	    
	    private int helper(List<NestedInteger> list, int plus) {
	        List<NestedInteger> nextLevel = new ArrayList<NestedInteger> ();
	        int sum = plus;
	        for (int i = 0; i < list.size(); i++) {
	            NestedInteger tmp = list.get(i);
	            if (tmp.isInteger()) {
	                sum += tmp.getInteger();
	            } else {
	                nextLevel.addAll(tmp.getList());
	            }
	        }
	        
	        if (nextLevel.size() != 0) {
	            sum += helper(nextLevel, sum);
	        }
	        
	        return sum;
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
