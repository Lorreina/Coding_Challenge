/**
 * LeetCode
 * @author lorreina
 *
 */
public class Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        
        int shortest = 0;
        int shortedLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortedLen) {
                shortedLen = strs[i].length();
                shortest = i;
            }
        }
        
        if (shortedLen == 0) {
            return "";
        }
        char[] prefix = strs[shortest].toCharArray();
        int len = prefix.length;
        
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < len; j++) {
                if (strs[i].charAt(j) != prefix[j]) {
                    len = j;
                    break;
                }
            }
            if (len == 0) {
                return "";
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(prefix[i]);
        }
        
        return res.toString();
    }
}
