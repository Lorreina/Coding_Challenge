import java.util.HashMap;

/**
 * LeetCode
 * 76. Minimum Window Substring
 * @author lorreina
 *
 */
public class Minimum_Window_Substring {
	/*
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
        boolean isValid = false;
        
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int start = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    counter--;
                } 
                map.put(c, map.get(c) - 1);
            }
            
            while (counter == 0) {
                isValid = true;
                if (minLen > i - start + 1) {
                    minStart = start;
                    minLen = i - start + 1;
                }
                
                char curr = s.charAt(start);
                if (map.containsKey(curr)) {
                    map.put(curr, map.get(curr) + 1);
                    if (map.get(curr) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        
        if (!isValid) {
            return "";
        }
        
        return s.substring(minStart, minStart + minLen);
    }
    */
    
    public static void main(String[] args) {
    	Minimum_Window_Substring tmp = new Minimum_Window_Substring();
//    	String s = "ADOBECODEBANC";
    	String s = "AAAAAAABCFNSJLFJLDSJF;LKADK;LKJFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
    	String t = "ABC";
    	System.out.println(tmp.minWindow(s, t));
    }
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> currentMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        int current = 0, st = 0, ans = Integer.MAX_VALUE, ansSt = 0;
//        System.out.println(t.length());
//        System.out.println(tMap.size());
//        System.out.println(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
                if (currentMap.get(c) == tMap.get(c)) {
                    current++;
//                    System.out.println(current);
                }
                if (current == tMap.size()) {
                    for (int j = st; j <= i; j++) {
                        if (ans > i - j + 1) {
                            ans = i - j + 1;
                            ansSt = j;
                        }
                        if (tMap.containsKey(s.charAt(j))) {
                            int tmp = currentMap.get(s.charAt(j)) - 1;
                            currentMap.put(s.charAt(j), tmp);
                            if (tmp < tMap.get(s.charAt(j))) {
                                st = j + 1;
                                current--;
                                break;
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(ans);
        if (ans == Integer.MAX_VALUE)
            return "";
        return s.substring(ansSt, ansSt + ans);
    }
}
