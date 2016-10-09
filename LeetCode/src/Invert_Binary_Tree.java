
/**
 * LeetCode
 * 226. Invert Binary Tree
 * @author lorreina
 *
 */
public class Invert_Binary_Tree {
	public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = helper(root.right);
        root.right = helper(left);
        return root;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
