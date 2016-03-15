/**
 * WePay
 * @author lorreina
 *
 */
public class String_Add_Number {
	public static int addNumbers(String s) {
		int sum = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}
		int start = -1;
		char tmp = ' ';
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			tmp = s.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				if (start == -1) {
					start = i;
				}
				x = x * 10 + (tmp - '0');
			} else {
				if (start >= 1 && s.charAt(start - 1) == '-') {
					sum = sum - x;
				} else {
					sum = sum + x;
				}
				start = -1;
				x = 0;
			}
		}
		
		if (x != 0) {
			if (start >= 1 && s.charAt(start - 1) == '-') {
				sum = sum - x;
			} else {
				sum = sum + x;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(addNumbers("10abc-5ghi3xyz-8"));
	}
}
