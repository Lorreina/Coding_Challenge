/**
 * LeetCode 24. Swap Nodes in Pairs
 * @author lorreina
 *
 */
public class Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        ListNode tmp;
        while (pointer.next != null && pointer.next.next != null) {
            tmp = pointer.next;
            pointer.next = tmp.next;
            tmp.next = tmp.next.next;
            pointer.next.next = tmp;
            pointer = tmp;
        }
        
        return dummy.next;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */