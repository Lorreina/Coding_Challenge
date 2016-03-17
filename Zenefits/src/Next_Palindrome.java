
public class Next_Palindrome {
	public static String findNext(String num) {
		if (num == null || num.length() == 0) {
			return null;
		}
		
		boolean isAdd = false;
		int n = num.length();
		StringBuilder result = new StringBuilder(num);
		
		int right = n - 1;
		int left = 0;
		
		while (left  <= right) {
			char leftNum = num.charAt(left);
			char rightNum = num.charAt(right);
			
			if (rightNum < leftNum) {
				result.setCharAt(right, leftNum);
				isAdd = true;
			} else if (rightNum > leftNum) {
				result.setCharAt(right, leftNum);
				isAdd = false;
			}
			left++;
			right--;
		}
		
		if (isAdd) {
			return result.toString();
		}
		
		left--;
		right++;
		
		while (left >= 0) {
			char digit = num.charAt(left);
			
			if (digit < '9') {
				result.setCharAt(left, (char) (digit + 1));
				result.setCharAt(right, (char) (digit + 1));
				return result.toString();
			} else {
				result.setCharAt(left, '0');
				result.setCharAt(right, '0');
				left--;
				right++;
			}
		}
		
		result.insert(0, '1');
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		String num = "23545";
		System.out.println(findNext(num));
	}
}
