/**
 * LeetCode
 * 161. One Edit Distance
 * @author lorreina
 *
 */
public class One_Edit_Distance {
	public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) {
            return false;
        }
        if (s == null) {
            if (t.length() == 1) {
                return true;
            } else {
                return false;
            }
        }
        if (t == null) {
            if (s.length() == 1) {
                return true;
            } else {
                return false;
            }
        }
        
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        
        if (s.length() == t.length()) {
            return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
    	String s = "a";
    	String t = "A";
    	One_Edit_Distance tmp = new One_Edit_Distance();
    	
    	System.out.println(tmp.isOneEditDistance(s, t));
    }
}
