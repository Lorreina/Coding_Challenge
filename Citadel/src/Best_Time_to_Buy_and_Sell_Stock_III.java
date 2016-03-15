
public class Best_Time_to_Buy_and_Sell_Stock_III {
	public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
			return 0;
		}
		
		int[] profitForward = new int[prices.length];
		int[] profitBackward = new int[prices.length];
		int n = prices.length;
		
        int lowPrice = prices[0];
        
        // calculate forward profit.      
        for (int i = 1; i < n; i++) {
        	if (prices[i] > prices[i - 1]) {
        		profitForward[i] = Math.max(profitForward[i - 1], prices[i] - lowPrice);
        	} else if (prices[i] >= lowPrice) {
        		profitForward[i] = profitForward[i - 1];
        	} else {
        		lowPrice = prices[i];
        		profitForward[i] = profitForward[i - 1];
        	}
        }
        
        if (prices.length == 2) {
        	return profitForward[1];
        }
        // calculate backward profit
        profitBackward[0] = 0;
        profitBackward[1] = 0;
        int highPrice = prices[prices.length - 1];
        
        for (int i = 2; i < n; i++) {
        	if (prices[n - i] < prices[n - i + 1]) {
        		profitBackward[i] = Math.max(profitBackward[i - 1], highPrice - prices[n - i]);
        	} else if (prices[n - i] <= highPrice) {
        		profitBackward[i] = profitBackward[i - 1];
        	} else {
        		profitBackward[i] = profitBackward[i - 1];
        		highPrice = prices[n - i];
        	}
        }
        
        // find the maximum profit
        int profit = 0;
        for (int i = 0; i < n; i++) {
        	profit = Math.max(profit, profitForward[i] + profitBackward[n - i - 1]);
        }
        
		return profit;
    }
	
	public static void main(String[] args) {
		int[] prices = {2, 4, 1};
		System.out.println(maxProfit(prices));
	}
}
