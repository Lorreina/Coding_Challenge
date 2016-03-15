/**
 * LeetCode
 * 86. Partition List
 * @author lorreina
 *
 */
public class Partition_List {
	public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pointer = head;
        ListNode prev = null;
        ListNode dummy = new ListNode(0);
        ListNode large = dummy;
        
        while (pointer != null) {
            if (pointer.val >= x) {
                large.next = pointer;
                large = large.next;
                if (prev == null) {
                    head = pointer.next;
                } else {
                    prev.next = pointer.next;
                }
            } else {
                prev = pointer;
            }
            pointer = pointer.next;
        }
        
        if (prev == null) {
            return dummy.next;
        }
        large.next = null;
        prev.next = dummy.next;
        
        return head;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
