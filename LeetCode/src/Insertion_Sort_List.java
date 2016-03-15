/**
 * LeetCode
 * 147. Insertion Sort List
 * @author lorreina
 *
 */
public class Insertion_Sort_List {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = head.next;
        head.next = null;
        ListNode tmp = null;
        while (dummy != null) {
            tmp = dummy;
            dummy = dummy.next;
            head = insert(head, tmp);
        }
        
        return head;
    }
    
    private ListNode insert(ListNode head, ListNode target) {
        if (target.val <= head.val) {
            target.next = head;
            return target;
        }
        
        ListNode prev = head;
        while (prev.next != null) {
            if (target.val <= prev.next.val) {
                target.next = prev.next;
                prev.next = target;
                return head;
            }
            prev = prev.next;
        }
    
        prev.next = target;
        target.next = null;
        return head;
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
