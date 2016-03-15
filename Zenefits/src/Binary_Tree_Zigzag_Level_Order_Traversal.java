import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 103. Binary Tree Zigzag Level Order Traversal
 * @author lorreina
 *
 */

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if (root == null) {
            return result;
        }
        
        List<TreeNode> level = new ArrayList<TreeNode> ();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> levelValue = new ArrayList<Integer> ();
            int len = level.size();
            if (result.size() % 2 == 0) {
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
            } else {
                for (int i = 0; i < len; i++) {
                    levelValue.add(0, level.get(0).val);
                    if (level.get(0).left != null) {
                        level.add(level.get(0).left);
                    }
                    if (level.get(0).right != null) {
                        level.add(level.get(0).right);
                    }
                    level.remove(0);
                }
            }
            result.add(levelValue);
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
