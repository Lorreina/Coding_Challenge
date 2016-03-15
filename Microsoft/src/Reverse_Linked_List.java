
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Reverse_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = null;
        ListNode prev = null;
        
        while (head != null) {
            dummy = head;
            head = head.next;
            dummy.next = prev;
            prev = dummy;
        }
        
        return dummy;
    }
}
