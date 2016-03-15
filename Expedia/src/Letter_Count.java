
public class Letter_Count {
	public static String countLetter(String s) {
		if (s == null) {
			return null;
		}
		
		StringBuilder result = new StringBuilder();
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				result.append(Integer.toString(count));
				result.append(s.charAt(i - 1));
				count = 1;
			}
		}
		
		result.append(Integer.toString(count));
		result.append(s.charAt(s.length() - 1));
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countLetter("aabbcc"));
	}
}
