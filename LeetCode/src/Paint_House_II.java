/**
 * LeetCode
 * 265. Paint House II
 * @author lorreina
 *
 */
public class Paint_House_II {
	public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int[][] color = new int[n][k];
        
        
        int min = -1;
        int min2 = -1;
        for (int j = 0; j < k; j++) {
            color[0][j] = costs[0][j];
            if (min < 0 || color[0][j] < color[0][min]) {
                min2 = min;
                min = j;
            } else if (min2 < 0 || color[0][j] < color[0][min2]) {
                min2 = j;
            }
        }
        
        
        for (int i = 1; i < n; i++) {
            int nextMin = -1;
            int nextMin2 = -1;
            for (int j = 0; j < k; j++) {
                if (j == min) {
                    color[i][j] = color[i - 1][min2] + costs[i][j];
                } else {
                    color[i][j] = color[i - 1][min] + costs[i][j];
                }
                
                // record the min and min2 for this loop
                if (nextMin < 0 || color[i][j] < color[i][nextMin]) {
                    nextMin2 = nextMin;
                    nextMin = j;
                } else if (nextMin2 < 0 || color[i][j] < color[i][nextMin2]) {
                    nextMin2 = j;
                }
            }
            // update min and min2
            min = nextMin;
            min2 = nextMin2;
        }
        
        return color[n - 1][min];
    }
	
	public static void main(String[] args) {
		Paint_House_II tmp = new Paint_House_II();
		int[][] costs = {{15,17,15,20,7,16,6,10,4,20,7,3,4}, {11,3,9,13,7,12,6,7,5,1,7,18,9}};
		System.out.println(tmp.minCostII(costs));
	}
}
