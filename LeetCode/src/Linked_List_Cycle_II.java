/**
 * LeetCode
 * 142. Linked List Cycle II
 * @author lorreina
 *
 */
public class Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        if (head == head.next.next) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        
        ListNode pointer = head;
        
        while (pointer != slow) {
            pointer = pointer.next;
            slow = slow.next;
        }
        
        return pointer;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
