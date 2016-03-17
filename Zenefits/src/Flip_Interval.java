import java.util.ArrayList;

public class Flip_Interval {
	public static ArrayList<Integer> flip(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		int start = 0;
		int maxCount = 0;
		int flipLen = 0;
		
		int left = 0;
		int count = 0;
		
		for (int i = 0; i< nums.length; i++) {
			if (count == 0) {
				if (nums[i] == 1) {
					continue;
				} else {
					left = i;
					count = 1;
					if (maxCount < 1) {
						maxCount = 1;
						start = i;
						flipLen = 1;
					}
				}
			} else {
				if (nums[i] == 1) {
					count--;
				} else {
					count++;
					if (maxCount < count) {
						maxCount = count;
						start = left;
						flipLen = i - left + 1;
					}
				}
			}
		}
		
		result.add(start);
		result.add(flipLen);
		result.add(maxCount);

		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,0,0};
		System.out.println(flip(nums));
	}
}
