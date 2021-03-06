import java.util.Arrays;

/**
 * LeetCode
 * 322. Coin Change
 * @author lorreina
 *
 */
public class Coin_Change {
	int total = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        Arrays.sort(coins);
        
        helper(coins, coins.length - 1, amount, 0);
        if (total == Integer.MAX_VALUE) {
            return -1;
        } else {
            return total;
        }
    }
    
    private void helper(int[] coins, int start, int amount, int count) {
        if (start < 0) {
            return;
        }
        int n = amount / coins[start];
        if (n + count >= total) {
            return;
        }
        
        for (int i = n; i >= 0; i--) {
            int newCount = count + i;
            int newAmount = amount - i * coins[start];
            
            if (newAmount > 0) {
                helper(coins, start - 1, newAmount, newCount);
            } else {
                if (newCount < total) {
                    total = newCount;
                    break;
                }
            }
        }
        
    }
}
