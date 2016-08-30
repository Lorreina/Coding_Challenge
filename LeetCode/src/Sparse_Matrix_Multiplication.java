
public class Sparse_Matrix_Multiplication {
	public static int[][] multiply(int[][] A, int[][] B) {
        boolean[] zeroA = new boolean[A.length];
        boolean[] zeroB = new boolean[B[0].length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    zeroA[i] = false;
                    break;
                } else {
                    zeroA[i] = true;
                }
            }
        }
        
        for (int i = 0; i < B[0].length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) {
                    zeroB[i] = false;
                    break;
                } else {
                    zeroB[i] = true;
                }
            }
        }
        
        int[][] C = new int[A.length][B[0].length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (zeroA[i] || zeroB[j]) {
                    C[i][j] = 0;
                } else {
                    for (int k = 0; k < B.length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        return C;
    }
	
	public static void main(String[] args) {
		int[][] A = {{1,0,0}, {-1,0,3}};
		int[][] B = {{7,0,0}, {0,0,0}, {0,0,1}};
		
		System.out.println(multiply(A, B));
	}
}
