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
        List<String> res = new ArrayList<String> ();
    
        helper(res, n, n, new StringBuilder());
        
        return res;
    }
    
    private void helper(List<String> res, int left, int right, StringBuilder s) {
        if (left == 0) {
            StringBuilder str = new StringBuilder(s);
            for (int i = 0; i < right; i++) {
                str.append(")");
            }
            res.add(str.toString());
        } else if (left <= right) {
            s.append("(");
            helper(res, left - 1, right, s);
            s.deleteCharAt(s.length() - 1);
            
            if (left < right) {
                s.append(")");
                helper(res, left, right - 1, s);
                s.deleteCharAt(s.length() - 1);
            }
        }
        
        return;
    }
    
    public static void main(String[] args) {
    	Generate_Parentheses tmp = new Generate_Parentheses();
    	int n = 3;
    	List<String> res = tmp.generateParenthesis(n);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.println(res.get(i));
    	}
    }
}
