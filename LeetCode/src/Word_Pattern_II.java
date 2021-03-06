import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 291. Word Pattern II
 * @author lorreina
 *
 */
public class Word_Pattern_II {
	public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || pattern.length() > str.length()) {
            return false;
        }
        
        char[] pat = pattern.toCharArray();
        HashMap<Character, String> map = new HashMap<Character, String> ();
        HashSet<String> set = new HashSet<String> ();
        
        return helper(pat, str, 0, 0, map, set);
    }
    
    private boolean helper(char[] pat, String str, int i, int j, HashMap<Character, String> map, HashSet<String> set) {
        if (pat.length - i > str.length() - j) {
            return false;
        }
        
        if (i == pat.length) {
            if (j == str.length()) {
                return true;
            } else {
                return false;
            }
        }
        
        if (map.containsKey(pat[i])) {
            String word = map.get(pat[i]);
            if (j + word.length() > str.length()) {
                return false;
            }
            String newWord = str.substring(j, j + word.length());
            if (!newWord.equals(word)) {
                return false;
            } else {
                return helper(pat, str, i + 1, j + word.length(), map, set);
            }
        } else {
            for (int k = j + 1; k <= str.length(); k++) {
                String newWord = str.substring(j, k);
                if (set.contains(newWord)) {
                    continue;
                } else {
                    set.add(newWord);
                    map.put(pat[i], newWord);
                    if (helper(pat, str, i + 1, j + newWord.length(), map, set)) {
                        return true;
                    }
                    set.remove(newWord);
                    map.remove(pat[i]);
                }
            }
            
            return false;
        }
        
    }
    
    public static void main(String[] args) {
    	Word_Pattern_II tmp = new Word_Pattern_II();
    	String pattern = "d";
    	String str = "ef";
    	System.out.println(tmp.wordPatternMatch(pattern, str));
    }
}
