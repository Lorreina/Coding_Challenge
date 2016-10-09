/**
 * LeetCode
 * 13. Roman to Integer
 * @author lorreina
 *
 */
public class Roman_to_Integer {
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] ch = s.toCharArray();
        int i = 0;
        int sum = 0;
        while (i < ch.length) {
            if (ch[i] == 'I') {
                if (i + 1 < ch.length) {
                    if (ch[i + 1] == 'V') {
                        sum += 4;
                        i += 2;
                        continue;
                    } else if (ch[i + 1] == 'X') {
                        sum += 9;
                        i += 2;
                        continue;
                    }
                } 
                sum += 1;
                i += 1;
            } else if (ch[i] == 'X') {
                if (i + 1 < ch.length) {
                    if (ch[i + 1] == 'L') {
                        sum +=40;
                        i += 2;
                        continue;
                    } else if (ch[i + 1] == 'C') {
                        sum += 90;
                        i += 2;
                        continue;
                    }
                }
                sum += 10;
                i += 1;
            } else if (ch[i] == 'C') {
                if (i + 1 < ch.length) {
                    if (ch[i + 1] == 'D') {
                        sum += 400;
                        i += 2;
                        continue;
                    } else if (ch[i + 1] == 'M') {
                        sum += 900;
                        i += 2;
                        continue;
                    }
                }
                sum += 100;
                i += 1;
            } else if (ch[i] == 'V') {
                sum += 5;
                i += 1;
            } else if (ch[i] == 'L') {
                sum += 50;
                i += 1;
            } else if (ch[i] == 'D') {
                sum += 500;
                i += 1;
            } else if (ch[i] == 'M') {
                sum += 1000;
                i += 1;
            }
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
		Roman_to_Integer tmp = new Roman_to_Integer();
		String s = "MCMXCVI";
		System.out.println(tmp.romanToInt(s));
	}
}
