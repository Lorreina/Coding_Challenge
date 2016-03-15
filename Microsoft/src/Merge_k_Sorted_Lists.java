import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * LeetCode Problem
 * 23. Merge k Sorted Lists
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
public class Merge_k_Sorted_Lists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        Comparator<ListNode> cmp = new Comparator<ListNode>() { 
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode> (cmp);
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        
        while (queue.size() > 1) {
            pointer.next = queue.peek();
            pointer = pointer.next;
            updateQueue(queue);
        }
        if (queue.size() == 1) {
            pointer.next = queue.poll();
        }
        
        return dummy.next;
    }
    
    private void updateQueue(PriorityQueue<ListNode> queue) {
        ListNode tmp = queue.poll();
        if (tmp.next != null) {
            queue.add(tmp.next);
        }
    }
}
