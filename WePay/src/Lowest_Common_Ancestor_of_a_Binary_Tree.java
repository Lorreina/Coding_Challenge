/**
 * LeetCode
 * 236. Lowest Common Ancestor of a Binary Tree
 * @author lorreina
 *
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        
        if (p == root) {
            return root;
        }
        if (q == root) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
