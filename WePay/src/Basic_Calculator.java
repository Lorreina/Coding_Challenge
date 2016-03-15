import java.util.Stack;

public class Basic_Calculator {
	/** 
	 * Using two stacks.
	 * @param s
	 * @return
	 */
	/*
	public int calculate(String s) {
        Stack<Character> op = new Stack<Character> ();
        Stack<Integer> nums = new Stack<Integer> ();
        int i = 0;
        int start = 0;
        boolean isNum = false;
        while (i < s.length()) {
            char tmp = s.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                if (!isNum) {
                    start = i;
                    isNum = true; 
                }
                i++;
                continue;
            } else {
                if (isNum) {
                    nums.push(Integer.parseInt(s.substring(start, i)));
                    isNum = false;
                }
                i++;
                if (tmp == ' ') {
                    continue;
                }
                if (tmp == ')') {
                    int sum = 0;
                    while (!op.isEmpty()) {
                        int operator = op.pop();
                        if (operator == '+') {
                            sum = sum + nums.pop();
                        } else if (operator == '-') {
                            sum = sum - nums.pop();
                        } else {
                            sum = sum + nums.pop();
                            break;
                        }
                    }
                    nums.push(sum);
                } else {
                    op.push(tmp);
                }
            }
        }
        if (isNum) {
            nums.push(Integer.parseInt(s.substring(start, i)));
        }
        int sum = 0;
        while (!op.isEmpty()) {
            if (op.pop() == '+') {
                sum = sum + nums.pop();
            } else {
                sum = sum - nums.pop();
            }
        }
        sum = sum + nums.pop();
        return sum;
    }
    */
	/**
	 * Using only one stack.
	 * @param s
	 * @return
	 */
	 public int calculate(String s) {
	
	    Stack<Integer> signs = new Stack<Integer> ();
	    int sum = 0;
	    int i = 0;
	    int start = 0;
	    boolean isNum = false;
	    int current = 1;
	    signs.push(current);
	    
	    while (i < s.length()) {
	        char tmp = s.charAt(i);
	        if (tmp >= '0' && tmp <= '9') {
	        if (!isNum) {
	            start = i;
	            isNum = true; 
	        }
	        i++;
	        continue;
	    } else {
	        if (isNum) {
	            int num = Integer.parseInt(s.substring(start, i));
	            isNum = false;
	            sum = sum + num * current;
	        }
	        i++;
	        if (tmp == ' ') {
	            continue;
	        }
	        if (tmp == '(') {
	            signs.push(current);
	        } else if (tmp == ')') {
	            signs.pop();
	        } else if (tmp == '-') {
	                current = -signs.peek();
	            } else {
	                current = signs.peek();
	            }
	        }
	    }
	    if (isNum) {
	        int num = Integer.parseInt(s.substring(start, i));
	        sum = sum + num * current;
	    }
	    
	    return sum;
	}
}
