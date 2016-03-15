import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Single_Number_III {
	
	/* Version 1: using bit operation with O(n) time and O(1) space */
	public static int[] singleNumber(int[] nums) {
		int[] result = new int[2];
		if (nums == null || nums.length == 0) {
            return result;
        }
		
		result[0] = 0;
		result[1] = 0;
		int x = 0;
		
		for (int i = 0; i < nums.length; i++) {
			x = x ^ nums[i];
		}
		
		// find the last difference digit between the two single number.
		x = x & (-x);
		int flag = x;
		for (int i = 0; i < 32; i++) {
			if ((x & 1) == 1) {
				flag = flag & (1 << i);
				break;
			} else {
				x = x >> 1;
			}
		}
		
		
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & flag) == 0) {
				result[0] = result[0] ^ nums[i];
			} else {
				result[1] = result[1] ^ nums[i];
			}
		}
			
		return result;
	}
	
	
	/* Version 2: using HashMap with extra O(n) space.
	public int[] singleNumber(int[] nums) {
		int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator<Integer> itr = map.keySet().iterator();
        
        result[0] = (int) itr.next();
        result[1] = (int) itr.next();
        
        return result;
    }
    */
	
	public static void main(String[] args) {
		int nums[] = {1, 2, 1, 3, 5, 2};
		System.out.println(Arrays.toString(singleNumber(nums)));
	}
}
