import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode
 * 107. Binary Tree Level Order Traversal II
 * @author lorreina
 *
 */

public class Binary_Tree_Level_Order_Traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if (root == null) {
            return result;
        }
        
        List<TreeNode> level = new ArrayList<TreeNode> ();
        level.add(root);
        while (!level.isEmpty()) {
            int len = level.size();
            List<Integer> levelValue = new ArrayList<Integer> ();
            for (int i = 0; i < len; i++) {
                levelValue.add(level.get(0).val);
                if (level.get(0).left != null) {
                    level.add(level.get(0).left);
                }
                if (level.get(0).right != null) {
                    level.add(level.get(0).right);
                }
                level.remove(0);
            }
            result.add(0, levelValue);
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
