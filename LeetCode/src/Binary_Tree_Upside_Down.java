
/**
 * LeetCode
 * 156. Binary Tree Upside Down
 * @author lorreina
 *
 */
public class Binary_Tree_Upside_Down {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null) {
            return root;
        }
        
        TreeNode tmp = root.left;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        tmp.left = right;
        tmp.right = root;
        root.left = null;
        root.right = null;
        
        return left;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}	
