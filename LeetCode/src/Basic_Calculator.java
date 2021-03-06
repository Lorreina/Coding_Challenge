import java.util.Stack;

/**
 * LeetCode
 * 224. Basic Calculator
 * @author lorreina
 *
 */
public class Basic_Calculator {
	public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> nums = new Stack<Integer> ();
        Stack<Character> op = new Stack<Character> ();
        char[] ch = s.toCharArray();
        
        int i = 0;
        for (; i < ch.length; i++) {
            if (ch[i] != ' ') {
                break;
            }
        }
        
        if (ch[i] != '-') {
            op.push('+');
        }
        
        boolean isNumber = false;
        int number = 0;
        for (; i < ch.length; i++) {
            if (ch[i] == ' ') {
                continue;
            }
            if (ch[i] == '(') {
                op.push('(');
            } else if (ch[i] >= '0' && ch[i] <= '9') {
                number = number * 10 + (ch[i] - '0');
                isNumber = true;
            } else{
                // push a number of number stack
            	if (isNumber == true) {
            		nums.push(number);
                    number = 0;
                    isNumber = false;
            	}
                
                if (op.peek() == '(') {
                    op.push('+');
                }
                
                if (ch[i] == ')') {
                    // pop from both stack
                    int sum = 0;
                    while (true) {
                        char operator = op.pop();
                        if (operator == '(') {
                            nums.push(sum);
                  
                            break;
                        } else if (operator == '+') {
                            sum += nums.pop();
                        } else {
                            sum -= nums.pop();
                        }
                    }
                } else {
                    op.push(ch[i]);
                }
            }
        }
        
        if (isNumber) {
        	nums.push(number);
        }
        
        int sum = 0;
        while (!nums.isEmpty() && !op.isEmpty()) {
            char c = op.pop();
            if (c == '+') {
                sum += nums.pop();
            } else {
                sum -= nums.pop();
            }
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
		Basic_Calculator tmp = new Basic_Calculator();
		String s = " 2-1 + 2 ";
		System.out.println(tmp.calculate(s));
	}
}
