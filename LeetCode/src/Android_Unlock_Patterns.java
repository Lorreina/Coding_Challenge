/**
 * LeetCode
 * 351. Android Unlock Patterns
 * @author lorreina
 *
 */
public class Android_Unlock_Patterns {
    int sum = 0;
    public int numberOfPatterns(int m, int n) {
        boolean[] used = new boolean[9];
        used[0] = true;
        
        // start from 1. (* 4)
        dfs(used, m, n, 1, 0);
        int a = sum;
        sum = 0;
    
        used[0] = false;
        used[1] = true;
        
        // start from 2. (* 4)
        dfs(used, m, n, 1, 1);
        int b = sum;
        sum = 0;
        
        used[1] = false;
        used[4] = true;
        // start from 5.
        dfs(used, m, n, 1, 4);
        int c = sum;
        
        return a * 4 + b * 4 + c;
        
    }
    
    private void dfs(boolean[] used, int m, int n, int k, int curr) {
        if (k >= m) {
            sum += 1;
            if (k == n) {
                return;
            }
        }
        
        int i = curr / 3;
        int j = curr % 3;
        
        for (int index = 0; index < 9; index++) {
            if (used[index] == true) {
                continue;
            }
            if (index - 2 == curr && j == 0) {
                if (used[index - 1] == false) {
                    continue;
                }
            } else if (index + 2 == curr && j == 2) {
                if (used[index + 1] == false) {
                    continue;
                }
            } else if (index - 6 == curr && i == 0) {
                if (used[index - 3] == false) {
                    continue;
                }
            } else if (index + 6 == curr && i == 2) {
            	if (used[index + 3] == false) {
            		continue;
            	}
            } else if ((curr == 0 && index == 8) ||
            		   (curr == 8 && index == 0) ||
            		   (curr == 2 && index == 6) ||
            		   (curr == 6 && index == 2)) {
                if (used[4] == false) {
                    continue;
                }
            }
            
            used[index] = true;
            dfs(used, m, n, k + 1, index);
            used[index] = false;
        }
        
        return;
    }
    
    public static void main(String[] args) {
    	Android_Unlock_Patterns tmp = new Android_Unlock_Patterns();
    	int m = 1, n = 3;
//    	System.out.println(tmp.numberOfPatterns(m, n));
    	int x = 3 / -5;
    	System.out.println(x);
    	
    }
}
