import java.util.ArrayList;

/**
 * LeetCode
 * 
 * @author lorreina
 *
 */
public class Integer_To_English_Words {
	public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        ArrayList<String> res = new ArrayList<String> ();
        String[] unit = {"Thousand", "Million", "Billion", "Trillion"};
        String[] word = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] ten = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        int n = num % 1000;
        num = num / 1000;
        res = helper(n, word, ten, tens);
        
        int start = 0;
        while (num != 0) {
            ArrayList<String> str = helper(num % 1000, word, ten, tens);
            if (str.size() > 0) {
                str.add(unit[start]);
                str.addAll(res);
                res = str;
            }
            num = num / 1000;
            start++;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.size() - 1; i++) {
            result.append(res.get(i));
            result.append(" ");
        }
        
        result.append(res.get(res.size() - 1));
        
        return result.toString();
    }
    
    private ArrayList<String> helper(int n, String[] word, String[] ten, String[] tens) {
        int a = n / 100;
        n = n % 100;
        int b = n / 10;
        int c = n % 10;
        
        ArrayList<String> res = new ArrayList<String> ();
        if (a != 0) {
            res.add(word[a - 1]);
            res.add("Hundred");
        }
        if (b == 1) {
            res.add(ten[n - 10]);
        } else {
        	if (b >= 2) {
        		res.add(tens[b - 2]);
        	}
        	if (c != 0) {
        		res.add(word[c - 1]);
        	}
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	Integer_To_English_Words tmp = new Integer_To_English_Words();
    	int num = 1;
    	System.out.println(tmp.numberToWords(num));
    }
}
