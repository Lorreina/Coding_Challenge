import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Minimum_Height_Trees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer> ();
        if (n <= 2) {
           for (int i = 0; i < n; i++) {
               result.add(i);
           }
           return result;
       }
       
       HashMap<Integer, ArrayList<Integer>> adjacency = new HashMap<Integer, ArrayList<Integer>> ();
       for (int i = 0; i < n; i++) {
           adjacency.put(i, new ArrayList<Integer> ());
       }
       // initialize the degree array and adjacency list.
       int[] degree = new int[n];
       for (int i = 0; i < edges.length; i++) {
           degree[edges[i][0]]++;
           degree[edges[i][1]]++;
           adjacency.get(edges[i][0]).add(edges[i][1]);
           adjacency.get(edges[i][1]).add(edges[i][0]);
       }
       
       // initialize queue
       ArrayList<Integer> queue = new ArrayList<Integer> ();
       for (int i = 0; i < degree.length; i++) {
           if (degree[i] == 1) {
               queue.add(i);
           }
       }
       
       int len = queue.size();
       int start = 0;
       while (true) {
           for (int i = start; i < len; i++) {
               ArrayList<Integer> tmp = adjacency.get(queue.get(i));
               for (int j = 0; j < tmp.size(); j++) {
                   degree[tmp.get(j)]--;
                   if (degree[tmp.get(j)] == 1) {
                       queue.add(tmp.get(j));
                       if (queue.size() == n) {
                           break;
                       }
                   }
               }
           }
           if (queue.size() == n) {
               break;
           }
           start = len;
           len = queue.size();
       }
       
       for (int i = len; i < n; i++) {
           result.add(queue.get(i));
       }
       
       return result;
       
    }
}
