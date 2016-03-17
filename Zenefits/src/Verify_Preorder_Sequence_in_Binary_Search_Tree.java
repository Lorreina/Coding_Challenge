import java.util.Stack;

/**
 * LeetCode
 * 255. Verify Preorder Sequence in Binary Search Tree	
 * @author lorreina
 *
 */

public class Verify_Preorder_Sequence_in_Binary_Search_Tree {
	
	// Solution 1: using a stack with O(n) space complexity
	
//	public boolean verifyPreorder(int[] preorder) {
//        if (preorder == null || preorder.length <= 1) {
//            return true;
//        }
//        
//        Stack<Integer> stack = new Stack<Integer> ();
//        stack.push(preorder[0]);
//        
//        int minValue = Integer.MIN_VALUE;
//        for (int i = 1; i < preorder.length; i++) {
//            if (preorder[i] < minValue) {
//                return false;
//            }
//            if (preorder[i] < stack.peek()) {
//                stack.push(preorder[i]);
//            } else {
//                while (preorder[i] > stack.peek()) {
//                    minValue = stack.pop();
//                    if (stack.isEmpty()) {
//                        stack.push(preorder[i]);
//                        break;
//                    }
//                }
//                if (preorder[i] > minValue) {
//                    stack.push(preorder[i]);
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
	
	// Solution 2: O(1) space complexity
	// using the original preorder array as stack, use i as index flag
	public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        
        int minValue = Integer.MIN_VALUE;
        int i = -1;
        
        for (int p : preorder) {
            if (p < minValue) {
                return false;
            }
            
            while (i >= 0 && p > preorder[i]) {
                minValue = preorder[i];
                i--;
            }
            i++;
            preorder[i] = p;
        }
        
        return true;
    }
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
