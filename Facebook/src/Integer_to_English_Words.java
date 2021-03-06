/**
 * LeetCode
 * 273. Integer to English Words
 * @company: Facebook
 * @author lorreina
 *
 */
public class Integer_to_English_Words {
	public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int count = 0;
        StringBuilder res = new StringBuilder();
        String[] unit = {"Thousand ", "Million ", "Billion ", "Trillion "};
        while (num > 0) {
            int tmp = num % 1000;
            num = num / 1000;
            
            if (count > 0 && tmp > 0) {
                res.insert(0, unit[count - 1]);
            }
            if (tmp > 0) {
                res.insert(0, helper(tmp));
            }
            count++;
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    
    private String helper(int num) {
        StringBuilder res = new StringBuilder();
        String[] one = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] ten = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] ty = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        
        int a = num / 100;
        num = num % 100;
        if (a > 0) {
            res.append(one[a - 1]);
            res.append("Hundred ");
        }
        int b = num / 10;
        num = num % 10;
        
        if (b == 1) {
            res.append(ten[num]);
        } else {
            if (b > 1) {
                res.append(ty[b - 2]);
            }
            if (num > 0) {
                res.append(one[num - 1]);
            }
        }
        
        return res.toString();
    }
}
