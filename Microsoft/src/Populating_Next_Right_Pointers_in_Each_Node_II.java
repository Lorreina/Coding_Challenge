/**
 * LeetCode Problem
 * 117. Populating Next Right Pointers in Each Node II
 */


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Populating_Next_Right_Pointers_in_Each_Node_II {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode tmp;
        TreeLinkNode node = root;
        while (node != null) {
            tmp = node;
            node = null;
            while (tmp != null) {
                if (node == null && tmp.left != null) {
                    node = tmp.left;
                }
                if (node == null && tmp.right != null) {
                    node = tmp.right;
                }
                helper(tmp);
                tmp = tmp.next;
            }
        }
    }
    
    private void helper(TreeLinkNode node) {
        if (node.left == null && node.right == null) {
            return;
        }
        
        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
            } else {
                TreeLinkNode tmpLeft = node.next;
                while(tmpLeft != null) {
                    if (tmpLeft.left != null) {
                        node.left.next = tmpLeft.left;
                        break;
                    } else if (tmpLeft.right != null) {
                        node.left.next = tmpLeft.right;
                        break;
                    } else {
                        tmpLeft = tmpLeft.next;
                    }
                }
            }
        }
        
        if (node.right != null) {
            TreeLinkNode tmpRight = node.next;
            while(tmpRight != null) {
                if (tmpRight.left != null) {
                    node.right.next = tmpRight.left;
                    break;
                } else if (tmpRight.right != null) {
                    node.right.next = tmpRight.right;
                    break;
                } else {
                    tmpRight = tmpRight.next;
                }
            }
        }
    }
}
