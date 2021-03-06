/**
 * LeetCode
 * 299. Bulls and Cows
 * @author lorreina
 *
 */
public class Bulls_and_Cows {
	public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        
        int a = 0;
        int b = 0;
        
        for (char c : secret.toCharArray()) {
            s[c - '0']++;
        }
        
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                a++;
            }
            if (g[c - '0'] < s[c - '0']) { 
                g[c - '0']++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            b += g[i];
        }
        
        StringBuilder result = new StringBuilder();
        
        result.append(a);
        result.append("A");
        result.append(b - a);
        result.append("B");
        
        return result.toString();
    }
}
