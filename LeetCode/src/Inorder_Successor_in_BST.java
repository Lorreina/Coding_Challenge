import java.util.Stack;

/**
 * LeetCode
 * 285. Inorder Successor in BST
 * @author lorreina
 *
 */
public class Inorder_Successor_in_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        // p has right child
        TreeNode successor;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        
        while (true) {
            TreeNode curr = stack.peek();
            if (curr.val == p.val) {
                stack.pop();
                break;
            } else if (curr.val < p.val) {
                stack.push(curr.right);
            } else {
                stack.push(curr.left);
            }
        }
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val > p.val) {
                return curr;
            }
        }
        
        return null;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
