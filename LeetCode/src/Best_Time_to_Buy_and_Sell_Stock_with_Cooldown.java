/**
 * LeetCode
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * @author lorreina
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        // buy[i] = Math.max(sell[i - 2] - price[i], buy[i - 1])
        // sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1])
        int buy = 0, preBuy = -prices[0];
        int sell = 0, preSell = 0, pre2Sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(pre2Sell - prices[i], preBuy);
            sell = Math.max(preBuy + prices[i], preSell);
            
            preBuy = buy;
            pre2Sell = preSell;
            preSell = sell;
        }
        
        return Math.max(buy, sell);
    }
}
