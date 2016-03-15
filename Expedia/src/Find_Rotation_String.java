
public class Find_Rotation_String {
	public static boolean isRotated(String a, String b) {
		if (a == null && b == null || a.length() == 0 && b.length() == 0) {
			return true;
		}
		
		if (a == null || a.length() == 0) {
			return false;
		}
		
		if (b == null || b.length() == 0) {
			return false;
		}
		if (a.length() != b.length()) {
			return false;
		}
		
		int rotate = 0;
		for (rotate = 0; rotate < b.length(); rotate++) {
			if (a.charAt(0) == b.charAt(rotate)) {
				break;
			}
		}
		if (rotate == b.length()) {
			return false;
		}
		
		int index = 0;
		for (int i = 1; i < a.length(); i++) {
			index = (i + rotate) % a.length();
			if (a.charAt(i) != b.charAt(index)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdba";
		System.out.println(isRotated(a, b));
	}
}
