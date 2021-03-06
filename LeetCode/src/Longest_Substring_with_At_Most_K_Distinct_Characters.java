/**
 * LeetCode
 * 340. Longest Substring with At Most K Distinct Characters
 * @company:Google
 * @author lorreina
 *
 */
public class Longest_Substring_with_At_Most_K_Distinct_Characters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        if (k == 0) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        
        int maxLength = 0;
        int count = 0;
        char[] ch = s.toCharArray();
        int start = 0;
        for (int i = 0; i < ch.length; i++) {
            if (map[ch[i]] == 0) {
                while (count == k) {
                    if (map[ch[start]] == 1) {
                        count--;
                    }
                    map[ch[start]]--;
                    start++;
                }
                map[ch[i]]++;
                count++;
            } else {
                map[ch[i]]++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        
        
        return maxLength;
    }
}
