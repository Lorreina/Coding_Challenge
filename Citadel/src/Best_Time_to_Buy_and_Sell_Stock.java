
public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
        int highPrice = prices[0];
        int lowPrice = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
        	if (lowPrice > prices[i]) {
        		profit = Math.max(profit, highPrice - lowPrice);
        		lowPrice = prices[i];
        		highPrice = prices[i];
        	} else if (highPrice < prices[i]) {
        		highPrice = prices[i];
        	}
        }
		
        
        return Math.max(profit, highPrice - lowPrice);
		
    }
}
