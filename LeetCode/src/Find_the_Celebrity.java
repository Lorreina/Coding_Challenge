import java.util.HashSet;

/**
 * LeetCode
 * 277. Find the Celebrity
 * @author lorreina
 *
 */
public class Find_the_Celebrity {
    public int findCelebrity(int n) {
        if (n == 1) {
            return 0;
        }
        HashSet<Integer> knows = new HashSet<Integer> ();
        int dontknow = -1;
        int celebrity = -1;
        
        if (knows(0, 1)) {
            celebrity = 1;
            knows.add(0);
        } else {
            celebrity = 0;
            dontknow = 1;
        }
        
        for (int i = 1 ; i < n; i++) {
            if (knows(i, celebrity)) {
                knows.add(i);
            } else {
                celebrity = i;
                dontknow = celebrity;
                knows.clear();
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i == celebrity) {
                continue;
            }
            // check if i knows celebrity
            if (!knows.contains(i)) {
                if (!knows(i, celebrity)) {
                    return -1;
                }
            }
            
            //check if celebeity doesn't know i
            if (i != dontknow) {
                if (knows(celebrity, i)) {
                    return -1;
                }
            }
        }
        
        return celebrity;
    }

	private boolean knows(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
}
