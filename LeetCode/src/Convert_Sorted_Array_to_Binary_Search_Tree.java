
/**
 * LeetCode
 * 108. Convert Sorted Array to Binary Search Tree
 * @author lorreina
 *
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
	
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (end == start) {
            return new TreeNode(nums[start]);
        }
        
        if (end == start + 1) {
            TreeNode curr = new TreeNode(nums[end]);
            curr.left = new TreeNode(nums[start]);
            return curr;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        
        return root;
    }
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
