/**
 * LeetCode
 * 311. Sparse Matrix Multiplication
 * @author lorreina
 *
 */
public class Sparse_Matrix_Multiplication {
	public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B[0].length; j++) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        
        return C;
    }
}
