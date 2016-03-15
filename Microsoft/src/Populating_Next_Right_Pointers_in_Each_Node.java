/**
 * LeetCode Problem
 * 116. Populating Next Right Pointers in Each Node
 */


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Populating_Next_Right_Pointers_in_Each_Node {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }
    
    private void helper(TreeLinkNode node) {
        if (node.left == null && node.right == null) {
            return;
        }
        node.left.next = node.right;
        if (node.next != null) {
            node.right.next = node.next.left;
        }
        helper(node.left);
        helper(node.right);
    }
}
