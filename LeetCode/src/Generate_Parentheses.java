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
    
        helper(res, n, new StringBuilder(), 0);
        
        return res;
    }
    
    private void helper(List<String> res, int n, StringBuilder s, int index) {
        
        if (index == s.length()) {
            s.append("()");
        } else {
            s.insert(index, "()");
        }
        
        if (n == 1) {
        	res.add(s.toString());
        } else {
            helper(res, n - 1, s, index + 1); 
	        helper(res, n - 1, s, index + 2);
	        if (index + 2 != s.length()) {
	        	helper(res, n - 1, s, s.length());
	        }
        }
        s.delete(index, index + 2);
        
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
