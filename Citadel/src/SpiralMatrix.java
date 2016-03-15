import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer> ();
        if (matrix == null || matrix.length == 0) {
        	return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        while (row > 0 && col > 0) {
        	result.addAll(helper(matrix, row, col));
        	row = row - 2;
        	col = col - 2;
        }
        
        return result;
    }
	
	private static ArrayList<Integer> helper(int[][] matrix, int row, int col){
		ArrayList<Integer> result = new ArrayList<Integer> ();
		int rowStart = (matrix.length - row) / 2;
		int colStart = (matrix[0].length - col) / 2;
		
		if (row == 1) {
		    for (int i = 0; i < col; i++) {
		        result.add(matrix[rowStart][i + colStart]);
		    }
		} else if (col == 1) {
		    for (int j = 0; j < row; j++) {
		        result.add(matrix[rowStart + j][colStart]);
		    }
		} else {
    		
    		for (int i = 0; i < col - 1; i++) {
    			result.add(matrix[rowStart][i + colStart]);
    		}
    		
    		for (int j = 0; j < row - 1; j++) {
    			result.add(matrix[j + rowStart][col + colStart - 1]);
    		}
    		
    		for (int i = 0; i < col - 1; i++) {
    			result.add(matrix[row + rowStart - 1][col + colStart - i - 1]);
    		}
    		
    		for (int j = 0; j < row - 1; j++) {
    			result.add(matrix[rowStart + row - j - 1][colStart]);
    		}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(matrix));
	}
}
