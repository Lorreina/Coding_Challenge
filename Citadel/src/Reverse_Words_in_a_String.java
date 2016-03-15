
public class Reverse_Words_in_a_String {
	public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        if (s == null || s.length() == 0) {
        	return reverse.toString();
        }
        
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
        	if (s.charAt(i) == ' ') {
        		if (end == -1) {
        			continue;
        		} else {
        			if (reverse.length() != 0) {
        				reverse.append(" ");
        			}
        			reverse.append(s.substring(i + 1, end + 1));
        			end = -1;
        		}
        	} else {
        		if (end == -1) {
        			end = i;
        		}
        	}
        }
        
        if (end != -1) {
        	if (reverse.length() != 0) {
				reverse.append(" ");
			}
        	reverse.append(s.substring(0, end + 1));
        }
        
        return reverse.toString();
    }
}
