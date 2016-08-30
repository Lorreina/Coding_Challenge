/**
 * LeetCode
 * 223. Rectangle Area
 * @author lorreina
 *
 */
public class Rectangle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0;
        
        if (!(E > C || A > G || F > D || B > H)) {
            int x = (Math.min(C, G) - Math.max(A, E));
            int y = (Math.min(D, H) - Math.max(B, F));
            overlap = x * y;
        }
        
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
}
