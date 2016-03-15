/**
 * LeetCode 263. Ugly Number
 * @author lorreina
 *
 */
public class Ugly_Number {
	public boolean isUgly(int num) {
	       if (num <= 0) {
	           return false;
	       }
	       
	       // divide by 2
	       while (true) {
	           if (num % 2 == 0) {
	               num = num / 2;
	           } else {
	               break;
	           }
	       }
	       
	       // divide by 3
	       while (true) {
	           if (num % 3 == 0) {
	               num = num / 3;
	           } else {
	               break;
	           }
	       }
	       
	       // divide by 5
	       while (true) {
	           if (num % 5 == 0) {
	               num = num / 5;
	           } else {
	               break;
	           }
	       }
	       
	       if (num == 1) {
	           return true;
	       }
	       return false;
	    }
}
