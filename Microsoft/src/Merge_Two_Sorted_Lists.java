/*
 * LeetCode Problem
 * 21. Merge Two Sorted Lists
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
public class Merge_Two_Sorted_Lists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }   
        
        ListNode dummy;
        
        if (l1.val < l2.val) {
            dummy = l1;
            l1 = l1.next;
        } else {
            dummy = l2;
            l2 = l2.next;
        }
        
        ListNode pointer = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next= l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 != null) {
            pointer.next = l1;
        } else {
            pointer.next = l2;
        }
        
        return dummy;
    }
}
