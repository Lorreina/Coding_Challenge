
public class Google_OA {
	public int solution(int X) {
        // write your code in Java SE 8
        String s = String.valueOf(X);
        char[] num = s.toCharArray();
        int i = 0;
        int replace = -1;
        while (i < num.length - 1) {
            int avg = (num[i] - '0' + num[i + 1] - '0' + 1) / 2;
            if (avg > num[i] - '0') {
                replace = i;
                break;
            } else if (avg < num[i] - '0') {
                i++;
            } else {
                int j = i + 2;
                for (j = i + 2; j < num.length; j++) {
                    if (num[j] != num[i + 1]) {
                        break;
                    }
                }
                if (j == num.length) {
                    replace = i;
                    break;
                } else if (num[j] > num[i + 1]) {
                    replace = i;
                    break;
                } else if (num[j] < num[i + 1]) {
                    i = j - 1;
                }
            }
        }
        
        if (replace == -1) {
            replace = num.length - 2;   
        }
        
        int avg = (num[replace] - '0' + num[replace + 1] - '0' + 1) / 2;
        
        String res = s.substring(0, replace) + avg + s.substring(replace + 2, s.length());
        
        return Integer.parseInt(res);
    }
	
	public static void main(String[] args) {
		Google_OA tmp = new Google_OA();
		int X = 432614;
		System.out.println(tmp.solution(X));
		
	}
}
