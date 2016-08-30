/**
 * LeetCode
 * 371. Sum of Two Integers
 * @author lorreina
 *
 */
public class Sum_of_Two_Integers {
	public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        
        int plus = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int offset = (1 << i);
            int abit = (a & offset);
            int bbit = (b & offset);
            if ((abit & bbit) != 0) {
                if (plus == 1) {
                    res = res ^ offset;
                }
                plus = 1; 
            } else if ((abit ^ bbit) != 0) {
                if (plus != 1) {
                    res = res ^ offset;
                }
            } else {
                if (plus == 1) {
                    res = res ^ offset;
                    plus = 0;
                }
            }
        }
        
        return res;
    }
}
