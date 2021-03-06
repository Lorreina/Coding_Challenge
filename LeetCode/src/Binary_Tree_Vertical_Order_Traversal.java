import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode
 * 314. Binary Tree Vertical Order Traversal
 * @author lorreina
 *
 */
public class Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        
        if (root == null) {
            return res;
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>> ();
        
        int min = 0, max = 0;
        ArrayList<TreeNode> level = new ArrayList<TreeNode> ();
        ArrayList<Integer> levelIndex = new ArrayList<Integer> ();
        level.add(root);
        levelIndex.add(0);
        map.put(0, new ArrayList<Integer> ());
        map.get(0).add(root.val);
        
        while (!level.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode> ();
            ArrayList<Integer> nextLevelIndex = new ArrayList<Integer> ();
            for (int i = 0; i < level.size(); i++) {
                TreeNode curr = level.get(i);
                if (curr.left != null) {
                    int index = levelIndex.get(i) - 1;
                    nextLevel.add(curr.left);
                    nextLevelIndex.add(index);
                    if (map.containsKey(index)) {
                        map.get(index).add(curr.left.val);
                    } else{
                        ArrayList<Integer> list = new ArrayList<Integer> ();
                        list.add(curr.left.val);
                        min = index;
                        map.put(index, list);
                    }
                }
                
                if (curr.right != null) {
                    int index = levelIndex.get(i) + 1;
                    nextLevel.add(curr.right);
                    nextLevelIndex.add(index);
                    if (map.containsKey(index)) {
                        map.get(index).add(curr.right.val);
                    } else{
                        ArrayList<Integer> list = new ArrayList<Integer> ();
                        list.add(curr.right.val);
                        max = index;
                        map.put(index, list);
                    }
                }
            }
            level = nextLevel;
            levelIndex = nextLevelIndex;
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
