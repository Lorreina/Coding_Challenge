
public class Longest_Substring_Without_Repeating_Characters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int left = 0;
        int[] dict = new int[256];
        dict[(int) s.charAt(0)]++;
        int longest = 1;
        for (int i = 1; i < s.length(); i++) {
            if (dict[(int)s.charAt(i)] == 1) {
                longest = Math.max(longest, i - left);
                for (int j = left; j < i; j++) {
                    dict[(int) s.charAt(j)]--;
                    left++;
                    if (s.charAt(j) == s.charAt(i)) {
                        break;
                    }
                }
            } 
            dict[(int)s.charAt(i)] = 1;
        }
        
        longest = Math.max(longest, s.length() - left);
        
        return longest;
    }
	
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters tmp = new Longest_Substring_Without_Repeating_Characters();
		String s = "abcabcbb";
		System.out.println(tmp.lengthOfLongestSubstring(s));
	}
}
