/**
 * LeetCode
 * 408. Valid Word Abbreviation
 * @author lorreina
 *
 */
public class Valid_Word_Abbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null && abbr == null) {
            return true;
        }
        if (word == null) {
            if (abbr.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        if (abbr == null) {
            if (word.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        int i = 0, j = 0, count = 0;
        while (i < abbr.length() && j < word.length()) {
            if (isLetter(abbr.charAt(i))) {
                if (count > 0) {
                    j += count;
                    count = 0;
                }
                if (abbr.charAt(i) != word.charAt(j)) {
                    // not match
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                count = count * 10 + (abbr.charAt(i) - '0');
                i++;
            }
        }
        
        j += count;
        return j == word.length();
    }
    
    private boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
    	Valid_Word_Abbreviation tmp = new Valid_Word_Abbreviation();
//    	String word = "internationalization";
    	String word = "apple";
    	String abbr = "a2e";
//    	String abbr = "i12iz4n";
    	System.out.println(tmp.validWordAbbreviation(word, abbr));
    }
}
