/**
 * LeetCode
 * 110. Balanced Binary Tree
 * @author lorreina
 *
 */
public class Balanced_Binary_Tree {
	public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (helper(root) == -1) {
            return false;
        }
        
        return true;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if (left == -1 || right == -1) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
