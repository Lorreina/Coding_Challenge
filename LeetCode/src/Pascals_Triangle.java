import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 118. Pascal's Triangle
 * @author lorreina
 *
 */
public class Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<> ();
        
        if (numRows > 0) {
            List<Integer> list = new ArrayList<Integer> ();
            list.add(1);
            res.add(list);
        }
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer> ();
            list.add(1);
            List<Integer> lastLine = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(lastLine.get(j - 1) + lastLine.get(j));
            }
            list.add(1);
            res.add(list);
        }
        
        return res;
    }
}
