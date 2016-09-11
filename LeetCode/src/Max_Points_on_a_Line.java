import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 149. Max Points on a Line
 * @author lorreina
 *
 */
public class Max_Points_on_a_Line {
	public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int maxPoints = 1;
        
        HashMap<String, HashSet<Point>> lines = new HashMap<String, HashSet<Point>> ();
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int a = points[i].y - points[j].y;
                int b = points[j].x - points[i].x;
                String s;
                if (a == 0 && b == 0) {
                    s = String.valueOf(points[j].x) + "+" + String.valueOf(points[j].y);
                } else {
                    int c = (points[i].x * points[j].y) - (points[j].x  * points[i].y);
                    if (a < 0) {
                        a = -a;
                        b = -b;
                        c = -c;
                    }
                    
                    int gcd = gcd(a, Math.abs(b));
                    if (c % gcd == 0) {
                    	a = a / gcd;
                    	b = b / gcd;
                    	c = c / gcd;
                    }
                    
                    s = String.valueOf(a) + "+" + String.valueOf(b) + "+" + String.valueOf(c);
                }
                if (lines.containsKey(s)) {
                    lines.get(s).add(points[i]);
                    lines.get(s).add(points[j]);
                    maxPoints = Math.max(maxPoints, lines.get(s).size());
                } else {
                    HashSet<Point> set = new HashSet<Point>();
                    set.add(points[i]);
                    set.add(points[j]);
                    lines.put(s, set);
                    maxPoints = Math.max(maxPoints, 2);
                }
            }
        }
        
        return maxPoints;
        
    }
	
	private int gcd(int a, int b) {
	    if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }

	    return a;
	}
	
	public static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	
	
	public static void main(String[] args) {
		Max_Points_on_a_Line tmp = new Max_Points_on_a_Line();
		Point[] points = new Point[3];
		points[0] = new Point(0,0);
		points[1] = new Point(-1,-1);
		points[2] = new Point(2,2);
		
		System.out.println(tmp.maxPoints(points));
	}
}
