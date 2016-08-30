import java.util.ArrayList;
import java.util.List;

public class Letter_combinations_of_a_phone_number {
	public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        return helper(digits);
    }
    
    private static List<String> helper(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        
        char tmp = digits.charAt(0);
        digits = digits.substring(1);
        List<String> next = helper(digits);
        String s = " ";
        if (tmp >= '2' && tmp <= '6') {
            for (int i = 0; i < 3; i++) {
                s = String.valueOf((char)('a' + (i + 3 * (tmp - '2'))));
                for (int j = 0; j < next.size(); j++) {
                    list.add(s + next.get(j));
                }
                if (next.size() == 0) {
                    list.add(s);
                }
            }
        } else if (tmp == '7') {
            for (int i = 0; i < 4; i++) {
                s = String.valueOf((char)('p' + i));
                for (int j = 0; j < next.size(); j++) {
                	list.add(s + next.get(j));
                }
                if (next.size() == 0) {
                    list.add(s);
                }
            }
        } else if (tmp == '8') {
            for (int i = 0; i < 3; i++) {
                s = String.valueOf((char)('t' + i));
                for (int j = 0; j < next.size(); j++) {
                	list.add(s + next.get(j));
                }
                if (next.size() == 0) {
                    list.add(s);
                }
            }
        } else if (tmp == '9') {
            for (int i = 0; i < 4; i++) {
                s = String.valueOf((char)('w' + i));
                for (int j = 0; j < next.size(); j++) {
                	list.add(s + next.get(j));
                }
                if (next.size() == 0) {
                    list.add(s);
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
    	System.out.println(letterCombinations("22"));
    }
    
}
