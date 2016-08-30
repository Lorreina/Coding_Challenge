import java.util.HashMap;

/**
 * LeetCode
 * 76. Minimum Window Substring
 * @author lorreina
 *
 */
public class Minimum_Window_Substring {
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
}