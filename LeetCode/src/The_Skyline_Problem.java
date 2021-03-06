import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode
 * 218. The Skyline Problem
 * @author lorreina
 *
 */
public class The_Skyline_Problem {
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]> ();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        
        // sort building according to height in ascending order
        Arrays.sort(buildings, new Comparator<int[]> () {
           public int compare(int[] a1, int[] a2) {
               return Integer.compare(a1[2], a2[2]);
           } 
        });
        
        SegmentTreeNode root = new SegmentTreeNode(0, Integer.MAX_VALUE, 0);
        
        for (int i = 0; i < buildings.length; i++) {
            addBuilding(buildings[i][0], buildings[i][1], buildings[i][2], root);
        }
        
        int i = 0;
        int lastHeight = 0;
        while (i < Integer.MAX_VALUE) {
            int[] pair = new int[2];
            findHeight(root, i, pair);
            if (pair[1] != lastHeight) {
                lastHeight = pair[1];
                int tmp = pair[0];
                pair[0] = i;
                i = tmp;
                res.add(pair);
            } else {
            	i = pair[0];
            }
        }
        
        if (lastHeight != 0) {
        	int[] pair = {Integer.MAX_VALUE, 0};
        	res.add(pair);
        }
        
        return res;
    }

    
    private void findHeight(SegmentTreeNode root, int index, int[] pair) {  
    	while (root.isSame != true) {
        	if (index < root.left.hi) {
        		root = root.left;
        	} else {
        		root = root.right;
        	}
        }
        
        pair[1] = root.height;
        pair[0] = root.hi;
        return;
        
    }
    
    private void addBuilding(int lo, int hi, int height, SegmentTreeNode root) {
    	if (root.lo == lo && root.hi == hi) {
        	root.isSame = true;
            root.height = height;
            return;
        }
        if (height == root.height && root.isSame == true) {
        	return;
        }
        
        if (root.left == null) {
            int mid = root.lo + (root.hi - root.lo) / 2;
            root.left = new SegmentTreeNode(root.lo, mid, root.height);
            root.right = new SegmentTreeNode(mid, root.hi, root.height);
        } else {
        	root.left.height = Math.max(root.height, root.left.height);
	        root.right.height = Math.max(root.height, root.right.height);
	        if (root.isSame) {
	        	root.left.isSame = true;
	        	root.right.isSame = true;
	        }
        }
        root.isSame = false;
        
        if (hi <= root.left.hi) {
            addBuilding(lo, hi, height, root.left);
        } else if (lo >= root.right.lo) {
            addBuilding(lo, hi, height, root.right);
        } else {
            addBuilding(lo, root.left.hi, height, root.left);
            addBuilding(root.right.lo, hi, height, root.right);
        }
        
        if (root.left.height > 0 && root.left.height == root.right.height && root.left.isSame && root.right.isSame) {
            root.height = root.left.height;
            root.isSame = true;
        }
    }
    
    class SegmentTreeNode {
        int lo;
        int hi;
        int height;
        boolean isSame;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        public SegmentTreeNode(int lo, int hi, int height) {
            this.lo = lo;
            this.hi = hi;
            this.height = height;
            this.isSame = true;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(String[] args) {
    	The_Skyline_Problem tmp = new The_Skyline_Problem();
//    	int[][] buildings = {{2,9,10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//    	int[][] buildings = {{0, Integer.MAX_VALUE, Integer.MAX_VALUE}};
    	int[][] buildings = {{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
    	List<int[]> res = tmp.getSkyline(buildings);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.print("[");
    		System.out.print(res.get(i)[0]);
    		System.out.print(", ");
    		System.out.print(res.get(i)[1]);
    		System.out.print("], ");
    	}
    }
}
