import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 366. Find Leaves of Binary Tree
 * @author lorreina
 *
 */
public class Find_Leaves_of_Binary_Tree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        
        if (root == null) {
            return res;
        }
        
        while(isLeaf(root) == false) {
            List<Integer> list = new ArrayList<Integer> ();
            list = helper(root);
            res.add(list);
        }
        
        List<Integer> rootList = new ArrayList<Integer> ();
        rootList.add(root.val);
        res.add(rootList);
        
        return res;
    }
    
    private List<Integer> helper(TreeNode node) {
        List<Integer> list = new ArrayList<Integer> ();
        if (node == null) {
            return list;
        }
        
        if (isLeaf(node.left)) {
            list.add(node.left.val);
            node.left = null;
        } else {
            list.addAll(helper(node.left));
        }
        if (isLeaf(node.right)) {
            list.add(node.right.val);
            node.right = null;
        } else {
            list.addAll(helper(node.right));
        }
        
        return list;
    }
    
    private boolean isLeaf(TreeNode node) {
        if(node != null && node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
	}
}
