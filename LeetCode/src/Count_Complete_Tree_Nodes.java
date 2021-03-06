
/**
 * LeetCode
 * 222. Count Complete Tree Nodes
 * @author lorreina
 *
 */
public class Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return helper(root, 1);
    }
    
    private int helper(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            return val;
        }
        
        if (root.right == null) {
            return val * 2;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (leftHeight > rightHeight) {
            return helper(root.left, val * 2);
        } else {
            return helper(root.right, val * 2 + 1);
        }
    }
    
    private int getHeight(TreeNode root) {
        int height = 0;
        
        while (root != null) {
            root = root.left;
            height++;
        }
        
        return height;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
