/**
 * LeetCode
 * 342. Power of Four 
 * @company: Two Sigma
 * @author lorreina
 *
 */
public class Power_of_Four {
	public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        int i;
        int mask = 1;
        for (i = 0; i < 31; i = i + 2) {
            if ((num & mask) != 0) {
                break;
            }
            mask = mask << 2;
        }
        
        return num == mask;
    }
}
