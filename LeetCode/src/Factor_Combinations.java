import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 245. Factor Combinations
 * @author lorreina
 *
 */
public class Factor_Combinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<> ();
        if (n == 1) {
            return res;
        }
        
        res = helper(n, 2);
        res.remove(0);
        
        return res;
    }
    
    private List<List<Integer>> helper(int n, int start) {
        List<List<Integer>> res = new ArrayList<> ();
        int end = (int) Math.sqrt(n);
        
        List<Integer> self = new ArrayList<Integer> ();
        self.add(n);
        res.add(self);
        
        for (int i = start; i <= end; i++) {
            if (n % i == 0) {
                List<List<Integer>> tmp = helper(n / i, i);
                for (int j = 0; j < tmp.size(); j++) {
                    tmp.get(j).add(0, i);
                }
                res.addAll(tmp);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	Factor_Combinations tmp = new Factor_Combinations();
    	List<List<Integer>> res = tmp.getFactors(12);
    	System.out.println(res);
    }
}
