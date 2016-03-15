/**
 * LeetCode
 * 98. Validate Binary Search Tree
 * @author lorreina
 *
 */
public class Validate_Binary_Search_Tree {
	public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val == Integer.MAX_VALUE) {
            if (root.right != null) {
                return false;
            }
        }
        
        if (root.val == Integer.MIN_VALUE) {
            if (root.left != null) {
                return false;
            }
        }
        if (root.val >= left && root.val <= right) {
            return helper(root.left, left, root.val - 1) && helper(root.right, root.val + 1, right);
        }
        return false;
    }
    
    public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
