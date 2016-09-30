/**
 * LeetCode
 * 308. Range Sum Query 2D - Mutable
 * @author lorreina
 *
 */
public class Range_Sum_Query_2D_Mutable {
	// use the idea of Binary Indexed Tree OR segment tree
	public class NumMatrix {
	    private int[][] colSums;
	    private int[][] matrix;

	    public NumMatrix(int[][] matrix) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return;
	        }
	        
	        this.matrix = matrix;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        colSums = new int[m + 1][n];
	        
	        // initialize colSums
	        for (int i = 1; i < m + 1; i++) {
	            for (int j = 0; j < n; j++) {
	                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
	            }
	        }
	    }

	    public void update(int row, int col, int val) {
	        for (int i = row + 1; i < colSums.length; i++) {
	            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
	        }
	        matrix[row][col] = val;
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int sum = 0;
	        for (int j = col1; j <= col2; j++) {
	            sum += colSums[row2 + 1][j] - colSums[row1][j];
	        }
	        
	        return sum;
	    }
	}


	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.update(1, 1, 10);
	// numMatrix.sumRegion(1, 2, 3, 4);
}
