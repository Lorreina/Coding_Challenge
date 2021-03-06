
/**
 * LeetCode
 * 129. Sum Root to Leaf Numbers
 * @author lorreina
 *
 */
public class Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        sum += root.val;
        
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        int newSum = dfs(root.left, sum * 10) + dfs(root.right, sum * 10);
        
        return newSum;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
