/**
 * LeetCode
 * 344. Reverse String
 * @author lorreina
 *
 */
public class Reverse_String {
    public String reverseString(String s) {
        StringBuilder res = new StringBuilder();
        char[] tmp = s.toCharArray();
        for (int i = tmp.length - 1; i >= 0; i--) {
            res.append(tmp[i]);
        }
        
        return res.toString();
    }
}
