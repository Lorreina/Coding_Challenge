import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * @author lorreina
 *
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	public int kthSmallest(int[][] matrix, int k) {
		// Use PriorityQueue to make sure that the first element is the smallest.
		// Keep order.
		// The order of the rest queue doesn't matter.
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple> ();
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new Tuple(i, 0, matrix[i][0]));
        }
        
        Tuple curr = null;
        for (int i = 0; i < k; i++) {
            curr = queue.poll();
            if (curr.y == (matrix[0].length - 1)) {
                continue;
            }
            queue.add(new Tuple(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
        }
        
        return curr.val;
    }
    
    public class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.val = value;
        }
        
        public int compareTo(Tuple t) {
            return Integer.valueOf(this.val).compareTo(Integer.valueOf(t.val));
        }
    }
}
