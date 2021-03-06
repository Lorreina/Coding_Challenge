import java.util.HashMap;

public class LRU_Cache {
	public static class LRUCache {
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
	                if (curr == null) {
	                	System.out.println("break");
	                }
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
	
	public static void main(String[] args) {
		LRUCache tmp = new LRUCache(2);
		tmp.set(2, 22);
		tmp.set(1, 11);
		System.out.println(tmp.get(2));
		tmp.set(4, 44);
		System.out.println(tmp.get(1));
		System.out.println(tmp.get(2));
		/*
		tmp.set(10,13);
		tmp.set(3,17);
		tmp.set(6,11);
		tmp.set(10,5);
		tmp.set(9,10);
		tmp.get(13);
		tmp.set(2,19);
		tmp.get(2);
		tmp.get(3);
		tmp.set(5,25);
		tmp.get(8);
		tmp.set(9,22);
		tmp.set(5,5);
		tmp.set(1,30);
		tmp.get(11);
		tmp.set(9,12);
		tmp.get(7);
		tmp.get(5);
		tmp.get(8);
		tmp.get(9);
		tmp.set(4,30);
		tmp.set(9,3);
		tmp.get(9);
		tmp.get(10);
		tmp.get(10);
		tmp.set(6,14);
		tmp.set(3,1);
		tmp.get(3);
		tmp.set(10,11);
		tmp.get(8);
		tmp.set(2,14);
		tmp.get(1);
		tmp.get(5);
		tmp.get(4);
		tmp.set(11,4);
		tmp.set(12,24);
		tmp.set(5,18);
		tmp.get(13);
		tmp.set(7,23);
		tmp.get(8);
		tmp.get(12);
		tmp.set(3,27);
		tmp.set(2,12);
		tmp.get(5);
		tmp.set(2,9);
		tmp.set(13,4);
		tmp.set(8,18);
		tmp.set(1,7);
		tmp.get(6);
		tmp.set(9,29);
		tmp.set(8,21);
		tmp.get(5);
		tmp.set(6,30);
		tmp.set(1,12);
		tmp.get(10);
		tmp.set(4,15);
		tmp.set(7,22);
		tmp.set(11,26);
		tmp.set(8,17);
		tmp.set(9,29);
		tmp.get(5);
		tmp.set(3,4);
		tmp.set(11,30);
		tmp.get(12);
		tmp.set(4,29);
		tmp.get(3);
		tmp.get(9);
		tmp.get(6);
		tmp.set(3,4);
		tmp.get(1);
		tmp.get(10);
		tmp.set(3,29);
		tmp.set(10,28);
		tmp.set(1,20);
		tmp.set(11,13);
		tmp.get(3);
		tmp.set(3,12);
		tmp.set(3,8);
		tmp.set(10,9);
		tmp.set(3,26);
		tmp.get(8);
		tmp.get(7);
		tmp.get(5);
		tmp.set(13,17);
		tmp.set(2,27);
		tmp.set(11,15);
		tmp.get(12);
		tmp.set(9,19);
		tmp.set(2,15);
		tmp.set(3,16);
		tmp.get(1);
		tmp.set(12,17);
		tmp.set(9,1);
		tmp.set(6,19);
		tmp.get(4);
		tmp.get(5);
		tmp.get(5);
		tmp.set(8,1);
		tmp.set(11,7);
		tmp.set(5,2);
		tmp.set(9,28);
		tmp.get(1);
		tmp.set(2,2);
		tmp.set(7,4);
		tmp.set(4,22);
		tmp.set(7,24);
		tmp.set(9,26);
		tmp.set(13,28);
		tmp.set(11,26);
		*/
	}
}
