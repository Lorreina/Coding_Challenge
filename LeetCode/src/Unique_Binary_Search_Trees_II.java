import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 95. Unique Binary Search Trees II
 * @author lorreina
 *
 */
public class Unique_Binary_Search_Trees_II {
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode> ();
        if (n == 0) {
            return result;
        }
        result = helper(1, n);
        return result;
        // return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode> ();
        
        if (start > end) {
            result.add(null);
            return result;
        }
        
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = helper(start, i - 1);
            right = helper(i + 1, end);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
    
    public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
