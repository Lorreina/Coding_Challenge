/**
 * LeetCode
 * 67. Add Binary
 * @author lorreina
 *
 */
public class Add_Binary {
	public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        
        if (b == null || b.length() == 0) {
            return a;
        }
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int m = a.charAt(a.length() - 1 - i) - '0';
            int n = b.charAt(b.length() - 1 - i) - '0';
            
            int sum = m + n + carry;
            if (sum == 0) {
                res.insert(0, '0');
            } else if (sum == 1) {
                res.insert(0, '1');
                carry = 0;
            } else if (sum == 2) {
                res.insert(0, '0');
                carry = 1;
            } else if (sum == 3) {
                res.insert(0, '1');
                carry = 1;
            }
        }
        
        if (a.length() < b.length()) {
            for (int i = (b.length() - a.length() - 1); i >= 0; i--) {
                int n = b.charAt(i) - '0';
                int sum = n + carry;
                if (sum == 0) {
                    res.insert(0, '0');
                } else if (sum == 1) {
                    res.insert(0, '1');
                    carry = 0;
                } else if (sum == 2) {
                    res.insert(0, '0');
                    carry = 1;
                }
            }
        } else if (b.length() < a.length()) {
            for (int i = (a.length() - b.length() - 1); i >= 0; i--) {
                int m = a.charAt(i) - '0';
                int sum = m + carry;
                if (sum == 0) {
                    res.insert(0, '0');
                } else if (sum == 1) {
                    res.insert(0, '1');
                    carry = 0;
                } else if (sum == 2) {
                    res.insert(0, '0');
                    carry = 1;
                }
            }
        }
        
        if (carry == 1) {
            res.insert(0, '1');
        }
        
        return res.toString();
    }
}
