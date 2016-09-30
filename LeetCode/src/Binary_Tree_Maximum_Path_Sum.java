

/**
 * LeetCode
 * 124. Binary Tree Maximum Path Sum
 * @author lorreina
 *
 */
public class Binary_Tree_Maximum_Path_Sum {
//    int max = Integer.MIN_VALUE;
    
//    public int maxPathSum(TreeNode root) {
//        helper(root);
//        
//        return max;
//    }
//    
//    /**
//     * helper returns the max branch's sum plus the current node.
//     * also update the max path sum.
//     **/
//    private int helper(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        
//        int left = helper(node.left);
//        int right = helper(node.right);
//        
//        max = Math.max(max, left + right + node.val);
//        
//        return Math.max(node.val + Math.max(right, left), 0);
//    }
    int maxPath = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumNode(root);
        
        return maxPath;
    }
    
    public int maxPathSumNode(TreeNode root) {
        int path = root.val;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        
        if (root.left != null) {
            left = maxPathSumNode(root.left);
            path = Math.max(path, root.val + left);
        }
        
        if (root.right != null) {
            right = maxPathSumNode(root.right);
            path = Math.max(path, root.val + right);
        }
        
        if (root.left != null && root.right != null) {
        	maxPath = Math.max(path, root.val + left + right);
        }
        
        maxPath = Math.max(path, maxPath);
        return path;
    }
    
    
    /**
     * Definition for a binary tree node.
     * @author lorreina
     *
     */
    public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    public static void main(String[] args) {
    	Binary_Tree_Maximum_Path_Sum tmp = new Binary_Tree_Maximum_Path_Sum();
    	
    	TreeNode root = new TreeNode(-2);
    	root.right = new TreeNode(-3);
    	System.out.println(tmp.maxPathSum(root));
    }
}
