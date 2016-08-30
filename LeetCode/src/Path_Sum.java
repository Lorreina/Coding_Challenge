/**
 * LeetCode
 * 112. Path Sum
 * @author lorreina
 *
 */

public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                return true;
            } else {
                return false;
            }
        } 
        
        return (helper(node.left, sum - node.val) || helper(node.right, sum - node.val));
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
