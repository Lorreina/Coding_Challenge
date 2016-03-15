/**
 * LeetCode
 * 25. Reverse Nodes in k-Group
 * @author lorreina
 *
 */
public class Reverse_Nodes_in_kGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null  || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode start = head;
        ListNode pointer = head;
        while (head != null) {
            start = head;
            for (int i = 1; i < k; i++) {
                head = head.next;
                if (head == null) {
                    return dummy.next;
                }
            }
            pointer = head;
            head = head.next;
            pointer.next = null;
            prev.next = reverse(start, head);
            prev = start;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, ListNode head) {
        ListNode tmp = start.next;
        ListNode prev = head;
        start.next = prev;
        prev = start;
        start = tmp;
        
        while (start != null) {
            tmp = start.next;
            start.next= prev;
            prev = start;
            start = tmp;
        }
        
        return prev;
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
