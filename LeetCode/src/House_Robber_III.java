
/**
 * LeetCode
 * 337. House Robber III
 * @author lorreina
 *
 */
public class House_Robber_III {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        
        return res[0];
    }
    
    public int[] helper(TreeNode root) {
        int[] res = new int[2];
        
        if (root == null) {
            return res;
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[1] = left[0] + right[0];
        res[0] = Math.max(res[1], root.val + left[1] + right[1]);
        
        return res;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
