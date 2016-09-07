import java.util.HashMap;

/**
 * LeetCode
 * 294. Flip Game II 
 * @author lorreina
 *
 */
public class Flip_Game_II {
    HashMap<String, Boolean> map;
    public boolean canWin(String s) {
        map = new HashMap<String, Boolean> ();
        if (s == null || s.length() <= 1 ) {
            return false;
        }
        
        char[] ch = s.toCharArray();
        return helper(ch);
    }
    
    private boolean helper (char[] ch) {
        if (map.containsKey(String.valueOf(ch))) {
            return map.get(String.valueOf(ch));
        }
        
        boolean res = true;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i - 1] == ch[i] && ch[i] == '+') {
            	ch[i - 1] = '-';
                ch[i] = '-';
                res = res && helper(ch);
                ch[i - 1] = '+';
                ch[i] = '+';
            }
        }
        
        map.put(String.valueOf(ch), !res);
        return !res;
    }
    
    public static void main(String[] args) {
    	Flip_Game_II tmp = new Flip_Game_II();
    	String s = "+++++++++";
    	System.out.println(tmp.canWin(s));
    }
}