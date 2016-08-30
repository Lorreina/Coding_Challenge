/**
 * 134. Gas Station
 * @author lorreina
 *
 */
public class Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int start = -1;
        int max = -1;
        int curr = 0;
        int sum = 0;
        int maxIndex = -1;
        int index = -1;
        
        for (int i = 0; i < gas.length; i++) {
            remain = gas[i] - cost[i];
            sum += remain;
            
            if ((curr + remain) >= 0) {
                curr = curr + remain;
                if (index == -1) {
                    index = i;
                }
            } else {
                if (start == -1) {
                    start = curr;
                }
                if (curr > max) {
                    max = curr;
                    maxIndex = index;
                }
                index = -1;
            }
        }
        
        if (sum < 0) {
            return -1;
        }
        
        if (index == 0) {
            return 0;
        }
        
        if (curr >= 0 && start >= 0) {
            if ((curr + start) > max) {
                return index;
            }
        }
        
        return maxIndex;
    }
}
