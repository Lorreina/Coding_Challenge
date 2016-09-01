import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 77. Combinations
 * @author lorreina
 *
 */
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k > n) {
            return null;
        }
        
        List<List<Integer>> res = new ArrayList<> ();
        dfs(res, new ArrayList<Integer> (), k, 1, n - k + 1);
        
        return res;
    }
    
    private static void dfs(List<List<Integer>> res, List<Integer> list, int count, int left, int right) {
        if (count == 0) {
            List<Integer> tmp = new ArrayList<Integer> ();
            tmp.addAll(list);
            res.add(tmp);
            return;
        }
        
        for (int i = left; i <= right; i++) {
            list.add(i);
            dfs(res, list, count - 1, i + 1, right + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> list = combine(5, 3);
    	for (int i = 0; i < list.size(); i++) {
    		List<Integer> tmp = list.get(i);
    		for (int j = 0; j < tmp.size(); j++) {
    			System.out.print(tmp.get(j));
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
}
