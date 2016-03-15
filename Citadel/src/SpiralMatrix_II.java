import java.util.Arrays;

public class SpiralMatrix_II {
	
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		
		int begin = 1;
		for (int i = n; i > 0; i = i - 2) {
			begin = helper(matrix, i, n, begin);
		}
		
		return matrix;
    }
	
	private static int helper(int[][] matrix, int line, int n, int begin) {
		int start = (n - line) / 2;
		
		if (line == 1) {
			for (int i = 0; i < line; i++) {
				matrix[start][i + start] = begin;
				begin++;
			}
		} else {
			for (int i = 0; i < line - 1; i++) {
				matrix[start][i + start] = begin;
				begin++;
			}
			for (int j = 0; j < line - 1; j++) {
    			matrix[j + start][line + start - 1] = begin;
    			begin++;
    		}
    		
    		for (int i = 0; i < line - 1; i++) {
    			matrix[line + start - 1][line + start - i - 1] = begin;
    			begin++;
    		}
    		
    		for (int j = 0; j < line - 1; j++) {
    			matrix[start + line - j - 1][start] = begin;
    			begin++;
    		}
		}
		return begin;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(generateMatrix(3)));
	}
}
