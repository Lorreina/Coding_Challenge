import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 22. Generate Parentheses
 * @author lorreina
 *
 */

public class Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String> ();
        if (n <= 0) {
            return list;
        }
        
        helper(list, "", n, n);
        
        return list;
    }
    
    private void helper(List<String> list, String str, int left, int right) {
        if (right == 0) {
            list.add(str);
        }
        
        if (left > 0) {
            helper(list, str + "(", left - 1, right);
        }
        
        if (right > left) {
            helper(list, str + ")", left, right - 1);
        }
    }
}
