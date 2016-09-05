import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 247. Strobogrammatic Number II
 * @author lorreina
 *
 */
public class Strobogrammatic_Number_II {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = helper(n);
        
        if (n == 1) {
            return res;
        }
        
        for (int i = res.size() - 1; i >= 0; i--) {
            if (res.get(i).charAt(0) == '0') {
                res.remove(i);
            }
        }

        return res;
    }
    
    private List<String> helper(int n) {
        List<String> res = new ArrayList<String> ();
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        
        if (n == 2) {
            res.add("00");
            res.add("11");
            res.add("69");
            res.add("88");
            res.add("96");
            return res;
        }
        
        List<String> list = helper(n - 2);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        
        return res;
    }
}
