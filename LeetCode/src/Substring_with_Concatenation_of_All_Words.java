import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode
 * 30. Substring with Concatenation of All Words
 * @author lorreina
 *
 */
public class Substring_with_Concatenation_of_All_Words {
	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> res = new ArrayList<Integer> ();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> con = new HashMap<String, Integer> ();
        HashMap<String, Integer> dict = new HashMap<String, Integer> ();
        
        for (int i = 0; i < words.length; i++) {
            if (dict.containsKey(words[i])) {
                dict.put(words[i], dict.get(words[i]) + 1);
            } else {
                dict.put(words[i], 1);
            }
        }
        
        int n = words[0].length();
        int count = words.length;
        int m = n * count;
        
        for (int i = 0; i < n; i++) {
            count = 0;
            con.clear();
            for (int j = i; j <= s.length() - n; j += n) {
                // add new word
                String newWord = s.substring(j, j + n);
                if (dict.containsKey(newWord)) {
                    if (!con.containsKey(newWord)) {
                        con.put(newWord, 1);
                        count++;
                    } else if (con.get(newWord) < dict.get(newWord)) {
                        con.put(newWord, con.get(newWord) + 1);
                        count++;
                    } else {
                        for (int k = j - count * n; k <= j - n; k += n) {
                        	String word = s.substring(k, k + n);
                        	if (word.equals(newWord)) {
                        		break;
                        	} else {
                        		con.put(word, con.get(word) - 1);
                        		count--;
                        	}
                        }
                    }
                } else {
                	con.clear();
                    count = 0;
                }
                if (count == words.length) {
                    res.add(j + n - m);
                    // remove old word
                    String word = s.substring(j + n - m, j + n + n - m);
                    con.put(word, con.get(word) - 1);
                    count--;
                }
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		Substring_with_Concatenation_of_All_Words tmp = new Substring_with_Concatenation_of_All_Words();
		String s = "aaaaaaaa";
		String[] words = {"aa","aa","aa"};
		
		System.out.println(tmp.findSubstring(s, words));
	}
}
