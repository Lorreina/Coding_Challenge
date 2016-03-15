import java.util.HashSet;

public class Delete_Duplicate_Linked_List {
	public ListNode deleteDuplicate(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		HashSet<Integer> map = new HashSet<Integer> ();
		ListNode pointer = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		while (pointer != null) {
			if (map.contains(pointer.val)) {
				dummy.next = pointer.next;
			} else {
				map.add(pointer.val);
				dummy = pointer;
			}
			pointer = pointer.next;
		}
		
		return dummy.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
