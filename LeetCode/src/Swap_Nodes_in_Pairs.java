
/**
 * LeetCode
 * 24. Swap Nodes in Pairs
 * @author lorreina
 *
 */
public class Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        ListNode first = null;
        ListNode second = null;
        
        while (curr.next != null && curr.next.next != null) {
            first = curr.next;
            second = curr.next.next;
            curr.next = second;
            first.next = second.next;
            second.next = first;
            curr = first;
        }
        
        return dummy.next;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
