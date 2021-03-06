import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 401. Binary Watch
 * @author lorreina
 *
 */
public class Binary_Watch {
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String> ();
        
        for (int i = 0; i <= num; i++) {
            helper(i, num - i, res);
        }
        
        return res;
    }
    
    private void helper(int h, int m, List<String> res) {
        if (h > 4 || m > 6 || h < 0 || m < 0) {
            return;
        }
        ArrayList<Integer> hours = new ArrayList<Integer> ();
        getNumber(hours, 4, h, 1, 0);
        ArrayList<Integer> minutes = new ArrayList<Integer> ();
        getNumber(minutes, 6, m, 1, 0);
        
        for (int i = 0; i < hours.size(); i++) {
            String hour = String.valueOf(hours.get(i));
            for (int j = 0; j < minutes.size(); j++) {
                String minute = String.valueOf(minutes.get(j));
                if (minute.length() == 1) {
                    minute = "0" + minute;
                }
                res.add(hour + ":" + minute);
            }
        }
    }
    
    private void getNumber(ArrayList<Integer> numbers, int n, int k, int flag, int number) {
    	if (k < 0) {
    		return;
    	}
    	if (n == 0) {
    		if (k == n) {
                numbers.add(number);
            }
    		return;
    	}
        
        
        getNumber(numbers, n - 1, k, flag << 1, number);
        getNumber(numbers, n - 1, k - 1, flag << 1, (number | flag));
        
        return;
    }
    
    public static void main(String[] args) {
    	Binary_Watch tmp = new Binary_Watch();
    	List<String> res = tmp.readBinaryWatch(1);
    	for (int i = 0; i< res.size(); i++) {
    		System.out.println(res.get(i));
    	}
    }
}
