
public class Valid_Palindrome {
	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j) {
            	if (isAlpha(s.charAt(i))) {
            		break;
            	}
            	i++;
            }
            while (j > i) {
            	if (isAlpha(s.charAt(j))) {
            		break;
            	}
            	j--;
            }
            if (i < j) {
            	if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
            		i++;
            		j--;
            	} else {
            		return false;
            	}
            }
        }
        return true;
    }
    
    private boolean isAlpha(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

}
