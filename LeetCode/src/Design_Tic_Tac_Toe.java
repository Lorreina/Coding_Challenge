/**
 * LeetCode
 * 348. Design Tic-Tac-Toe
 * @author lorreina
 *
 */
public class Design_Tic_Tac_Toe {
	public class TicTacToe {
	    int[][] rows;
	    int[][] cols;
	    int[] diagonal;
	    int[] antiDia;
	    int n;

	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        this.rows = new int[2][n];
	        this.cols = new int[2][n];
	        diagonal = new int[2];
	        antiDia = new int[2];
	        this.n = n;
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        if (this.rows[player - 1][row] == n - 1 || this.cols[player - 1][col] == n - 1) {
	            return player;
	        } else {
	            this.rows[player - 1][row]++;
	            this.cols[player - 1][col]++;
	        }
	        
	        if (row == col) {
	            if (diagonal[player - 1] == n - 1) {
	                return player;
	            } else {
	                diagonal[player - 1]++;
	            }
	        }
	        
	        if (row + col == n - 1) {
	            if (antiDia[player - 1] == n - 1) {
	                return player;
	            } else {
	                antiDia[player - 1]++;   
	            }
	        }
	        
	        return 0;
	    }
	}

	/**
	 * Your TicTacToe object will be instantiated and called as such:
	 * TicTacToe obj = new TicTacToe(n);
	 * int param_1 = obj.move(row,col,player);
	 */
}
