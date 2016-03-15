/**
 * LeetCode: 292. Nim Game
 * @author lorreina
 *
 */
public class Nim_Game {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }
}
