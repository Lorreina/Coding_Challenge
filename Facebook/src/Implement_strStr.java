/**
 * LeetCode
 * 28. Implement strStr()
 * @company: Facebook
 * @author lorreina
 *
 */

// Implement strStr().
// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Implement_strStr {
	public int strStr(String haystack, String needle) {
        /**
         * Use the built-in method of Java.
         */
        // return haystack.indexOf(needle);
        
        /**
         * Use my implementation.
         */
        int nLen = needle.length();
        int n = haystack.length() - nLen + 1;
        
        for (int i = 0; i < n; i++) {
            if (needle.equals(haystack.substring(i, i + nLen))) {
                return i;
            }
        }
        return -1;
    }
}
