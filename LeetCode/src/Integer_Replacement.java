/**
 * 397. Integer Replacement
 * @author lorreina
 *
 */
public class Integer_Replacement {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int count = 0;
        while (n > 1) {
            count += 1;
            if ((n & 1) == 0) {
                n = n >> 1;
            } else {
            	if (n != 3 && (n & 3) == 3) {
            		n = n + 1;
            	} else {
            		n = n - 1;
            	}
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
    	Integer_Replacement tmp = new Integer_Replacement();
    	System.out.println(tmp.integerReplacement(10000));
    }
    
}
