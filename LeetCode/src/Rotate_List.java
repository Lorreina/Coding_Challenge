/**
 * LeetCode
 * 61. Rotate List
 * @author lorreina
 *
 */
public class Rotate_List {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int i = 1;
        ListNode fast = head;
        ListNode slow = head;
        
        for (i = 1; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        
        if (fast == null) {
            k = k % i;
            fast = head;
            for (i = 1; i < k; i++) {
                fast = fast.next;
            }
        }
        
        if (fast.next == null || k == 0) {
            return head;
        }
        
        ListNode prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        fast.next = head;
        
        return slow;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
