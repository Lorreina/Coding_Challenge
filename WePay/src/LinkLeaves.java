import java.util.ArrayDeque;
import java.util.Deque;
/**
 * WePay Phone Interview.
 * @author lorreina
 *
 */
public class LinkLeaves {
	public void linkLeaves (TreeNode root) {
        if (root==null) return;
        Deque<TreeNode> lt = new ArrayDeque<TreeNode>();
        TreeNode pre = null;
        lt.push(root);
        while (!lt.isEmpty()) { 
                TreeNode node = lt.pop();
                if (node.right != null) lt.push(node.right);
                if (node.left != null) lt.push(node.left);                
                if ((node.left == null) && (node.right == null)) {
                        if (pre != null) {
                                pre.left = node;
                                node.right = pre;
                        }
                        pre = node;
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
