
/**
 * LeetCode
 * 333. Largest BST Subtree
 * @author lorreina
 *
 */
public class Largest_BST_Subtree {
    int maxNum;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root);
        return maxNum;
    }
    
    public int[] helper(TreeNode root) {
        int[] res = new int[3];
        if (root.left == null && root.right == null) {
            res[0] = 1;
            res[1] = root.val;
            res[2] = root.val;
            
        } else if (root.left == null) {
            int[] right = helper(root.right);
            if (right[0] > 0 && root.val < right[1]) {
                res[0] = right[0] + 1;
                res[1] = root.val;
                res[2] = right[2];
            }
        } else if (root.right == null) {
            int[] left = helper(root.left);
            if (left[0] > 0 && root.val > left[2]) {
                res[0] = left[0] + 1;
                res[1] = left[1];
                res[2] = root.val;
            }
        } else {
            int[] left = helper(root.left);
            int[] right = helper(root.right);
            if (left[0] > 0 && right[0] > 0 && root.val < right[1] && root.val > left[2]) {
                res[0] = right[0] + 1 + left[0];
                res[1] = left[1];
                res[2] = right[2];
            }
        }
        
        maxNum = Math.max(maxNum, res[0]);
        return res;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
