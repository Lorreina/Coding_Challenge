/**
 * LeetCode
 * 383. Ransom Note
 * @author lorreina
 *
 */
public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Use array instead of HashMap to store the frequency of each character
        int[] array = new int[26];
        
        for (char c : magazine.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            array[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            array[c - 'a']--;
            if (array[c - 'a'] == -1) {
                return false;
            }
        }
        
        return true;
    }
}
