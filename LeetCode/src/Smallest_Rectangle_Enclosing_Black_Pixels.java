import java.util.ArrayDeque;

/**
 * LeetCode
 * 302. Smallest Rectangle Enclosing Black Pixels
 * @author lorreina
 *
 */
public class Smallest_Rectangle_Enclosing_Black_Pixels {
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
    
    public static void main(String[] args) {
    	char[][] image = {{'0', '0', '1', '0'}, {'0','1','1','0'}, {'0','1','0','0'}};
    	Smallest_Rectangle_Enclosing_Black_Pixels tmp = new Smallest_Rectangle_Enclosing_Black_Pixels();
    	int x = 0, y = 2;
    	System.out.println(tmp.minArea(image, x, y));
    }
}