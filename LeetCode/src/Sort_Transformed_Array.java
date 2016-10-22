/**
 * LeetCode
 * 360. Sort Transformed Array
 * @author lorreina
 *
 */
public class Sort_Transformed_Array {
	// Version 2:
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int n = nums.length;
        int[] res = new int[n];
        
        
        if (a == 0) {
            if (b >= 0) {
                for (int i = 0; i < n; i++) {
                    res[i] = f(nums[i], a, b, c);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    res[i] = f(nums[n - i - 1], a, b, c);
                }
            }
            return res;
        }
        
        // when a != 0
        if (a < 0) {
            int i = 0, j = n - 1;
            int index = 0;
            while (i <= j) {
                int left = f(nums[i], a, b, c);
                int right = f(nums[j], a, b, c);
                if (left <= right) {
                    res[index++] = left;
                    i++;
                } else {
                    res[index++] = right;
                    j--;
                }
            }
        } else {
            int i = 0, j = n - 1;
            int index = n - 1;
            while (i <= j) {
                int left = f(nums[i], a, b, c);
                int right = f(nums[j], a, b, c);
                if (left >= right) {
                    res[index--] = left;
                    i++;
                } else {
                    res[index--] = right;
                    j--;
                }
            }
        }
        
        return res;
    }
    
    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    
    public static void main(String[] args) {
    	Sort_Transformed_Array tmp = new Sort_Transformed_Array();
    	int[] nums = {-4, -2, 2, 4};
    	int a = -1, b = 3, c = 5;
    	int[] res = tmp.sortTransformedArray(nums, a, b, c);
    	
    	for (int i = 0; i < res.length; i++) {
    		System.out.print(res[i]);
    		System.out.print(" ");
    	}
    }
	
	
	// Version 1
	/*
    int a;
    int b;
    int c;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length];
        this.a = a;
        this.b = b;
        this.c = c;
        
        if (a == 0) {
            if (b >= 0) {
                for (int i = 0; i < nums.length; i++) {
                    res[i] = b * nums[i] + c;
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    res[nums.length - 1 - i] = b * nums[i] + c;
                }
            }
            return res;
        } 
        
        double root = ((double) (-b)) / (a * 2);
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= root) {
                left = i - 1;
                break;
            }
        }
        int right = left + 1;
        
        int i = 0;
        while (left >= 0 && right < nums.length) {
            if ((nums[right] - root) > (root - nums[left])) {
                if (a < 0) {
                    res[nums.length - 1 - i] = getValue(nums[left]);
                } else {
                    res[i] = getValue(nums[left]);
                }
                left--;
            } else {
                if (a < 0) {
                    res[nums.length - 1 - i] = getValue(nums[right]);
                } else {
                    res[i] = getValue(nums[right]);
                }
                right++;
            }
            i++;
        }
        
        while (left >= 0) {
            if (a < 0) {
                res[nums.length - 1 - i] = getValue(nums[left]);
            } else {
                res[i] = getValue(nums[left]);
            }
            left--;
            i++;
        }
        
        while (right < nums.length) {
            if (a < 0) {
                res[nums.length - 1 - i] = getValue(nums[right]);
            } else {
                res[i] = getValue(nums[right]);
            }
            right++;
            i++;
        }
        
        return res;
    }
    
    private int getValue(int x) {
        return a * x * x + b * x + c;
    }
    
    */
}
