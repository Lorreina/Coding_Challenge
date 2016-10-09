/**
 * LeetCode
 * 66. Plus One	
 * @author lorreina
 *
 */
public class Plus_One {
	public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                break;
            }
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            
            return res;
        }
        
    }
}
