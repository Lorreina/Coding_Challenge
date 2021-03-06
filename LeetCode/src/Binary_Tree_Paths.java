import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 257. Binary Tree Paths
 * @author lorreina
 *
 */
public class Binary_Tree_Paths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String> ();
        if (root == null) {
            return res;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        dfs(res, root, list);
        
        return res;
    }
    
    private void dfs(List<String> res, TreeNode root, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder();
            
            for (int i = 0; i < list.size() - 1; i++) {
                path.append(list.get(i));
                path.append("->");
            }
            path.append(list.get(list.size() - 1));
            res.add(path.toString());
            return;
        }
        
        if (root.left != null) {
            list.add(root.left.val);
            dfs(res, root.left, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            dfs(res, root.right, list);
            list.remove(list.size() - 1);
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
