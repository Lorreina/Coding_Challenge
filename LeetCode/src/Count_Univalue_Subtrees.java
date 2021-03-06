
/**
 * LeetCode
 * 250. Count Univalue Subtrees
 * @author lorreina
 *
 */
public class Count_Univalue_Subtrees {
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.count = 0;
        isUnivalSubtree(root);
        return this.count;
    }
    
    private boolean isUnivalSubtree(TreeNode root) {
        if (root.left == null && root.right == null) {
            this.count++;
            return true;
        } else if (root.left == null) {
            if (isUnivalSubtree(root.right)) {
                if (root.val == root.right.val) {
                    this.count++;
                    return true;
                }
            }
        } else if (root.right == null) {
            if (isUnivalSubtree(root.left)) {
                if (root.val == root.left.val) {
                    this.count++;
                    return true;
                }
            }
        } else {
        	boolean left = isUnivalSubtree(root.left);
        	boolean right = isUnivalSubtree(root.right);
            if (left && right) {
                if (root.val == root.right.val && root.val == root.left.val) {
                    this.count++;
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    public static void main(String[] args) {
    	Count_Univalue_Subtrees tmp = new Count_Univalue_Subtrees();
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(5);
    	root.left.left = new TreeNode(5);
    	root.left.right = new TreeNode(5);
    	root.right.right = new TreeNode(5);
    	
    	System.out.println(tmp.countUnivalSubtrees(root));
    }
}
