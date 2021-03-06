import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * LeetCode
 * 365. Water and Jug Problem
 * @author lorreina
 *
 */
public class Water_and_Jug_Problem {
//	public boolean canMeasureWater(int x, int y, int z) {
//        if (z < 0) {
//            return false;
//        }
//        
//        if (z == 0) {
//            return true;
//        }
//        
//        if (x == y) {
//            if (z == x) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        
//        if (z == x || z == y || z == (x + y)) {
//            return true;
//        }
//        
//        if (z > (x + y)) {
//            return false;
//        }
//        
//        if (x > y) {
//            return helper(y, x, z);
//        } else {
//            return helper(x, y, z);
//        }
//    }
//    
//    private boolean helper(int x, int y, int z) {
//        if (x == 0) {
//            return (z == y);
//        }
//        int water = z % x;
//        if (water == y % x) {
//        	return true;
//        }
//        HashSet<Integer> set = new HashSet<Integer> ();
//        
//        
//        Queue<Integer> queue = new ArrayDeque<Integer> ();
//        queue.offer(0);
//        set.add(0);
//        
//        while (!queue.isEmpty()) {
//        	int n = queue.poll();
//        	if (n == water || z == n + y) {
//        		return true;
//        	}
//        	int n1 = (y - (x - n)) % x;
//        	if (!set.contains(n1)) {
//        		queue.add(n1);
//        		set.add(n1);
//        	}
//        	int n2 = x - (y - n) % x;
//        	if (!set.contains(n2)) {
//        		queue.add(n2);
//        		set.add(n2);
//        	}
//        }
//        
//        return false;
//    }
    
	// math solution
	public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0) {
            return false;
        }
        
        if (z == 0) {
            return true;
        }
        
        if (z == x || z == y || z == (x + y)) {
            return true;
        }
        
        if (z > (x + y)) {
            return false;
        }
        
        return (z % gcd(x, y) == 0);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        
        return a;
    }
	
    public static void main(String[] args) {
    	Water_and_Jug_Problem tmp = new Water_and_Jug_Problem();
    	int x = 3;
    	int y = 5;
    	int z = 4;
    	System.out.println(tmp.canMeasureWater(x, y, z));
    }
}
