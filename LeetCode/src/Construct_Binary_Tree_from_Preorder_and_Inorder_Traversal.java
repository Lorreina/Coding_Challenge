/**
 * LeetCode
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * @author lorreina
 *
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        return helper(preorder, 0, inorder, 0, preorder.length);
    }
    
    private TreeNode helper(int[] preorder, int ps, int[] inorder, int is, int len) {
        if (len == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[ps]);
        if (len == 1) {
            return root;
        }
        
        int index = indexOf(inorder, preorder[ps], is, is + len - 1);
        root.left = helper(preorder, ps + 1, inorder, is, index - is);
        root.right = helper(preorder, ps + index - is + 1, inorder, index + 1, is + len - 1 - index);
        
        return root;
    }
    
    private int indexOf(int[] nums, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
	}
}
