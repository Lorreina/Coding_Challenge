/**
 * LeetCode
 * 400. Nth Digit
 * @author lorreina
 *
 */
public class Nth_Digit {
	public int findNthDigit(int n) {
		if (n <= 9) {
			return n;
		}
        int pow = 1;
        int base = 9;
        int sum = 0;
        while (true) {
        	if (pow * base < 0 || sum + pow * base >= n) {
        		break;
        	}
        	sum += pow * base;
        	if (base * 10 < 0) {
        		break;
        	}
            base = base * 10;
            pow += 1;
        }
        
        int diff = n - sum;
        int number = base / 9 + (diff - 1) / pow;
        int count = pow - (diff - 1) % pow;
        
        for (int i = 1; i < count; i++) {
            number = number / 10;
            
        }
        
        return number % 10;
    }
	
	public static void main(String[] args) {
		Nth_Digit tmp = new Nth_Digit();
		int n = 999999999;
		System.out.println(tmp.findNthDigit(n));
	}
}
