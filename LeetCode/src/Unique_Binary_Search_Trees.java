/**
 * LeetCode
 * 96. Unique Binary Search Trees
 * @author lorreina
 *
 */
public class Unique_Binary_Search_Trees {
	public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        
        return result[n];
    }
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
