/**
 * LeetCode
 * 345. Reverse Vowels of a String
 * @author lorreina
 *
 */
public class Reverse_Vowels_of_a_String {
	public String reverseVowels(String s) {
        StringBuilder res = new StringBuilder();
        char[] tmp = s.toCharArray();
        
        int j = tmp.length - 1;
        for (int i = 0; i < tmp.length; i++) {
            if (isVowel(tmp[i])) {
                while (!isVowel(tmp[j])) {
                    j--;
                }
                res.append(tmp[j]);
                j--;
            } else {
                res.append(tmp[i]);
            }
        }
        
        return res.toString();
    }
    
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
