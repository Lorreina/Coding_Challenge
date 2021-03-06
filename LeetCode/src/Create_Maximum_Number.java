import java.util.ArrayList;

/**
 * LeetCode
 * 321. Create Maximum Number
 * @author lorreina
 *
 */
public class Create_Maximum_Number {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k <= 0) {
            return new int[0];
        }
        if (nums1 == null || nums1.length == 0) {
            return quickSolve(nums2, k);
        } else if (nums2 == null || nums2.length == 0) {
            return quickSolve(nums1, k);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int start1 = Math.max(0, m - k);
        int end1 = Math.min(m, m + n - k);
        int start2 = Math.max(0, n - k);
        int end2 = Math.min(n, m + n - k);
        
        int[] res = new int[k];
        
        ArrayList<Integer[]> part1 = generatePart(nums1, start1, end1);
        ArrayList<Integer[]> part2 = generatePart(nums2, start2, end2);
        
        for (int i = 0; i < (end1 - start1 + 1); i++) {
            Integer[] list1 = part1.get(i);
            Integer[] list2 = part2.get(part2.size() - i - 1);
            
            merge(list1, list2, res);
        }
        
        return res;
    }
    
    private void merge(Integer[] list1, Integer[] list2, int[] res) {
        int i = 0, j = 0;
        int p = 0, q = 0;
        boolean isGreat = false;
        int whichFirst = -1;
        int whichFirstTrue = -1;
        while (i < list1.length && j < list2.length) {
        	if (list1[i] == list2[j]) {
        		if (p - i != q - j || p <= i) {
        			p = i + 1;
            		q = j + 1;
            		while (p < list1.length && q < list2.length) {
            			if (list1[p] == list2[q]) {
            				q++;
            				p++;
            			} else {
            				break;
            			}
            		}
            		
            		if (p == list1.length) {
            			whichFirstTrue = 2;
            		} else if (q == list2.length) {
            			whichFirstTrue = 1;
            		} else if (list1[p] > list2[q]) {
            			whichFirstTrue = 1;
            		} else {
            			whichFirstTrue = 2;
            		}
            		
        		}
        		
        		whichFirst = whichFirstTrue;
            }
        	
            if (list1[i] > list2[j] || whichFirst == 1) {
            	whichFirst = -1;
                if (isGreat) {
                    res[i + j] = list1[i];
                } else {
                    if (list1[i] < res[i + j]) {
                        return;
                    } else if (list1[i] > res[i + j]) {
                        isGreat = true;
                        res[i + j] = list1[i];
                    }
                }
                i++;
            } else if (list1[i] < list2[j] || whichFirst == 2) {
            	whichFirst = -1;
                if (isGreat) {
                    res[i + j] = list2[j];
                } else {
                    if (list2[j] < res[i + j]) {
                        return;
                    } else if (list2[j] > res[i + j]) {
                        isGreat = true;
                        res[i + j] = list2[j];
                    }
                }
                j++;
            }
        }
        
        while (i < list1.length) {
            if (isGreat) {
                res[i + j] = list1[i];
            } else {
                if (list1[i] < res[i + j]) {
                    return;
                } else if (list1[i] > res[i + j]) {
                    isGreat = true;
                    res[i + j] = list1[i];
                }
            }
            i++;
        }
        
        while (j < list2.length) {
            if (isGreat) {
                res[i + j] = list2[j];
            } else {
                if (list2[j] < res[i + j]) {
                    return;
                } else if (list2[j] > res[i + j]) {
                    isGreat = true;
                    res[i + j] = list2[j];
                }
            }
            j++;
        }
        
        return;
    }
    
    private ArrayList<Integer[]> generatePart(int[] nums, int start, int end) {
        ArrayList<Integer[]> res = new ArrayList<Integer[]> ();
        ArrayList<Integer> list = new ArrayList<Integer> ();
        
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        
        if (start == 0) {
        	res.add(list.toArray(new Integer[list.size()]));
        }
        
        int p = 0;
        for (int i = 1; i <= end; i++) {
        	while (p < list.size() - 1 && list.get(p) >= list.get(p + 1)) {
    			p++;
    		}
    		list.remove(p);
    		if (p > 0) {
    			p--;
    		}
    		if (i >= start) {
    			res.add(list.toArray(new Integer[list.size()]));
    		}
    	}
        
    	return res;
    }
    
    private int[] quickSolve(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        if (k == nums.length) {
        	return nums;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        
        int p = 0;
        for (int i = 1; i <= (nums.length - k); i++) {
        	while (p < list.size() - 1 && list.get(p) >= list.get(p + 1)) {
    			p++;
    		}
    		list.remove(p);
    		if (p > 0) {
    			p--;
    		}
    	}
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
        	res[i] = list.get(i);
        }
        
        
        return res;
    }
    
	public static void main(String[] args) {
//		int[] nums1 = {3,4,6,5};
//		int[] nums2 = {9,1,2,5,8,3};
		int[] nums1 = {2,5,6,4,4,0};
		int[] nums2 = {7,3,8,0,6,5,7,6,2};
		int k = 15;
//		int[] nums1 = {3,8,1,4,5,4,6,8,2,6,0,6,9,1,8,0,2,6,3,9,5,2,4,7,8,8,0,3,6};
//		int[] nums2 = {2,6,0,3,4};
//		int k = 34;
//		int[] nums1 = {2,1,7,8,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5};
//		int[] nums2 = {2,6,2,0,1,0,5,4,5,5,3,3,3,4};
//		int k = 35;
		Create_Maximum_Number tmp = new Create_Maximum_Number();
		int[] res = tmp.maxNumber(nums1, nums2, k);
		for (int i = 0 ; i < res.length; i++) {
			System.out.print(res[i]);
			System.out.print("  ");
		}
	}
}
