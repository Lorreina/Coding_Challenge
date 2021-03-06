import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
        String maxKey = "";
        
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
                    if (lines.get(s).size() > maxPoints) {
                    	maxKey = s;
                    }
                    maxPoints = Math.max(maxPoints, lines.get(s).size());
                } else {
                    HashSet<Point> set = new HashSet<Point>();
                    set.add(points[i]);
                    set.add(points[j]);
                    lines.put(s, set);
                    maxPoints = Math.max(maxPoints, 2);
                    if (lines.get(s).size() > maxPoints) {
                    	maxKey = s;
                    }
                }
            }
        }
        System.out.println(maxKey);
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
//		Point[] points = new Point[3];
//		points[0] = new Point(1,1);
//		points[1] = new Point(1,1);
//		points[2] = new Point(2,2);
		
		int[][] data = {{40,-23},{9,138},{429,115},{50,-17},{-3,80},{-10,33},{5,-21},{-3,80},{-6,-65},{-18,26},{-6,-65},{5,72},{0,77},{-9,86},{10,-2},{-8,85},{21,130},{18,-6},{-18,26},{-1,-15},{10,-2},{8,69},{-4,63},{0,3},{-4,40},{-7,84},{-8,7},{30,154},{16,-5},{6,90},{18,-6},{5,77},{-4,77},{7,-13},{-1,-45},{16,-5},{-9,86},{-16,11},{-7,84},{1,76},{3,77},{10,67},{1,-37},{-10,-81},{4,-11},{-20,13},{-10,77},{6,-17},{-27,2},{-10,-81},{10,-1},{-9,1},{-8,43},{2,2},{2,-21},{3,82},{8,-1},{10,-1},{-9,1},{-12,42},{16,-5},{-5,-61},{20,-7},{9,-35},{10,6},{12,106},{5,-21},{-5,82},{6,71},{-15,34},{-10,87},{-14,-12},{12,106},{-5,82},{-46,-45},{-4,63},{16,-5},{4,1},{-3,-53},{0,-17},{9,98},{-18,26},{-9,86},{2,77},{-2,-49},{1,76},{-3,-38},{-8,7},{-17,-37},{5,72},{10,-37},{-4,-57},{-3,-53},{3,74},{-3,-11},{-8,7},{1,88},{-12,42},{1,-37},{2,77},{-6,77},{5,72},{-4,-57},{-18,-33},{-12,42},{-9,86},{2,77},{-8,77},{-3,77},{9,-42},{16,41},{-29,-37},{0,-41},{-21,18},{-27,-34},{0,77},{3,74},{-7,-69},{-21,18},{27,146},{-20,13},{21,130},{-6,-65},{14,-4},{0,3},{9,-5},{6,-29},{-2,73},{-1,-15},{1,76},{-4,77},{6,-29}};
		Point[] points = new Point[data.length];
		for (int i = 0; i < data.length; i++) {
			points[i] = new Point(data[i][0], data[i][1]);
		}
		
		System.out.println(tmp.maxPoints(points));
		System.out.println(tmp.gcd(8, 0));
		System.out.println(tmp.gcd(0, 8));
		System.out.println(tmp.gcd(8, 8));
		System.out.println(tmp.gcd(8, -2));
	}
}
