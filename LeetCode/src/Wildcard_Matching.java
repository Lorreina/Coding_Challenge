/**
 * LeetCode
 * 44. Wildcard Matching
 * @author lorreina
 *
 */
public class Wildcard_Matching {
	public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) {
            return true;
        }
        
        if (p == null || p.length() == 0) {
            return false;
        }
        
        char[] parray = p.toCharArray();
        if (s == null || s.length() == 0) {
            for (int i = 0; i < p.length(); i++) {
                if (parray[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        
        char[] sarray = s.toCharArray();
        
        return helper(sarray, parray);
    }
    
    public boolean helper(char[] s, char[] p) {
        int i = 0; 
        int j = 0;
        while (i < s.length && j < p.length) {
            if (s[i] == p[j] || p[j] == '?') {
                i++;
                j++;
            } else if (p[j] == '*') {
                break;
            } else {
                return false;
            }
        }
        
        if (j == p.length) {
            if (i == s.length) {
                return true;
            } else {
                return false;
            }
        } else if (p[j] != '*') {
            return false; 
        } else if (i == s.length) {
            for (int k = j; k < p.length; k++) {
                if (p[k] != '*') {
                    return false;
                }
            }
            return true;
        }
        
        int m = s.length - 1;
        int n = p.length - 1;
        while (m >= i && n >= j) {
            if (s[m] == p[n] || p[n] == '?') {
                m--;
                n--;
            } else if (p[n] == '*') {
                break;
            } else {
                return false;
            }
        }
        
        String[] str = String.valueOf(p).substring(j, n + 1).split("\\*");
        int count = 0;
        while (i <= m && count < str.length && i + str[count].length() - 1 <= m) {
        	int k = 0;
        	for (k = 0; k < str[count].length(); k++) {
        		if (s[i + k] != str[count].charAt(k) && str[count].charAt(k) != '?') {
        			break;
        		}
        	}
        	if (k == str[count].length()) {
        		count += 1;
        		i += k;
        	} else {
        		i++;
        	}
        }
        
        if (count == str.length) {
        	return true;
        } else {
        	return false;
        }
    }
    
    public static void main(String[] args) {
//    	String p = "aasdf.*asdf.*asdf.*asdf.*s";
//    	String s = "aasdfasdfasdfasdfas";
    	String p = "*?*";
    	String s = "c";
    	
    	Wildcard_Matching tmp = new Wildcard_Matching();
    	System.out.println(tmp.isMatch(s, p));
    }
}
