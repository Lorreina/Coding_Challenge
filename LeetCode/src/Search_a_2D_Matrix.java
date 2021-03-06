/**
 * LeetCode
 * 74. Search a 2D Matrix
 * @author lorreina
 *
 */
public class Search_a_2D_Matrix {
	
	// just treat the 2D matrix as a sorted list
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        return helper(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }
    
    private boolean helper(int[][] matrix, int target, int start, int end) {
        if (start == end) {
            if (getValue(matrix, start) == target) {
                return true;
            } else {
                return false;
            }
        }
        
        if (start == end - 1) {
            if (getValue(matrix, start) == target) {
                return true;
            } else if (getValue(matrix, end) == target) {
                return true;
            } else {
                return false;
            }
        }
        
        int mid = start + (end - start) / 2;
        int midValue = getValue(matrix, mid);
        if (midValue == target) {
            return true;
        } else if (midValue < target) {
            return helper(matrix, target, mid + 1, end);
        } else {
            return helper(matrix, target, start, mid - 1);
        }
    }
    
    private int getValue(int[][] matrix, int index) {
        int i = index / matrix[0].length;
        int j = index % matrix[0].length;
        
        return matrix[i][j];
    }
}
