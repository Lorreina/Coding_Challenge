import java.util.ArrayList;

/**
 * LeetCode
 * 264. Ugly Number II
 * @author lorreina
 *
 */
public class Ugly_Number_II {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        ArrayList<Integer> uglyList = new ArrayList<Integer> ();
        uglyList.add(1);
        int bucket2 = 0;
        int bucket3 = 0;
        int bucket5 = 0;
        
        for (int i = 1; i < n; i++) {
            int ugly = Math.min(uglyList.get(bucket2) * 2, Math.min(uglyList.get(bucket3) * 3, uglyList.get(bucket5) * 5));
            uglyList.add(ugly);
            if (ugly == 2 * uglyList.get(bucket2)) {
                bucket2++;
            }
            if (ugly == 3 * uglyList.get(bucket3)) {
                bucket3++;
            }
            if (ugly == 5 * uglyList.get(bucket5)) {
                bucket5++;
            }
        }
        
        return uglyList.get(n - 1);
    }
}
