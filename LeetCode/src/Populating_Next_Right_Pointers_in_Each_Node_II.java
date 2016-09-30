/**
 * LeetCode
 * 117. Populating Next Right Pointers in Each Node II
 * @author lorreina
 *
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II {
	public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        
        while (start != null) {
            TreeLinkNode nextStart = null;
            TreeLinkNode curr = null;
            while (start != null) {
                curr = start.next;
                if (start.left != null) {
                    if (nextStart == null) {
                        nextStart = start.left;
                    }
                    if (start.right != null) {
                        start.left.next = start.right;
                        curr = start.next;
                    } else {
                        curr = start.next;
                        while (curr != null) {
                            if (curr.left != null) {
                                start.left.next = curr.left;
                                break;
                            } else if (curr.right != null) {
                                start.left.next = curr.right;
                                break;
                            } else {
                                curr = curr.next;
                            }
                        }
                    }
                } 
                
                if (start.right != null) {
                    if (nextStart == null) {
                        nextStart = start.right;
                    }
                    curr = start.next;
                    while (curr != null) {
                        if (curr.left != null) {
                            start.right.next = curr.left;
                            break;
                        } else if (curr.right != null) {
                            start.right.next = curr.right;
                            if (nextStart == null) {
                                nextStart = start.right;
                            }
                            break;
                        } else {
                            curr = curr.next;
                        }
                    }
                }
                
                start = curr;
            }
            start = nextStart;
        }
        
        return;
    }
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
}
