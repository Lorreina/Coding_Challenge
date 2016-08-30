/**
 * LeetCode
 * 165. Compare Version Numbers
 * @author lorreina
 *
 */
public class Compare_Version_Numbers {
	public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.min(v1.length, v2.length);
        
        for (int i = 0; i < len; i++) {
            int ver1 = Integer.parseInt(v1[i]);
            int ver2 = Integer.parseInt(v2[i]);
            if (ver1 > ver2) {
                return 1;
            } else if (ver1 < ver2) {
                return -1;
            }
        }
        
        if (v1.length > v2.length) {
            // check if all the remaining of array is all zero.
            if (checkZero(v1, v2.length)) {
                return 0;
            } else {
                return 1;
            }
        } else if (v1.length < v2.length){
            if (checkZero(v2, v1.length)) {
                return 0;
            }
            return -1;
        } else {
            return 0;
        }
    }
    
    private boolean checkZero(String[] v1, int start) {
        for (int i = start; i < v1.length; i++) {
            int num = Integer.parseInt(v1[i]);
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }
}
