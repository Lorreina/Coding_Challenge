/**
 * LeetCode
 * 240. Search_a_2D_Matrix_II
 * @author lorreina
 *
 */
public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int col = n - 1;
        int row = 0;
        
        while (row < m && col >=0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        
        return false;
        
    }
}
