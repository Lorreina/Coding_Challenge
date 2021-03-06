import java.util.HashSet;

/**
 * LeetCode
 * 356. Line Reflection
 * @author lorreina
 *
 */
public class Line_Reflection {
	public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<String> ();
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        
        for (int i = 0; i < points.length; i++) {
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            
            String point = points[i][0] + "+" + points[i][1];
            set.add(point);
        }
        
        int axis = max + min;
        
        for (int i = 0; i < points.length; i++) {
            String point = (axis - points[i][0]) + "+" + points[i][1];
            if (!set.contains(point)) {
                return false;
            }
        }
        
        return true;
    }
}
