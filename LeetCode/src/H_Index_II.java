/**
 * LeetCode
 * 275. H-Index II
 * @author lorreina
 *
 */
public class H_Index_II {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= citations.length) {
                if (sum >= citations[i]) {
                    return sum;
                }
            }
            sum += 1;
        }
        
        return citations.length;
    }
}
