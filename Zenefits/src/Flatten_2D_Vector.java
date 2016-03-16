import java.util.List;

/**
 * LeetCode
 * 251. Flatten 2D Vector
 * @author lorreina
 *
 */

public class Flatten_2D_Vector {
	public class Vector2D {
	    List<List<Integer>> vector;
	    int x, y;
	    public Vector2D(List<List<Integer>> vec2d) {
	        this.vector = vec2d;
	        x = 0;
	        y = 0;
	    }

	    public int next() {
	        int result = vector.get(x).get(y);
	        y++;
	        return result;
	    }

	    public boolean hasNext() {
	        if (vector == null) {
	            return false;
	        }
	        while (x < vector.size()) {
	            if (vector.get(x) == null || y >= vector.get(x).size()) {
	                x++;
	                y = 0;
	            } else {
	                return true;
	            }
	        }
	        return false;
	    }
	}

	/**
	 * Your Vector2D object will be instantiated and called as such:
	 * Vector2D i = new Vector2D(vec2d);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}
