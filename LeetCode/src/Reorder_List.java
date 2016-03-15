/**
 * LeetCode
 * 143. Reorder List
 * @author lorreina
 *
 */
public class Reorder_List {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        // merge two list
        ListNode tmp = null;
        while (fast != null) {
            tmp = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast.next = tmp;
            fast = slow;
            slow = tmp;
        }
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode tmp = null;
        
        while (head != null) {
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
