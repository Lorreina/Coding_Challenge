/**
 * LeetCode
 * Find the Difference
 * @author lorreina
 *
 */
public class Find_the_Difference {
    public char findTheDifference(String s, String t) {
        char[] dict = new char[26];
        
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (dict[c - 'a'] == 0) {
                return c;
            }
            dict[c - 'a']--;
        }
        
        return 0;
    }
}
