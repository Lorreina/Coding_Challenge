/**
 * LeetCode: 226. Invert Binary Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Invert_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    
    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        helper(node.left);
        helper(node.right);
    }
}
