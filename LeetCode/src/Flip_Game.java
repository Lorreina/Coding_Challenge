import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 293. Flip Game
 * @author lorreina
 *
 */
public class Flip_Game {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String> ();
        if (s == null || s.length() <= 1) {
            return res;
        }
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == '+') {
                String tmp = s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length());
                res.add(tmp);
            }
        }
        
        return res;
    }
}
