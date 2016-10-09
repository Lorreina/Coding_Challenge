import java.util.HashMap;

/**
 * LeetCode
 * 146. LRU Cache
 * @author lorreina
 *
 */
public class LRU_Cache {
	public class LRUCache {
	    HashMap<Integer, ListNode> map;
	    ListNode dummy;
	    ListNode end;
	    int capacity;
	    
	    
	    public LRUCache(int capacity) {
	        this.map = new HashMap<Integer, ListNode> ();
	        this.dummy = new ListNode(0, 0);
	        this.end = dummy;
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        if (map.containsKey(key)) {
	            ListNode prev = map.get(key);
	            if (prev.next != end) {
	                ListNode curr = prev.next;
	                map.put(curr.next.key, prev);
	                prev.next = curr.next;
	                curr.next = null;
	                end.next = curr;
	                map.put(key, end);
	                end = end.next;
	            }
	            return map.get(key).next.value;
	        } else {
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	        if (capacity <= 0) {
	            return;
	        }
	        
	        if (map.containsKey(key)) {
	            ListNode prev = map.get(key);
	            if (prev.next == end) {
	                prev.next.value = value;
	            } else {
	                ListNode curr = prev.next;
	                map.put(curr.next.key, prev);
	                prev.next = curr.next;
	                curr.next = null;
	                curr.value = value;
	                end.next = curr;
	                map.put(key, end);
	                end = end.next;
	            }
	        } else {
	        	if (map.size() < capacity) {
		            end.next = new ListNode(key, value);
		            map.put(key, end);
		            end = end.next;
		            return;
		        }
		        
		        if (dummy.next == end) {
		            map.remove(end.key);
		            map.put(key, dummy);
		            end.key = key;
		            end.value = value;
		        } else {
	                ListNode curr = dummy.next;
	                dummy.next = dummy.next.next;
	                map.put(dummy.next.key, dummy);
	                map.remove(curr.key);
	                curr.key = key;
	                curr.value = value;
	                curr.next = null;
	                end.next = curr;
	                map.put(key, end);
	                end = end.next;
		        }
	            
	        }
	    }
	    
	    public class ListNode {
	        public int value;
	        public int key;
	        public ListNode next;
	        
	        public ListNode(int key, int val) {
	            this.value = val;
	            this.key = key;
	            this.next = null;
	        }
	    }
	}
}
