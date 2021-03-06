import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 403. Frog Jump
 * @author lorreina
 *
 */
public class Frog_Jump {
	public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        if (stones[1] != 1) {
            return false;
        }
        HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap<Integer, LinkedHashSet<Integer>> ();
        
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new LinkedHashSet<Integer> ());
        }
        map.get(1).add(1);
        
        for (int i = 1; i < stones.length; i++) {
            LinkedHashSet<Integer> set = map.get(stones[i]);
            Iterator<Integer> itr = set.iterator();
            while (itr.hasNext()) {
                int step = (int)itr.next();
                for (int j = step - 1; j <= step + 1; j++) {
                    if (map.containsKey(stones[i] + j)) {
                        map.get(stones[i] + j).add(j);
                    }
                }
            }
        }
        
        LinkedHashSet<Integer> last = map.get(stones[stones.length - 1]);
        if (last == null || last.isEmpty()) {
            return false;
        }
        return true;
    
    }
}
