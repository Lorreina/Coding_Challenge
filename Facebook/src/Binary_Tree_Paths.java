import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String> ();
        if (root == null) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
        }
        if (root.left != null) {
            helper(result, path, root.left);
        }
        if (root.right != null) {
            helper(result, path, root.right);
        }
        return result;
        
    }
    
    public static void helper(List<String> result, StringBuilder path, TreeNode node) {
        path.append("->");
        path.append(node.val);
        int len = Integer.toString(node.val).length();
        if (node.left == null && node.right == null) {
            result.add(path.toString());
            path.delete(path.length() - len - 2, path.length());
            return;
        }
        if (node.left != null) {
            helper(result, path, node.left);
        } 
        if (node.right != null) {
            helper(result, path, node.right);
        }
        path.delete(path.length() - len - 2, path.length());
    }
    
    public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(37);
    	root.left = new TreeNode(-34);
    	root.right = new TreeNode(-48);
    	root.left.right = new TreeNode(-100);
    	root.right.left = new TreeNode(-100);
    	root.right.right = new TreeNode(48);
    	root.right.right.left = new TreeNode(-54);
    	root.right.right.left.left = new TreeNode(-71);
    	root.right.right.left.right = new TreeNode(-22);
    	root.right.right.left.right.left = new TreeNode(8);
    	
    	List<String> result = binaryTreePaths(root);
    	for (int i = 0; i < result.size(); i++) {
    		System.out.println(result.get(i));
    	}
    }
}
