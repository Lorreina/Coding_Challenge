import java.util.ArrayDeque;

/**
 * LeetCode
 * 302. Smallest Rectangle Enclosing Black Pixels
 * @author lorreina
 *
 */
public class Smallest_Rectangle_Enclosing_Black_Pixels {
	// Solution 2: Binary Search
	// binray search for top/bottom rows and left/right cols.
	int m;
    int n;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        m = image.length;
        n = image[0].length;
        int left = searchLeft(image, 0, y);
        int right = searchRight(image, y, n);
        int top = searchTop(image, 0, x);
        int bottom = searchBottom(image, x, m);
        
        return (right - left) * (bottom - top);
    }
    
    private int searchLeft(char[][] image, int left, int right) {
        while (left < right) {
            int k = 0;
            int mid = left + (right - left) / 2;
            while (k < m && image[k][mid] == '0') {
                k++;
            }
            if (k == m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int searchRight(char[][] image, int left, int right) {
        while (left < right) {
            int k = 0;
            int mid = left + (right - left) / 2;
            while (k < m && image[k][mid] == '0') {
                k++;
            }
            if (k == m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    private int searchTop(char[][] image, int top, int bottom) {
        while (top < bottom) {
            int k = 0;
            int mid = top + (bottom - top) / 2;
            while (k < n && image[mid][k] == '0') {
                k++;
            }
            if (k == n) {
                top = mid + 1;
            } else {
                bottom = mid;
            }
        }
        
        return top;
    }
    
    private int searchBottom(char[][] image, int top, int bottom) {
        while (top < bottom) {
            int k = 0;
            int mid = top + (bottom - top) / 2;
            while (k < n && image[mid][k] == '0') {
                k++;
            }
            if (k == n) {
                bottom = mid;
            } else {
                top = mid + 1;
            }
        }
        
        return bottom;
    }
	
	
	// Solution 1: BFS
    /*
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        int m = image.length;
        int n = image[0].length;
        
        int left = y;
        int right = y;
        int up = x;
        int down = x;
        boolean[][] used = new boolean[image.length][image[0].length];
        
        ArrayDeque<Integer> queuex = new ArrayDeque<Integer> ();
        ArrayDeque<Integer> queuey = new ArrayDeque<Integer> ();
        queuex.add(x);
        queuey.add(y);
        
        while (!queuex.isEmpty()) {
            x = queuex.poll();
            y = queuey.poll();
            
            if (x > 0 && used[x - 1][y] == false && image[x - 1][y] == '1') {
                queuex.add(x - 1);
                queuey.add(y);
                up = Math.min(up, x - 1);
                used[x - 1][y] = true;
            }
            if (x < m - 1 && used[x + 1][y] == false && image[x + 1][y] == '1') {
                queuex.add(x + 1);
                queuey.add(y);
                down = Math.max(down, x + 1);
                used[x + 1][y] = true;
            } 
            
            if (y > 0 && used[x][y - 1] == false && image[x][y - 1] == '1') {
                queuex.add(x);
                queuey.add(y - 1);
                left = Math.min(left, y - 1);
                used[x][y - 1] = true;
            }
            if (y < n - 1 && used[x][y + 1] == false && image[x][y + 1] == '1') {
                queuex.add(x);
                queuey.add(y + 1);
                right = Math.max(y + 1, right);
                used[x][y + 1] = true;
            }
        }
        
        return (right - left + 1) * (down - up + 1);
    }
    */
    
    public static void main(String[] args) {
    	char[][] image = {{'0', '0', '1', '0'}, {'0','1','1','0'}, {'0','1','0','0'}};
    	Smallest_Rectangle_Enclosing_Black_Pixels tmp = new Smallest_Rectangle_Enclosing_Black_Pixels();
    	int x = 0, y = 2;
    	System.out.println(tmp.minArea(image, x, y));
    }
}
