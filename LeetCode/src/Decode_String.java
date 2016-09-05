import java.util.Stack;

/**
 * LeetCode
 * 394. Decode String
 * @author lorreina
 *
 */
public class Decode_String {
    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        
        String res= "";
        Stack<Integer> timeStack = new Stack<Integer> ();
        Stack<String> strStack = new Stack<String> ();
        strStack.push("");
        int numStart = 0;
        int charStart = 0;
        int charEnd = 0;
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            if (isNum(ch[i])) {
                if (!isNum(ch[i - 1])) {
                    numStart = i;
                }
                if (isLetter(ch[i - 1])) {
                    String str = s.substring(charStart, i);
                    strStack.push(strStack.pop() + str);
                }
            } else if (ch[i] == '[') {
                int time = Integer.parseInt(s.substring(numStart, i));
                timeStack.push(time);
                strStack.push("");
                charStart = i + 1;
            } else if (ch[i] == ']') {
            	String str = strStack.pop();
            	if (charStart <= charEnd) {
            		 str += s.substring(charStart, charEnd + 1);
            	}
                
                charStart = i + 1;
                int time = timeStack.pop();
                String newStr = "";
                for (int j = 0; j < time; j++) {
                    newStr += str;
                }
                
                if (strStack.isEmpty()) {
                    res += newStr;
                } else {
                    strStack.push(strStack.pop() + newStr);
                }
            } else if (isLetter(ch[i])) {
            	charEnd = i;
                if (ch[i - 1] == ']') {
                    charStart = i;
                }
            }
        }
        
        if (!strStack.isEmpty()) {
        	res += strStack.pop();
        }
        if (charStart < s.length()) {
        	res += s.substring(charStart, s.length());
        }
        return res;
    }
    
    private boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
    	Decode_String tmp = new Decode_String();
    	String s = "abc3[cd]xyz";
    	String res = tmp.decodeString(s);
    	System.out.println(res);
    }
}
