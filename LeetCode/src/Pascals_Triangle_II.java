import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 119. Pascal's Triangle II
 * @author lorreina
 *
 */
public class Pascals_Triangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer> ();
        
        if (rowIndex == 0) {
        	res.add(1);
            return res;
        }
        
        if (rowIndex == 0) {
        	res.add(1);
        	res.add(1);
            return res;
        }
        
        int[] curr = new int[rowIndex + 1];
        int[] last = new int[rowIndex + 1];
        last[0] = 1;
        last[1] = 1;
        curr[0] = 1;
        int[] tmp = new int[rowIndex + 1];
        for (int i = 2; i <= rowIndex; i++) {
        	
            for (int j = 1; j < i; j++) {
            	curr[j] = last[j - 1] + last[j];
            }
            curr[i] = 1;
            tmp = last;
            last = curr;
            curr = tmp;
        }
        
        for (int i = 0; i <= rowIndex; i++) {
        	res.add(last[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	List<Integer> res = getRow(4);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.print(res.get(i));
    		System.out.print(" ");
    	}
    }
}	
