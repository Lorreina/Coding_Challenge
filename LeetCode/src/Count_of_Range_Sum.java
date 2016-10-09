import java.util.Arrays;

/**
 * LeetCode
 * 327. Count of Range Sum
 * @author lorreina
 *
 */
public class Count_of_Range_Sum {
	// Solution 3: Divide and Conquer + Merge Sort
	public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        
        
        // S(i, j) = sums[j + 1] - sum[i];
        
        long[] sums = new long[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        return helper(sums, 0, sums.length - 1, lower, upper);
    }
    
    private int helper(long[] nums, int start, int end, int lower, int upper) {
        if (start == end) {
            return 0;
        }
        if (start == end - 1) {
            long tmp = nums[end] - nums[start];
            // sort nums
            if (nums[end] < nums[start]) {
                long temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            if (tmp >= lower && tmp <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int mid = start + (end - start) / 2;
        int count = helper(nums, start, mid, lower, upper) + helper(nums, mid + 1, end, lower, upper);
        
        
        for (int i = start; i <= mid; i++) {
            long lo = lower + nums[i];
            long hi = upper + nums[i];
            
            int l = binarySearchLeft(nums, mid + 1, end, lo);
            int r = binarySearchRight(nums, mid + 1, end, hi);
    
            count += Math.max(r - l + 1, 0);
        }
        
        // merge sort
        long[] cache = new long[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                cache[k++] = nums[i++];
            } else {
                cache[k++] = nums[j++];
            }
        }
        
        while (i <= mid) {
            cache[k++] = nums[i++];
        }
        
        while (j <= end) {
            cache[k++] = nums[j++];
        }
        
        for (i = start; i <= end; i++) {
            nums[i] = cache[i - start];
        }
        
        return count;
    }
    
    private int binarySearchLeft(long[] nums, int start, int end, long target) {
        // find the index of the first element >= target
        
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }
    
    private int binarySearchRight(long[] nums, int start, int end, long target) {
        // find the index of the first element <= target
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1; 
            } else {
                end = mid;
            }
        }
        
        if (nums[end] > target) {
            return end - 1;
        } else {
            return end;
        }
    }
	
	
	// Solution 2: Divide and Conquer O(n(logn)^2)
    /*
	public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        
        return helper(nums, 0, nums.length - 1, lower, upper);
    }
    
    private int helper(int[] nums, int start, int end, int lower, int upper) {
        if (start == end) {
            if (nums[start] >= lower && nums[start] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int mid = start + (end - start) / 2;
        int count = helper(nums, start, mid, lower, upper) + helper(nums, mid + 1, end, lower, upper);
        long[] left = new long[mid - start + 1];
        long[] right = new long[end - mid];
        
        left[0] = nums[mid];
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + nums[mid - i];
        }
        right[0] = nums[mid + 1];
        for (int i = 1; i < right.length; i++) {
            right[i] = right[i - 1] + nums[mid + 1 + i];
        }
        
        count += findSum(left, right, lower, upper);
        
        return count;
    }
    
    private int findSum(long[] left, long[] right, int lower, int upper) {
        Arrays.sort(left);
        Arrays.sort(right);
        int count = 0;
        
        for (long num : left) {
            long lo = lower - num;
            long hi = upper - num;
            
            int l = binarySearchLeft(right, lo);
            int r = binarySearchRight(right, hi);
    
            count += Math.max(r - l + 1, 0);
        }
        
        return count;
    }
    
    private int binarySearchLeft(long[] nums, long target) {
        // find the index of the first element >= target
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }
    
    private int binarySearchRight(long[] nums, long target) {
        // find the index of the first element <= target
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1; 
            } else {
                end = mid;
            }
        }
        
        if (nums[end] > target) {
            return end - 1;
        } else {
            return end;
        }
    }
    */
	
	
	// Solution 1: Naive O(n^2) -> TLE
	/*
	public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        long[] dp = new long[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        
        // S(i, j) = dp[j + 1] - dp[i]
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                long diff = dp[j] - dp[i];
                if (diff >= lower && diff <= upper) {
                    count++;
                }
            }
        }
        
        return count;
    }
    */
}
