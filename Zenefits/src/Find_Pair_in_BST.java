import java.util.Stack;

public class Find_Pair_in_BST {
	public static boolean isPairPresent(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		// Create two stacks. s1 is used for normal inorder traversal
	    // and s2 is used for reverse inorder traversal
		Stack<TreeNode> stack1 = new Stack<TreeNode> ();
		Stack<TreeNode> stack2 = new Stack<TreeNode> ();
		
		// done1, val1 and curr1 are used for normal inorder traversal using s1
	    // done2, val2 and curr2 are used for reverse inorder traversal using s2
		boolean done1 = false, done2 = false;
		int val1 = 0, val2 = 0;
		
		TreeNode curr1 = root, curr2 = root;
		
		// The loop will break when we either find a pair or one of the two
	    // traversals is complete
		while (true) {
			// Find next node in normal Inorder traversal. See following post
			while (done1 == false) {
				if (curr1 != null) {
					stack1.push(curr1);
					curr1 = curr1.left;
				} else {
					if (stack1.isEmpty()) {
						done1 = true;
					} else {
						curr1 = stack1.pop();
						val1 = curr1.val;
						curr1 = curr1.right;
						done1 = true;
					}
				}
			}
			
			// Find next node in REVERSE Inorder traversal. The only
	        // difference between above and below loop is, in below loop
	        // right subtree is traversed before left subtree
			while (done2 == false) {
				if (curr2 != null) {
					stack2.push(curr2);
					curr2 = curr2.right;
				} else {
					if (stack2.isEmpty()) {
						done2 = true;
					} else {
						curr2 = stack2.pop();
						val2 = curr2.val;
						curr2 = curr2.left;
						done2 = true;
					}
				}
			}
			
			// If we find a pair, then print the pair and return. The first
	        // condition makes sure that two same values are not added
			if (val1 != val2 && (val1 + val2 == k)) {
				return true;
			}
			
			// If any of the inorder traversals is over, then there is no pair
	        // so return false
			if (val1 >= val2) {
				return false;
			}
			
			// If sum of current values is smaller, then move to next node in
	        // normal inorder traversal
			if (val1 + val2 < k) {
				done1 = false;
			} else {
				// If sum of current values is greater, then move to next node in
		        // reverse inorder traversal
				done2 = false;
			}
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		
		System.out.println(isPairPresent(root, 18));
	}
}
