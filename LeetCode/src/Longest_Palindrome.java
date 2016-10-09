/**
 * LeetCode
 * 409. Longest Palindrome
 * @author lorreina
 *
 */
public class Longest_Palindrome {
	public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dictLower = new int[26];
        int[] dictUpper = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                dictLower[c - 'a']++;
            } else {
                dictUpper[c - 'A']++;
            }
        }
        
        int countSingle = 0;
        for (int i = 0; i < 26; i++) {
            if (dictLower[i] % 2 == 1) {
                countSingle++;
            }
            if (dictUpper[i] % 2 == 1) {
                countSingle++;
            }
        }
        
        if (countSingle <= 1) {
            return s.length();
        } else {
            return s.length() - countSingle + 1;
        }
    }
}	
