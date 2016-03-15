
public class Single_Number_II {
	
	/* Version 1: using bit operation with O(n) time and O(1) space */
	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return (Integer) null;
		}
		
		int[] digit = new int [32];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 31; j >= 0; j--) {
				digit[j] += (nums[i] & 1);
				nums[i] = nums[i] >> 1;
			}
		}
		
		int single = 0;
		for (int i = 0; i < 32; i++) {
			single = single | ((digit[31 - i] % 3) << i);
		}
			
		return single;
	}
	
	
	/* Version 1 using HashMap with O(n) extra space
	public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (Integer) null;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) == 2) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return map.keySet().iterator().next();
    }
    */
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(singleNumber(nums));
	}
}
