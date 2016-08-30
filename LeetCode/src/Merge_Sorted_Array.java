
public class Merge_Sorted_Array {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        
        while (true) {
            if (i < 0 || j < 0) {
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums1[i + j + 1] = nums2[j];
                j--;
            } else {
                nums1[i + j + 1] = nums1[i];
                i--;
            }
        }
        
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
        
        return;
    }
}
