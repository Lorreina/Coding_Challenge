
public class Add_Binary {
public static String addBinary(String a, String b) {
        
        if (a == null || a.length() == 0) {
            return b;
        }
        
        if (b == null || b.length() == 0) {
            return a;
        }
        
        int length = Math.min(a.length(), b.length());
        char[] chara = new StringBuilder(a).reverse().toString().toCharArray();
        char[] charb = new StringBuilder(b).reverse().toString().toCharArray();
        StringBuilder result = new StringBuilder();
        int tmp = 0;
        for (int i = 0; i < length; i++) {
            if (chara[i] != charb[i]) {
                if (tmp == 0) {
                    result.append('1');
                } else {
                    result.append('0');
                }
            } else {
                result.append((char)('0' + tmp));
                if (chara[i] == '0') {
                    tmp = 0;
                } else {
                    tmp = 1;
                }
            }
        }
        
        if (a.length() > length) {
            for (int i = length; i < a.length(); i++) {
                if (chara[i] == '1' && tmp == 1) {
                    result.append('0');
                } else if (chara[i] == '0' && tmp == 1) {
                    result.append('1');
                    tmp = 0;
                } else {
                    result.append(chara[i]);
                }
            }
        } else if (b.length() > length) {
            for (int i = length; i < b.length(); i++) {
                if (charb[i] == '1' && tmp == 1) {
                    result.append('0');
                } else if (charb[i] == '0' && tmp == 1) {
                    result.append('1');
                    tmp = 0;
                } else {
                    result.append(charb[i]);
                }
            }
        }
        
        if (tmp == 1) {
            result.append('1');
        }
        
        return result.reverse().toString();
        
    }
	
	public static void main(String[] args) {
		String a = "1101";
		String b = "11";
		System.out.println(addBinary(a, b));
	}
}
