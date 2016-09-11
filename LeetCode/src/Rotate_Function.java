/**
 * LeetCode
 * 396. Rotate Function
 * @author lorreina
 *
 */
public class Rotate_Function {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int last = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            last += i * A[i];
        }
        int maxValue = last;
        
        for (int i = 0; i < A.length - 1; i++) {
            int tmp = last - sum + A.length * A[i];
            maxValue = Math.max(maxValue, tmp);
            last = tmp;
        }
        
        return maxValue;
    }
}
