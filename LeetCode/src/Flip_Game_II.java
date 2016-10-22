import java.util.HashMap;

/**
 * LeetCode
 * 294. Flip Game II 
 * @author lorreina
 *
 */
public class Flip_Game_II {
	// Solution 2: backtracking with memorization and optimization
	public boolean canWin(String s) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean> ();
        
        if (s == null || s.length() <= 1) {
            return false;
        }
        
        char[] ch = s.toCharArray();
        return helper(map, ch);
    }
    
    private boolean helper(HashMap<String, Boolean> map, char[] ch) {
        String s = String.valueOf(ch);
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        boolean res = false;
        
        for (int i = 1; i < ch.length; i++) {
            if (ch[i - 1] == '+' && ch[i] == '+') {
                ch[i - 1] = '-';
                ch[i] = '-';
                res = res | !helper(map, ch);
                ch[i - 1] = '+';
                ch[i] = '+';
                if (res == true) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        
        map.put(s, false);
        return false;
    }
	
	
	// Solution 1: backtracking with memorization
	/*
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
    */
    
    public static void main(String[] args) {
    	Flip_Game_II tmp = new Flip_Game_II();
    	String s = "+++++++++";
    	System.out.println(tmp.canWin(s));
    }
    
}
