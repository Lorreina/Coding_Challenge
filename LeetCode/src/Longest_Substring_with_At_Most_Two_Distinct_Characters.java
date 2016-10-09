/**
 * LeetCode
 * 159. Longest Substring with At Most Two Distinct Characters
 * @author lorreina
 *
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        if (s.length() <= 2) {
            return s.length();
        }
        
        int count = 0;
        int start = 0;
        int maxLen = 0;
        int[] map = new int[256];
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            if (map[ch[i]] == 0) {
                while (count == 2) {
                    if (map[ch[start]] == 1) {
                        count--;
                    }
                    map[ch[start]]--;
                    start++;
                }
                count++;
                map[ch[i]] = 1;
            } else {
                map[ch[i]]++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}
