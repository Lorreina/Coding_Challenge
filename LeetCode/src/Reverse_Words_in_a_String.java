/**
 * LeetCode
 * 151. Reverse Words in a String
 * @author lorreina
 *
 */
public class Reverse_Words_in_a_String {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length() - 1);
        
        int start = 0;
        int end = 0;
        
        StringBuilder res = new StringBuilder();
        
        while (start < s.length()) {
            start = findStart(ch, start);
            if (start >= s.length()) {
                break;
            }
            end = findEnd(ch, start + 1);
            String word = reverseWord(ch, start, end);
            res.append(" ");
            res.append(word);
            start = end + 1;
        }
        
        if (res.length() == 0) {
            return "";
        } else {
            return res.deleteCharAt(0).toString();
        }
    }
    
    private String reverseWord(char[] ch, int start, int end) {
        StringBuilder res = new StringBuilder();
        for (int i = end; i >= start; i--) {
            res.append(ch[i]);
        }
        
        return res.toString();
    }
    
    private int findEnd(char[] ch, int end) {
        for (int i = end; i < ch.length; i++) {
            if (ch[i] == ' ') {
                return i - 1;
            }
        }
        return ch.length - 1;
    }
    
    private int findStart(char[] ch, int start) {
        for (int i = start; i < ch.length; i++) {
            if (ch[i] != ' ') {
                return i;
            }
        }
        
        return ch.length;
    }
    
    private void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
        
        return;
    }
    
    public static void main(String[] args) {
    	Reverse_Words_in_a_String tmp = new Reverse_Words_in_a_String();
    	String s = "a";
    	System.out.println(tmp.reverseWords(s));
    }
}
