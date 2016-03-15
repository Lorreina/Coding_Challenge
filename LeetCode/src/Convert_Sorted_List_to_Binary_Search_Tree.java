/**
 * LeetCode
 * 109. Convert Sorted List to Binary Search Tree
 * @author lorreina
 *
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(head.val);
        
        if (head.next == null) {
            root = new TreeNode(head.val);
            return root;
        }
        
        if (head.next.next == null) {
            root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        root = new TreeNode(slow.val);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
