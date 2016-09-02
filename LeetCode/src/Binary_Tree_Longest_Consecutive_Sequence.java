
/**
 * LeetCode
 * 298. Binary Tree Longest Consecutive Sequence
 * @author lorreina
 *
 */
public class Binary_Tree_Longest_Consecutive_Sequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return helper(root)[1];
    }
    
    private int[] helper(TreeNode root) {
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 1;
        
        if (root.left == null && root.right == null) {
            return res;
        }
        
        if (root.left != null) {
            int[] left = helper(root.left);
            if (root.left.val == (root.val + 1)) {
                res[0] = left[0] + 1;
            }
            res[1] = Math.max(res[0], left[1]);
        }
        
        if (root.right != null) {
            int[] right = helper(root.right);
            if (root.right.val == (root.val + 1)) {
                res[0] = Math.max(res[0], 1 + right[0]);
            }
            res[1] = Math.max(res[0], Math.max(res[1], right[1]));
        }
        
        return res;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
