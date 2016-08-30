/**
 * LeetCode
 * 374. Guess Number Higher or Lower
 * @author lorreina
 *
 */


public class Guess_Number_Higher_or_Lower {
	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); */

	public static int guessNumber(int n) {
        int lb = 1, ub = n;
        
        while (lb < ub) {
            int mid = lb + (ub - lb) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                ub = mid - 1;
            } else if (res == 1) {
                lb = mid + 1;
            }
        }
        
        return lb;
	}
	
	private static int guess(int n) {
    	if (n > 6) {
    		return -1;
    	}
    	if (n < 6) {
    		return 1;
    	}
    	return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(guessNumber(10));
	}
	
}

