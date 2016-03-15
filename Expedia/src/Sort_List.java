/**
 * LeetCode
 * 148. Sort List
 * @author lorreina
 *
 */
public class Sort_List {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;
        
        ListNode first = sortList(head);
        second = sortList(second);
        
        head = mergeList(first, second);
        return head;
    }
    
    private ListNode mergeList(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
    
        while (first != null && second != null) {
            if (first.val < second.val) {
                pointer.next = first;
                first = first.next;
            } else {
                pointer.next = second;
                second = second.next;
            }
            pointer = pointer.next;
        }
        
        if (first != null) {
            pointer.next = first;
        } else if (second != null) {
            pointer.next = second;
        }
        
        return dummy.next;
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}	
