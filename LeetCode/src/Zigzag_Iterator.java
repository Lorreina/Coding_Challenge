import java.util.List;
/**
 * LeetCode
 * 281. Zigzag Iterator
 * @author lorreina
 *
 */
public class Zigzag_Iterator {
	public class ZigzagIterator {
	    List<Integer> v1;
	    List<Integer> v2;
	    int count;
	    
	    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	        this.v1 = v1;
	        this.v2 = v2;
	        count = 0;
	    }

	    public int next() {
	        int index = this.count / 2;
	        this.count++;
	        if (v1 == null) {
	            return v2.get(count - 1);
	        } 
	    
	        if (v2 == null) {
	            return v1.get(count - 1);
	        }
	        
	        if (v1.size() < v2.size()) {
	            if (index >= v1.size()) {
	                return v2.get(count - v1.size() - 1);
	            }
	        } else if (v1.size() > v2.size()) {
	            if (index >= v2.size()) {
	                return v1.get(count - v2.size() - 1);
	            }
	        }
	        
	        if (this.count % 2 == 1) {
	            return v1.get(index);
	        } else {
	            return v2.get(index);
	        }
	        
	    }

	    public boolean hasNext() {
	        if (v1 == null && v2 == null) {
	            return false;
	        }
	        
	        if (v1 == null) {
	            if (count == v2.size()) {
	                return false;
	            } else {
	                return true;
	            }
	        } 
	        
	        if (v2 == null) {
	            if (count == v1.size()) {
	                return false;
	            } else {
	                return true;
	            }
	        }
	        if (count == v1.size() + v2.size()) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	}

	/**
	 * Your ZigzagIterator object will be instantiated and called as such:
	 * ZigzagIterator i = new ZigzagIterator(v1, v2);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}