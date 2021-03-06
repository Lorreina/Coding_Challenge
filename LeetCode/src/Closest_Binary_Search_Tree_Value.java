
/**
 * 270. Closest Binary Search Tree Value
 * @author lorreina
 *
 */
public class Closest_Binary_Search_Tree_Value {
    TreeNode lower;
    TreeNode upper;
    
    public int closestValue(TreeNode root, double target) {
        getLowerAndUpper(root, target);
        
        if (lower == null) {
            return upper.val;
        }
        if (upper == null) {
            return lower.val;
        }
        
        double diffLeft = target - (double) lower.val;
        double diffRight = (double) upper.val - target;
        if (diffLeft < diffRight) {
            return lower.val;
        } else {
            return upper.val;
        }
    }
    
    private void getLowerAndUpper(TreeNode root, double target) {
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null) {
            if (Double.compare((double) curr.val, target) == 0) {
                this.lower = curr;
                break;
            }
            if (curr.val < target) {
                this.lower = curr;
                curr = curr.right;
            } else {
                parent = curr;
                curr = curr.left;
            }
        }
        
        if (this.lower == null) {
            this.upper = parent;
            return;
        }
        
        if (this.lower.right == null) {
            this.upper = parent;
        } else {
            this.upper = this.lower.right;
            while (this.upper.left != null) {
                this.upper = this.upper.left;
            }
        }
        
        return;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
