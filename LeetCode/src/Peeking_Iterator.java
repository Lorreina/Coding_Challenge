import java.util.Iterator;

/**
 * LeetCode
 * 284. Peeking Iterator
 * @author lorreina
 *
 */
public class Peeking_Iterator {
	// Java Iterator interface reference:
	// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	class PeekingIterator implements Iterator<Integer> {
	    private Iterator<Integer> iterator;
	    // private int currNum;
	    private int nextNum;
	    private boolean end;
	    
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		    this.iterator = iterator;
		   // if (this.iterator.hasNext()) {
		   //     currNum = this.iterator.next();
		   // } else {
		   //     end = 0;
		   // }
		    if (this.iterator.hasNext()) {
		        nextNum = this.iterator.next();
		    } else {
		        end = true;
		    }
		    
		    end = false;
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        return this.nextNum;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    int res = nextNum;
		    if (this.iterator.hasNext()) {
		        this.nextNum = this.iterator.next();
		    } else {
		        this.end = true;
		    }
		    
		    return res;
		}

		@Override
		public boolean hasNext() {
		    return !this.end;
		}
	}
}
