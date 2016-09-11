import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode
 * 399. Evaluate Division
 * @author lorreina
 *
 */
public class Evaluate_Division {
	public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        if (query == null || query.length == 0) {
            return null;
        }
        double[] res = new double[query.length];
        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>> ();
        
        
        if (values != null && values.length != 0) {
            for (int i = 0; i < values.length; i++) {
                if (map.containsKey(equations[i][0])) {
                    map.get(equations[i][0]).put(equations[i][1], values[i]);
                } else {
                    HashMap<String, Double> tmp = new HashMap<String, Double> ();
                    tmp.put(equations[i][1], values[i]);
                    map.put(equations[i][0], tmp);
                }
                
                double num = (double) 1 / values[i];
                if (map.containsKey(equations[i][1])) {
                    map.get(equations[i][1]).put(equations[i][0], num);
                } else {
                    HashMap<String, Double> tmp = new HashMap<String, Double> ();
                    tmp.put(equations[i][0], num);
                    map.put(equations[i][1], tmp);
                }
            }
        }
        
        HashSet<String> set = new HashSet<String> ();
        for (int i = 0; i < query.length; i++) {
            if (!map.containsKey(query[i][0]) || !map.containsKey(query[i][1])) {
                res[i] = -1.0;
            } else if (query[i][0].equals(query[i][1])) {
                res[i] = 1.0;
            } else {
            	set.add(query[i][0]);
            	double[] tmp = find(set, map, query[i][0], query[i][1]);
                if (tmp[0] == 0) {
                    res[i] = -1.0;
                } else {
                    res[i] = tmp[1];
                }
                set.remove(query[i][0]);
            }
        }
        
        return res;
    }
    
    private double[] find(HashSet<String> set, HashMap<String, HashMap<String, Double>> map, String a, String b) {
        double res[] = new double[2];
        HashMap<String, Double> amap = map.get(a);
        if (amap.containsKey(b)) {
            res[0] = 1;
            res[1] = amap.get(b);
            return res;
        }
        
        for (String s : amap.keySet()) {
        	if (set.contains(s)) {
        		continue;
        	}
        	set.add(s);
            double tmp[] = find(set, map, s, b);
            set.remove(s);
            if (tmp[0] == 1) {
                res[0] = 1;
                res[1] = tmp[1] * amap.get(s);
                return res;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	Evaluate_Division tmp = new Evaluate_Division();
    	String[][] equations = {{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"}, {"x4", "x5"}};
    	double[] values = {3, 4, 5, 6};
    	String[][] query = {{"x1", "x5"}, {"x5", "x2"}, {"x2", "x4"}, {"x2", "x2"}, {"x2","x9"}, {"x9", "x9"}};
    	double[] res = tmp.calcEquation(equations, values, query);
    	for (int i = 0; i < res.length; i++) {
    		System.out.println(res[i]);
    	}
    }
}
