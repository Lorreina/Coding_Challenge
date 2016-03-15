import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ValidBST {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++){
			int node = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < node; j++) {
				list.add(sc.nextInt());
			}
			if(isValidBST(list)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
    }

	private static boolean isValidBST(ArrayList<Integer> list) {
		if (list.size() == 1) {
			return true;
		}
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(list.get(0));
		
		int minValue = Integer.MIN_VALUE;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < minValue) {
				return false;
			}
			if (list.get(i) < stack.peek()) {
				stack.push(list.get(i));
			} else {
				while (list.get(i) > stack.peek()) {
					minValue = stack.pop();
					if (stack.isEmpty()) {
						stack.push(list.get(i));
						break;
					}
				}
				if (list.get(i) > minValue) {
					stack.push(list.get(i));
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
