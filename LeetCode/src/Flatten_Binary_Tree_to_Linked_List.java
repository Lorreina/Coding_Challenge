
/**
 * LeetCode
 * 114. Flatten Binary Tree to Linked List
 * @author lorreina
 *
 */
public class Flatten_Binary_Tree_to_Linked_List {
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        
        if (root.left == null) {
            return helper(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return helper(root.right);
        } else {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tmp = helper(root.right);
            tmp.right = right;
            return helper(right);
        }
        
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
