/**
 * LeetCode
 * 186. Reverse Words in a String II
 * @author lorreina
 *
 */
public class Reverse_Words_in_a_String_II {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        
        reverse(s, 0, s.length - 1);
        
        int last = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, last, i - 1);
                last = i + 1;
            }
        }
        
        reverse(s, last, s.length - 1);
        
    }
    
    private void reverse(char[] s, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
