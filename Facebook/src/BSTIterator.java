import java.util.Stack;
/**
 * LeetCode
 * 173. Binary Search Tree Iterator
 * @company: Facebook, LinkedIn, Google, Microsoft
 * @author lorreina
 *
 */

public class BSTIterator {
private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode> ();
        if (root != null) {
            stack.push(root);
            TreeNode curr = root;
            while (curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int num = curr.val;
        if (curr.right != null) {
            stack.push(curr.right);
            curr = curr.right;
            while (curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            }
        }
        
        return num;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */