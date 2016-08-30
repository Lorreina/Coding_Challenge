/**
 * LeetCode
 * 370. Range Addition
 * @author lorreina
 *
 */
public class Range_Addition {
	public int[] getModifiedArray(int length, int[][] updates) {
        int [] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            res[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < length) {
                res[updates[i][1] + 1] -= updates[i][2];
            }
        }
        
        int sum = 0;
        for (int j = 0; j < length; j++) {
            res[j] += sum;
            sum = res[j];
        }
        
        return res;
    }
}
