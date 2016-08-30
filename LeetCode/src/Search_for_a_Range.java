/**
 * LeetCode
 * 34. Search for a Range
 * @author lorreina
 *
 */
public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            int [] res = {-1, -1};
            return res;
        }
        return helper(nums, target, 0, nums.length -1);
    }
    
    private int[] helper(int[] nums, int target, int start, int end) {
        int[] res = new int[2];
        if (end - start <= 1) {
            if (nums[start] == target && nums[end] == target) {
                res[0] = start;
                res[1] = end;
            } else if (nums[start] == target) {
                res[0] = start;
                res[1] = start;
            } else if (nums[end] == target) {
                res[0] = end;
                res[1] = end;
            } else {
                res[0] = -1;
                res[1] = -1;
            }
            
            return res;
        }
        
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            if (nums[mid - 1] == target) {
                res[0] = searchLeft(nums, target, start, mid - 1);
            } else {
                res[0] = mid;
            }
            
            if (nums[mid + 1] == target) {
                res[1] = searchRight(nums, target, mid + 1, end);
            } else {
                res[1] = mid;
            }
        } else if (nums[mid] > target) {
            return helper(nums, target, start, mid - 1);
        } else {
            return helper(nums, target, mid + 1, end);
        }
        
        return res;
    }
    
    private int searchLeft(int[] nums, int target, int start, int end) {
        if (end == start) {
            return start;
        }
        if (end - start == 1) {
            if (nums[start] == target) {
                return start;
            } else {
                return end;
            }
        }
        
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return searchLeft(nums, target, start, mid);
        } else {
            return searchLeft(nums, target, mid + 1, end);
        }
    }
    
    private int searchRight(int[] nums, int target, int start, int end) {
        if (end == start) {
            return start;
        }
        
        if (end - start == 1) {
            if (nums[end] == target) {
                return end;
            } else {
                return start;
            }
        }
        
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return searchRight(nums, target, mid, end);
        } else {
            return searchRight(nums, target, start, mid - 1);
        }
    }
}
