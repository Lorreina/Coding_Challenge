
public class Best_Time_to_Buy_and_Sell_Stock_II {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
        int profit = 0;
        int small = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] < prices[i - 1]) {
        		profit += prices[i - 1] - small;
        		small = prices[i];
        	}
        }
        
        return profit + Math.max(prices[prices.length - 1] - small, 0);
    }
}
