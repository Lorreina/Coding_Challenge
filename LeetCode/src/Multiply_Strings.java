/**
 * LeetCode
 * 43. Multiply Strings
 * @author lorreina
 *
 */
public class Multiply_Strings {
	public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        
        int[] pos = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = pos[i + j + 1] + mul;
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        int start = 0;
        
        for (; start < pos.length; start++) {
            if (pos[start] != 0) {
                break;
            }
        }
        
        if (start == pos.length) {
            return "0";
        }
        
        for (int i = start; i < pos.length; i++) {
            res.append(pos[i]);
        }
        
        return res.toString();
    }
	
	public static void main(String[] args) {
		Multiply_Strings tmp = new Multiply_Strings();
		String num1 = "123";
		String num2 = "456";
		System.out.println(tmp.multiply(num1, num2));
	}
}
