
public class String_to_integer_atoi {
	public static int myAtoi(String str) {
        int start = 0;
        int isPositive = 1;
        
        while (start < str.length()) {
            char tmp = str.charAt(start);
            if (tmp == ' ') {
                start++;
            } else {
                if (tmp == '+') {
                    start++;
                    break;
                } else if (tmp == '-') {
                    isPositive = -1;
                    start++;
                    break;
                }
                break;
            }
        }
        
        long result = 0;
        
        while (start < str.length()) {
            char tmp = str.charAt(start);
            if (tmp < '0' || tmp > '9') {
                return (int) result * isPositive;
            }
            result = result * 10 + (tmp - '0');
            if (isPositive == 1) {
                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (-result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            start++;
        }
        
        return (int) result * isPositive;
    }
	
	public static void main(String[] args) {
		 System.out.println(myAtoi("  -0012a42"));
	 }
}
