/**
 * LeetCode
 * 168. Excel Sheet Column Title
 * @author lorreina
 *
 */
public class Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        
        StringBuilder result = new StringBuilder();
        
        while (n != 0) {
            int res = n % 26;
            n = n / 26;
            // deal with char 'Z', be careful
            // take 26*26 + 26 = "ZZ" as an example, n is now 26 * 1 + 1
            if (res == 0) {
                result.insert(0, 'Z'); // result = "Z"
                n = n - 1; // n = 27 - 1 = 26
            } else {
                result.insert(0, (char) ('A' + res - 1));
            }
        }
        
        return result.toString();
    }
}
