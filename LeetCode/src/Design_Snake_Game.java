import java.util.ArrayList;

/**
 * LeetCode
 * 353. Design Snake Game
 * @author lorreina
 *
 */
public class Design_Snake_Game {
	public static class SnakeGame {
	    int m;
	    int n;
	    int i;
	    int j;
	    int[][] food;
	    // int index;
	    ArrayList<Integer> snake;
	    boolean[][] used;

	    /** Initialize your data structure here.
	        @param width - screen width
	        @param height - screen height 
	        @param food - A list of food positions
	        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	    public SnakeGame(int width, int height, int[][] food) {
	        this.n = width;
	        this.m = height;
	        this.food = food;
	        this.i = 0;
	        this.j = 0;
	        snake = new ArrayList<Integer> ();
	        snake.add(0);
	        used = new boolean[m][n];
	        used[0][0] = true;
	    }
	    
	    /** Moves the snake.
	        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	        @return The game's score after the move. Return -1 if game over. 
	        Game over when snake crosses the screen boundary or bites its body. */
	    public int move(String direction) {
	        if (direction.equals("U")) {
	            if (i == 0) {
	                return -1;
	            } else {
	                i--;
	                return meetFood();
	            }
	        } else if (direction.equals("D")) {
	            if (i == m - 1) {
	                return -1;
	            } else {
	                i++;
	                return meetFood();
	            }
	        } else if (direction.equals("L")) {
	            if (j == 0) {
	                return -1;
	            } else {
	                j--;
	                return meetFood();
	            }
	        } else if (direction.equals("R")) {
	            if (j == n - 1) {
	                return -1;
	            } else {
	                j++;
	                return meetFood();
	            }
	        }
	        
	        return -1;
	    }
	    
	    private int meetFood() {
	        int index = snake.size() - 1;
	        int last = snake.get(index);
	        if (index == food.length || i != food[index][0] || j != food[index][1]) {
	            used[last / n][last % n] = false;
	            snake.remove(index);
	        }
	        
	        if (used[i][j] == true) {
	        	return -1;
	        }
	        used[i][j] = true;
	        snake.add(0, i * n + j);
	        
	        
	        return snake.size() - 1;
	    }
	}

	/**
	 * Your SnakeGame object will be instantiated and called as such:
	 * SnakeGame obj = new SnakeGame(width, height, food);
	 * int param_1 = obj.move(direction);
	 */
	
	public static void main(String[] args) {
		int width = 3;
		int height = 3;
		int[][] food = {{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}};
		SnakeGame tmp = new SnakeGame(width, height, food);

		tmp.move("R");
		tmp.move("R");
		tmp.move("D");
		tmp.move("D");
		tmp.move("L");
		tmp.move("L");
		tmp.move("U");
		tmp.move("U");
		tmp.move("R");
		tmp.move("R");
		tmp.move("D");
		tmp.move("D");
		tmp.move("L");
		tmp.move("L");
		tmp.move("U");
		tmp.move("R");
		tmp.move("U");
		
		System.out.println(tmp.move("L"));
		System.out.println(tmp.move("D"));
		
	}
}
