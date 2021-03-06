import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode
 * 295. Find Median from Data Stream
 * @author lorreina
 *
 */
public class Find_Median_from_Data_Stream {
	public static class MedianFinder {
	    
	    private PriorityQueue<Integer> left;
	    private PriorityQueue<Integer> right;
	    
	    public MedianFinder() {
	        left = new PriorityQueue<Integer> (10, new Comparator<Integer> () {
	           public int compare(Integer a, Integer b) {
	               return -Integer.compare(a, b);
	           } 
	        });
	        right = new PriorityQueue<Integer> ();
	        
	    }
	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        if (left.size() == 0) {
	            left.add(num);
	        } else {
	            if (left.size() == right.size()) {
	                if (num <= right.peek()) {
	                    left.offer(num);
	                } else {
	                    left.offer(right.poll());
	                    right.offer(num);
	                }
	            } else {
	                if (num >= left.peek()) {
	                    right.offer(num);
	                } else {
	                    right.offer(left.poll());
	                    left.offer(num);
	                }
	            }
	        }
	        return;
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if (left.size() == right.size()) {
	            return left.peek() + ((double) (right.peek() - left.peek())) / 2;
	        } else {
	            return (double) left.peek();
	        }
	    }
	};

	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		System.out.println(mf.findMedian());
	}
}
