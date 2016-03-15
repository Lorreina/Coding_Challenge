/**
 * LeetCode
 * 65. Valid Number
 * @author lorreina
 *
 */
public class Valid_Number {
	public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        
        int start = 0;
        
        for (start = 0; start < s.length(); start++) {
            char tmp = s.charAt(start);
            if (tmp != ' ') {
                break;
            }
        }
        
        if (start == s.length()) {
            return false;
        }
        boolean hasDot = false;
        boolean hasE = false;
        boolean digitLeft = false;
        boolean digitRight = false;
        boolean hasDigit = false;
        
        if (s.charAt(start) == '-' || s.charAt(start) == '+') {
            start++;
        }
        
        if (s.charAt(start) >= '0' && s.charAt(start) <= '9') {
            digitLeft = true;
        }
        
        int end = s.length();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigit = true;
                if (hasE) {
                    digitRight = true;
                }
                digitLeft = true;
                continue;
            }
            if (c == 'e') {
                if (hasE || !digitLeft) {
                    return false;
                }
                hasE = true;
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                end = i;
                break;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        for (int i = end; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                return false;
            }
        }
        
        if (hasDigit == false) {
            return false;
        }
        
        if (hasE) {
            if (digitRight == false) {
                return false;
            }
        }
        
        return true;
    }
}
