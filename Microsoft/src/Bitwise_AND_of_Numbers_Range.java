
public class Bitwise_AND_of_Numbers_Range {
	public int rangeBitwiseAnd(int m, int n) {
        int tmp = m & n;
        
        if (tmp == 0) {
            return tmp;
        }
        
        if (m == n) {
            return m;
        }
        int i;
        for (i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if ((mask & m) != (mask & n)) {
                break;
            }
        }
        tmp = (m & n) & (0xFFFFFFFF << i);
        
        return tmp;
    }
}
