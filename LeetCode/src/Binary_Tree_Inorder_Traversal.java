import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode
 * 94. Binary Tree Inorder Traversal
 * @author lorreina
 *
 */
public class Binary_Tree_Inorder_Traversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> ();
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
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
