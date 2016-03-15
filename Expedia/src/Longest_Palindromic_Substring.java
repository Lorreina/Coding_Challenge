/**
 * LeetCode
 * Longest Palindromic Substring
 * @author lorreina
 *
 */
public class Longest_Palindromic_Substring {
	int start = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        
        char[] tmp = s.toCharArray();
        
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome(tmp, i, i);
            isPalindrome(tmp, i, i + 1);
        }
        return s.substring(start, start + maxLength);
    }
    
    private void isPalindrome(char[] tmp, int left, int right) {
        while (left >= 0 && right < tmp.length && tmp[left] == tmp[right]) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLength) {
            start = left + 1;
            maxLength = right - left - 1;
        } 
    }
}
