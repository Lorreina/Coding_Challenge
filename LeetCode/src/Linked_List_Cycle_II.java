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
            if (slow == fast && slow != head) {
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
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		Linked_List_Cycle_II tmp = new Linked_List_Cycle_II();
		System.out.println(tmp.detectCycle(head).val);
		
	}
}
