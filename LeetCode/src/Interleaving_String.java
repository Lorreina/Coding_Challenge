/**
 * LeetCode
 * 97. Interleaving String
 * @author lorreina
 *
 */
public class Interleaving_String {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s1 == null && s3 == null) {
            return true;
        }
        
        int len1 = 0, len2 = 0, len3 = 0;
        if (s1 != null) {
            len1 = s1.length();
        }
        if (s2 != null) {
            len2 = s2.length();
        }
        if (s3 != null) {
            len3 = s3.length();
        }
        
        if (len3 != len1 + len2) {
            return false;
        }
        
        if (len3 == 0) {
            return true;
        } else if (len3 == len1) {
            return s1.equals(s3);
        } else if (len3 == len2) {
            return s2.equals(s3);
        }
        
        int i = 0, j = 0, k = 0;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        boolean[][] invalid = new boolean[ch1.length + 1][ch2.length + 1];
        
        return helper(ch1, ch2, ch3, i, j, k, invalid);
    }
    
    private boolean helper(char[] ch1, char[] ch2, char[] ch3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j] == true) {
            return false;
        }
        
        if (i == ch1.length && j == ch2.length) {
            return true;
        }
        
        if (i < ch1.length) {
            if (ch1[i] == ch3[k]) {
                if (helper(ch1, ch2, ch3, i + 1, j, k + 1, invalid) == true) {
                    return true;
                } else {
                    invalid[i + 1][j] = true;
                }
            } 
        }
        if (j < ch2.length) {
            if (ch2[j] == ch3[k]) {
                if (helper(ch1, ch2, ch3, i, j + 1, k + 1, invalid) == true) {
                    return true;
                } else {
                    invalid[i][j + 1] = true;
                }
            }
        }
        
        invalid[i][j] = true;
        return false;
    }
}
