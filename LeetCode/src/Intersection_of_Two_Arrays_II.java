/**
 * LeetCode
 * 350. Intersection of Two Arrays II
 * @author lorreina
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_of_Two_Arrays_II {
	public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer> ();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        
        int[] result = new int[res.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = res.get(k);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1};
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}
}
