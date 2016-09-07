import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 320. Generalized Abbreviation
 * @author lorreina
 *
 */
public class Generalized_Abbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String> ();
        
        if (word == null || word.length() == 0) {
            if (word.length() == 0) {
                res.add("");
            }
            return res;
        }
        
        List<StringBuilder> tmp = helper(word.toCharArray(), 0);
        for (int i = 0; i < tmp.size(); i++) {
            res.add(tmp.get(i).toString());
        }
        
        return res;
    }
    
    private List<StringBuilder> helper(char[] ch, int start) {
        List<StringBuilder> res = new ArrayList<StringBuilder> ();
        
        if (start == ch.length - 1) {
            res.add(new StringBuilder(String.valueOf(ch[start])));
            res.add(new StringBuilder("1"));
            
            return res;
        }
        
        List<StringBuilder> right = helper(ch, start + 1);
        for (int i = 0; i < right.size(); i++) {
            StringBuilder copy = new StringBuilder(right.get(i));
            right.get(i).insert(0, ch[start]);
            res.add(right.get(i));
            
            int end = 0;
            for (int j = 0; j < copy.length(); j++) {
                if (copy.charAt(j) < '0' || copy.charAt(j) > '9') {
                    break;
                }
                end++;
            }
            
            int num = 0;
            if (end > 0) {
                num = Integer.parseInt(copy.substring(0, end));
                copy.delete(0, end);
            }
            copy.insert(0, num + 1);
            res.add(copy);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	String word = "word";
    	Generalized_Abbreviation tmp = new Generalized_Abbreviation();
    	tmp.generateAbbreviations(word);
    }
}
