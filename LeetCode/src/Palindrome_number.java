/**
 * LeetCode
 * 9. Palindrome Number
 * @author lorreina
 *
 */
public class Palindrome_number {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int originalX = x;
        long reverse = 0;
        int digit = 0;
        while (x != 0) {
            digit = x % 10;
            x = x / 10;
            reverse = reverse * 10 + digit;
        }
        
        if (reverse == originalX) {
            return true;
        }
        return false;
    } 
    
    public static void main(String[] args) {
    	System.out.println(isPalindrome(1));
    }
}
