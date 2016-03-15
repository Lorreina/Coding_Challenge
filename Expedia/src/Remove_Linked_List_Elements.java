/**
 * LeetCode
 * 203. Remove Linked List Elements
 * @author lorreina
 *
 */
public class Remove_Linked_List_Elements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode pointer = head.next;
        while (pointer != null) {
            if (pointer.val == val) {
                prev.next = pointer.next;
            } else {
                prev = pointer;
            }
            pointer = pointer.next;
        }
        return head;
    }
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
