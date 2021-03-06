import java.util.ArrayList;
import java.util.HashSet;

/**
 * LeetCode
 * 323. Number of Connected Components in an Undirected Graph
 * @author lorreina
 *
 */
public class Number_of_Connected_Components_in_an_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return n;
        }
        
        
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>> ();
        
        list.add(new HashSet<Integer> ());
        list.get(0).add(edges[0][0]);
        list.get(0).add(edges[0][1]);
        int count = 2;
        
        for (int i = 1; i < edges.length; i++) {
            int left = -1;
            int right = -1;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).contains(edges[i][0])) {
                    left = j;
                }
                if (list.get(j).contains(edges[i][1])) {
                    right = j;
                }
                if (left >= 0 && right >= 0) {
                    break;
                }
            }
            
            if (left == -1 && right == -1) {
                HashSet<Integer> set = new HashSet<Integer> ();
                set.add(edges[i][0]);
                set.add(edges[i][1]);
                list.add(set);
                count += 2;
            } else if (left == -1) {
                list.get(right).add(edges[i][0]);
                list.get(right).add(edges[i][1]);
                count += 1;
            } else if (right == -1) {
                list.get(left).add(edges[i][0]);
                list.get(left).add(edges[i][1]);
                count += 1;
            } else {
                // add vertex
                list.get(left).add(edges[i][0]);
                list.get(right).add(edges[i][1]);
                if (left != right) {
                    list.get(left).addAll(list.get(right));
                    list.remove(right);
                }
            }
        }
        
        return list.size() + (n - count);
    }
    
    public static void main(String[] args) {
    	int[][] edges = {{0,1}, {1, 2}, {3,4}};
    	int n = 5;
    	Number_of_Connected_Components_in_an_Undirected_Graph tmp = new Number_of_Connected_Components_in_an_Undirected_Graph();
    	System.out.println(tmp.countComponents(n, edges));
    }
}
