import java.util.Stack;

/**
 * LeetCode
 * 114. Flatten Binary Tree to Linked List
 * @author lorreina
 *
 */
public class Flatten_Binary_Tree_to_Linked_List {
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        TreeNode pointer = root;
        
        while (true) {
            if (pointer.left == null) {
                if (pointer.right == null) {
                    if (stack.isEmpty()) {
                        break;
                    }
                    pointer.right = stack.pop();
                }
                pointer = pointer.right;
            } else {
                if (pointer.right != null) {
                    stack.push(pointer.right);
                }
                pointer.right = pointer.left;
                pointer.left = null;
                pointer = pointer.right;
            }
        }
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
