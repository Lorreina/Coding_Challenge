import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 
 * 131. Palindrome Partitioning
 * @author lorreina
 *
 */
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<> ();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        dfs(res, s, 0, new ArrayList<String> ());
        
        return res;
    }
    
    private void dfs(List<List<String>> res, String s, int start, List<String> list) {
        if (start == s.length()) {
            res.add(new ArrayList<String> (list));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                dfs(res, s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
        
        return;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
