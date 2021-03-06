import java.util.List;

/**
 * LeetCode
 * 339. Nested List Weight Sum
 * @author lorreina
 *
 */

public class Nested_List_Weight_Sum {
	public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        
        return helper(nestedList, 1);
        
    }
    
    private int helper(List<NestedInteger> nestedList, int coefficient) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger tmp = nestedList.get(i);
            if (tmp.isInteger()) {
                sum = sum + tmp.getInteger() * coefficient;
            } else {
                sum = sum + helper(tmp.getList(), coefficient + 1);
            }
        }
        return sum;
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
