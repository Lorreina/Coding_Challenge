/**
 * LeetCode
 * 45. Jump Game II
 * @author lorreina
 *
 */
public class Jump_Game_II {
	public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int[] steps = new int[nums.length];
        
        int far = 0;
        int maxStep = 0;
        int n = nums.length - 1;
        
        for (int i = 0; i < nums.length; i++) {
            int next = i + nums[i];
            if (next >= n) {
                return 1 + steps[i];
            } else if (next > far) {
                for (int k = far + 1; k <= next; k++) {
                    steps[k] = steps[i] + 1;
                }
                far = next;
                maxStep = steps[i] + 1;
            } else {
                if (steps[next] == 0) {
                    steps[next] = maxStep;
                } else {
                    steps[next] = Math.min(steps[next], maxStep);
                }
            }
        }
        
        return steps[n];
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 4, 5};
		Jump_Game_II tmp = new Jump_Game_II();
		System.out.println(tmp.jump(nums));
	}
}
