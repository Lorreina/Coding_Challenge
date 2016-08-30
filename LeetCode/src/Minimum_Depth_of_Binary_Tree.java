import java.util.ArrayList;

/**
 * LeetCode
 * 111. Minimum Depth of Binary Tree
 * @author lorreina
 *
 */
public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode> ();
        list.add(root);
        int depth = 1;
 
        while (list != null) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode> ();
            for (int i = 0; i < list.size(); i++) {
                TreeNode curr = list.get(i);
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                
                if (curr.left != null) {
                    nextLevel.add(curr.left);
                }
                
                if (curr.right != null) {
                    nextLevel.add(curr.right);
                }
            }
            depth++;
            list = nextLevel;
        }
        
        return depth;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
