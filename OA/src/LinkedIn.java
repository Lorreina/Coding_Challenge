import java.util.HashMap;

public class LinkedIn {
	static long kSub(int k, int[] nums) {
        if (k == 0 || nums == null || nums.length == 0)
                return 0;
        long ans = 0;
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else
                map.put(sum, (long)1);
        }
        for (int i : map.keySet()) {
            long tmp = map.get(i);
            ans += tmp * (tmp - 1) / 2;
        }
        if (map.containsKey(0))
            ans += map.get(0);
        return ans;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,1};
		int k = 3;
		System.out.println(kSub(k, arr));
	}
}
