import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode
 * 49. Group Anagrams
 * @author lorreina
 *
 */

public class Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<> ();
        
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>> ();
        
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String tmp = String.valueOf(ch);
            
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                ArrayList<String> list = new ArrayList<String> ();
                list.add(str);
                map.put(tmp, list);
            }
        }
        
        for (ArrayList<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        
        return result;
    }
}
