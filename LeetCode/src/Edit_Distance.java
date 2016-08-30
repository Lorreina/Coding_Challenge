/**
 * LeetCode
 * 72. Edit Distance
 * @author lorreina
 *
 */
public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 1; i < (word1.length() + 1); i++) {
            matrix[i][0] = i;
        }
        for (int i = 1; i < (word2.length() + 1); i++) {
            matrix[0][i] = i;
        }
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        for (int i = 1; i < (word1.length() + 1); i++ ){
            for (int j = 1; j < (word2.length() + 1); j++) {
                int step = 1;
                if (w1[i - 1] == w2[j - 1]) {
                    step = 0;
                }
                matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]) + 1, matrix[i - 1][j - 1] + step);
            }
        }
        
        return matrix[word1.length()][word2.length()];
    }
}
