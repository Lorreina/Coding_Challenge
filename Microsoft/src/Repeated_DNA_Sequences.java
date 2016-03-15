import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Repeated_DNA_Sequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String> ();
        if (s == null || s.length() < 11) {
            return result;
        }
        HashSet<Integer> set = new HashSet<Integer> ();
        HashSet<Integer> exclude = new HashSet<Integer> ();
        int n = 0;
        for (int i = 0; i < 10; i++) {
            n = (n << 2) | findValue(s.charAt(i));
        }
        
        set.add(n);
        int mask = 0xFFFFF;
        for (int i = 1; i < s.length() - 9; i++) {
            n = ((n << 2) | findValue(s.charAt(i + 9))) & mask;
            if (exclude.contains(n)) {
                continue;
            }
            if (set.contains(n)) {
                result.add(s.substring(i, i + 10));
                exclude.add(n);
            } else {
                set.add(n);
            }
        }
        
        return result;
        
    }
    
    private int findValue(char c) {
        switch (c) {
            case 'A':   return 0;
            case 'C':   return 1;
            case 'G':   return 2;
            case 'T':   return 3;
            default:    return -1;
        }
    }
}
