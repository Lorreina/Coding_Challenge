/**
 * LeetCode 91. Decode Ways
 * @author lorreina
 *
 */
public class Decode_Ways {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] num = new int[s.length() + 1];
        num[0] = 1;
        num[1] = 1;
        char tmp;
        char last = s.charAt(0);
        if (last == '0') {
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            tmp = s.charAt(i);
            if (tmp == '0') {
                if (last == '0' || (last > '2' && last <= '9')) {
                    return 0;
                } else {
                    num[i + 1] = num[i - 1];
                }
            } else if ((last == '2' && tmp > '6') || last >= '3' || last == '0') {
                num[i + 1] = num[i];
            } else {
                num[i + 1] = num[i] + num[i - 1];
            }
            last = tmp;
        }
        
        return num[s.length()];
    }
}
