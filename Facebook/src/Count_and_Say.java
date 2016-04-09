
public class Count_and_Say {
	public String countAndSay(int n) {
        String init = "1";
        for (int i = 0; i < n - 1; i++) {
            init = helper(init);
        }
        
        return init;
    }
    
    public String helper(String s) {
        StringBuilder result = new StringBuilder();
        char[] num = s.toCharArray();
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == num[i - 1]) {
                count++;
            } else {
                result.append(count);
                result.append(num[i - 1]);
                count = 1;
            }
        }
        
        result.append(count);
        result.append(num[num.length - 1]);
        
        return result.toString();
    }
}
