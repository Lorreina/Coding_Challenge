/**
 * LeetCode
 * 92. Reverse Linked List II
 * @author lorreina
 *
 */
public class Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        
        ListNode pointer = head;
        ListNode prev = null;
        ListNode tmp = null;
        
        for (int i = 1; i < m; i++) {
            start = start.next;
            pointer = pointer.next;
        }
        tmp = pointer;
        for (int i = m; i < n; i++) {
            tmp = tmp.next;
        }
        
        prev = tmp.next;
        tmp.next = null;
        
        tmp = pointer.next;
        pointer.next = prev;
        prev = pointer;
        pointer = tmp;
        
        while (pointer != null) {
            tmp = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = tmp;
        }
        
        start.next = prev;
        
        return dummy.next;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
