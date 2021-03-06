import java.util.ArrayList;

public class String_Match {
	public static int stringMatch(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return 0;
		}
		
		int result = 0;
		ArrayList<String> pattern = new ArrayList<String> ();
		for (int i = 0; i < s2.length() - 1; i = i + 2) {
			int count = 2;
			if (s2.charAt(i + 1) == '-') {
				count = 4;
			}
			StringBuilder tmp = new StringBuilder();
			for (int j = 0; j < count; j++) {
				tmp.append(String.valueOf(s2.charAt(i)));
			}
			pattern.add(tmp.toString());
		}
		
		while (true) {
			for (int i = 0; i < pattern.size(); i++) {
				int index = s1.indexOf(pattern.get(i));
				if (index == -1) {
					return result;
				}
				s1 = s1.substring(index + pattern.get(i).length());
			}
			result++;
		}
	}
	
	public static void main(String[] args) {
		String s1 = "waeginsapnaabangpisebbasepgnccccapisdnfngaabndlrjngeuiogbbegbuoecccc";
		String s2 = "a+b+c-";
		
		System.out.println(stringMatch(s1, s2));
	}
}
