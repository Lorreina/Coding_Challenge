
/**
 * LeetCode
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author lorreina
 *
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        
        return helper(inorder, 0, postorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] inorder, int is, int[] postorder, int ps, int len) {
        if (len == 0) {
            return null;
        }
        
        int rootVal = postorder[ps + len - 1];
        TreeNode root = new TreeNode(rootVal);
        
        int index = indexOf(inorder, is, is + len, rootVal);
        root.left = helper(inorder, is, postorder, ps, index - is);
        root.right = helper(inorder, index + 1, postorder, ps + index - is, len - index + is - 1);
        
        return root;
    }
    
    private int indexOf(int[] nums, int start, int end, int target) {
        for (int i = start; i < end; i++) {
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
