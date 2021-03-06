/**
 * LeetCode
 * 161. One Edit Distance
 * @company: Facebook, Uber
 * @author lorreina
 *
 */
public class One_Edit_Distance {
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int change = 0;
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (change == 1) {
                        return false;
                    }
                    change = 1;
                }
            }
            if (change == 0) {
                return false;
            }
        } else if (s.length() - t.length() == 1) {
            int i = 0;
            while (i < t.length()) {
                if (s.charAt(i + change) != t.charAt(i)) {
                    if (change == 1) {
                        return false;
                    }
                    change = 1;
                } else {
                   i++; 
                }
            }
        } else {
            int i = 0;
            while (i < s.length()) {
                if (t.charAt(i + change) != s.charAt(i)) {
                    if (change == 1) {
                        return false;
                    }
                    change = 1;
                } else {
                   i++; 
                }
            }
        }
        return true;
    }
}
