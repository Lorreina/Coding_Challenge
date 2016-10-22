/**
 * LeetCode
 * 408. Valid Word Abbreviation
 * @author lorreina
 *
 */
public class Valid_Word_Abbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || word.length() == 0) {
            if (abbr == null || abbr.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        if (abbr == null || abbr.length() == 0) {
            return false;
        }
        
        int count = 0;
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            if (isLetter(c)) {
                if (count > 0) {
                    i += count;
                    count = 0;
                }
                if (i >= word.length() || word.charAt(i) != c) {
                    return false;
                }
                i++;
                j++;
            } else {
                if (count == 0 && c == '0') {
                    return false;
                }
                count = count * 10 + (c - '0');
                j++;
            }
        }
        
        i += count;
        return i == word.length() && j == abbr.length();
    }
    
    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
    
    public static void main(String[] args) {
    	Valid_Word_Abbreviation tmp = new Valid_Word_Abbreviation();
    	String word = "internationalization";
//    	String word = "apple";
//    	String abbr = "a2e";
//    	String abbr = "i12iz4n";
    	String abbr = "i5a11o1";
    	System.out.println(tmp.validWordAbbreviation(word, abbr));
    }
}
