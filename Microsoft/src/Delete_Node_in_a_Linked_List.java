/**
 * LeetCode: 237. Delete Node in a Linked List
 * @author lorreina
 *
 */
public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
    
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
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
