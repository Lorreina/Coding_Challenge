/**
 * LeetCode
 * 4. Median of Two Sorted Arrays
 * @author lorreina
 *
 */
public class Median_of_two_sorted_arrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int remain = (length - 1) / 2;
        boolean isTwo = true;
        if (length % 2 == 1) {
            isTwo = false;
        }
        
        double result = 0.0;
        int start1 = 0;
        int start2 = 0;
        
        // if (remain == 0) {
        //     if (nums1.length == 0) {
        //         result =  nums2[0];
        //         start2 = 1;
        //     } else if (nums2.length == 0) {
        //         result =  nums1[0];
        //         start1 = 1;
        //     } else {
        //         return (double) (nums1[0] + nums2[0]) / 2;
        //     }
        // }
        
        while (remain > 0 && start1 < nums1.length && start2 < nums2.length) {
            int median1 = start1 + (nums1.length - start1) / 2;
            int median2 = start2 + (nums2.length - start2) / 2;
            
            if (start1 == median1 && start2 == median2) {
                if (nums1[median1] <= nums2[median2]) {
                    start1++;
                    // result = nums1[median1];
                    remain = remain - 1;
                } else {
                    start2++;
                    // result = nums2[median2];
                    remain = remain - 1;
                }
            } else if (start1 == median1) {
                if (nums1[median1] <= nums2[median2 - 1]) {
                    start1++;
                    // result = nums1[median1];
                    remain = remain - 1;
                } else {
                    if ((median2 - start2) < remain) {
                        // result = nums2[median2];
                        remain = remain - (median2 - start2);
                        start2 = median2;
                    } else {
                        // result = nums2[start2 + remain - 1];
                        start2 = start2 + remain;
                        remain = 0;
                        break;
                    }
                }
            } else if (start2 == median2) {
                if (nums2[median2] <= nums1[median1 - 1]) {
                    start2++;
                    // result = nums2[median2];
                    remain = remain - 1;
                } else {
                    if ((median1 - start1) < remain) {
                        // result = nums1[median1];
                        remain = remain - (median1 - start1);
                        start1 = median1;
                    } else {
                        // result = nums1[start1 + remain - 1];
                        start1 = start1 + remain;
                        remain = 0;
                        break;
                    }
                }
            } else {
                if (nums1[median1 - 1] <= nums2[median2 - 1]) {
                    if ((median1 - start1) < remain) {
                        // result = nums1[median1];
                        remain = remain - (median1 - start1);
                        start1 = median1;
                    } else {
                        // result = nums1[start1 + remain - 1];
                        start1 = start1 + remain;
                        remain = 0;
                        break;
                    }
                } else {
                    if ((median2 - start2) < remain) {
                        // result = nums2[median2];
                        remain = remain - (median2 - start2);
                        start2 = median2;
                    } else {
                        // result = nums2[start2 + remain - 1];
                        start2 = start2 + remain;
                        remain = 0;
                        break;
                    }
                }
            }
        }
        
        // if (start1 < nums1.length && start2 < nums2.length) {
        //     result = Math.min(nums1[start1], nums2[start2]);
        // } else if (start1 < nums1.length) {
        //     result = nums1[start1];
        //     start1++;
        // } else {
        //     result = nums2[start2];
        //     start2++;
        // }
        
        // if (remain != 0) {
        //     if (start1 < nums1.length) {
        //         result = nums1[start1 + remain];
        //         start1 = start1 + remain + 1;
        //     } else {
        //         result = nums2[start2 + remain];
        //         start2 = start2 + remain + 1;
        //     }
        // } else {
        //     result = Math.min(nums1[start1], nums2[start2]);
        // }
        
        if (start1 >= nums1.length) {
            result = nums2[start2 + remain];
            start2 = start2 + remain + 1;
        } else if (start2 >= nums2.length) {
            result = nums1[start1 + remain];
            start1 = start1 + remain + 1;
        } else {
            if (nums1[start1] >= nums2[start2]) {
                result = nums2[start2];
                start2++;
            } else {
                result = nums1[start1];
                start1++;
            }
        }
        
        if (isTwo == true) {
            if (start1 >= nums1.length) {
                result = (result + nums2[start2]) / 2;
            } else if (start2 >= nums2.length) {
                result = (result + nums1[start1]) / 2;
            } else {
                result = (result + Math.min(nums1[start1], nums2[start2])) / 2;
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {1,1};
		double x = findMedianSortedArrays(nums1, nums2);
		System.out.println(x);
	}
}
