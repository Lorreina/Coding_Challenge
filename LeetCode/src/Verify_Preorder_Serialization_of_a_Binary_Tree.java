import java.util.ArrayList;

public class Verify_Preorder_Serialization_of_a_Binary_Tree {
	public static boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        if (preorder.equals("#")) {
            return true;
        }
        if (preorder.charAt(0) == '#') {
        	return false;
        }
        ArrayList<Integer> stack = new ArrayList<Integer> ();
        stack.add(0);
        
        for (int i = 1; i < preorder.length(); i++) {
        	char tmp = preorder.charAt(i);
        	if( tmp == ',' || (i > 0 && preorder.charAt(i - 1) >= '0' && tmp <= '9')) {
        		continue;
        	}
        	
        	while (!stack.isEmpty() && stack.get(stack.size() - 1) == 2) {
        		stack.remove(stack.size() - 1);
        	}
        	if (stack.isEmpty()) {
        		return false;
        	}
            if (preorder.charAt(i) == '#') {
               stack.set(stack.size() - 1, stack.get(stack.size() - 1) + 1);
            } else {
            	stack.set(stack.size() - 1, stack.get(stack.size() - 1) + 1);
            	stack.add(0);
            }
        }
        
        for (int i = 0; i < stack.size(); i++) {
        	if (stack.get(i) < 2) {
        		return false;
        	}
        }
        
        return true;
        
    }
	
	public static void main(String[] args) {
		String preorder = "9,#,92,#,#";
		if (isValidSerialization(preorder)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
