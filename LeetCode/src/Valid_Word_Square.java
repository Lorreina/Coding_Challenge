import java.util.List;

/**
 * LeetCode
 * 422. Valid Word Square
 * @author lorreina
 *
 */
public class Valid_Word_Square {
	public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        
        if (words.size() != words.get(0).length()) {
            return false;
        }
        
        int n = words.size();
        for (int k = 0; k < n; k++) {
            if (words.get(k).length() > n) {
                return false;
            }
            
            // compare the kth row and kth column starting from (k,k)
            for (int i = k; i < words.get(k).length(); i++) {
                if (words.get(i).length() <= k) {
                    return false;
                }
                if (words.get(i).charAt(k) != words.get(k).charAt(i)) {
                    return false;
                }
            }
            
            for (int i = words.get(k).length(); i < n; i++) {
                if (words.get(i).length() > k) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
