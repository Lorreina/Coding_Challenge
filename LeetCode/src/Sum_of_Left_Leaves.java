
/**
 * LeetCode
 * 404. Sum of Left Leaves
 * @author lorreina
 *
 */
public class Sum_of_Left_Leaves {
	int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        
        return sum;
    }
    
    private void helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                sum += root.val;
            }
            return;
        }
        
        helper(root.left, true);
        helper(root.right, false);
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
