/**
 * LeetCode
 * 316. Remove Duplicate Letters
 * @author lorreina
 *
 */
public class Remove_Duplicate_Letters {
	public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] tmp = s.toCharArray();
        int[] letter = new int[26];
        boolean[] isVisited = new boolean[26];
        
        for (char c : tmp) {
            letter[c - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        int index;
        
        for (char c : tmp) {
            index = c - 'a';
            letter[index]--;
            if (isVisited[index]) {
                continue;
            }
            while (result.length() > 0 && c < result.charAt(result.length() - 1) && letter[result.charAt(result.length() - 1) - 'a'] > 0) {
                isVisited[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }
            result.append(c);
            isVisited[index] = true;
        }
        return result.toString();
    }
}
