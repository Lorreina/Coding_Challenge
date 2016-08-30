/**
 * LeetCode
 * 369. Plus One Linked List
 * @author lorreina
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Plus_One_Linked_List {
	public ListNode plusOne(ListNode head) {
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode nine = null;
        
        // 只有从最后一位开始连续的999序列需要向前进1. xx99xxx这种情况需要。只有xx99xx99这种才需要。
        while(curr.next != null) {
            if(curr.next.val == 9) {
                if (nine == null) {
                    nine = curr;
                }
            } else {
                nine = null;
            }
            curr = curr.next;
        }
        
        if (nine == null) { // 没有出现进位
            curr.val = curr.val + 1;
        } else if(nine.next == head) { // 从head开始都是9，整个序列是999……999。
            nine.val = 1;
            while (head != null) {
                head.val = 0;
                head = head.next;
            }
            head = nine;
        } else { // 从中间某处出现999序列，xxx……xx9999.
            nine.val = nine.val + 1;
            nine = nine.next;
            while (nine != null) {
                nine.val = 0;
                nine = nine.next;
            }
        }
        
        return head;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
