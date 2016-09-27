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
        if (end == start) {
            return start;
        }
        
        int mid = start + (end - start) / 2;
        boolean isBad = isBadVersion(mid);
        
        if (isBad == true) {
            return helper(start, mid);
        } else {
            return helper(mid + 1, end);
        }
    }

	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
}
