/**
 * LeetCode
 * 405. Convert a Number to Hexadecimal
 * @author lorreina
 *
 */
public class Convert_a_Number_to_Hexadecimal {
	public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            res.insert(0, helper(num & 0xf));
            num = num >> 4;
        }
        
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                return res.substring(i, res.length());
            }
        }
        
        return res.toString();
    }
    
    private char helper(int num) {
        
        if (num < 10) {
            return (char) ('0' + num);
        } else {
            return (char) ('a' + (num - 10));
        }
        
    }
}
