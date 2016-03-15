
public class Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return (Integer) null;
        }
        
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            x = x + (int)Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 'A' + 1);
        }
        
        return x;
        
    }
}
