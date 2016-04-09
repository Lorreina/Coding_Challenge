/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
 * LeetCode
 * 278. First Bad Version
 * @author lorreina
 *
 */
public class First_Bad_Version {
	public int firstBadVersion(int n) {
        return helper(1, n);
    }
    
    private int helper(int start, int end) {
        if (start == end) {
            return start;
        } else if (end - start == 1) {
            if (isBadVersion(start)) {
                return start;
            } else {
                return end;
            }
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return helper(start, mid);
        } else {
            return helper(mid + 1, end);
        }
    }
    
    private boolean isBadVersion(int version) {
    	return true;
    }
}
