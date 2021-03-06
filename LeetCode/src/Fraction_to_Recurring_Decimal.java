import java.util.HashMap;
/**
 * LeetCode
 * 166. Fraction to Recurring Decimal
 * @author lorreina
 *
 */
public class Fraction_to_Recurring_Decimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        if (numerator > 0 && denominator < 0) {
            result.append("-");
        } else if (numerator < 0 && denominator > 0) {
            result.append("-");
        }
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // add the integer part
        result.append(num / den);
        num = num % den;
        
        if (num == 0) {
            return result.toString();
        }
        
        // add dot
        result.append(".");
        
        // determine whether there's cycle
        HashMap<Long, Integer> map = new HashMap<Long, Integer> ();
        map.put(num, result.length());
        while (num != 0) {
            num = num * 10;
            result.append(num / den);
            num = num % den;
            // contains cycle
            if (map.containsKey(num)) {
            	// the start location of cycle part
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            } else {
                map.put(num, result.length());
            }
        }
        return result.toString();
    }
}
