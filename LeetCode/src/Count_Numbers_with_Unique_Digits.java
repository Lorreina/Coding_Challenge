/**
 * LeetCode
 * 357. Count Numbers with Unique Digits
 * @author lorreina
 *
 */
public class Count_Numbers_with_Unique_Digits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            n = 10;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += helper(i);
        }
        return count;
    }
    
    private int helper(int n) {
        int res = 9;
        if (n == 1) {
            return 10;
        }
        
        for (int i = 1; i < n; i++) {
            res = res * (10 - i);
        }
        
        return res;
    }
}
