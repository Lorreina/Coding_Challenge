/**
 * LeetCode
 * 392. Is Subsequence
 * @author lorreina
 *
 */
public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        
        int sindex = 0;
        int tindex = 0;
        
        while (sindex < s.length() && tindex < t.length()) {
            if (s.charAt(sindex) == t.charAt(tindex)) {
                sindex++;
                tindex++;
            } else {
                tindex++;
            }
        }
        
        if (sindex == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
