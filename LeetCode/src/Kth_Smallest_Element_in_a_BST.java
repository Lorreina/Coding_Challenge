import java.util.Stack;

/**
 * LeetCode
 * 230. Kth Smallest Element in a BST
 * @author lorreina
 *
 */
public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        while (k > 0) {
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            } 
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        
        return -1;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
