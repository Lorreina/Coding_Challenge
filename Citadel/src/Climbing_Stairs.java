
public class Climbing_Stairs {
	public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        
        if (n == 1) {
        	return 1;
        }

        int[] solution = new int[n];
        solution[0] = 1;
        solution[1] = 2;
        
        for (int i = 2; i < n; i++) {
        	solution[i] = solution[i-2] + solution[i - 1];
        }
        return solution[n - 1];
    }
}
