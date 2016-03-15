import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 205. Isomorphic Strings
 * @author lorreina
 *
 */

public class Isomorphic_Strings {
	public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s == null || t == null) {
            return false;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        // use HashMap to store the replacing pairs -> no duplicate keys allowed.
        // use HashSet to store the values in HashMap -> no duplicate values allowed.
        HashMap<Character, Character> map = new HashMap<Character, Character> ();
        HashSet<Character> set = new HashSet<Character> ();
        
        char tmps = ' ';
        char tmpt = ' ';
        for (int i = 0; i < s.length(); i++) {
            tmps = s.charAt(i);
            tmpt = t.charAt(i);
            if (map.containsKey(tmps)) {
                if (map.get(tmps) != tmpt) {
                    return false;
                }
            } else {
                if (set.contains(tmpt)) {
                    return false;
                }
                map.put(tmps, tmpt);
                set.add(tmpt);
            }
        }
        return true;
    }
}
