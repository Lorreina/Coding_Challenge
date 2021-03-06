import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 113. Path Sum II
 * @author lorreina
 *
 */
public class Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<> ();
        
        dfs(root, sum, res, new ArrayList<Integer> ());
        
        return res;
    }
    
    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        
        path.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<Integer> (path));
            }
        } else {
            dfs(root.left, sum - root.val, res, path);
            dfs(root.right, sum - root.val, res, path);
        }
        
        path.remove(path.size() - 1);
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
