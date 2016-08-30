/**
 * LeetCode
 * 266. Palindrome Permutation
 * @author lorreina
 *
 */
public class Palindrome_Permutation {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[(int) c] += 1;
        }
        
        boolean isOdd = false;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 1) {
                if (isOdd == true) {
                    return false;
                }
                isOdd = true;
            }
        }
        
        if (isOdd == true && (s.length() % 2 == 0)) {
            return false;
        }
        
        return true;
    }
}
