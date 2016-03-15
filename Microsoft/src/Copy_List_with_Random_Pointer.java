/**
 * LeetCode 138. Copy List with Random Pointer
 * @author lorreina
 *
 */
public class Copy_List_with_Random_Pointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = new RandomListNode(head.label);
            head.next.random = head.random;
            head.next.next = tmp;
            head = tmp;
        }
        
        head = dummy.next.next;
        while (true) {
            if (head.random != null) {
                head.random = head.random.next; 
            }
            if (head.next == null) {
                break;
            } else {
                head = head.next.next;
            }
        }
        
        head = dummy.next;
        RandomListNode copy = dummy.next.next;
        RandomListNode prev = head; 
        RandomListNode pointer = head.next;
        while (pointer.next != null) {
            prev.next = pointer.next;
            prev = prev.next;
            pointer.next = prev.next;
            pointer = pointer.next;
        }
        pointer.next = null;
        prev.next = null;
        
        return copy;
        
    }
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
