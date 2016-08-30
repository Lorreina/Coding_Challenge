

/**
 * LeetCode
 * 124. Binary Tree Maximum Path Sum
 * @author lorreina
 *
 */
public class Binary_Tree_Maximum_Path_Sum {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        
        return max;
    }
    
    /**
     * helper returns the max branch's sum plus the current node.
     * also update the max path sum.
     **/
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        max = Math.max(max, left + right + node.val);
        
        return Math.max(node.val + Math.max(right, left), 0);
    }
    
    
    /**
     * Definition for a binary tree node.
     * @author lorreina
     *
     */
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}