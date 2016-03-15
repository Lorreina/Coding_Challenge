/**
 * LeetCode
 * 328. Odd Even Linked List
 * @author lorreina
 *
 */
public class Odd_Even_Linked_List {
	public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode dummy = head.next;
        ListNode odd = head;
        ListNode even = odd.next;
        
        while (odd.next != null && odd.next.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = dummy;
        return head;
    }
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode pointer = head;
		for (int i = 2; i < 9; i++) {
			pointer.next = new ListNode(i);
			pointer = pointer.next;
		}
		ListNode result = oddEvenList(head);
		System.out.println("good");
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
