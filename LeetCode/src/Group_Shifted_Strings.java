import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode
 * 249. Group Shifted Strings
 * @author lorreina
 *
 */
public class Group_Shifted_Strings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<> ();
        if (strings == null || strings.length == 0) {
            return res;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer> ();
        for (String s : strings) {
            String shift = shift(s);
            if (map.containsKey(shift)) {
                res.get(map.get(shift)).add(s);
            } else {
                map.put(shift, res.size());
                List<String> list = new ArrayList<String> ();
                list.add(s);
                res.add(list);
            }
        }
        
        return res;
    }
    
//    private String shift(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        
//        char[] ch = s.toCharArray();
//        int step = ch[0] - 'a';
//        if (step == 0) {
//            return s;
//        }
//        
//        for (int i = 0; i < ch.length; i++) {
//            int diff = ch[i] - 'a';
//            if (diff < step) {
//                ch[i] = (char) ('z' - (step - diff - 1));
//            } else {
//                ch[i] -= step;
//            }
//        }
//        
//        return String.valueOf(ch);
//    }
    private String shift(String s) {
        if (s.length() == 0) {
            return "";
        }
        
        char[] ch = s.toCharArray();
        int step = ch[0] - 'a';
        if (step == 0) {
            return s;
        }
        for (int i = 0; i < ch.length; i++) {
        	ch[i] = (char) ('a' + ((ch[i] - 'a') - step + 26) % 26);
        }
        
        return String.valueOf(ch);
    }
    
    public static void main(String[] args) {
    	Group_Shifted_Strings tmp = new Group_Shifted_Strings();
    	String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    	List<List<String>> list = tmp.groupStrings(strings);
    }
}
