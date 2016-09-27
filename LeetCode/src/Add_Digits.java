/**
 * LeetCode
 * 258. Add Digits
 * @author lorreina
 *
 */
public class Add_Digits {
	public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        
        int x = num % 9;
        if (x == 0) {
            return 9;
        } else {
            return x;
        }
    }
}
