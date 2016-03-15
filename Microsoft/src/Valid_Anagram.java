
public class Valid_Anagram {
	public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] list = new int[26];
        for (int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (list[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            list[t.charAt(i) - 'a']--;
        }
        
        return true;
    }
}
