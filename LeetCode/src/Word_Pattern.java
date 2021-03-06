import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 290. Word Pattern
 * @author lorreina
 *
 */
public class Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return true;
        }
        
        String[] words = str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String> ();
        HashSet<String> set = new HashSet<String> ();
        
        if (words.length != pattern.length()) {
            return false;
        }
        
        char c = ' ';
        for (int i = 0; i < pattern.length(); i++) {
            c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!words[i].equals(map.get(c))) {
                    return false;
                }
            } else {
                if (set.contains(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
                set.add(words[i]);
            }
        }
        return true;
    }
}
