/**
 * LeetCode
 * 227. Basic Calculator II
 * @author lorreina
 *
 */
public class Basic_Calculator_II {
	public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean divide = false;
        int result = 0;
        int sign = 1, preNum = 0, num = 0;
        
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (divide) {
                    num = preNum / num;
                    divide = false;
                }
                if (c == '/') {
                    divide = true;
                    preNum = num * sign;
                    sign = 1;
                } else if (c == '*') {
                    sign = sign * num;
                } else {
                    result = result + sign * num;
                    if (c == '+') {
                        sign = 1;
                    } else if (c == '-') {
                        sign = -1;
                    }
                }
                num = 0;
            }
        }
        if (num > 0) {
            if (divide) {
                num = preNum / num;
            }
            result = result + sign * num;
        }
        return result;
    }
}	
