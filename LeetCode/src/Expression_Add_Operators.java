import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 282. Expression Add Operators
 * @author lorreina
 *
 */
public class Expression_Add_Operators {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String> ();
        if (num == null || num.length() == 0) {
            return res;
        }
        
        char[] digits = num.toCharArray();
        char[] path = new char[digits.length * 2 - 1];
        long n = 0;
        
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(res, path, digits, target, i + 1, i + 1, 0, n);
            if (n == 0) {
                break;
            }
        }
        
        return res;
    }
    
    private void dfs(List<String> res, char[] path, char[] digits, int target, int dPointer, int pPointer, long prev, long cur) {
        if (dPointer == digits.length) {
            if (prev + cur == target) {
                res.add(new String(path, 0, pPointer));
                return;
            }
        }
        
        long n = 0;
        int indexOp = pPointer;
        for (int i = dPointer; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            pPointer++;
            path[pPointer] = digits[i];
            // put opearators
            path[indexOp] = '+';
            dfs(res, path, digits, target, i + 1, pPointer + 1, prev + cur, n);
            path[indexOp] = '-';
            dfs(res, path, digits, target, i + 1, pPointer + 1, prev + cur, -n);
            path[indexOp] = '*';
            dfs(res, path, digits, target, i + 1, pPointer + 1, prev, cur * n);
            
            // check whether the start is 0
            if (digits[dPointer] == '0') {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
    	Expression_Add_Operators tmp = new Expression_Add_Operators();
    	String num = "123";
    	int target = 6;
    	List<String> res = tmp.addOperators(num, target);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.println(res.get(i));
    	}
    	
    }
}
