import java.util.Random;

/**
 * LeetCode
 * 
 * @author lorreina
 *
 */
public class Linked_List_Random_Node {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    ListNode head;
	    int length;
	    /** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	    public Solution(ListNode head) {
	        this.head = head;
	        this.length = 0;
	        while (head != null) {
	            this.length++;
	            head = head.next;
	        }
	    }
	    
	    /** Returns a random node's value. */
	    public int getRandom() {
	        Random rand = new Random();
	        ListNode curr = this.head;
	        // ListNode pointer = curr.next();
	        
	        int step = rand.nextInt(this.length);
	        for (int i = 0; i < step; i++) {
	            curr = curr.next;
	        }
	        
	        return curr.val;
	    }
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(head);
	 * int param_1 = obj.getRandom();
	 */
}
