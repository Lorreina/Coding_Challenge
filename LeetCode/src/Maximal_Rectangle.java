/**
 * LeetCode
 * 85. Maximal Rectangle
 * @author lorreina
 *
 */
public class Maximal_Rectangle {
//	left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
//	right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
//	height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
//	height(i,j) = 0, if matrix[i][j]=='0'
	
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            right[i] = n;
        }
        
        for (int i = 0; i < m; i++) {
            int currLeft = 0, currRight = n;
            
            for (int j = 0; j < n; j++) {
                int k = n - j - 1;
                
                if (matrix[i][j] == '1') {
                    // compute height
                    height[j]++;
                    // compute left
                    left[j] = Math.max(currLeft, left[j]);
                } else {
                    // compute height
                    height[j] = 0;
                    // compute left
                    left[j] = 0;
                    currLeft = j + 1;
                }
                
                if (matrix[i][k] == '1') {
                	// compute right
                    right[k] = Math.min(currRight, right[k]);
                    // compute right
                } else {
                    right[k] = n;
                    currRight = k;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int currArea = (right[j] - left[j]) * height[j];
                maxArea = Math.max(maxArea, currArea);
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{1,0,1,0,0}, {1,0,1,1,1}, {1,1,1,1,1}, {1,0,0,1,0}};
//    	int[][] matrix = {{1}};
    	char[][] charMatrix = new char[matrix.length][matrix[0].length];
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {
    			charMatrix[i][j] = (char) (matrix[i][j] + '0')  ;
    		}
    	}
 
    	System.out.println(maximalRectangle(charMatrix));
    }
}
