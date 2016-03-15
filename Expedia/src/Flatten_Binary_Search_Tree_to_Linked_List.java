import java.util.Stack;

public class Flatten_Binary_Search_Tree_to_Linked_List {
	public TreeNode flatten(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode> ();
		stack.push(root);
		
		TreeNode curr = root;
		TreeNode node = null;
		TreeNode head = new TreeNode(0);
		
		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				node = stack.pop();
				head.right = node;
				head = node;
				curr = node.right;
			}
		}
		
		return head.right;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
