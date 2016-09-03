import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * @author lorreina
 *
 */
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> ();
        if (root == null) {
            return res;
        }
        
        List<TreeNode> level = new ArrayList<TreeNode> ();
        level.add(root);
        while (level.size() != 0) {
            res.add(level.get(level.size() - 1).val);
            List<TreeNode> nextLevel = new ArrayList<TreeNode> ();
            for (int i = 0; i < level.size(); i++) {
                if (level.get(i).left != null) {
                    nextLevel.add(level.get(i).left);
                }
                if (level.get(i).right != null) {
                    nextLevel.add(level.get(i).right);
                }
            }
            level = nextLevel;
        }
        
        return res;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
