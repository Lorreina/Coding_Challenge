import java.util.Stack;

/**
 * LeetCode
 * 173. Binary Search Tree Iterator
 * @author lorreina
 *
 */
public class Binary_Search_Tree_Iterator {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	public class BSTIterator {
	    Stack<TreeNode> stack;
	    
	    public BSTIterator(TreeNode root) {
	        stack = new Stack<TreeNode> ();
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode small = stack.pop();
	        TreeNode right = small.right;
	        
	        while (right != null) {
	            stack.push(right);
	            right = right.left;
	        }
	        
	        return small.val;
	    }
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}
