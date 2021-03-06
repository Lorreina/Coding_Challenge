/**
 * LeetCode
 * 188. Best Time to Buy and Sell Stock IV
 * @author lorreina
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV {
	public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        if (k >= n / 2) {
            return helper(prices);
        }
        
        // profit(i,j) is the max profit for up to i transactions by time j (0<=i<=k, 0<=j<n).
        int[][] profit = new int[k + 1][n];
        
        for (int i = 1; i < k + 1; i++) {
        	// tmpMax means the maximum profit of just doing at most i-1 transactions, 
        	// using at most first j-1 prices, and buying the stock at price[j] 
        	// this is used for the next loop.
            int tmpMax = -prices[0];
            for (int j = 1; j < n; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], tmpMax + prices[j]);
                tmpMax = Math.max(tmpMax, profit[i - 1][j - 1] - prices[j]);
            }
        }
        
        return profit[k][n - 1];
        
    }
    
    private int helper (int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        
        return sum;
    }
}
