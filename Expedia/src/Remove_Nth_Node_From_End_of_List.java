/**
 * LeetCode
 * 19. Remove Nth Node From End of List
 * @author lorreina
 *
 */
public class Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        
        if (prev == null) {
            return head.next;
        } else {
            prev.next = slow.next;
        }
        
        return head;
    }
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}	
