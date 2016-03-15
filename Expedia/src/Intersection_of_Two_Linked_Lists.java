
public class Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA= 0, lenB = 0, diff;
        ListNode pointerA = headA, pointerB = headB, pointer, tmp;
        
        while (pointerA != null) {
            lenA++;
            pointerA = pointerA.next;
        }
        
        while (pointerB != null) {
            lenB++;
            pointerB = pointerB.next;
        }
        
        diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            pointer = headA;
            tmp = headB;
        } else {
            pointer = headB;
            tmp = headA;
        }
        
        while (diff > 0) {
            pointer = pointer.next;
            diff--;
        }
        
        while (pointer != null) {
            if (pointer == tmp) {
                return pointer;
            }
            pointer = pointer.next;
            tmp = tmp.next;
        }
        
        return null;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
