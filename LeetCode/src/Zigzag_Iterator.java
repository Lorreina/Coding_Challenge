import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * LeetCode
 * 281. Zigzag Iterator
 * @author lorreina
 *
 */
public class Zigzag_Iterator {
//	public class ZigzagIterator {
//	    List<Integer> v1;
//	    List<Integer> v2;
//	    int count;
//	    
//	    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//	        this.v1 = v1;
//	        this.v2 = v2;
//	        count = 0;
//	    }
//
//	    public int next() {
//	        int index = this.count / 2;
//	        this.count++;
//	        if (v1 == null) {
//	            return v2.get(count - 1);
//	        } 
//	    
//	        if (v2 == null) {
//	            return v1.get(count - 1);
//	        }
//	        
//	        if (v1.size() < v2.size()) {
//	            if (index >= v1.size()) {
//	                return v2.get(count - v1.size() - 1);
//	            }
//	        } else if (v1.size() > v2.size()) {
//	            if (index >= v2.size()) {
//	                return v1.get(count - v2.size() - 1);
//	            }
//	        }
//	        
//	        if (this.count % 2 == 1) {
//	            return v1.get(index);
//	        } else {
//	            return v2.get(index);
//	        }
//	        
//	    }
//
//	    public boolean hasNext() {
//	        if (v1 == null && v2 == null) {
//	            return false;
//	        }
//	        
//	        if (v1 == null) {
//	            if (count == v2.size()) {
//	                return false;
//	            } else {
//	                return true;
//	            }
//	        } 
//	        
//	        if (v2 == null) {
//	            if (count == v1.size()) {
//	                return false;
//	            } else {
//	                return true;
//	            }
//	        }
//	        if (count == v1.size() + v2.size()) {
//	            return false;
//	        } else {
//	            return true;
//	        }
//	    }
//	}
	public static class ZigzagIterator {
		Queue<List<Integer>> queue;
		Queue<Integer> pointer;
    
	    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	        this.queue = new ArrayDeque<List<Integer>> ();
	        this.pointer = new ArrayDeque<Integer> ();
	        if (v1.size() > 0) {
	            queue.offer(v1);
	            pointer.offer(0);
	        }
	        if (v2.size() > 0) {
	        	queue.offer(v2);
	            pointer.offer(0);
	        }
	    }
	
	    public int next() {
	        List<Integer> list = queue.poll();
	        int index = pointer.poll();
	        int res = list.get(index);
	        
	        if (index < list.size() - 1) {
	            queue.offer(list);
	            pointer.offer(index + 1);
	        }
	        
	        return res;
	    }
	
	    public boolean hasNext() {
	        if (queue == null) {
	            return false;
	        }
	        
	        return !queue.isEmpty();
	    }
    }
    
    
    public static void main(String[] args) {
    	List<Integer> v1 = new ArrayList<Integer> ();
    	List<Integer> v2 = new ArrayList<Integer> ();
    	v1.add(1);
    	v1.add(2);
    	v2.add(3);
    	v2.add(4);
    	v2.add(5);
    	v2.add(6);
    	ZigzagIterator i = new ZigzagIterator(v1, v2);
    	while (i.hasNext()) {
    		System.out.println(i.next());
    	}
    }
    

	/**
	 * Your ZigzagIterator object will be instantiated and called as such:
	 * ZigzagIterator i = new ZigzagIterator(v1, v2);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}
