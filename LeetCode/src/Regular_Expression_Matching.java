
/**
 * LeetCode
 * 10. Regular Expression Matching
 * @author lorreina
 *
 */
public class Regular_Expression_Matching {
	public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        
        if (p == null || s == null) {
            return false;
        }
        
        char[] parray = p.toCharArray();
        char[] sarray = s.toCharArray();
        
        return helper(sarray, parray, 0, 0);
    }
    
    public boolean helper(char[] s, char[] p, int i, int j) {
        int last = j;
        while (i < s.length && j < p.length) {
        	// update last
            last = j;
            if (j + 1 < p.length && p[j + 1] == '*') {
            	if (helper(s, p, i, j + 2) == true) {
                    return true;
                }
            	while (i < s.length && (p[last] == s[i] || p[last] == '.')) {
                	if (helper(s, p, i + 1, j + 2) == true) {
                	    return true;
                	}
                    i++;
                }
            	return false;
            } else if (s[i] == p[j] || p[j] == '.') {
                i++;
                j++;
            } else {
            	return false;
            }
        }

        while (j < p.length) {
        	if (j + 1 < p.length && p[j + 1] == '*') {
        		j += 2;
        	} else {
        		break;
        	}
        }
        if (i == s.length && j == p.length) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
//    	String p = "aasdf.*asdf.*asdf.*asdf.*s";
//    	String s = "aasdfasdfasdfasdfas";
    	String p = "ab*";
    	String s = "a";
    	Regular_Expression_Matching tmp = new Regular_Expression_Matching();
//    	System.out.println(tmp.isMatch(s, p));
    	String str = "*ab*";
    	String[] arr = str.split("\\*");
    	int a = 1;
    }
}
