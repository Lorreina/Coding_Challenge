/**
 * LeetCode
 * 214. Shortest Palindrome
 * @author lorreina
 *
 */
public class Shortest_Palindrome {
	// any better solutions?
	
	/*
	public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] ch = s.toCharArray();
        int end = ch.length - 1;
        for (; end >= 0; end--) {
            if (isPalindrome(ch, end)) {
                break;
            }
        }
        
        StringBuilder head = new StringBuilder();
        for (int i = ch.length - 1; i > end; i--) {
            head.append(ch[i]);
        }
        
        head.append(s);
        return head.toString();
    }
    
    private boolean isPalindrome(char[] ch, int end) {
        int i = 0, j = end;
        while (i < j) {
            if (ch[i] != ch[j]) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    */
	
	// KMP
	public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        
        int end = table[table.length - 1];
        
        StringBuilder head = new StringBuilder();
        for (int i = s.length() - 1; i >= end; i--) {
            head.append(s.charAt(i));
        }
        
        head.append(s);
        return head.toString();
    }
    
    public int[] getTable(String str){
        int[] table = new int[str.length()];
        
        int p = 0;
        int s = 1;
        
        while (s < str.length()) {
            if (str.charAt(p) == str.charAt(s)) {
                table[s] = p + 1;
                p++;
                s++;
            } else {
                if (p == 0) {
                    s++;
                } else {
                    p = table[p - 1];
                }
            }
        }
        
        return table;
    }
    
    public static void main(String[] args) {
    	Shortest_Palindrome tmp = new Shortest_Palindrome();
    	String s = "aacecaaa";
    	System.out.println(tmp.shortestPalindrome(s));
    }
}
