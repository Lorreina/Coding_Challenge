/**
 * LeetCode
 * 141. Linked List Cycle
 * @author lorreina
 *
 */
public class Linked_List_Cycle {
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return false;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
