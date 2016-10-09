import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode
 * 336. Palindrome Pairs
 * @author lorreina
 *
 */
public class Palindrome_Pairs {
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<> ();
        if (words == null || words.length == 0) {
            return res;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer> ();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0,j);
                String right = words[i].substring(j);
                
                if (isPalindrome(left)) {
                    String rev = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        List<Integer> list = new ArrayList<Integer> ();
                        list.add(map.get(rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                
                if (isPalindrome(right) && right.length() > 0) {
                    String rev = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        List<Integer> list = new ArrayList<Integer> ();
                        list.add(i);
                        list.add(map.get(rev));
                        res.add(list);
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
