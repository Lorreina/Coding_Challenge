/**
 * LeetCode
 * 415. Add Strings
 * @author lorreina
 *
 */
public class Add_Strings {
	public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        
        // int end1 = num1.length();
        // for (int i = 0; i < num1.length(); i++) {
        //     if (num1.charAt(i) != '0') {
        //         end1 = i;
        //         break;
        //     }
        // }
        // int end2 = num2.length();
        // for (int i = 0; i < num2.length(); i++) {
        //     if (num2.charAt(i) != '0') {
        //         end2 = i;
        //         break;
        //     }
        // }
        
        // if (end1 == num1.length() && end2 == num2.length()) {
        //     return "0";
        // }
        int end1 = 0, end2 = 0;
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        char[] res = new char[Math.max(num1.length() - end1, num2.length() - end2)];
        
        while (i >= end1 && j >= end2) {
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            res[Math.max(i - end1, j - end2)] = (char) (sum % 10 + '0');
            carry = sum / 10;
            i--;
            j--;
        }
        
        while (i >= end1) {
            int sum = num1.charAt(i) - '0' + carry;
            res[i - end1] = (char) (sum % 10 + '0');
            carry = sum / 10;
            i--;
        }
        
        while (j >= end2) {
            int sum = num2.charAt(j) - '0' + carry;
            res[j - end2] = (char) (sum % 10 + '0');
            carry = sum / 10;
            j--;
        }
        
        StringBuilder sum = new StringBuilder();
        if (carry != 0) {
            sum.append(carry);
        }
        sum.append(res);
        
        return sum.toString();
    }
	
	public static void main(String[] args) {
		Add_Strings tmp = new Add_Strings();
		String num1 = "00123";
		String num2 = "000002";
		System.out.println(tmp.addStrings(num1, num2));
	}
}
