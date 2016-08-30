import java.util.List;

/**
 * LeetCode
 * 120. Triangle
 * @author lorreina
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int[] curr = new int[triangle.size()];
        int[] last = new int[triangle.size()];
        
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    curr[j] = last[j] + row.get(j);
                } else if (j == i) {
                    curr[j] = last[j - 1] + row.get(j);
                } else {
                    curr[j] = Math.min(last[j], last[j - 1]) + row.get(j);
                }
            }
            
            int[] tmp = last;
            last = curr;
            curr = tmp;
        }
        
        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            minTotal = Math.min(minTotal, last[i]);
        }
        
        return minTotal;
    }
}
