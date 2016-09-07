/**
 * LeetCode
 * 372. Super Pow
 * @author lorreina
 *
 */
public class Super_Pow {
    public int superPow(int a, int[] b) {
        if (a == 1) {
            return a;
        }
        
        long res = 1;
        int x = a % 1337;
        for (int i = 0; i < b[b.length - 1]; i++) {
            res = (res * x) % 1337;
        }
        long last = x;
        
        for (int i = b.length - 2; i >= 0; i--) {
            long tmp = last;
            for (int j = 0; j < 9; j++) {
                tmp = (tmp * last) % 1337;
            }
            last = tmp;
            
            if (b[i] > 0) {
                for (int j = 0; j < b[i] - 1; j++) {
                    tmp = (tmp * last) % 1337;
                }
                res = (res * tmp) % 1337;   
            }
        }
        
        return (int) res;
    }
}
