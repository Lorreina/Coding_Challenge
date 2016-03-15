/**
 * LeetCode
 * 82. Remove Duplicates from Sorted List II
 * @author lorreina
 *
 */
public class Remove_Duplicates_from_Sorted_List_II {
	public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean isUnique = true;
        while (head.next != null) {
            isUnique = true;
            while (head.val == head.next.val) {
                isUnique = false;
                head = head.next;
                if (head.next == null) {
                    return null;
                }
            }
            if (!isUnique) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode pointer = head.next;
        while (pointer.next != null) {
            isUnique = true;
            while (pointer.val == pointer.next.val) {
                isUnique = false;
                pointer = pointer.next;
                if (pointer.next == null) {
                    prev.next = null;
                    return head;
                }
            }
            if (isUnique == true) {
                prev.next = pointer;
                prev = prev.next;
            }
            pointer = pointer.next;
        }
        
        prev.next = pointer;
        pointer.next = null;
        
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
		for (int i = 2; i < 5; i++) {
			pointer.next = new ListNode(i);
			pointer = pointer.next;
		}
		ListNode result = deleteDuplicates(head);
	}
}
