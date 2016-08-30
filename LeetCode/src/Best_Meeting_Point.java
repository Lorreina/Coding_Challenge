import java.util.ArrayList;
import java.util.Collections;

/**
 * LeetCode
 * 296. Best Meeting Point
 * @author lorreina
 *
 */
public class Best_Meeting_Point {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> x = new ArrayList<Integer> ();
        ArrayList<Integer> y = new ArrayList<Integer> ();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        Collections.sort(x);
        Collections.sort(y);
        
        int xaxis = x.get(x.size() / 2);
        int yaxis = y.get(y.size() / 2);
        
        int sum = 0;
        for (int i = 0; i < x.size(); i++) {
            sum += Math.abs(xaxis - x.get(i)) + Math.abs(yaxis - y.get(i));
        }
        
        return sum;
    }
}
