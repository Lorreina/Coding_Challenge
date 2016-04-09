/**
 * LeetCode
 * 43. Multiply Strings
 * @company: Facebook
 * @author lorreina
 *
 */
public class Multiply_Strings {
	public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        
        int[] pos = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }
        
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (; i < m + n; i++) {
            if (pos[i] != 0) {
                break;
            }
        }
        
        for (; i < m + n; i++) {
            res.append(pos[i]);
        }
        
        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }
}
