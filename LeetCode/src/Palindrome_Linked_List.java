/**
 * LeetCode
 * 234. Palindrome Linked List
 * @author lorreina
 *
 */
public class Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode pointer = slow.next;
        slow.next = null;
        pointer = reverse(pointer);
        
        while (pointer != null) {
            if (head.val != pointer.val) {
                return false;
            }
            head = head.next;
            pointer = pointer.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode tmp;
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
