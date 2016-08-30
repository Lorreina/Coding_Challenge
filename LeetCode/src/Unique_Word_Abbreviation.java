import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 288. Unique Word Abbreviation
 * @author lorreina
 *
 */
public class Unique_Word_Abbreviation {
	public class ValidWordAbbr {
	    HashSet<String> set;
	    HashMap<String, Integer> map;
	    public ValidWordAbbr(String[] dictionary) {
	        set = new HashSet<String> ();
	        map = new HashMap<String, Integer> ();
	        for (int i = 0; i < dictionary.length; i++) {
	            String abv = generateAbbr(dictionary[i]);
	            if (set.contains(dictionary[i])) {
	                continue;
	            }
	            set.add(dictionary[i]);
	            if (map.containsKey(abv)) {
	                map.put(abv, -1);
	            } else {
	                map.put(abv, 1);
	            }
	        }
	    }

	    public boolean isUnique(String word) {
	        String abv = generateAbbr(word);
	        if (set.contains(word)) {
	            int res = map.get(abv);
	            if (res == 1) {
	                return true;
	            } else {
	                return false;
	            }
	        } else {
	            if (map.containsKey(abv)) {
	                return false;
	            } else {
	                return true;
	            }
	        }
	    }
	    
	    private String generateAbbr(String word) {
	        StringBuilder abv = new StringBuilder();
	        if (word.length() <= 2) {
	            abv.append(word);
	        } else {
	            abv.append(word.charAt(0));
	            abv.append(word.length() - 2);
	            abv.append(word.charAt(word.length() - 1));
	        }
	        
	        return abv.toString();
	    }
	}


	// Your ValidWordAbbr object will be instantiated and called as such:
	// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
	// vwa.isUnique("Word");
	// vwa.isUnique("anotherWord");
}
