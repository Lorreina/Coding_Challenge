/**
 * LeetCode
 * 58. Length of Last Word
 * @author lorreina
 *
 */
public class Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        int length = 0;
        int start = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        
        return length;
    }
}
