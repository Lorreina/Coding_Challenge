/**
 * LeetCode
 * 246. Strobogrammatic Number
 * @author lorreina
 *
 */
public class Strobogrammatic_Number {
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        
        while (i < j) {
            char left = num.charAt(i);
            char right = num.charAt(j);
            i++;
            j--;
            if (left == right) {
                if (left == '1' || left == '8' || right == '0') {
                    continue;
                } else {
                    return false;
                }
            } else if (left == '6' && right == '9') {
                continue;
            } else if (left == '9' && right == '6') {
                continue;
            } else {
                return false;
            }
        }
        
        if (i == j) {
            char mid = num.charAt(i);
            if (mid != '8' && mid != '1' && mid != '0') {
                return false;
            }
        }
        
        return true;
    }
}
